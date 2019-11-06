package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.config.TaskQueueFactory;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.SysTask;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.exception.LoginException;
import com.cdhenren.fetch.exception.PageNotLoadedException;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;
import com.cdhenren.fetch.task.TaskType;
import com.cdhenren.fetch.tools.PropertiesTools;
import com.cdhenren.fetch.tools.ReflectTools;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 统一抽象驱动
 * 参考文档：http://chromedriver.chromium.org/
 *
 * @author Baopz
 * @version 1.0.0
 * @date 2018/04/25
 */
public abstract class AbstractDriverTemplate implements Runnable {
    protected List<String> hands = new ArrayList<>();
    protected WebDriver driver;
    protected String firstHand;
    protected TaskWrap taskWrap;
    protected Semaphore semaphore;
    private static Logger logger = LoggerFactory.getLogger(AbstractDriverTemplate.class);
    protected SysTaskService sysTaskService = new SysTaskServiceImpl();
    protected String downloadPath = PropertiesTools.getProperty("tower.properties", "downLoadPath");

    protected AbstractDriverTemplate() {
    }

    protected AbstractDriverTemplate(TaskWrap taskWrap) {
        this.taskWrap = taskWrap;
    }

    protected AbstractDriverTemplate(TaskWrap taskWrap, Semaphore semaphore) {
        this.taskWrap = taskWrap;
        this.semaphore = semaphore;
    }

    /**
     * 初始化配置
     */
    protected void initProperty() {
        driver = new ChromeDriver(iniChromeOptions(downloadPath));
    }

    /**
     * version1.1.2新增
     *
     * @return
     */
    public TaskWrap getTaskWrap() {
        return taskWrap;
    }

    /**
     * firefox 初始化参数设置
     *
     * @param downloadPath
     * @return
     * @since 0.0.1
     * version1.0.0已经被抛弃
     */
    @Deprecated
    protected FirefoxOptions initFirefoxOptions(String downloadPath) {
        System.setProperty("webdriver.gecko.driver", PropertiesTools.getProperty("tower.properties", "driver"));
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        /**以下使用手动配置**/
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", downloadPath);
        firefoxProfile.setPreference("browser.download.panel.shown", false);
        firefoxProfile.setPreference("browser.tabs.loadBookmarksInBackground", true);
        firefoxProfile.setPreference("browser.tabs.loadDivertedInBackground", true);
        firefoxProfile.setPreference("browser.tabs.loadInBackground", true);

        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk"
                , "text/html,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        firefoxProfile.setPreference("permissions.default.image", 2);
        //打开混合模式，https和http同时使用
        firefoxProfile.setPreference("security.mixed_content.block_active_content", false);
        // 设置脚本无响应提示时间 =0 : 不提示
        firefoxProfile.setPreference("dom.max_script_run_time", 0);
        firefoxOptions.setProfile(firefoxProfile);
        return firefoxOptions;
    }

    /**
     * chrome初始化参数设置
     *
     * @param download
     * @return
     */
    private ChromeOptions iniChromeOptions(String download) {
        String location = getTaskWrap().getSysTask().getLocation();
        Path path = Paths.get(download).resolve(location == null ? "NoLocation" : location).resolve(this.hashCode() + "");
        if (!Files.isDirectory(path) && !Files.exists(path)) {
            try {
                path = Files.createDirectories(path);
                downloadPath = path.toString();
                logger.info("临时文件夹创建成功.{}", path);
            } catch (IOException e) {
                logger.warn("临时文件夹创建失败.{}", e.fillInStackTrace());
            }
        }
        System.setProperty("webdriver.chrome.driver", PropertiesTools.getProperty("tower.properties", "driver"));
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>(1 << 3);
        //后续处理IE下面下载问题
        String useragentie11 = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko";
        chromePrefs.put("profile.general_useragent_override", useragentie11);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.managed_default_content_settings.images", 2);
        chromePrefs.put("download.default_directory", downloadPath);
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
//        options.addArguments("user-data-dir=C:/test");
        //无界面浏览器，貌似不起作用
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


    /**
     * 系统统一登录
     *
     * @since 1.0.0
     * <p>
     * 1.注释部分为version1.1.0，2018.07.07,更新
     */
    protected void login() throws LoginException {
        initProperty();
        driver.get("http://4a.chinatowercom.cn:20000/uac_oa/web3/jsp/login/login.jsp");
        driver.findElement(By.cssSelector("#username")).sendKeys(new String[]{taskWrap.getSysTask().getUser()});
        driver.findElement(By.cssSelector("#password")).sendKeys(new String[]{taskWrap.getSysTask().getPwd()});
        chromeWait(driver, 2);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            //ignore
        }
        //登录两种方式
        try {
            //version2.0.1
            driver.findElement(By.cssSelector("body > div.container > div.box > div > div:nth-child(2) > input.login_btn")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector("body > div.wrap > div > div.right-form > div:nth-child(4) > input.btn")).click();
            } catch (Exception e1) {
                throw new LoginException("登录界面元素发生改变", e);
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            //ignore
        }
        //强制登录确认按钮，利用异常跳转，是比较低效的方式，可以修改为条件跳转，不想改
        //消除提示version2.0.1
        try {
            WebElement submit1 = driver.findElement(By.cssSelector("#btn_kick > button.login-btn.bg-red"));
            WebElement submit2 = driver.findElement(By.cssSelector("#btn_kick > button.oalogin-btn.bg-red"));
            //如果为空，则是没有提示
            if (submit1 != null || submit2 != null) {
                Actions actions = new Actions(driver);
                actions.moveToElement(submit1).click().perform();

                actions = new Actions(driver);
                actions.moveToElement(submit2).click().perform();
            }
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            //ignore
            //throw new LoginException("用户在其他地方未注销时，点击确认注销按钮时出错。");
        }
        chromeWait(driver, 3);
    }

