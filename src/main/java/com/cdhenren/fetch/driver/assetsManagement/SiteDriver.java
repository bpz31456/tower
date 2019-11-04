package com.cdhenren.fetch.driver.assetsManagement;

import com.cdhenren.fetch.driver.AbstractResourceManager;
import com.cdhenren.fetch.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/04/25
 */
public class SiteDriver extends AbstractResourceManager {
    private static final String MAIN_MENU = "站址";

    public SiteDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }
    public SiteDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap,semaphore);
    }

    @Override
    protected void setup() throws Exception {
        next(MAIN_MENU);
    }

    @Override
    protected List<ResultSet> parse() {
        String content = driver.getPageSource();
        Document document = Jsoup.parse(content);
        Elements lines = document.select("div.objbox > table > tbody > tr");
        List<ResultSet> tmpSiteList = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpSite tmpSite = new TmpSite();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpSite, values);
            if (StringUtils.isEmpty(tmpSite.get站址编码()) || StringUtils.isEmpty(tmpSite.get省())) {
                continue;
            }
            tmpSiteList.add(tmpSite);
        }
        return tmpSiteList;
    }

    /**
     * IE才能处理下载，但是现在未实现完
     *
     * @throws InterruptedException
     */
    private void download() throws Exception {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#arw_doExport")).click();
        List<WebElement> webElements3 = driver.findElements(By.cssSelector(".btn_item"));
        for (WebElement element : webElements3) {
            String item = element.getAttribute("idd");
            if ("exportAll".equals(item)) {
                element.click();
            }
        }
        addHandle();
        driver.switchTo().window(hands.get(3));
        chromeWait(driver,3);
        driver.findElement(By.cssSelector(".btn_onmouseover")).click();

        //回到之前的工作空间
        driver.switchTo().window(hands.get(2));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions action = new Actions(driver);
        int count = 0;
        while (true) {
            WebElement webElement2 = driver.findElement(By.cssSelector("#exportAllWin"));
            if (webElement2.getText().contains("完成")) {
                action.moveToElement(webElement2).clickAndHold();
                break;
            }
            TimeUnit.SECONDS.sleep(1);
            if (count++ > 10) {
                break;
            }
        }
        WebElement webElement1 = driver.findElement(By.cssSelector("#downQueryExcel"));
        webElement1.click();
    }

}
