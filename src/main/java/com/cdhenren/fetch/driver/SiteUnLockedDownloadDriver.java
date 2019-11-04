package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpSiteUnLocked;
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
 * @date 2018/05/24
 */
public class SiteUnLockedDownloadDriver extends AbstractMonitoringDownloadDriver {
    private static final String MENU_1_LEVEL = "资源管理";
    private static final String MENU_2_LEVEL = "站址管理";

    public SiteUnLockedDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public SiteUnLockedDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("站址管理信息-导出")) {
                    file2.delete();
                }
            }
        }
        //选择锁定
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("body > div:nth-child(178) > ul > li:nth-child(2)")).click();

        //查询
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(7);
        driver.findElement(By.cssSelector("#queryForm\\3a siteQueryId")).click();

        //下载文件
        chromeWait(driver, 5);
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.cssSelector("#queryForm\\3a j_id20")).click();

        //同意
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("#exportExcelPanelContentTable > tbody > tr:nth-child(2) > td > form > center >input:nth-child(1)")).click();
        TimeUnit.SECONDS.sleep(20);
        chromeWait(driver,100);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpSiteUnLocked.class};
        int[] skipLines = new int[]{2};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        if(files==null || files.length==0){
            return null;
        }
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("站址管理信息-导出")) {
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
