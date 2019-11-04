package com.cdhenren.fetch.driver.enhancer.assetsManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpAsset;
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
 * 资产卡片
 *
 * @author Fuhj
 */
public class EnhancerAssetDriver extends AbstractDriverEnhancerTemplate {
    public EnhancerAssetDriver(TaskWrap taskWrap, Semaphore semaphore) {
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
        WebElement element1 = driver.findElement(By.cssSelector("#nav > li:nth-child(3) > dl > dd:nth-child(2)"));
        hover(driver, element1);
        TimeUnit.SECONDS.sleep(1);
        WebElement element2 = driver.findElement(By.cssSelector("#nav > li:nth-child(3) > dl > dd:nth-child(2) > ul > li:nth-child(1)"));
        hoverAndClick(driver, element2);
        TimeUnit.SECONDS.sleep(5);
        addHandle();
        gotoLastHandle();
        //记载资产卡片
        chromeWait(driver, 3);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        chromeWait(driver, 10);
        driver.switchTo().frame(iframe);

        List<WebElement> webElements = driver.findElements(By.cssSelector("span.standartTreeRow"));
        for (WebElement webElement : webElements) {
            String txt = webElement.getText();
            if ("资产卡片".equals(txt)) {
                webElement.click();
                break;
            }
        }
        driver.switchTo().defaultContent();
        //
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

        List<ResultSet> tmpAssets = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpAsset tmpAsset = new TmpAsset();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.contains("&nbsp;") ? "" : e);
            }
            reflectEntity(tmpAsset, values);
            if (StringUtils.isEmpty(tmpAsset.get站址编码())) {
                continue;
            }
            tmpAssets.add(tmpAsset);
        }
        return tmpAssets;
    }

    @Override
    protected List<ResultSet> resourceManageQueryData() throws Exception {
        List<ResultSet> tmpList;
        TimeUnit.SECONDS.sleep(5);
        //第一次Iframe
        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        driver.switchTo().frame(iframes.get(1));

        //第二次Ifram
        List<WebElement> webElements1 = driver.findElements(By.tagName("iframe"));
        for (WebElement webElement : webElements1) {
            String src = webElement.getAttribute("src");
            if (!src.contains("mainFrame")) {
                driver.get(src);
                break;
            }
        }

        //设置pageSize为200，默认是20，新增一个0，得到200
        driver.findElement(By.id("pageSize")).sendKeys(new String[]{"0"});

        //点击查询按钮
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector(".dhxcont_global_layout_area > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div")).click();

        //解析数据
        TimeUnit.SECONDS.sleep(3);
        tmpList = resourceManageParse();

        //获取分页信息
        String totalPage = driver.findElement(By.id("totalPages")).getText();
        //TODO 分页处理测试
        totalPage = "2";
        String page = driver.findElement(By.id("page")).getAttribute("value");
        int pageInt = Integer.valueOf("".endsWith(page) ? "2" : page);

        if (StringUtils.isEmpty(totalPage)) {
            for (; ; pageInt++) {
                TimeUnit.SECONDS.sleep(3);
                List<ResultSet> resultSets = resourceManageParse();
                if (resultSets.isEmpty()) {
                    break;
                }
                tmpList.addAll(resultSets);
                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
            }
        } else {
            int totalPageInt = Integer.valueOf(totalPage);
            for (; pageInt <= totalPageInt; pageInt++) {
                TimeUnit.SECONDS.sleep(3);
                tmpList.addAll(resourceManageParse());

                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
            }
        }
        return tmpList;
    }
}
