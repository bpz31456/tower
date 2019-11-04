package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.config.Location;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpPhoto;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.FileTools;
import org.apache.commons.lang3.StringUtils;
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
 * 资源管理
 *
 * @author Baopz
 * @date 2018/04/27
 */
public class PhotoDownloadDriver extends AbstractDriverTemplate {
    private static final String RESOURCE_MENU = "200010";
    private Logger logger = LoggerFactory.getLogger(PhotoDownloadDriver.class);

    public PhotoDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public PhotoDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected void setup() throws Exception {
        //跳转到经典分析界面
        toSticalAnalysisMenu();
        //窗口跳转
        List<WebElement> iframes = driver.findElements(By.cssSelector("iframe"));
        logger.debug("iframes的长度:{}", iframes.size());
        driver.get(iframes.get(0).getAttribute("src"));
        //完成
        completed(searchData());
    }

    private Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>();
        //左边树形菜单
        List<WebElement> list = driver.findElements(By.cssSelector("#bjui-accordionmenu > div:nth-child(2) > div:nth-child(2) > div > ul > li"));
        for (WebElement webElement : list) {
            String txt = webElement.getText();
            if (StringUtils.isNotEmpty(txt) && txt.contains("照片统计")) {
                webElement.click();
                chromeWait(driver, 5);
                TimeUnit.SECONDS.sleep(2);
                webElement.findElement(By.cssSelector("ul > li:nth-child(1)")).click();
                chromeWait(driver, 5);
                TimeUnit.SECONDS.sleep(2);
                break;
            }
        }
        //内容区域
        List<WebElement> as = driver.findElements(By.cssSelector("#photoStation-doc-datagrid-table4 > tbody > tr > td > div > a"));
        for (WebElement a : as) {
            String txt = a.getText();
            logger.debug("列表消息：{}", txt);
            if (StringUtils.isNotEmpty(txt) && txt.contains("西藏自治区")) {
                a.click();
                chromeWait(driver, 10);
                TimeUnit.SECONDS.sleep(2);
                break;
            }
        }

        List<WebElement> subAs = driver.findElements(By.cssSelector("#photoStation-doc-datagrid-table4 > tbody > tr > td > div > a"));
        for (WebElement a : subAs) {
            String txt = a.getText();
            logger.debug("地区：{}", txt);
            if (StringUtils.isNotEmpty(txt) && txt.contains(Location.acquireNameOfId(MyBatisUtil.getLocation()))) {
                a.click();
                chromeWait(driver, 10);
                TimeUnit.SECONDS.sleep(2);
                break;
            }
        }
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(2);
        mapMarge(tmpMap, parse());
        return tmpMap;
    }

    private Map<Class, List<? extends ResultSet>> parse() throws Exception {
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("质量专题-西藏自治区-"+Location.acquireNameOfId(MyBatisUtil.getLocation())+"-站址照片统计-详细数据")) {
                    file2.delete();
                }
            }
        }
        //下载
        driver.findElement(By.cssSelector("#bjui-searchBar > div.pull-right > div:nth-child(1) > button")).click();
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#bjui-searchBar > div.pull-right > div.btn-group.open > ul > li:nth-child(2) > a")).click();

        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector(" #bjui-alertMsgBox > div > div > div.toolBar > ul > li:nth-child(1) > button")).click();
        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(2);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpPhoto.class};
        int[] skipLines = new int[]{4};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("质量专题-西藏自治区-"+Location.acquireNameOfId(MyBatisUtil.getLocation())+"-站址照片统计-详细数据")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
                TimeUnit.SECONDS.sleep(5);
                FileTools.deleteFile(file1);
            }
        }
        return classListMap;
    }

    private void toSticalAnalysisMenu() throws Exception {
        hands.add(firstHand);
        /*List<WebElement> webElements = driver.findElement(By.cssSelector("#appModuleDiv")).findElements(By.cssSelector(".module"));

        for (WebElement webElement : webElements) {
            String moduleId = webElement.getAttribute("moduleid");
            if (moduleId.equals(RESOURCE_MENU)) {
                webElement.click();
                break;
            }
        }*/
        //2018.07.07 版本更新
        gotoModelMenu("资源管理");
        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(1));

        chromeWait(driver, 3);
        driver.findElement(By.cssSelector("body > div:nth-child(12) > div.nav > ul > li:nth-child(6)")).click();
        TimeUnit.SECONDS.sleep(2);
        addHandle();
        driver.switchTo().window(hands.get(2));

        chromeWait(driver, 10);
        driver.findElement(By.cssSelector("#olddiv")).click();
        TimeUnit.SECONDS.sleep(2);
        addHandle();
        driver.switchTo().window(hands.get(3));
        chromeWait(driver, 10);
    }

}
