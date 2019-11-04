package com.cdhenren.fetch.driver.property;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpBasicInformation;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 物业管理-基础信息管理,物业信息管理
 *
 * @author Baopz
 * @date 2018/04/28
 */
public class BasicInformationDownloadDriver extends AbstractDownloadRealEstate {
    private static final String MENU_1_LEVEL = "基础信息";
    private static final String MENU_2_LEVEL = "物业信息管理";

    public BasicInformationDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public BasicInformationDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
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
            for (File file2 : Objects.requireNonNull(iniFile.listFiles())) {
                if (file2.getName().contains("物业信息")) {
                    file2.delete();
                }
            }
        }
        //下载
        driver.findElement(By.cssSelector("#exportButton")).click();
        TimeUnit.SECONDS.sleep(1);

        driver.findElement(By.cssSelector(".mini-messagebox-buttons > .mini-button")).click();
        TimeUnit.SECONDS.sleep(20);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpBasicInformation.class};
        int[] skipLines = new int[]{1};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        for (File file1 : file.listFiles()) {
            if (file1.getName().contains("物业信息")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
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
