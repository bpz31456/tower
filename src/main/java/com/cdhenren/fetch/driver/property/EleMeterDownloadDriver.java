package com.cdhenren.fetch.driver.property;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleMeter;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/15
 */
public class EleMeterDownloadDriver extends AbstractDownloadRealEstate {
    private static final String MENU_1_LEVEL = "电费基础信息";
    private static final String MENU_2_LEVEL = "电表信息管理";

    public EleMeterDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public EleMeterDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("电表信息")) {
                    file2.delete();
                }
            }
        }
        //下载
        driver.findElement(By.cssSelector("#exportBtn")).click();
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.cssSelector(".mini-messagebox-buttons > .mini-button")).click();
        TimeUnit.SECONDS.sleep(20);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpEleMeter.class};
        int[] skipLines = new int[]{1};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(2);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("电表信息")) {
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
