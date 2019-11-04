package com.cdhenren.fetch.driver.property;

import com.cdhenren.fetch.entity.*;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 物业管理
 *
 * @author Baopz
 * @date 2018/04/28
 */
public class ContractRDownloadDriver extends AbstractDownloadRealEstate {
    private static final String MENU_1_LEVEL = "基础信息";
    private static final String MENU_2_LEVEL = "合同信息管理";

    public ContractRDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public ContractRDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    /**
     * 解析
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("综合查询")) {
                    file2.delete();
                }
            }
        }
        //下载
        driver.findElement(By.cssSelector("#excelExportBtn")).click();
        TimeUnit.SECONDS.sleep(20);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpPropertyContract.class};
        int[] skipLines = new int[]{2};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        for (File file1 : file.listFiles()) {
            if (file1.getName().contains("合同信息")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
                TimeUnit.SECONDS.sleep(5);
                FileTools.deleteFile(file1);
            }
        }
        return classListMap;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }

}
