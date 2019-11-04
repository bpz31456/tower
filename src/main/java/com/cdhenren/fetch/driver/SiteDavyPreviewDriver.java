package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpSiteDavyPreview;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/24
 */
public class SiteDavyPreviewDriver extends AbstractMonitoringDownloadDriver {
    private static final String MENU_1_LEVEL = "运营管理";
    private static final String MENU_2_LEVEL = "本月成本费用预览";
    private Logger logger = LoggerFactory.getLogger(SiteDavyPreviewDriver.class);

    public SiteDavyPreviewDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public SiteDavyPreviewDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("成本费用预览-导出")) {
                    file2.delete();
                }
            }
        }

        //同意
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#exportExcelPanelContentTable > tbody > tr:nth-child(2) > td > form > center >input:nth-child(1)")).click();
        TimeUnit.SECONDS.sleep(3);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpSiteDavyPreview.class};
        int[] skipLines = new int[]{1};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("成本费用预览-导出")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
                TimeUnit.SECONDS.sleep(5);
                FileTools.deleteFile(file1);
            }
        }
        return classListMap;
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>();
        TimeUnit.SECONDS.sleep(5);

        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        //窗口跳转易错点
        String src = null;
        try {
            src = iframes.get(2).getAttribute("src");
        } catch (Exception e) {
            try {
                src = iframes.get(1).getAttribute("src");
            } catch (Exception e1) {
                throw e1;
            }
        }
        driver.get(src);
        TimeUnit.SECONDS.sleep(4);
//#table1 > tbody > tr:nth-child(2) > td:nth-child(4)
        driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(2) > td:nth-child(4)")).click();
        chromeWait(driver, 10);
        driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(2) > td:nth-child(4) > select > option:nth-child(2)")).click();
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.cssSelector("#queryForm > center > input:nth-child(1)")).click();
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(3);

        //下载
        List<WebElement> webElements = driver.findElements(By.cssSelector("#queryForm > input.rich-button"));
        for (WebElement webElement : webElements) {
            if("导出Excel".equals(webElement.getAttribute("value"))){
                webElement.click();
                break;
            }
        }
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(3);

        mapMarge(tmpMap, parse());
        logger.debug("结果集：{}", tmpMap);
        return tmpMap;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }
}
