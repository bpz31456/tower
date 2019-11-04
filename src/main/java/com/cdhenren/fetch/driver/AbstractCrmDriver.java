package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * CRM
 * @author Baopz
 * @date 2018/05/02
 */
public abstract class AbstractCrmDriver extends AbstractDriverTemplate {
    private static final String REAL_ESTATE_MENU = "200002";

    protected AbstractCrmDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    protected AbstractCrmDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toCrmMenu() throws Exception {
        hands.add(firstHand);

        //2018.07.07 版本更新
        gotoModelMenu("CRM");

        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(2));
    }

    protected Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>(5);
        TimeUnit.SECONDS.sleep(5);

        //第一次Iframe
        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        driver.switchTo().frame(0);

        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 10);

        mapMarge(tmpMap, parse());
        return tmpMap;
    }

    /**
     * 解析数据
     *
     * @return
     */
    protected abstract Map<Class, List<? extends ResultSet>> parse() throws Exception;

    /**
     * 进入具体菜单
     *
     * @param menu1level
     * @param menu2level
     */
    protected void next(String menu1level, String menu2level) throws Exception{
        Map<Class, List<? extends ResultSet>> tmpMap = null;
        //合同菜单
        toCrmMenu();
        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 10);
        List<WebElement> level1menus = driver.findElements(By.cssSelector("body > div > div > div.logo_search_coment_wrap > div.nav > div > ul > li"));
        for (WebElement level1menu : level1menus) {
            String menuTitle = level1menu.getText();
            if (menuTitle.contains(menu1level)) {
                Actions action = new Actions(driver);
                action.moveToElement(level1menu).perform();
                List<WebElement> level2menus = level1menu.findElements(By.cssSelector("div.menu_list_info > div"));
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
