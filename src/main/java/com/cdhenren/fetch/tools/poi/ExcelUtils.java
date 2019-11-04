package com.cdhenren.fetch.tools.poi;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.tools.ReflectTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现了接口 com.cdhenren.fetch.entity.ResultSet
 *
 * @author Baopz
 * @date 2018/05/03
 */
public final class ExcelUtils {
    private static String XLS = "xls";
    private static String XLSX = "xlsx";

    public static Map<Class, List<? extends ResultSet>> readFile(String filename, Class... clazz) throws Exception {
        return readFile(filename, new int[]{1}, clazz);
    }

    public static Map<Class, List<? extends ResultSet>> readFile(File file, Class... clazz) throws Exception {
        return readFile(file, new int[]{1}, clazz);
    }

    /**
     * @param file
     * @param skipLines 每个shet对应数据启始行号，从0开始
     * @param clazzes   每个shet对应的类
     * @return
     * @throws Exception
     */
    public static Map<Class, List<? extends ResultSet>> readFile(File file,
                                                                 int[] skipLines,
                                                                 Class[] clazzes) throws Exception {
        if (file == null) {
            throw new FileNotFoundException("文件不能为空");
        }
        skipLines = checkSkipLines(skipLines, clazzes);
        if (file.getName().endsWith(XLS)) {
            return readXls(file, skipLines, clazzes);
        } else if (file.getName().endsWith(XLSX)) {
            return readXlsx(file, skipLines, clazzes);
        }
        return null;
    }

    private static int[] checkSkipLines(int[] skipLines, Class[] clazzes) throws Exception {
        if (skipLines == null || skipLines.length == 0) {
            skipLines = new int[]{1};
        }
        if (clazzes == null || clazzes.length == 0) {
            throw new Exception("没有发现接受的类型。");
        }
        return skipLines;
    }

    private static Map<Class, List<? extends ResultSet>> readXlsx(File file, int[] skipLines, Class[] clazzes) throws Exception {
        Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
        return sheetHandler(workbook, skipLines, clazzes);
    }

    private static Map<Class, List<? extends ResultSet>> readXls(File file, int[] skipLines, Class[] clazzes) throws Exception {
        Workbook workbook = new HSSFWorkbook(new FileInputStream(file));
        return sheetHandler(workbook, skipLines, clazzes);
    }

    /**
     * slipLines的值从下标0开始，skipLines.length与classzzes.length对应
     *
     * @param filename
     * @param skipLines
     * @param clazzes
     * @return
     * @throws Exception
     */
    public static Map<Class, List<? extends ResultSet>> readFile(String filename,
                                                                 int[] skipLines,
                                                                 Class... clazzes) throws Exception {
        if (StringUtils.isEmpty(filename)) {
            throw new FileNotFoundException("文件名为空。" + filename);
        }
        if (!(filename.endsWith(XLS) || filename.endsWith(XLSX))) {
            throw new NotSupportedFileType("不支持的文件类型。" + filename);
        }
        skipLines = checkSkipLines(skipLines, clazzes);
        if (filename.endsWith(XLS)) {
            return readXls(filename, skipLines, clazzes);
        } else if (filename.endsWith(XLSX)) {
            return readXlsx(filename, skipLines, clazzes);
        }
        return null;
    }

    /**
     * xmlx文件的读取
     *
     * @param filename
     * @param skipLines
     * @param classes
     * @return
     */
    private static Map<Class, List<? extends ResultSet>> readXlsx(String filename, int[] skipLines, Class... classes) throws Exception {
        try (
                Workbook workbook = new SXSSFWorkbook(new XSSFWorkbook(new FileInputStream(new File(filename))), 100)
        ) {
            return sheetHandler(workbook, skipLines, classes);
        }
    }

    private static Map<Class, List<? extends ResultSet>> sheetHandler(Workbook workbook, int[] skipLines, Class... classes) throws Exception {
        Sheet sheet;
        Map<Class, List<? extends ResultSet>> map = new HashMap<>(workbook.getNumberOfSheets());
        //处理初始化标题间隔行数
        if (skipLines.length < workbook.getNumberOfSheets()) {
            int[] tmp = new int[workbook.getNumberOfSheets()];
            System.arraycopy(skipLines, 0, tmp, 0, skipLines.length);
            for (int i = skipLines.length; i < tmp.length; i++) {
                tmp[i] = 0;
            }
            skipLines = tmp;
        }
        for (int i = 0; i < workbook.getNumberOfSheets() && i < classes.length; i++) {
            sheet = workbook.getSheetAt(i);
            List<ResultSet> sheetRow = new ArrayList<>();
            for (int j = skipLines[i]; j < sheet.getLastRowNum() + 1; j++) {
                Row row = sheet.getRow(j);
                List<String> values = new ArrayList<>(row.getLastCellNum());
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    if (row.getCell(k) != null) {
                        values.add(row.getCell(k) + "");
                    } else {
                        values.add("");
                    }
                }
                ResultSet rs = (ResultSet) classes[i].newInstance();
                ReflectTools.reflectEntity(rs, values);
                sheetRow.add(rs);
            }
            map.put(classes[i], sheetRow);
        }
        return map;
    }

    /**
     * xls文件的读取
     *
     * @param filename
     * @param skipLines
     * @param classes
     * @return
     */
    private static Map<Class, List<? extends ResultSet>> readXls(String filename, int[] skipLines, Class... classes) throws Exception {
        try (
                Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(filename)));) {
            return sheetHandler(workbook, skipLines, classes);
        }
    }

}
