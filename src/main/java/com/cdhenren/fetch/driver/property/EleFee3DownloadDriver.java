package com.cdhenren.fetch.driver.property;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleFee3;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/15
 */
public class EleFee3DownloadDriver extends AbstractDownloadRealEstate {
    private static final String MACHINE_ACCOUNT = "电费预付费台帐";
    private static final String MENU_1_LEVEL = "电费报账及核销";
    private static final String MENU_2_LEVEL = "电费支付台账";
    private SysTaskService sysTaskService = new SysTaskServiceImpl();

    public EleFee3DownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public EleFee3DownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> searchData() throws Exception {
        Map<Class, List<? extends ResultSet>> tmpMap = new HashMap<>();
        TimeUnit.SECONDS.sleep(5);

        //第一次Iframe
        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        String src = iframes.get(1).getAttribute("src");
        driver.get(src);
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"eleCostType\"]/span/span/span[2]/span")).click();
        List<WebElement> machineAccounts = driver.findElements(By.cssSelector(".mini-listbox-item"));
        for (WebElement machineAccount : machineAccounts) {
            //System.out.println(machineAccount.getText());
            if (MACHINE_ACCOUNT.equals(machineAccount.getText())) {
                machineAccount.click();
                break;
            }
        }
        //点击查询按钮
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#searchBtn")).click();

        mapMarge(tmpMap, parse());
        return tmpMap;
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(60);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("电费预付费台账")) {
                    file2.delete();
                }
            }
        }
        //下载
        driver.findElement(By.cssSelector("#expExcelBtn")).click();
        TimeUnit.SECONDS.sleep(3);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpEleFee3.class};
        int[] skipLines = new int[]{1};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("电费预付费台账")) {
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
}
