package com.cdhenren.fetch.driver.property;

import com.cdhenren.fetch.driver.AbstractDriverTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 物业管理，excel导出版本
 *
 * @author Baopz
 * @date 2018/04/28
 */
public abstract class AbstractDownloadRealEstate extends AbstractDriverTemplate {
    private Logger logger = LoggerFactory.getLogger(AbstractDownloadRealEstate.class);

    protected AbstractDownloadRealEstate(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public AbstractDownloadRealEstate(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toRealEstateMenu() throws Exception {

        //2018.07.07 版本更新
        gotoModelMenu("物业管理");

        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(2));
    }

    protected Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>();
        TimeUnit.SECONDS.sleep(5);

        //第一次Iframe
        chromeWait(driver, 5);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 5);
        String src = iframes.get(2).getAttribute("src");
        logger.debug("物业信息管理:size={},跳转页面：{}",iframes.size(),src);
        driver.get(src);

        TimeUnit.SECONDS.sleep(3);
        try {
            driver.findElement(By.cssSelector("#searchBtn")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector("#searchButton")).click();
            } catch (Exception e1) {
                driver.findElement(By.cssSelector("#search_btn")).click();
            }
        }
        mapMarge(tmpMap, parse());
        return tmpMap;
    }

    /**
     * 进入具体菜单
     *
     * @param menu1level
     * @param menu2level
     */
    protected void next(String menu1level, String menu2level) throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = null;
        //物业管理跳转
        toRealEstateMenu();

        TimeUnit.SECONDS.sleep(5);
        chromeWait(driver, 10);
        //#customMenu > ul > li
        List<WebElement> level1menus = driver.findElements(By.cssSelector("#customMenu > ul > li"));
        for (WebElement level1menu : level1menus) {
            String menuTitle = level1menu.findElement(By.cssSelector("a")).getText();
            if (menuTitle.contains(menu1level)) {
                Actions action = new Actions(driver);
                action.moveToElement(level1menu).perform();
                List<WebElement> level2menus = level1menu.findElements(By.cssSelector("ul > li > a"));
                logger.debug("物业管理：一级菜单{},二级菜单数量{}", menuTitle, level2menus == null ? 0 : level2menus.size());
                for (WebElement level2menu : level2menus) {
                    String subMenu = level2menu.getText();
                    logger.debug("菜单：{}", subMenu);
                    if (subMenu.contains(menu2level)) {
                        level2menu.click();
                        break;
                    }
                }
                TimeUnit.SECONDS.sleep(1);
            }
        }
        TimeUnit.SECONDS.sleep(2);
        //入库
        completed(searchData());
    }

    /**
     * 解析数据
     *
     * @return
     */
    protected abstract Map<Class, List<? extends ResultSet>> parse() throws Exception;

}
