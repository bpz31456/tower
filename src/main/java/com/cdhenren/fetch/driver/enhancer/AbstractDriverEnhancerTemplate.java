package com.cdhenren.fetch.driver.enhancer;

import com.cdhenren.fetch.config.SingleThreadPoolFactory;
import com.cdhenren.fetch.dao.bean.CommonMapper;
import com.cdhenren.fetch.dao.xml.SysTaskMapper;
import com.cdhenren.fetch.dao.xml.TmpMapper;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.driver.AbstractDriverTemplate;
import com.cdhenren.fetch.entity.*;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import com.cdhenren.fetch.group.Region;
import com.cdhenren.fetch.group.Session;
import com.cdhenren.fetch.group.SessionManager;
import com.cdhenren.fetch.group.TaskRegion;
import com.cdhenren.fetch.tools.DbUtils;
import com.cdhenren.fetch.tools.DynamicSqlUtils;
import com.cdhenren.fetch.tools.FileTools;
import com.cdhenren.fetch.tools.TableColumnInfoInterceptor;
import com.cdhenren.fetch.tools.poi.ExcelEnhancerUtils;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import com.cdhenren.fetch.tools.poi.Relationship;
import com.cdhenren.fetch.tools.poi.RelationshipFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 增强抽象模板
 *
 * @author Fuhj
 */
