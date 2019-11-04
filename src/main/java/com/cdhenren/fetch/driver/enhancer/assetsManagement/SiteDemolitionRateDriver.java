package com.cdhenren.fetch.driver.enhancer.assetsManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpSiteRemovalRate;
import com.cdhenren.fetch.tools.FileTools;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Fuhj
 * @date 2019.11.03
 * 资管-站址拆除率
 */
public class SiteDemolitionRateDriver extends AbstractDriverEnhancerTemplate {
    private List<ResultSet> resultSets = new ArrayList<>(1<<3);

    public SiteDemolitionRateDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected void saveData() throws Exception {
        logger.debug("完成");
        MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        completed(resultSets);
    }

    @Override
    protected void setup() throws Exception {
        //获取数据
        chromeWait(driver, 3);
        //统计分析
        driver.findElement(By.cssSelector("#nav > li:nth-child(7)")).click();
        //资源管理
        TimeUnit.SECONDS.sleep(1);
        addHandle();
        gotoLastHandle();
        //
        driver.findElement(By.cssSelector("#old")).click();
        TimeUnit.SECONDS.sleep(1);
        addHandle();
        gotoLastHandle();
        TimeUnit.SECONDS.sleep(1);
        //菜单
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < iframes.size(); i++) {
            logger.debug("src:{}{}", i, iframes.get(i).getAttribute("src"));
        }
        String src = iframes.get(0).getAttribute("src");
        driver.get(src);
        TimeUnit.SECONDS.sleep(1);
        //站址拆除率
        driver.findElement(By.cssSelector("#bjui-doc-tree-base-quality_86_span")).click();
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> as = driver.findElements(By.cssSelector("#removesta-doc-datagrid-table4 > tbody > tr > td > div > a"));
        for (WebElement a : as) {
            logger.info("{}",a.getText());
            if(a.getText().contains("西藏自治区")){
                a.click();
                break;
            }
        }
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#bjui-searchBar > div.pull-right > div:nth-child(1) > button")).click();
        //下载按钮
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#bjui-searchBar > div.pull-right > div.btn-group.open > ul > li:nth-child(2) > a > span")).click();
        //确认按钮
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#bjui-alertMsgBox > div > div > div.toolBar > ul > li:nth-child(1) > button")).click();
        TimeUnit.SECONDS.sleep(2);
        //处理数据
        dealDownLoadFile(resultSets,4,TmpSiteRemovalRate.class,"站址拆除率");
    }
}
