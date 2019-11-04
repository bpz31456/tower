package com.cdhenren.fetch.driver.enhancer.propertyManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpBasicInformation;
import com.cdhenren.fetch.entity.TmpEleMeter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Fuhj
 * @date
 */
public class EleMeterEnhancerDriver extends AbstractDriverEnhancerTemplate {
    public EleMeterEnhancerDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }
    private List<ResultSet> resultSets = new ArrayList<>(1 << 10);

    @Override
    protected void saveData() throws Exception {
        logger.debug("完成");
        MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        completed(resultSets);
    }

    @Override
    protected void setup() throws Exception {
        chromeWait(driver, 3);
        //基础信息
        WebElement element = driver.findElement(By.cssSelector("#customMenu > ul > li:nth-child(9)"));
        hover(driver, element);
        //
        List<WebElement> menus = driver.findElements(By.cssSelector("#customMenu > ul > li > ul > li"));
        logger.info("size={}", menus.size());
        for (WebElement menu : menus) {
            String text = menu.getText();
            logger.info("{}", text);
            if (menu.getText().contains("电表信息管理")) {
                menu.click();
                break;
            }
        }
        chromeWait(driver, 5);
        TimeUnit.SECONDS.sleep(2);
        //页面跳转
        //url=/default/baseinfo/property/QueryPropertyInfo.jsp?_t=667802&_winid=w6904
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 5);
        for (int i = 0; i < iframes.size(); i++) {
            logger.debug("src:{}{}", i, iframes.get(i).getAttribute("src"));
        }
        String src = iframes.get(2).getAttribute("src");
        logger.debug("物业信息管理:size={},跳转页面：{}", iframes.size(), src);
        driver.get(src);
        TimeUnit.SECONDS.sleep(3);
        //查询
        try {
            driver.findElement(By.cssSelector("#searchBtn")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector("#searchButton")).click();
            } catch (Exception e1) {
                driver.findElement(By.cssSelector("#search_btn")).click();
            }
        }

        TimeUnit.SECONDS.sleep(1);
        //导出
        driver.findElement(By.cssSelector("#exportBtn")).click();
        TimeUnit.SECONDS.sleep(1);

        //确认按钮
        driver.findElement(By.cssSelector(".mini-messagebox-buttons > .mini-button")).click();
        TimeUnit.SECONDS.sleep(20);
        //TmpSiteRemovalRate.class
        dealDownLoadFile(resultSets, 1, TmpEleMeter.class, "电表信息");
    }
}
