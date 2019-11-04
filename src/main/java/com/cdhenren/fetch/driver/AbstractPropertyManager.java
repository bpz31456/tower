package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 资产管理
 *
 * @author Baopz
 * @date 2018/04/27
 */
public abstract class AbstractPropertyManager extends AbstractDriverTemplate {
    public static final String TREE_ROW = "span.standartTreeRow";
    private static final String RESOURCE_MENU = "200010";

    protected AbstractPropertyManager(TaskWrap taskWrap) {
        super(taskWrap);
    }

    protected AbstractPropertyManager(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toPropertyManagerMenu() throws Exception {
        hands.add(firstHand);

        //2018.07.07，官方版本更换，需要更新
        gotoModelMenu("资源管理");

        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(2));

        chromeWait(driver, 3);
        driver.findElement(By.cssSelector("body > div:nth-child(12) > div.nav > ul > li:nth-child(4)")).click();
        TimeUnit.SECONDS.sleep(2);
        addHandle();
        driver.switchTo().window(hands.get(2));
    }

    protected List<ResultSet> searchData() throws InterruptedException {
        List<ResultSet> tmpList;
        TimeUnit.SECONDS.sleep(5);
        //第一次Iframe
        chromeWait(driver, 10);
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        chromeWait(driver, 10);
        driver.switchTo().frame(iframes.get(1));

        //第二次Ifram
        List<WebElement> webElements1 = driver.findElements(By.tagName("iframe"));
        for (WebElement webElement : webElements1) {
            String src = webElement.getAttribute("src");
            if (!src.contains("mainFrame")) {
                driver.get(src);
                break;
            }
        }

        //version1.1.4添加的代码，version2.0.1代码屏蔽，官方功能恢复
       /* driver.findElement(By.cssSelector("#moreCondition")).click();
        TimeUnit.SECONDS.sleep(2);
        //添加条件
        driver.findElement(By.cssSelector("#C_as_WORK_GROUP_NAME")).sendKeys(new String[]{"林芝"});
        TimeUnit.SECONDS.sleep(2);*/


        //设置pageSize为200，默认是20，新增一个0，得到200
        driver.findElement(By.id("pageSize")).sendKeys(new String[]{"0"});

        //点击查询按钮
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector(".dhxcont_global_layout_area > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div")).click();

        //解析数据
        TimeUnit.SECONDS.sleep(3);
        tmpList = parse();

        //获取分页信息
        String totalPage = driver.findElement(By.id("totalPages")).getText();
        String page = driver.findElement(By.id("page")).getAttribute("value");

        int pageInt = Integer.valueOf("".endsWith(page) ? "2" : page);
        if (StringUtils.isEmpty(totalPage)) {
            for (; ; pageInt++) {
                TimeUnit.SECONDS.sleep(3);
                List<ResultSet> resultSets = parse();
                if (resultSets.isEmpty()) {
                    break;
                }
                tmpList.addAll(resultSets);
                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
            }
        } else {
            int totalPageInt = Integer.valueOf(totalPage);


            for (; pageInt <= totalPageInt; pageInt++) {
                TimeUnit.SECONDS.sleep(3);
                tmpList.addAll(parse());

                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
            }
        }

        return tmpList;
    }

    /**
     * 解析数据
     *
     * @return
     */
    protected abstract List<ResultSet> parse();

    /**
     * 第一步
     *
     * @param mainMenu
     */
    protected void next(String mainMenu) throws Exception {
        //资源管理跳转
        toPropertyManagerMenu();

        chromeWait(driver, 3);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        chromeWait(driver, 10);
        driver.switchTo().frame(iframe);

        List<WebElement> webElements = driver.findElements(By.cssSelector(TREE_ROW));
        for (WebElement webElement : webElements) {
            String txt = webElement.getText();
            if (mainMenu.equals(txt)) {
                webElement.click();
                break;
            }
        }
        driver.switchTo().defaultContent();
        //入库
        completed(searchData());
    }

}
