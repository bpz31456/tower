package com.cdhenren.fetch.driver.enhancer.operationsManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpPerformance;
import com.cdhenren.fetch.entity.TmpPullException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Fuhj
 */
public class PerformanceDriver extends AbstractDriverEnhancerTemplate {
    private List<ResultSet> resultSets = new ArrayList<>(1 << 10);

    public PerformanceDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected void saveData() throws Exception {
        MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        completed(resultSets);
    }

    @Override
    protected void setup() throws Exception {
        chromeWait(driver, 3);
        TimeUnit.SECONDS.sleep(3);
        //运维监控菜单
        monitoring("网络监控", "性能查询");
        TimeUnit.SECONDS.sleep(3);
        //窗口最大化
        chromeWait(driver, 5);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 5);
        for (int i = 0; i < iframes.size(); i++) {
            logger.debug("src:{}{}", i, iframes.get(i).getAttribute("src"));
        }
        String src = iframes.get(1).getAttribute("src");
        driver.get(src);
        TimeUnit.SECONDS.sleep(2);

        //
        List<WebElement> menus = driver.findElements(By.cssSelector("#burTree > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr"));
        for (int i = 1; i < menus.size(); i++) {
            WebElement menu = menus.get(i);
            menu.findElement(By.cssSelector("td:nth-child(2) > table > tbody > tr > td:nth-child(2)")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.cssSelector("#queryForm\\3a j_id43")).click();
            TimeUnit.SECONDS.sleep(5);
            driver.findElement(By.cssSelector("#queryForm\\3a j_id48")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.cssSelector("#j_id263 > center > input:nth-child(3)")).click();
            TimeUnit.SECONDS.sleep(5);
            menus = driver.findElements(By.cssSelector("#burTree > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr"));
        }
        //日数据-性能数据-交流输入停电告警
        driver.findElement(By.cssSelector("#queryForm\\3a j_id16")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm3\\3a mname")).sendKeys("交流输入停电告警");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm3\\3a queryMid")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("#\\30 418011001")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#j_id359")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm\\3a midType > tbody > tr > td:nth-child(2)")).click();
        TimeUnit.SECONDS.sleep(1);
        //查询，导出当页面
        driver.findElement(By.cssSelector("#queryForm\\3a j_id43")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("#queryForm\\3a j_id48")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#j_id263 > center > input:nth-child(3)")).click();
        TimeUnit.SECONDS.sleep(5);
        //
        //门锁开关状态
        driver.findElement(By.cssSelector("#queryForm\\3a j_id16")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm3\\3a mname")).sendKeys("门锁开关状态");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm3\\3a queryMid")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("#\\30 499006001")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#j_id359")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm\\3a midType > tbody > tr > td:nth-child(2)")).click();
        TimeUnit.SECONDS.sleep(1);
        //查询，导出当页面
        driver.findElement(By.cssSelector("#queryForm\\3a j_id43")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("#queryForm\\3a j_id48")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#j_id263 > center > input:nth-child(3)")).click();
        TimeUnit.SECONDS.sleep(5);

        //油机发电状态
        driver.findElement(By.cssSelector("#queryForm\\3a j_id16")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm3\\3a mname")).sendKeys("油机发电状态");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm3\\3a queryMid")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("#\\30 418012001")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#j_id359")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm\\3a midType > tbody > tr > td:nth-child(2)")).click();
        TimeUnit.SECONDS.sleep(1);
        //查询，导出当页面
        driver.findElement(By.cssSelector("#queryForm\\3a j_id43")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("#queryForm\\3a j_id48")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#j_id263 > center > input:nth-child(3)")).click();
        TimeUnit.SECONDS.sleep(5);

        dealDownLoadFile(resultSets, 1, TmpPerformance.class, "性能-导出");
    }
}
