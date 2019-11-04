package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpReProj;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 项目-销项项目
 * @author Baopz
 * @date 2018/05/15
 */
public class ReProjDownloadDriver extends AbstractProjDownloadDriver {
    private static final String MENU_1_LEVEL = "全视图";
    private static final String MENU_2_LEVEL = "数据导出";


    public ReProjDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public ReProjDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("铁塔类项目信息")) {
                    file2.delete();
                }
            }
        }
        //点击条件
        //项目类型
        driver.findElement(By.cssSelector("#typeCombo > span")).click();
        chromeWait(driver,10);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#mini-26 > div.mini-listbox-border > div.mini-listbox-view > div > table > tbody > tr:nth-child(2)")).click();
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(2);

        //是否销项
        //version 2.0.2
//        driver.findElement(By.cssSelector("#is_revocation")).click();
        driver.findElement(By.cssSelector("#table2 > tbody > tr > td:nth-child(1)")).click();

        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#mini-74 > div.mini-listbox-border > div.mini-listbox-view > div > table > tbody >tr:nth-child(3)")).click();

        //下载
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.cssSelector("#exportButton")).click();
        chromeWait(driver, 140);
        TimeUnit.SECONDS.sleep(140);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpReProj.class};
        int[] skipLines = new int[]{4};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("铁塔类项目信息")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
                TimeUnit.SECONDS.sleep(4);
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