public abstract class AbstractDriverEnhancerTemplate extends AbstractDriverTemplate {
    private volatile Session session;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public AbstractDriverEnhancerTemplate(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
        session = SessionManager.getSession(taskWrap.getSysTask().getUser());
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            //登陆处理
            login0();
            //继续处理
            setup0();
            //当前任务结束
            theOneSessionCompleted();
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
            clearSession();
            exceptionHandler(e);
            try {
                semaphore.release();
            } catch (Exception e1) {
                //ignore
            }
        }
    }

    private void setup0() throws Exception {
        setup();
        //这里需要事务控制
        //updateHisTask();
        //
        //结果处理
        saveData();
    }

    /**
     * 保存结果
     *
     * @throws Exception
     */
    protected abstract void saveData() throws Exception;

    /**
     * 当前任务结束
     */
    private void theOneSessionCompleted() {
        ThreadPoolExecutor threadPoolExecutor = SingleThreadPoolFactory.shareSingleThread("[" + this.taskWrap.getSysTask().getUser() + "]Session");
        BlockingQueue<Runnable> taskQueue = threadPoolExecutor.getQueue();
        if (taskQueue == null || taskQueue.size() == 0) {
            logger.debug("当前Session剩余任务量:{}", 0);
            SessionManager.removeSessin(this.taskWrap.getSysTask().getUser());
            clearSession();
        } else {
            logger.debug("当前Session剩余任务量:{}", taskQueue.size());
        }
    }

    /**
     * 分为三个阶段，
     * 第一个阶段登陆操作，
     * 第二个阶段，跳转一级菜单
     * 第三个阶段，跳转二级菜单
     */
    private void login0() throws Exception {
        logger.info("login status:{}", session.isLogin());
        //登陆
        if (!session.isLogin()) {
            login();
            session.login();
            SessionManager.addSession(session);
            SessionManager.addDriver(session, driver);
        }
        //判断第二阶段
        if (session.getRegion() == null || !session.getRegion().isEnter()) {
            TaskRegion firstRegion = getTaskRegion(taskWrap.getSysTask().getFirstRegion());
            if (firstRegion.equals(TaskRegion.OPERATIONS_MANAGE) || firstRegion.equals(TaskRegion.OPERATION_ANALYSIS_MAIN)) {
                driver.get(firstRegion.getUrl());
            } else {
                throw new Exception("在第一阶段登录时，未发现正确的TaskRegion");
            }
            session.setRegion(new Region(firstRegion, true));
        }

        //判断第三阶段
        if (session.getRegion().getSubRegion() == null || !session.getRegion().getSubRegion().isEnter()) {
            TaskRegion secRegion = getTaskRegion(taskWrap.getSysTask().getSecRegion());
            if (secRegion.equals(TaskRegion.OPERATION_ANALYSIS)) {
                toOperationAnalysis();
            } else {
                gotoModelMenu(secRegion.getModelName());
            }
            addHandle();
            gotoLastHandle();
            session.getRegion().setSubRegion(new Region(secRegion, true));
        }
        //初始化
        String url = session.getRegion().getSubRegion().getCurRegion().getUrl();
        logger.debug("三阶段url:{}", url);
        driver = SessionManager.getDriver(session);
        if (driver == null) {
            initProperty();
            SessionManager.addDriver(session, driver);
        }
        driver.get(url);
    }

    private void toOperationAnalysis() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        chromeWait(driver, 10);
        List<WebElement> webElements = driver.findElements(By.cssSelector("#con_dh > dl:nth-child(1) > dd > p"));
        for (WebElement webElement : webElements) {
            if ("运营分析".equals(webElement.getText())) {
                webElement.click();
            }
        }
    }

    private TaskRegion getTaskRegion(String regionName) throws Exception {
        for (TaskRegion value : TaskRegion.values()) {
            if (value.name().equals(regionName)) {
                return value;
            }
        }
        throw new Exception("没有发现名为" + regionName + "的Region");
    }

    private void clearSession() {
        session.loginOut();
        if (driver != null) {
            driver.quit();
        }
    }

    protected void excelDataSave(String filename) throws Exception {
        String region = taskWrap.getSysTask().getLocation();
        String tableName = taskWrap.getSysTask().getTmpTable();
        //过滤KEY_ID,CRT_DATE两个字段，自动添加
        TableColumnInfoInterceptor interceptor = new TableColumnInfoInterceptor(new String[]{"KEY_ID", "CRT_DATE"});
        List<TableColumnInfo> tableColumnInfos = DbUtils.getTableColumns(region, tableName);
        Relationship relationship = RelationshipFactory.generator(region, tableName, interceptor);
        Map<String, List<Object>> stringListMap =
                ExcelEnhancerUtils.readFile(filename,
                        new int[]{1},
                        relationship,
                        new String[]{tableName});
        stringListMap.forEach((s, objects) -> {
            logger.info("tableName:{},size:{}", s, objects.size());
        });

        List<Object> list = stringListMap.get(tableName);

        //入库
        MyBatisUtil.setLocation(region);
        SqlSession sqlSession = MyBatisUtil.getSession(ExecutorType.BATCH);
        CommonMapper mapper = sqlSession.getMapper(CommonMapper.class);
        DynamicSqlUtils.batchInsert(list, tableName, tableColumnInfos)
                .insertStatements().forEach(mapper::insert);
        sqlSession.commit();
        MyBatisUtil.closeSession(sqlSession);
    }

    protected void completed() throws Exception {
        SqlSession session = MyBatisUtil.getSession(taskWrap.getSysTask().getLocation());
        try {
            TmpMapper mapper = session.getMapper(TmpMapper.class);
            mapper.truncateTable(taskWrap.getSysTask().getTmpTable());
            //清空tmp表
            SysTaskMapper sysTaskMapper = session.getMapper(SysTaskMapper.class);
            SysTaskHis sysTaskHis = sysTaskToHis(taskWrap.getSysTask());
            //更新his
            sysTaskMapper.insertSysTaskHis(sysTaskHis);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        }
        MyBatisUtil.closeSession(session);
    }

    private SysTaskHis sysTaskToHis(SysTask sysTask) {
        SysTaskHis sysTaskHis = new SysTaskHis();
        sysTaskHis.setBeginTime(sysTask.getBeginTime());
        sysTaskHis.setCrtDate(sysTask.getCrtDate());
        sysTaskHis.setDetail(sysTask.getDetail());
        sysTaskHis.setEndTime(sysTask.getEndTime());
        sysTaskHis.setKeyId(sysTask.getKeyId());
        sysTaskHis.setState(sysTask.getState());
        sysTaskHis.setTaskCode(sysTask.getTaskCode());
        sysTaskHis.setReTry("" + sysTask.getReTry());
        sysTaskHis.setLocation(sysTask.getLocation());
        logger.debug(sysTaskHis.toString());
        return sysTaskHis;
    }

    protected void hover(WebDriver driver, WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    protected void hoverAndClick(WebDriver driver, WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
    }

    /**
     * 资源管理，点击到具体的菜单界面
     *
     * @param mainMenu
     */
    protected void resourceManageMenuControl(String mainMenu) {
        chromeWait(driver, 3);
        for (WebElement webElement : driver.findElements(By.cssSelector(".standartTreeImage"))) {
            try {
                if (webElement.findElement(By.tagName("img")).getAttribute("src").contains("plus3.gif")) {
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
        for (WebElement webElement : driver.findElements(By.cssSelector(".standartTreeRow"))) {
            String txt = webElement.getText();
            if (mainMenu.equals(txt)) {
                webElement.click();
                break;
            }
        }
    }

    /**
     * 资源管理数据查询
     *
     * @return
     * @throws Exception
     */
    protected List<ResultSet> resourceManageQueryData() throws Exception {
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
        tmpList = resourceManageParse();
        if (tmpList.isEmpty()) {
            return tmpList;
        }
        //获取分页信息
        TimeUnit.SECONDS.sleep(2);
        chromeWait(driver, 10);
        String page = driver.findElement(By.id("page")).getAttribute("value");
        int pageInt = Integer.valueOf("".endsWith(page) ? "1" : page);
        String totalPage = driver.findElement(By.id("totalPages")).getText();
        //TODO 开发测试调整采集次数
        totalPage = "2";
        if (StringUtils.isEmpty(totalPage)) {
            for (int i = 2; ; i++) {
                driver.findElement(By.cssSelector("#next")).click();
                chromeWait(driver, 3);
                TimeUnit.SECONDS.sleep(5);
                List list = resourceManageParse();
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
                tmpList.addAll(resourceManageParse());
            }
        }
        return tmpList;
    }

    /**
     * 资源管理数据解析，需要重写
     *
     * @return
     */
    protected List<ResultSet> resourceManageParse() {
        return null;
    }

    /**
     * 处理download的文件
     * @param resultSets
     * @param key
     * @return
     * @throws Exception
     */
    protected List<ResultSet> dealDownLoadFile(List<ResultSet> resultSets,int skip,Class clazz, String key) throws Exception {
        if (resultSets == null) {throw new Exception("需要实例化接受参数");}
        FileTools.list(downloadPath, key).forEach(s -> {
            try {
                List<? extends ResultSet> rs = ExcelUtils.readFile(new File(s), new int[]{skip}, new Class[]{clazz}).get(clazz);
                resultSets.addAll(rs);
                logger.info("读取数据条数：{}", rs.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return resultSets;
    }
}
