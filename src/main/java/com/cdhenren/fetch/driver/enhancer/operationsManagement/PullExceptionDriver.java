package com.cdhenren.fetch.driver.enhancer.operationsManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpHistoryWarnHbase;
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
public class PullExceptionDriver extends AbstractDriverEnhancerTemplate {
    public PullExceptionDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }
    private List<ResultSet> resultSets = new ArrayList<>(1 << 10);
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
        monitoring("资源管理", "取信异常设备清单");
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

        //查询
        driver.findElement(By.cssSelector("#queryForm\\3a btn1")).click();
        TimeUnit.SECONDS.sleep(10);

        //导出
        driver.findElement(By.cssSelector("#queryForm\\3a j_id27")).click();
        TimeUnit.SECONDS.sleep(2);

        //#j_id287 > center:nth-child(2) > input:nth-child(3)
        //TODO 下载当页
        driver.findElement(By.cssSelector("#j_id287 > center:nth-child(2) > input:nth-child(3)")).click();
        TimeUnit.SECONDS.sleep(20);

        dealDownLoadFile(resultSets, 1, TmpPullException.class, "取信异常设备清单");
    }
}
