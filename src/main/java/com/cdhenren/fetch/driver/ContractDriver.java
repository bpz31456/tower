package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpContract;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/02
 */
public class ContractDriver extends AbstractContractDriver {
    private static final String MENU_1_LEVEL = "综合查询";
    private static final String MENU_2_LEVEL = "合同综合查询";

    public ContractDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public ContractDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        Map<Class, List<? extends ResultSet>> classListMap = null;
        File file = new File(downloadPath);
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                if (file1.getName().contains("综合查询")) {
                    file1.delete();
                }
            }
        }
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#exportExcelMoreRowSelect")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#moreFieldsSelectAll")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#moreFieldsExp")).click();
        Alert alt = driver.switchTo().alert();
        alt.accept();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Class[] classes = new Class[]{TmpContract.class};
        int[] skipLines = new int[]{1};
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("综合查询")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
                TimeUnit.SECONDS.sleep(5);
                FileTools.deleteFile(file1);
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return classListMap;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}
