package driver;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TmpAsset;
import com.cdhenren.fetch.exception.LoginException;
import com.cdhenren.fetch.exception.PageNotLoadedException;
import com.cdhenren.fetch.tools.ReflectTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.Asserts;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverFuctionTest {

    private String firstHand;
    private List<String> hands = new ArrayList<>();

    @Test
    public void main() throws Exception {
        WebDriver driver = new ChromeDriver(iniChromeOptions());
        try {
            //登录
            login(driver);
            //到主界面
            toMainPage(driver);
            //
            setup(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //driver.quit();
        }

    }

    private void setup(WebDriver driver) {
        System.out.println("选择资产卡片");
        //调用资产卡片
        try {
            asset(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void asset(WebDriver driver) throws Exception {
        System.out.println("进入菜单选项");
        chromeWait(driver, 1);
        addHandle(driver);
        driver.switchTo().window(hands.get(1));
        WebElement element = driver.findElement(By.cssSelector("#returnOld"));
        showTargetElement(driver, element);
        element.click();
        chromeWait(driver, 1);
        //资源管理跳转
        List<WebElement> webElements = driver.findElement(By.cssSelector("body > div.menu-left > div.div_scroll")).findElements(By.cssSelector("ul > li"));
        System.out.println("webElements" + webElements.size());
        for (WebElement webElement : webElements) {
            String moduleId = webElement.getText();
            if (moduleId.equals("资源管理")) {
                webElement.findElement(By.cssSelector("a")).click();
                break;
            }
        }
        TimeUnit.SECONDS.sleep(3);

        chromeWait(driver, 3);
        addHandle(driver);
        driver.switchTo().window(hands.get(2));

        //

        TimeUnit.SECONDS.sleep(10);
        chromeWait(driver, 3);
        driver.get("http://res.chinatowercom.cn:7010/resweb/mainFrame.spr?method=basicframe&viewPathId=190&itemId=508");
        //driver.findElement(By.cssSelector("body > div:nth-child(12) > div.nav > ul > li:nth-child(4)")).click();
        /*TimeUnit.SECONDS.sleep(2);
        addHandle(driver);
        driver.switchTo().window(hands.get(3));*/

        //
        chromeWait(driver, 3);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        chromeWait(driver, 2);
        driver.switchTo().frame(iframe);

        List<WebElement> webElements1 = driver.findElements(By.cssSelector("span.standartTreeRow"));
        for (WebElement webElement : webElements1) {
            String txt = webElement.getText();
            if ("资产卡片".equals(txt)) {
                webElement.click();
                break;
            }
        }
        driver.switchTo().defaultContent();
        //入库
        searchData(driver);
    }

    protected List<ResultSet> searchData(WebDriver driver) throws InterruptedException {
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

       /* //version1.1.4
        driver.findElement(By.cssSelector("#moreCondition")).click();
        TimeUnit.SECONDS.sleep(2);

        //version1.1.4 添加条件
        driver.findElement(By.cssSelector("#C_as_WORK_GROUP_NAME")).sendKeys(new String[]{"林芝"});
        TimeUnit.SECONDS.sleep(2);*/

        //设置pageSize为200，默认是20，新增一个0，得到200
        driver.findElement(By.id("pageSize")).sendKeys(new String[]{"0"});

        //点击查询按钮
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector(".dhxcont_global_layout_area > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div")).click();

        //解析数据
        TimeUnit.SECONDS.sleep(3);
        tmpList = parse(driver);

        //获取分页信息
        String totalPage = driver.findElement(By.id("totalPages")).getText();
        String page = driver.findElement(By.id("page")).getAttribute("value");

        int pageInt = Integer.valueOf("".endsWith(page) ? "2" : page);
        if (StringUtils.isEmpty(totalPage)) {
            for (; ; pageInt++) {
                TimeUnit.SECONDS.sleep(3);
                List<ResultSet> resultSets = parse(driver);
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
                tmpList.addAll(parse(driver));

                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
            }
        }
        System.out.println("tmpList:总长度" + tmpList.size());
        return tmpList;
    }

    protected List<ResultSet> parse(WebDriver driver) {
        Document document = Jsoup.parse(driver.getPageSource());
        Elements lines = document.select("div.objbox > table > tbody > tr");

        List<ResultSet> tmpAssets = new ArrayList<>(lines.size());
        for (Element line : lines) {
            TmpAsset tmpAsset = new TmpAsset();
            List<String> values = new ArrayList<>();
            Elements elements = line.select("td");
            for (Element element : elements) {
                String e = element.html();
                if (e.contains("img")) {
                    continue;
                }
                values.add(e.contains("&nbsp;") ? "" : e);
            }
            ReflectTools.reflectEntity(tmpAsset, values);
            //TODO xxxx
            if (StringUtils.isEmpty(tmpAsset.get站址编码())) {
                continue;
            }
            tmpAssets.add(tmpAsset);
        }
        return tmpAssets;
    }

    private void addHandle(WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (hands.contains(handle)) {
                continue;
            }
            hands.add(handle);
        }
        hands.removeAll(Collections.singleton(null));
    }


    private void login(WebDriver driver) throws InterruptedException, LoginException {
        driver.get("http://4a.chinatowercom.cn:20000/uac_oa/web3/jsp/login/login.jsp");
        driver.findElement(By.cssSelector("#username")).sendKeys(new String[]{""});
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("#password")).sendKeys(new String[]{""});
        TimeUnit.SECONDS.sleep(2);

        //登录按钮
        try {
            driver.findElement(By.cssSelector("body > div.container > div.box > div > div:nth-child(2) > input.login_btn")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector("body > div.wrap > div > div.right-form > div:nth-child(4) > input.btn")).click();
            } catch (Exception e1) {
                throw new LoginException("登录界面元素发生改变", e);
            }
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            //ignore
        }

        //强制登录确认按钮，利用异常跳转，是比较低效的方式，可以修改为条件跳转，不想改
        try {
            WebElement submit1 = driver.findElement(By.cssSelector("#btn_kick > button.login-btn.bg-red"));
            WebElement submit2 = driver.findElement(By.cssSelector("#btn_kick > button.oalogin-btn.bg-red"));
            //如果为空，则是没有提示
            if (submit2 != null || submit1 != null) {
                Actions actions = new Actions(driver);
                actions.moveToElement(submit1).click().perform();
                actions = new Actions(driver);
                actions.moveToElement(submit2).click().perform();
            }
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            //ignore
        }

        //
        TimeUnit.SECONDS.sleep(3);
        chromeWait(driver, 5);
        //关闭广告version1.1.1改版
        try {
            List<WebElement> ads = driver.findElements(By.cssSelector("div[id^=_DialogDiv_]"));
            if (ads != null) {
                ads.get(0).findElement(By.cssSelector("td > div:nth-child(2)")).click();
            }
        } catch (Exception e) {
            //ignore
        }
    }
//#returnOld
    private void toMainPage(WebDriver driver) throws InterruptedException, PageNotLoadedException {
        //跳转到主界面
        TimeUnit.SECONDS.sleep(2);
        chromeWait(driver, 2);
        List<WebElement> webElements = driver.findElements(By.cssSelector("#con_dh > dl:nth-child(1) > dd > p"));
        for (WebElement webElement : webElements) {
            System.out.println(webElement.getText());
            if ("运营管理".equals(webElement.getText())) {
                webElement.click();
            }
        }

        chromeWait(driver, 10);
        TimeUnit.SECONDS.sleep(10 + new Random().nextInt(5));
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        if (iframes == null || iframes.isEmpty()) {
            throw new PageNotLoadedException("在等待<运营管理>菜单界面加载10s后，尝试监控时没有发现有效的iframe元素。");
        }
        Asserts.check(iframes.size() > 2, "主页iframe数量必须大于2.");

        System.out.println("长度：" + iframes.size());
        if (iframes.size() == 10) {
            driver.get(iframes.get(8).getAttribute("src"));
        } else if (iframes.size() == 8) {
            driver.get(iframes.get(6).getAttribute("src"));
        } else if (iframes.size() == 9) {
            driver.get(iframes.get(7).getAttribute("src"));
        } else {
            //尝试用index=6来解析
            driver.get(iframes.get(6).getAttribute("src"));
        }
        chromeWait(driver, 5);
        TimeUnit.SECONDS.sleep(2);
        firstHand = driver.getWindowHandle();
        System.out.println("进入选择界面");
    }

    private void chromeWait(WebDriver driver, long sec) {
        try {
            driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ChromeOptions iniChromeOptions() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fuhj\\Desktop\\env\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        //后续处理IE下面下载问题
        String userAgentIE11 = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko";
        chromePrefs.put("profile.general_useragent_override", userAgentIE11);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.managed_default_content_settings.images", 2);
        //对于实验性质的选项
        options.setExperimentalOption("prefs", chromePrefs);
        //消除安全校验
        options.addArguments("--allow-running-insecure-content");
        //最大化
        options.addArguments("--ash-enable-fullscreen-app-list");
        //启动最大化，防止失去焦点
        options.addArguments("--start-maximized");
        //关闭gpu图片渲染
        options.addArguments("--disable-gpu");
        //无界面浏览器
//        options.setHeadless(true);
        //user-agent 设置 profile.general_useragent_override

        //以下打开日志
        /*LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.PROFILER, Level.ALL);
        logs.enable(LogType.SERVER, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS,logs);
        options.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY,true);*/

        //webDriver错误弹框，同意,貌似没啥用
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        return options;
    }

    private void showTargetElement(WebDriver webDriver, WebElement targetElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        //内置参数arguments复制，[0]为下标
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", targetElement);
    }
}
