package com.cdhenren.fetch.driver.enhancer.propertyManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleFee1;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author bpz777@163.com
 */
public class EleFee1EnhancerDriver extends AbstractDriverEnhancerTemplate {
    public EleFee1EnhancerDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    private List<ResultSet> resultSets = new ArrayList<>(1 << 10);

    @Override
    protected void saveData() throws Exception {
        logger.debug("完成");
       // MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        //completed(resultSets);
    }

    @Override
    protected void setup() throws Exception {
        chromeWait(driver, 3);
        //电费报账及核销
        WebElement element = driver.findElement(By.cssSelector("#customMenu > ul > li:nth-child(10)"));
        hover(driver, element);
        //
        List<WebElement> menus = driver.findElements(By.cssSelector("#customMenu > ul > li > ul > li"));
        logger.info("size={}", menus.size());
        for (WebElement menu : menus) {
            String text = menu.getText();
            logger.info("{}", text);
            if (menu.getText().contains("电费支付台账")) {
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
        String src = iframes.get(2).getAttribute("src");
        logger.debug("size={},跳转页面：{}", iframes.size(), src);
        driver.get(src);
        TimeUnit.SECONDS.sleep(3);
        //条件筛选
        driver.findElement(By.cssSelector("#cityOrgcode > span > span > span.mini-buttonedit-button")).click();
        //#mini-6\24 2
        //#mini-6 > div.mini-listbox-border > div.mini-listbox-view > div > table
        List<WebElement> items = driver.findElements(By.cssSelector("#mini-6 > div.mini-listbox-border > div.mini-listbox-view > div > table > tbody > tr"));
        int itemLen = items.size();
        logger.info("下拉框数量：{}",itemLen);
        //各个点击下载
        for (int i = 0; i < itemLen; i++) {
            WebElement item = items.get(i);
            String text = item.getText();
            if (StringUtils.isEmpty(text) || text.contains("西藏自治区")) {
                continue;
            }
            item.click();
            driver.findElement(By.cssSelector("#searchBtn")).click();
            chromeWait(driver, 5);
            TimeUnit.SECONDS.sleep(2);
            //导出
            driver.findElement(By.cssSelector("#expExcelBtn")).click();
            TimeUnit.SECONDS.sleep(5);
            items = driver.findElements(By.cssSelector("#mini-6 > div.mini-listbox-border > div.mini-listbox-view > div > table > tr"));
        }
        TimeUnit.SECONDS.sleep(5);
        dealDownLoadFile(resultSets, 2, TmpEleFee1.class, "电费有票支付台账");
        //TODO 测试
    }
}
