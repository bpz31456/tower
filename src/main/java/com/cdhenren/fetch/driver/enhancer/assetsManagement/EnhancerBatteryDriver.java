package com.cdhenren.fetch.driver.enhancer.assetsManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpBattery;
import com.cdhenren.fetch.entity.TmpSite;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 蓄电池
 * @author Fuhj
 */
public class EnhancerBatteryDriver extends AbstractDriverEnhancerTemplate {
    public EnhancerBatteryDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    private List<ResultSet> resultSets;
    @Override
    protected void setup() throws Exception {
        //获取数据
        chromeWait(driver, 3);
        //资源资产管理
        WebElement element = driver.findElement(By.cssSelector("#nav > li:nth-child(3)"));
        hover(driver, element);
        TimeUnit.SECONDS.sleep(1);
        //资源管理
        WebElement element1 = driver.findElement(By.cssSelector("#nav > li:nth-child(3) > dl > dd:nth-child(1)"));
        hover(driver, element1);
        TimeUnit.SECONDS.sleep(1);
        WebElement element2 = driver.findElement(By.cssSelector("#nav > li:nth-child(3) > dl > dd:nth-child(1) > ul > li:nth-child(1)"));
        hoverAndClick(driver, element2);
        TimeUnit.SECONDS.sleep(1);
        addHandle();
        gotoLastHandle();
        String reswebUrl = driver.getCurrentUrl().replace("&itemId=508", "");
        driver.get(reswebUrl);
        TimeUnit.SECONDS.sleep(1);
        resourceManageMenuControl("蓄电池组");
        resultSets = resourceManageQueryData();
    }

    @Override
    protected void saveData() throws Exception {
        logger.debug("完成");
        MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        completed(resultSets);
    }

    @Override
    protected List<ResultSet> resourceManageParse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpBatterys = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpBattery tmpBattery = new TmpBattery();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpBattery, values);
            if (StringUtils.isEmpty(tmpBattery.get资产编号())) {
                continue;
            }
            tmpBatterys.add(tmpBattery);
        }
        return tmpBatterys;
    }
}
