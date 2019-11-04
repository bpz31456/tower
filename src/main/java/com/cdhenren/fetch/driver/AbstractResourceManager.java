package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TaskWrap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 资源管理
 * @author Baopz
 * @date 2018/04/27
 */
public abstract class AbstractResourceManager extends AbstractDriverTemplate {
    public static final String TREE_ROW = ".standartTreeRow";
    public static final String TREE_ROW_IMAGE = ".standartTreeImage";
    public static final String TREE_ROW_IMAGE_PLUS = "plus3.gif";
    private static final String RESOURCE_MENU = "200010";

    protected AbstractResourceManager(TaskWrap taskWrap) {
        super(taskWrap);
    }

    protected AbstractResourceManager(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    protected void toResourceManaagerMenu() throws Exception {
        gotoModelMenu("资源管理");
        chromeWait(driver, 3);
        addHandle();
        driver.switchTo().window(hands.get(2));

        chromeWait(driver, 3);
        driver.findElement(By.cssSelector("body > div:nth-child(12) > div.nav > ul > li:nth-child(3)")).click();
        TimeUnit.SECONDS.sleep(2);
        addHandle();
        driver.switchTo().window(hands.get(3));
    }

    @Deprecated
    protected List<ResultSet> searchData() throws Exception {
        List<ResultSet> tmpList;
        TimeUnit.SECONDS.sleep(5);
        //第一次Iframe
        chromeWait(driver, 10);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        chromeWait(driver, 10);
        driver.switchTo().frame(iframe);

        //第二次Ifram
        List<WebElement> webElements1 = driver.findElements(By.tagName("iframe"));
        for (WebElement webElement : webElements1) {
            String src = webElement.getAttribute("src");
            if (!src.contains("mainFrame")) {
                driver.get(src);
                break;
            }
        }

        //第三次IFrame
        chromeWait(driver, 10);
        WebElement webElement = driver.findElement(By.tagName("iframe"));
        driver.get(webElement.getAttribute("src"));

        //第一次点击，加载pageSize
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector(".dhxcont_global_layout_area > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div")).click();

        //设置pageSize为200，默认是20，新增一个0，得到200
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("pageSize")).sendKeys(new String[]{"0"});

        //按照200来重新点击页面
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector(".dhxcont_global_layout_area > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div")).click();

        //解析数据,使分页信息显示出来
        TimeUnit.SECONDS.sleep(2);

        //第一次分析页面
        tmpList = parse();
        if (tmpList.isEmpty()) {
            return tmpList;
        }
        //获取分页信息
        TimeUnit.SECONDS.sleep(2);
        chromeWait(driver, 10);
        String page = driver.findElement(By.id("page")).getAttribute("value");
        int pageInt = Integer.valueOf("".endsWith(page) ? "1" : page);
        String totalPage = driver.findElement(By.id("totalPages")).getText();
        if (StringUtils.isEmpty(totalPage)) {
            for (int i = 2; ; i++) {
                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
                TimeUnit.SECONDS.sleep(5);
                List list = parse();
                if (list.isEmpty()) {
                    break;
                }
                tmpList.addAll(list);
            }
        } else {
            int totalPageInt = Integer.valueOf(totalPage);
            for (; pageInt < totalPageInt; pageInt++) {
                driver.findElement(By.cssSelector("#next")).click();

                chromeWait(driver, 3);
                TimeUnit.SECONDS.sleep(2);
                tmpList.addAll(parse());
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

    protected void next(String mainMenu) throws Exception {
        //资源管理跳转
        toResourceManaagerMenu();
        //把所有的菜单点开
        chromeWait(driver, 3);
        for (WebElement webElement : driver.findElements(By.cssSelector(TREE_ROW_IMAGE))) {
            try {
                if (webElement.findElement(By.tagName("img")).getAttribute("src").contains(TREE_ROW_IMAGE_PLUS)) {
                    webElement.click();
                    chromeWait(driver, 3);
                }
            } catch (NoSuchElementException exception) {
                //屏蔽不能点的标签
                continue;
            }
        }

        chromeWait(driver, 3);
        //具体地址
        for (WebElement webElement : driver.findElements(By.cssSelector(TREE_ROW))) {
            String txt = webElement.getText();
            if (mainMenu.equals(txt)) {
                webElement.click();
                break;
            }
        }
        //入库
        completed(searchData());
    }

}
