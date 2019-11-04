package com.cdhenren.fetch.driver;

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
 * 项目管理
 *
 * @author Baopz
 * @date 2018/05/15
 */
public abstract class AbstractProjDownloadDriver extends AbstractDriverTemplate {
    private static final String REAL_ESTATE_MENU = "200001";

    private Logger logger = LoggerFactory.getLogger(AbstractProjDownloadDriver.class);

    protected AbstractProjDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    protected AbstractProjDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toProjMenu() throws Exception {
        hands.add(firstHand);
        //2018.07.07 版本更新
        gotoModelMenu("项目管理");

        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(2));
    }

    protected Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>();
        TimeUnit.SECONDS.sleep(5);

        //第一次Iframe
        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        String src = iframes.get(0).getAttribute("src");
        driver.get(src);

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
    protected void next(String menu1level, String menu2level) throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = null;
        //项目管理
        toProjMenu();
        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 10);
        //version2.0.2 界面修复
//        List<WebElement> level1menus = driver.findElements(By.cssSelector("#customMenu > ul > li"));
        List<WebElement> level1menus = driver.findElements(By.cssSelector("#customMenuLevel1 > li"));
        for (WebElement level1menu : level1menus) {
            String menuTitle = level1menu.findElement(By.cssSelector("a")).getText();
            if (menuTitle.contains(menu1level)) {
                Actions action = new Actions(driver);
                action.moveToElement(level1menu).perform();
                //version2.0.2 界面修复
//                List<WebElement> level2menus = level1menu.findElements(By.cssSelector("ul > li > a"));
                List<WebElement> level2menus = driver.findElements(By.cssSelector("#childMenu > div > div > dl > dt "));
                logger.debug("level2menus.长度:{}",level2menus.size());
                for (WebElement level2menu : level2menus) {
                    String subMenu = level2menu.getText();
                    logger.debug("text:{}",subMenu);
                    if (subMenu.contains(menu2level)) {
                        level2menu.findElement(By.cssSelector("a")).click();
                    }
                }
            }
        }
        //入库
        completed(searchData());
    }

}
