package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpProject;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 项目-项目
 * @author Baopz
 * @date 2018/05/15
 */
public class ProjDownloadDriver extends AbstractProjDownloadDriver {
    private static final String MENU_1_LEVEL = "全视图";
    private static final String MENU_2_LEVEL = "数据导出";
    private Logger logger = LoggerFactory.getLogger(ProjDownloadDriver.class);

    public ProjDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public ProjDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
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
        //筛选条件
        driver.findElement(By.cssSelector("#typeCombo > span")).click();
        chromeWait(driver,10);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#mini-26 > div.mini-listbox-border > div.mini-listbox-view > div > table > tbody > tr:nth-child(2)")).click();
//        driver.findElement(By.cssSelector("#mini-25 > div.mini-listbox-border > div.mini-listbox-view > div > table > tbody > tr:nth-child(2)")).click();

        //下载
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.cssSelector("#exportButton")).click();
        chromeWait(driver, 140);
        TimeUnit.SECONDS.sleep(140);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpProject.class};
        int[] skipLines = new int[]{4};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("铁塔类项目信息")) {
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