    protected boolean isLoginExclude() {
        return false;
    }

    /**
     * 数据采集或稽核实体或调用过程
     *
     * @throws Exception
     */
    protected abstract void setup() throws Exception;


    /**
     * 消除限流设置
     *
     * @since 1.0.0
     */
    @Override
    public void run() {
        //线程设置地区
        MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            logger.error("获取Semaphore信号失败。");
        }
        //开始时间设置
        logger.debug("BEGIN_TIME:{}", taskWrap.getSysTask().getBeginTime());
        if (taskWrap.getSysTask().getBeginTime() == null) {
            taskWrap.getSysTask().setBeginTime(new Timestamp(System.currentTimeMillis()));
            try {
                logger.debug("taskWrap.getTaskType:{},TaskType.ETL_P_CHECK:{}", taskWrap.getTaskType(), TaskType.ETL_P_CHECK);
                if (TaskType.ETL_P_CHECK != taskWrap.getTaskType()) {
                    sysTaskService.updateTask(taskWrap, null);
                }
            } catch (Exception e) {
                logger.warn("更新开始时间失败.{}", e.getMessage());
            }
        }
        logger.debug("BEGIN_TIME 设置后:{}", taskWrap.getSysTask().getBeginTime());
        //登录处理
        if (!isLoginExclude()) {
            try {
                login();
                toMainMemu();
            } catch (Exception e) {
                if (driver != null) {
                    driver.quit();
                }
                exceptionHandler(e);
                semaphore.release();
                return;
            }
        }
        //逻辑处理
        try {
            setup();
        } catch (Exception e) {
            exceptionHandler(e);
        } finally {
            if (driver != null) {
                driver.quit();
            }
            semaphore.release();
        }
    }

    /**
     * version.1.1.1改版
     * 主界面新增广告
     *
     * @throws Exception
     */
    protected void toMainMemu() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        chromeWait(driver, 10);
        //关闭广告version1.1.1改版
        try {
            List<WebElement> ads = driver.findElements(By.cssSelector("div[id^=_DialogDiv_]"));
            if (ads != null) {
                ads.get(0).findElement(By.cssSelector("td > div:nth-child(2)")).click();
            }
        } catch (Exception e) {
            //ignore
        }
        //跳转到主界面
        TimeUnit.SECONDS.sleep(2);
        chromeWait(driver, 5);
        List<WebElement> webElements = driver.findElements(By.cssSelector("#con_dh > dl:nth-child(1) > dd > p"));
        for (WebElement webElement : webElements) {
            if ("运营管理".equals(webElement.getText())) {
                webElement.click();
            }
        }

        chromeWait(driver, 5);
        TimeUnit.SECONDS.sleep(1 + new Random().nextInt(5));
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        if (iframes == null || iframes.isEmpty()) {
            throw new PageNotLoadedException("在等待<运营管理>菜单界面加载10s后，尝试监控时没有发现有效的iframe元素。");
        }
        logger.info("iframems 长度{}", iframes.size());
        Asserts.check(iframes.size() > 2, "主页iframe数量必须大于2.");
        for (int i = 0; i < iframes.size(); i++) {
            logger.debug("iframes {},src {}", i, iframes.get(i).getAttribute("src"));
        }
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
        firstHand = driver.getWindowHandle();
        chromeWait(driver, 1);
        hands.add(firstHand);

        //
        addHandle();
        driver.switchTo().window(hands.get(1));
        WebElement element = driver.findElement(By.cssSelector("#returnOld"));
        showTargetElement(driver, element);
        element.click();
        chromeWait(driver, 1);
    }

    protected void showTargetElement(WebDriver webDriver, WebElement targetElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        //内置参数arguments复制，[0]为下标
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", targetElement);
    }


    /**
     * 2018.07.07，官方版本更新，需要做处调整,
     * 2019.09.07，公共界面跳转到模块中
     *
     * @param modelMenuName
     * @throws InterruptedException
     * @since 1.1.0
     */
    protected void gotoModelMenu(String modelMenuName) throws InterruptedException {
        List<WebElement> webElements = driver.findElement(By.cssSelector("body > div.menu-left > div.div_scroll")).findElements(By.cssSelector("ul > li"));
        for (WebElement webElement : webElements) {
            String moduleId = webElement.getText();
            if (moduleId.equals(modelMenuName)) {
                webElement.click();
                break;
            }
        }
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * 停顿加载公共方法
     *
     * @param driver
     * @param sec
     */
    protected void chromeWait(WebDriver driver, long sec) {
        try {
            driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 窗口处理公共方法
     */
    protected void addHandle() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (hands.contains(handle)) {
                continue;
            }
            hands.add(handle);
        }
        hands.removeAll(Collections.singleton(null));
    }

    /**
     * 跳转到最后一个页面
     */
    protected void gotoLastHandle() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        driver.switchTo().window(hands.get(hands.size() - 1));
    }

    /**
     * 异常处理
     *
     * @param e
     * @version 1.1.0
     * 新增登录异常处理,直接设置当前任务无效
     */
    protected void exceptionHandler(Exception e) {
        SysTask sysTask = taskWrap.getSysTask();
        logger.warn("异常信息{}", e);
        String exceptionMsg = e.getMessage();
        exceptionMsg = exceptionMsg == null ? "异常中断。" : exceptionMsg.substring(0, exceptionMsg.length() > 16384 ? 16384 : exceptionMsg.length());
        sysTask.setDetail(exceptionMsg);
        logger.warn(exceptionMsg);

        if (e instanceof LoginException) {
            sysTask.setReTry(sysTask.getReTryMax());
        }

        if (sysTask.getReTry() < sysTask.getReTryMax()) {
            sysTask.setState(SysTask.STATE_1);
            sysTask.setReTry(sysTask.getReTry() + 1);
            try {
                TaskQueueFactory.getInstance(taskWrap.getSysTask().getLocation()).put(taskWrap);
                logger.info("任务重新放入队列中{}", taskWrap);
            } catch (InterruptedException e1) {
                sysTask.setDetail("任务重新添加到队列中失败。" + taskWrap);
                logger.error("{}", e1);
            }
        } else {
            sysTask.setState(SysTask.STATE_2);
            sysTask.setEndTime(new Timestamp(System.currentTimeMillis()));
        }

        try {
            sysTaskService.updateTask(taskWrap, null);
        } catch (Exception e1) {
            logger.error("任务状态更新失败。{}", e1);
        }
    }

    /**
     * 正常结束
     */
    protected void completed(Map<Class, List<? extends ResultSet>> tmpMap) throws Exception {
        updateHisTask();
        sysTaskService.updateTask(taskWrap, tmpMap);
    }

    protected void updateHisTask(){
        taskWrap.getSysTask().setState(SysTask.STATE_3);
        taskWrap.getSysTask().setDetail("任务采集完成");
        taskWrap.getSysTask().setEndTime(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 正常结束
     *
     * @param tmpList
     * @throws Exception
     */
    protected void completed(List<ResultSet> tmpList) throws Exception {
        sysTaskService.updateTask(taskWrap, tmpList);
        updateHisTask();
    }

    protected final void reflectEntity(ResultSet result, List<String> values) {
        ReflectTools.reflectEntity(result, values);
    }

    /**
     * 数据合并
     *
     * @param tmpMap
     * @param sub
     */
    protected void mapMarge(Map<Class, List<? extends ResultSet>> tmpMap, Map<Class, List<? extends ResultSet>> sub) {
        //2018.08.25，修复如果数据未读取到时，直接返回空
        if (sub == null) {
            return;
        }
        if (tmpMap.isEmpty()) {
            tmpMap.putAll(sub);
        } else {
            for (Class parClass : tmpMap.keySet()) {
                for (Class subClass : sub.keySet()) {
                    if (parClass.equals(subClass)) {
                        List<? extends ResultSet> rsList = tmpMap.get(parClass);
                        List<? extends ResultSet> subList = sub.get(subClass);
                        rsList.addAll(convert(subList));
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> convert(List<?> list) {
        return (List<T>) list;
    }

    /**
     * 运维监控菜单
     * @param menuLevel1
     * @param menuLevel2
     * @throws Exception
     */
    protected void monitoring(String menuLevel1, String menuLevel2) throws Exception{
        driver.findElement(By.cssSelector("#app > div.navbar > div > ul.nav.nav-left > li > a")).click();
        TimeUnit.SECONDS.sleep(5);
        //
        List<WebElement> menus = driver.findElements(By.cssSelector("div.popover-content > div.popover-sider > ul > li"));
        for (WebElement menu : menus) {
            logger.debug("菜单信息{}",menu.getText());
            if(menu.getText().contains(menuLevel1)){
                menu.click();
                chromeWait(driver,10);
                List<WebElement> subMenus =  driver.findElements(By.cssSelector("#app > div.popover.bottom.popover-home.animated.bounceInDown.active > div.popover-content > div.popover-content-inner > div > dl > dd > a"));
                logger.debug("子菜长度{}",subMenus==null?0:subMenus.size());
                for (WebElement subMenu : subMenus) {
                    logger.debug("子菜名称{}",subMenu.getText());
                    if(menuLevel2.equals(subMenu.getText())) {
                        subMenu.click();
                        chromeWait(driver, 10);
                        break;
                    }
                }
                break;
            }
        }
    }
}
