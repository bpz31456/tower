package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleFee2;
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
 * @author Baopz
 * @date 2018/04/28
 */
public class EleFee2Driver extends AbstractRealEstate {
    private static final String MENU_1_LEVEL = "电费报账及核销";
    private static final String MENU_2_LEVEL = "电费支付台账";
    private static final String MACHINE_ACCOUNT = "转供电支付台账";

    public EleFee2Driver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public EleFee2Driver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected List<ResultSet> parse() {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select(".mini-grid-row");

        List<ResultSet> tmpEleFee2s = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpEleFee2 tmpEleFee2 = new TmpEleFee2();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.select("div").html();
                if (e.contains("checkbox")) {
                    continue;
                }
                values.add(e.indexOf("&nbsp;") > -1 ? "" : e);
            }
            reflectEntity(tmpEleFee2, values);
            if (StringUtils.isEmpty(tmpEleFee2.get省())) {
                continue;
            }
            tmpEleFee2s.add(tmpEleFee2);
        }
        return tmpEleFee2s;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }

    @Override
    protected List<ResultSet> searchData() throws InterruptedException {
        List<ResultSet> tmpList = new ArrayList<>(500);
        TimeUnit.SECONDS.sleep(5);

        //第一次Iframe
        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        String src = iframes.get(1).getAttribute("src");
        driver.get(src);

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector(".mini-pager-size > span > .mini-buttonedit-border > .mini-buttonedit-buttons")).click();
        List<WebElement> items = driver.findElements(By.cssSelector(".mini-listbox-items > tbody > tr"));
        for (WebElement item : items) {
            if (item.getText().contains("100")) {
                item.click();
                break;
            }
        }

        driver.findElement(By.xpath("//*[@id=\"eleCostType\"]/span/span/span[2]/span")).click();
        List<WebElement> machineAccounts = driver.findElements(By.cssSelector(".mini-listbox-item"));
        for (WebElement machineAccount : machineAccounts) {
            if (MACHINE_ACCOUNT.equals(machineAccount.getText())) {
                machineAccount.click();
                break;
            }
        }
        //点击查询按钮
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#searchBtn")).click();

        TimeUnit.SECONDS.sleep(3);
        String page = driver.findElement(By.cssSelector(".mini-pager-index > .mini-pager-num")).getAttribute("value");
        String pageSize = driver.findElement(By.cssSelector(".mini-pager-index > .mini-pager-pages")).getText();
        pageSize = pageSize.replaceAll("/", "").replaceAll("\\s", "");

        int pageInt = Integer.valueOf(page);
        int pageSizeInt = Integer.valueOf(pageSize);

        //解析数据
        TimeUnit.SECONDS.sleep(2);
        //获取分页信息
        for (tmpList.addAll(parse()); pageInt < pageSizeInt; pageInt++) {
            chromeWait(driver, 3);
            TimeUnit.SECONDS.sleep(1);
            List<WebElement> miniButtons = driver.findElements(By.cssSelector(".mini-button"));
            for (WebElement webElement : miniButtons) {
                if (webElement.getAttribute("title").contains("下一页")) {
                    webElement.click();
                    break;
                }
            }
            chromeWait(driver, 3);
            tmpList.addAll(parse());
        }
        return tmpList;
    }
}
