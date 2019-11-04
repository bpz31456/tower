package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 合同管理
 *
 * @author Baopz
 * @date 2018/05/02
 */
public abstract class AbstractContractDriver extends AbstractDriverTemplate {
    private static final String REAL_ESTATE_MENU = "200012";

    protected AbstractContractDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    protected AbstractContractDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toContractMenu() throws Exception {
        hands.add(firstHand);

        //2018.07.07 版本更新
        gotoModelMenu("合同管理");

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

        //点击查询按钮
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#searchBtn")).click();
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
        //合同菜单
        toContractMenu();
        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 10);
        List<WebElement> level1menus = driver.findElements(By.cssSelector(".mini-menuitem"));
        for (WebElement level1menu : level1menus) {
            String menuTitle = level1menu.getText();
            if (menuTitle.contains(menu1level)) {
                level1menu.click();
                List<WebElement> level2menus = driver.findElements(By.cssSelector(".mini-menuitem"));
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

    /**
     * 解析数据
     *
     * @return
     */
    protected abstract Map<Class, List<? extends ResultSet>> parse() throws Exception;

}
