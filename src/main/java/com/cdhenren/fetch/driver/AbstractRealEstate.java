package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 物业管理
 *
 * @author Baopz
 * @date 2018/04/28
 */
public abstract class AbstractRealEstate extends AbstractDriverTemplate {
    private static final String REAL_ESTATE_MENU = "200011";

    protected AbstractRealEstate(TaskWrap taskWrap) {
        super(taskWrap);
    }

    protected AbstractRealEstate(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toRealEstateMenu() throws Exception {
        hands.add(firstHand);
        //2018.07.07 版本更新
        gotoModelMenu("物业管理");

        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(2));
    }

    protected List<ResultSet> searchData() throws Exception {
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
        //点击查询按钮
        TimeUnit.SECONDS.sleep(1);
        try {
            driver.findElement(By.cssSelector("#searchBtn")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector("#searchButton")).click();
            } catch (Exception e1) {
                driver.findElement(By.cssSelector("#search_btn")).click();
            }
        }

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

    /**
     * 解析数据
     *
     * @return
     */
    protected abstract List<ResultSet> parse();

    /**
     * 进入具体菜单
     *
     * @param menu1level
     * @param menu2level
     */
    protected void next(String menu1level, String menu2level) throws Exception {
        //物业管理跳转
        toRealEstateMenu();
        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 10);
        List<WebElement> level1menus = driver.findElements(By.cssSelector("#customMenu > ul > li"));
        for (WebElement level1menu : level1menus) {
            String menuTitle = level1menu.findElement(By.cssSelector("a")).getText();
            if (menuTitle.contains(menu1level)) {
                Actions action = new Actions(driver);
                action.moveToElement(level1menu).perform();
                List<WebElement> level2menus = level1menu.findElements(By.cssSelector("ul > li > a"));
                for (WebElement level2menu : level2menus) {
                    String subMenu = level2menu.getText();
                    if (subMenu.contains(menu2level)) {
                        level2menu.click();
                    }
                }
            }
        }
        //入库
        completed(searchData());
    }

}
