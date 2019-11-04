package com.cdhenren.fetch.driver.property;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpEleFee2;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;
import com.cdhenren.fetch.tools.FileTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class EleFee2DownloadDriver extends AbstractDownloadRealEstate {
    private static final String MENU_1_LEVEL = "电费报账及核销";
    private static final String MENU_2_LEVEL = "电费支付台账";
    private static final String MACHINE_ACCOUNT = "转供电支付台账";
    private Logger logger = LoggerFactory.getLogger(EleFee2DownloadDriver.class);
    private SysTaskService sysTaskService = new SysTaskServiceImpl();

    public EleFee2DownloadDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public EleFee2DownloadDriver(TaskWrap taskWrap, Semaphore semaphore) {
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
            if (MACHINE_ACCOUNT.equals(machineAccount.getText())) {
                machineAccount.click();
                break;
            }
        }
        //点击查询按钮
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#searchBtn")).click();
        Map<Class, List<? extends ResultSet>> classListMap = parse();
        logger.debug("外部容器：{},解析出的内容:{}",tmpMap,classListMap);
        mapMarge(tmpMap, classListMap);
        return tmpMap;
    }

    @Override
    protected Map<Class, List<? extends ResultSet>> parse() throws Exception {
        TimeUnit.SECONDS.sleep(60);
        File iniFile = new File(downloadPath);
        if (iniFile.isDirectory()) {
            for (File file2 : iniFile.listFiles()) {
                if (file2.getName().contains("转供电支付台账")) {
                    file2.delete();
                }
            }
        }
        //下载
        driver.findElement(By.cssSelector("#expExcelBtn")).click();
        TimeUnit.SECONDS.sleep(3);

        File file = new File(downloadPath);
        Class[] classes = new Class[]{TmpEleFee2.class};
        int[] skipLines = new int[]{1};
        Map<Class, List<? extends ResultSet>> classListMap = null;
        TimeUnit.SECONDS.sleep(3);
        File[] files = file.listFiles();
        FileTools.rename(files);
        files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("转供电支付台账")) {
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
