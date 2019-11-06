package com.cdhenren.fetch.driver.enhancer.operationsManagement;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.entity.TmpHistoryWarnHbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 历史告警Hbase-日监控
 *
 * @author Fuhj
 */
public class HistoryWarnHbaseDriver extends AbstractDriverEnhancerTemplate {

    private List<ResultSet> resultSets = new ArrayList<>(1 << 10);

    public HistoryWarnHbaseDriver(TaskWrap taskWrap, Semaphore semaphore) {
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
        monitoring("网络监控", "历史告警Hbase查询");
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

        driver.findElement(By.cssSelector("#queryForm\\3a firststarttimePopup")).click();
        TimeUnit.SECONDS.sleep(1);

        //日历计算
        WebElement calendar = driver.findElement(By.cssSelector("#queryForm\\3a firststarttime > tbody"));
        List<WebElement> weeks = calendar.findElements(By.cssSelector("tr"));
        //初始化时起始(3,1),today(x,y)
        int todayX = 0, todayY = 0;
        String today = "0", yesterday = "0";
        for (int i = 3; i < weeks.size() - 2; i++) {
            WebElement week = weeks.get(i);
            List<WebElement> days = week.findElements(By.cssSelector("td"));
            for (int j = 1; j < days.size(); j++) {
                WebElement day = days.get(j);
                String cssStyle = day.getAttribute("class");
                String dayTxt = day.getText().trim();
                if (cssStyle != null && cssStyle.contains("rich-calendar-today")) {
                    todayX = i;
                    todayY = j;
                    today = dayTxt;
                }
                //边界最大值
                if (cssStyle.contains("rich-calendar-boundary-dates")) {
                    if (Integer.valueOf(dayTxt) > Integer.valueOf(yesterday)) {
                        yesterday = dayTxt;
                    }
                }
            }
        }
        //起始点或者1号，需要换前一页，并且重新计算日历有效的最后一天
        if (todayX == 3 && todayY == 1) {
            driver.findElement(By.cssSelector("#queryForm\\3a firststarttimeHeader > table > tbody > tr > td:nth-child(2) > div")).click();
            TimeUnit.SECONDS.sleep(1);
            todayX = 7;
            todayY = 7;
        } else if ("1".equals(today)) {
            driver.findElement(By.cssSelector("#queryForm\\3a firststarttimeHeader > table > tbody > tr > td:nth-child(2) > div")).click();
            TimeUnit.SECONDS.sleep(1);
            calendar = driver.findElement(By.cssSelector("#queryForm\\3a firststarttime > tbody"));
            weeks = calendar.findElements(By.cssSelector("tr"));
            for (int i = 3; i < weeks.size() - 2; i++) {
                WebElement week = weeks.get(i);
                List<WebElement> days = week.findElements(By.cssSelector("td"));
                for (int j = 1; j < days.size(); j++) {
                    WebElement day = days.get(j);
                    String dayTxt = day.getText().trim();
                    if (dayTxt.equals(yesterday)) {
                        todayX = i;
                        todayY = j;
                    }
                }
            }
        } else if (todayX != 3 && todayY == 1) {
            todayX = todayX - 1;
            todayY = 7;
        } else {
            todayY = todayY - 1;
        }

        //点击日历
        TimeUnit.SECONDS.sleep(2);
        calendar = driver.findElement(By.cssSelector("#queryForm\\3a firststarttime > tbody"));
        weeks = calendar.findElements(By.cssSelector("tr"));
        for (int i = 3; i < weeks.size() - 2; i++) {
            WebElement week = weeks.get(i);
            List<WebElement> days = week.findElements(By.cssSelector("td"));
            for (int j = 1; j < days.size(); j++) {
                WebElement day = days.get(j);
                if (i == todayX && j == todayY) {
                    day.click();
                    break;
                }
            }
        }
        //查询
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("#queryForm\\3a j_id49")).click();
        //导出
        chromeWait(driver, 20);
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.cssSelector("#queryForm\\3a j_id54")).click();
        //选择全部
        TimeUnit.SECONDS.sleep(1);
//        driver.findElement(By.cssSelector("#j_id297\\3a devExport")).click();
        //#j_id297\3a devExport
        //#j_id297 > center:nth-child(2) > input:nth-child(3)
        driver.findElement(By.cssSelector("#j_id297 > center:nth-child(2) > input:nth-child(3)")).click();
        TimeUnit.SECONDS.sleep(10);
        dealDownLoadFile(resultSets, 1, TmpHistoryWarnHbase.class, "历史告警HBASE");
    }
}
