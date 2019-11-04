package com.cdhenren.fetch.tools.poi;

import com.cdhenren.fetch.entity.enhancer.CommonBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public final class ExcelEnhancerUtils {
    private static Logger logger = LoggerFactory.getLogger(ExcelEnhancerUtils.class);
    private static String XLS = "xls";
    private static String XLSX = "xlsx";


    /**
     * @param file
     * @param skipLines  每个shet对应数据启始行号，从0开始
     * @param tableNames 每个sheet对应的表
     * @return
     * @throws Exception
     */
    public static Map<String, List<Object>> readFile(File file,
                                                     int[] skipLines,
                                                     String[] tableNames,
                                                     Relationship relationship) throws Exception {
        if (file == null) {
            throw new FileNotFoundException("文件不能为空");
        }
        skipLines = checkSkipLines(skipLines, tableNames);
        if (file.getName().endsWith(XLS)) {
            return readXls(file, skipLines, tableNames, relationship);
        } else if (file.getName().endsWith(XLSX)) {
            return readXlsx(file, skipLines, tableNames, relationship);
        }
        return null;
    }

    private static int[] checkSkipLines(int[] skipLines, String[] tableNames) throws Exception {
        if (skipLines == null || skipLines.length == 0) {
            skipLines = new int[]{1};
        }
        if (tableNames == null || tableNames.length == 0) {
            throw new Exception("没有发现接受的类型。");
        }
        return skipLines;
    }

    private static Map<String, List<Object>> readXlsx(File file, int[] skipLines, String[] tableNames, Relationship relationship) throws Exception {
        Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
        return sheetHandler(workbook, skipLines, relationship, tableNames);
    }

    private static Map<String, List<Object>> readXls(File file, int[] skipLines, String[] tableNames, Relationship relationship) throws Exception {
        Workbook workbook = new HSSFWorkbook(new FileInputStream(file));
        return sheetHandler(workbook, skipLines, relationship, tableNames);
    }

    /**
     * slipLines的值从下标0开始，skipLines.length与classzzes.length对应
     *
     * @param filename
     * @param skipLines
     * @param tableNames
     * @param relationship
     * @return
     * @throws Exception
     */
    public static Map<String, List<Object>> readFile(String filename,
                                                     int[] skipLines,
                                                     Relationship relationship,
                                                     String... tableNames) throws Exception {
        if (StringUtils.isEmpty(filename)) {
            throw new FileNotFoundException("文件名为空。" + filename);
        }
        if (!(filename.endsWith(XLS) || filename.endsWith(XLSX))) {
            throw new NotSupportedFileType("不支持的文件类型。" + filename);
        }
        skipLines = checkSkipLines(skipLines, tableNames);
        if (filename.endsWith(XLS)) {
            return readXls(filename, skipLines, relationship, tableNames);
        } else if (filename.endsWith(XLSX)) {
            return readXlsx(filename, skipLines, relationship, tableNames);
        }
        return null;
    }

    /**
     * xmlx文件的读取
     *
     * @param filename
     * @param skipLines
     * @param tableNames
     * @return
     */
    private static Map<String, List<Object>> readXlsx(String filename, int[] skipLines, Relationship relationship, String... tableNames) throws Exception {
        try (
                Workbook workbook = new SXSSFWorkbook(new XSSFWorkbook(new FileInputStream(new File(filename))), 100)
        ) {
            return sheetHandler(workbook, skipLines, relationship, tableNames);
        }
    }

    private static Map<String, List<Object>> sheetHandler(Workbook workbook,
                                                          int[] skipLines,
                                                          Relationship relationship,
                                                          String[] tableNames) throws Exception {
        Sheet sheet;
        Map<String, List<Object>> map = new HashMap<>(workbook.getNumberOfSheets());
        //处理初始化标题间隔行数
        if (skipLines.length < workbook.getNumberOfSheets()) {
            int[] tmp = new int[workbook.getNumberOfSheets()];
            System.arraycopy(skipLines, 0, tmp, 0, skipLines.length);
            for (int i = skipLines.length; i < tmp.length; i++) {
                tmp[i] = 0;
            }
            skipLines = tmp;
        }
        //Sheet
        for (int i = 0; i < workbook.getNumberOfSheets() && i < tableNames.length; i++) {
            sheet = workbook.getSheetAt(i);
            List<Object> sheetRow = new ArrayList<>();
            //row
            for (int j = skipLines[i]; j < sheet.getLastRowNum() + 1; j++) {
                Row row = sheet.getRow(j);
                CommonBean commonBean = new CommonBean(relationship.getPropertiesMap());
                relationship.getRelationships().forEach(sysTableRelationship -> {
                    Cell cell = row.getCell(CellReference.convertColStringToIndex(sysTableRelationship.getExcelColumn()));
                    Object value = readValue(cell, sysTableRelationship.getDataType());
                    logger.info("value_type:{},value:{}",value.getClass().getName(),value.toString());
                    commonBean.setValue(sysTableRelationship.getColumn(), value);
                });
                sheetRow.add(commonBean.getObject());
            }
            map.put(tableNames[i], sheetRow);
        }
        return map;
    }

    private static Object readValue(Cell cell, String dataType) {
        if (cell == null) {
            return "";
        }
        Object object;
        switch (dataType) {
            case "int":
                object = cell.getNumericCellValue();
                object = ((Double)object).intValue();
                break;
            case "varchar":
                object = cell.getStringCellValue();
                break;
            case "timestamp":
            case "datetime":
                object = cell.getDateCellValue();
                break;
            case "double":
                object = cell.getNumericCellValue();
                break;
            default:
                object = "";
        }
        return object;
    }

    /**
     * xls文件的读取
     *
     * @param filename
     * @param skipLines
     * @param tableNames
     * @return
     */
    private static Map<String, List<Object>> readXls(String filename, int[] skipLines, Relationship relationship, String... tableNames) throws Exception {
        try (
                Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(filename)));) {
            return sheetHandler(workbook, skipLines, relationship, tableNames);
        }
    }
}
