package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 运维监控
 * @author Baopz
 * @date 2018/05/24
 */
public abstract class AbstractMonitoringDownloadDriver extends AbstractDriverTemplate {
    private Logger logger = LoggerFactory.getLogger(AbstractMonitoringDownloadDriver.class);
    private static final String REAL_ESTATE_MENU = "200007";

    protected AbstractMonitoringDownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public AbstractMonitoringDownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void next(String menuLevel1, String menuLevel2) throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = null;
        //监控系统
        toMonitorMenu();
        TimeUnit.SECONDS.sleep(30);
        chromeWait(driver,30);
        //进入
        driver.findElement(By.cssSelector("#app > div.navbar > div > ul.nav.nav-left > li > a")).click();
        TimeUnit.SECONDS.sleep(5);
        //
        List<WebElement> menus = driver.findElements(By.cssSelector("div.popover-content > div.popover-sider > ul > li"));
        for (WebElement menu : menus) {
            logger.debug("菜单信息{}",menu.getText());
            if(menu.getText().contains(menuLevel1)){
                menu.click();
                chromeWait(driver,10);
                List<WebElement> subMenus =  driver.findElements(By.cssSelector("#app > div.popover.bottom.popover-home.animated.bounceInDown.active > div.popover-content > div.popover-content-inner > div > dl > dd > a"));
                logger.debug("子菜长度{}",subMenus==null?0:subMenus.size());
                for (WebElement subMenu : subMenus) {
                    logger.debug("子菜名称{}",subMenu.getText());
                    if(menuLevel2.equals(subMenu.getText())) {
                        subMenu.click();
                        chromeWait(driver, 10);
                        break;
                    }
                }
                break;
            }
        }

        //入库
        completed(searchData());
    }

    protected void toMonitorMenu() throws Exception {
        hands.add(firstHand);
        //2018.07.07 版本更新
        gotoModelMenu("运维监控");

        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(1));
    }

    protected Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>();
        TimeUnit.SECONDS.sleep(5);

        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        for (int i = 0; i < iframes.size(); i++) {
            logger.debug("src:{}{}",i,iframes.get(i).getAttribute("src"));
        }
        String src = iframes.get(2).getAttribute("src");
        driver.get(src);
        TimeUnit.SECONDS.sleep(3);

        //勾选左边的树结构
        driver.findElement(By.cssSelector("#burTree > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2)")).click();

        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(2);
        //FSU全选，易错点
        //#queryForm > center:nth-child(2) > table:nth-child(3) > tbody > tr:nth-child(3) > td:nth-child(2) > button
        driver.findElement(By.cssSelector("#queryForm > center:nth-child(2) > table:nth-child(3) > tbody > tr:nth-child(3) > td:nth-child(2) > button")).click();
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(2);
        //全选按钮
        //2018.10.20
        /*driver.findElement(By.cssSelector("body > div:nth-child(127) > div > ul > li:nth-child(1)")).click();*/
        //driver.findElement(By.cssSelector("body > div:nth-child(158) > div > ul > li:nth-child(1)")).click();
        //2018.11.12
        //#ext-gen6 > div:nth-child(167) > div > ul > li:nth-child(1) > a
//        driver.findElement(By.cssSelector("body > div:nth-child(159) > div > ul > li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("body > div:nth-child(167) > div > ul > li:nth-child(1)")).click();

        //是否锁定，易错点
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#queryForm > center:nth-child(2) > table:nth-child(3) > tbody > tr:nth-child(6) > td:nth-child(6) > button")).click();

        mapMarge(tmpMap, parse());
        logger.debug("结果集：{}",tmpMap);
        return tmpMap;
    }


    /**
     * 解析数据
     *
     * @return
     */
    protected abstract Map<Class, List<? extends ResultSet>> parse() throws Exception;
}
