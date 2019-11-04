package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.*;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * CRM综合查询
 *
 * @author Baopz
 * @date 2018/05/02
 */
public class CrmComprehensiveQueryDriver extends AbstractCrmDriver {

    private static final String MENU_1_LEVEL = "综合查询";
    private static final String MENU_2_LEVEL = "综合查询";
    private SysTaskService sysTaskService = new SysTaskServiceImpl();

    public CrmComprehensiveQueryDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public CrmComprehensiveQueryDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {

        chromeWait(driver, 3);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File file = new File(downloadPath);
        for (File file1 : file.listFiles()) {
            if (file1.getName().contains("订单文件")) {
                file1.delete();
            }
        }
        //下载
        driver.findElement(By.cssSelector("#downLorad")).click();
        Class[] classes = new Class[]{TmpTowerOrder.class, TmpRoomClassify.class, TmpTransferOrder.class, TmpNonSignOrder.class, TmpTinySiteOrder.class};
        int[] skipLines = new int[]{4, 4, 4, 4, 4};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("订单文件")) {
                classListMap = ExcelUtils.readFile(file1, skipLines, classes);
                TimeUnit.SECONDS.sleep(5);
                FileTools.deleteFile(file1);
            }
        }
        return classListMap;
    }

    @Override
    protected void setup() throws Exception {
        next(MENU_1_LEVEL, MENU_2_LEVEL);
    }

    /**
     * 修改的部分
     * @param menu1level
     * @param menu2level
     * @throws Exception
     */
    protected void next(String menu1level, String menu2level) throws Exception{
        Map<Class, List<? extends ResultSet>> tmpMap = null;
        //合同菜单
        toCrmMenu();
        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 10);
        driver.findElement(By.cssSelector("body > div > div > div.width1200.content > div.menu_announcement_wrap.clear > div.Quick_menu.radius.floatL > div:nth-child(2) > a:nth-child(1)")).click();
        /*List<WebElement> level1menus = driver.findElements(By.cssSelector("body > div > div > div.logo_search_coment_wrap > div.nav > div > ul > li"));
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
        }*/
        chromeWait(driver, 10);
        //入库
        completed(searchData());
    }
}
