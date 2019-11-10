package com.cdhenren.fetch.server.impl;


import com.cdhenren.fetch.dao.xml.SysTaskMapper;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.*;
import com.cdhenren.fetch.entity.enhancer.SysTableRelationship;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.TmpService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author Baopz
 * @date 2018/04/23
 */
public class SysTaskServiceImpl implements SysTaskService {
    private static Logger logger = LoggerFactory.getLogger(SysTaskServiceImpl.class);
    private SysTaskMapper sysTaskMapper = null;
    private TmpService tmpService = getCGLIBTmpService();

    /**
     * 在插入前清除数据
     *
     * @return
     */
    private TmpService getCGLIBTmpService() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TmpServiceImpl.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            //调用过程时，需要设置,com.cdhenren.fetch.driver.CallProcessDriver中已经这是location
            //需要清空历史数据
            for (FunctionName2Table functionName2Table : FunctionName2Table.values()) {
                if (functionName2Table.getFunctionName().equals(method.getName())) {
                    //insert tmp表的时候清空表数据
                    if("tmp_电费支付台账_直供".equals(functionName2Table.getTableName())){
                        new TmpServiceImpl().truncateTable("tmp_电费支付台账_直供");
                        new TmpServiceImpl().truncateTable("tmp_电费支付台账_转供");
                    }else{
                        new TmpServiceImpl().truncateTable(functionName2Table.getTableName());
                    }
                    break;
                }
            }
            return methodProxy.invokeSuper(o, objects);
        });
        return (TmpServiceImpl) enhancer.create();
    }

    /**
     * version2.0.0 2018.07.26
     *
     * @return
     */
    @Override
    public List<SysTask> sysTasks() {
        List<SysTask> sysTasks = new ArrayList<>(MyBatisUtil.getRegionals().length * 30);
        for (String s : MyBatisUtil.getRegionals()) {
            SqlSession sqlSession = MyBatisUtil.getSession(s);
            try {
                sysTaskMapper = sqlSession.getMapper(SysTaskMapper.class);
                List<SysTask> sysTasks1 = sysTaskMapper.sysTasks();
                for (SysTask sysTask : sysTasks1) {
                    sysTask.setLocation(s);
                }
                sysTasks.addAll(sysTasks1);
            } finally {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
        return sysTasks;
    }

    @Override
    public List<SysTaskPama> taskPamas() throws Exception {
        logger.debug("进入参数获取。");
        List<SysTaskPama> sysTaskPamas = new ArrayList<>(MyBatisUtil.getRegionals().length * 30);
        logger.debug("地区长度{}", MyBatisUtil.getRegionals().length);
        logger.info("MyBatisUtil.getRegionals().length,{}", MyBatisUtil.getRegionals().length);
        for (String regional : MyBatisUtil.getRegionals()) {
            SqlSession sqlSession = MyBatisUtil.getSession(regional);
            try {
                sysTaskMapper = sqlSession.getMapper(SysTaskMapper.class);
                List<SysTaskPama> singleSysTaskPama = sysTaskMapper.taskPamas();
                for (SysTaskPama sysTaskPama : singleSysTaskPama) {
                    sysTaskPama.setLocation(regional);
                }
                sysTaskPamas.addAll(singleSysTaskPama);
                sqlSession.commit();
            } finally {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
        return sysTaskPamas;
    }

    @Override
    public List<SysTaskHis> taskHis() {
        return null;
    }

    @Override
    public void insertCompletedTask(SysTaskHis sysTaskHis) {

    }

    /**
     * 对单个任务进行更新
     *
     * @param taskWrap
     * @param r
     * @return
     * @throws Exception
     * @since 1.0.0
     * version 2.0.0 /2018.07.26
     */
    @Override
    public int updateTask(TaskWrap taskWrap, Object r) throws Exception {
        //得到具体应该得到的Location进行处理，version 2.0.0
        SqlSession sqlSession = MyBatisUtil.getSession(taskWrap.getSysTask().getLocation());
        //结果集处理
        int total = 0;
        try {
            sysTaskMapper = sqlSession.getMapper(SysTaskMapper.class);
            //任务实例
            SysTask sysTask = taskWrap.getSysTask();
            //历史数据
            SysTaskHis sysTaskHis = sysTaskToHis(sysTask);
            //数据表处理
            if (r instanceof List) {
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpSite) {
                    total = tmpService.insertTmpSite((List<TmpSite>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpTower) {
                    total = tmpService.insertTmpTower((List<TmpTower>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpMroom) {
                    total = tmpService.insertTmpMroom((List<TmpMroom>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpSwitchp) {
                    total = tmpService.insertTmpSwitchp((List<TmpSwitchp>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpPlane) {
                    total = tmpService.insertTmpPlanes((List<TmpPlane>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpBattery) {
                    total = tmpService.insertTmpBatterys((List<TmpBattery>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpAirCond) {
                    total = tmpService.insertTmpAirConds((List<TmpAirCond>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpAsset) {
                    logger.info("资产卡片:{}", ((List) r).get(0).toString());
                    total = tmpService.insertTmpAssets((List<TmpAsset>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpEleMeter) {
                    total = tmpService.insertTmpEleMeters((List<TmpEleMeter>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpEleQuan) {
                    total = tmpService.insertTmpEleQuans((List<TmpEleQuan>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpCard) {
                    total = tmpService.insertTmpCards((List<TmpCard>) r);
                }
                /*if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpPropertyR) {
                    total = tmpService.insertTmpPropertyRs((List<TmpPropertyR>) r);
                }*/
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpPropertyContract) {
                    total = tmpService.insertTmpPropertyContracts((List<TmpPropertyContract>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpEleFeeR) {
                    total = tmpService.insertTmpEleFeeRs((List<TmpEleFeeR>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpRent) {
                    total = tmpService.insertTmpRents((List<TmpRent>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpEleFee1) {
                    total = tmpService.insertTmpEleFee1s((List<TmpEleFee1>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpEleFee3) {
                    total = tmpService.insertTmpEleFee3s((List<TmpEleFee3>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpFallView) {
                    total = tmpService.insertTmpFallViews((List<TmpFallView>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpSiteRemovalRate) {
                    total = tmpService.insertTmpSiteRemovalRates((List<TmpSiteRemovalRate>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpBasicInformation) {
                    total = tmpService.insertTmpBasicInformations((List<TmpBasicInformation>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpReProj) {
                    total = tmpService.insertTmpReProjs((List<TmpReProj>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpHistoryWarnHbase) {
                    total = tmpService.insertTmpHistoryWarnHbases((List<TmpHistoryWarnHbase>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpPullException) {
                    total = tmpService.insertTmpPullExceptions((List<TmpPullException>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpWrongEquipment) {
                    total = tmpService.insertTmpWrongEquipments((List<TmpWrongEquipment>) r);
                }
                if ((!((List) r).isEmpty()) && ((List) r).get(0) instanceof TmpPerformance) {
                    total = tmpService.insertTmpPerformances((List<TmpPerformance>) r);
                }
            } else if (r instanceof Map) {
                if ((!((Map) r).isEmpty())) {
                    Set<Class> resultSets = ((Map) r).keySet();
                    Iterator<Class> it = resultSets.iterator();
                    while (it.hasNext()) {
                        Class clazz = it.next();
                        if (clazz.equals(TmpTowerOrder.class)) {
                            total += tmpService.insertTmpTowerOrder((List<TmpTowerOrder>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpRoomClassify.class)) {
                            total += tmpService.insertTmpRoomClassify((List<TmpRoomClassify>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpTransferOrder.class)) {
                            total += tmpService.insertTmpTransferOrder((List<TmpTransferOrder>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpNonSignOrder.class)) {
                            total += tmpService.insertTmpNonSignOrder((List<TmpNonSignOrder>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpTinySiteOrder.class)) {
                            total += tmpService.insertTmpTinySiteOrder((List<TmpTinySiteOrder>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpContract.class)) {
                            total += tmpService.insertTmpContracts((List<TmpContract>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpContractR.class)) {
                            total += tmpService.insertTmpContractRs((List<TmpContractR>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpEleMeter.class)) {
                            total += tmpService.insertTmpEleMeters((List<TmpEleMeter>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpEleQuan.class)) {
                            total += tmpService.insertTmpEleQuans((List<TmpEleQuan>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpCard.class)) {
                            total += tmpService.insertTmpCards((List<TmpCard>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpEleFeeR.class)) {
                            total += tmpService.insertTmpEleFeeRs((List<TmpEleFeeR>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpRent.class)) {
                            total += tmpService.insertTmpRents((List<TmpRent>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpEleFee1.class)) {
                            total += tmpService.insertTmpEleFee1s((List<TmpEleFee1>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpEleFee3.class)) {
                            total += tmpService.insertTmpEleFee3s((List<TmpEleFee3>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpReProj.class)) {
                            total += tmpService.insertTmpReProjs((List<TmpReProj>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpProject.class)) {
                            total += tmpService.insertTmpProjects((List<TmpProject>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpSiteLocked.class)) {
                            total += tmpService.insertTmpSizeLockeds((List<TmpSiteLocked>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpSiteUnLocked.class)) {
                            total += tmpService.insertTmpSiteUnLockeds((List<TmpSiteUnLocked>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpDavyContract.class)) {
                            total += tmpService.insertTmpDavyContracts((List<TmpDavyContract>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpSiteDavyPreview.class)) {
                            total += tmpService.insertTmpSiteDavyPreviews((List<TmpSiteDavyPreview>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpPayRent.class)) {
                            total += tmpService.insertTmpPayRents((List<TmpPayRent>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpElectricChargePrepay.class)) {
                            total += tmpService.insertTmpElectricChargePrepays((List<TmpElectricChargePrepay>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpElectricChargePay.class)) {
                            total += tmpService.insertTmpElectricChargePays((List<TmpElectricChargePay>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpBasicInformation.class)) {
                            total += tmpService.insertTmpBasicInformations((List<TmpBasicInformation>) ((Map) r).get(clazz));
                        }
                        if (clazz.equals(TmpPhoto.class)) {
                            total += tmpService.insertTmpPhotos((List<TmpPhoto>) ((Map) r).get(clazz));
                        }
                    }
                }
            }
            //任务表处理
            if (sysTask.getState() == SysTask.STATE_3) {
                sysTaskMapper.deleteSysTask(sysTask);
                //his表处理
                sysTaskHis.setTotal(total);
                sysTaskMapper.insertSysTaskHis(sysTaskHis);
            } else {
                sysTaskMapper.updateTask(sysTask);
            }
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return total;
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

    /**
     * 单个任务的插入
     *
     * @param sysTask
     * @return
     * @throws Exception
     */
    @Override
    public int insertSysTask(SysTask sysTask) throws Exception {
        int result = 0;
        SqlSession sqlSession = MyBatisUtil.getSession(sysTask.getLocation());
        try {
            sysTaskMapper = sqlSession.getMapper(SysTaskMapper.class);
            result += sysTaskMapper.insertSysTask(sysTask);
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return result;
    }

    @Override
    public List<TableColumnInfo> queryTableColumnInfo(String region, String tableName) {
        SqlSession sqlSession = MyBatisUtil.getSession(region);
        SysTaskMapper mapper = sqlSession.getMapper(SysTaskMapper.class);
        List<TableColumnInfo> tableColumnInfos = mapper.queryTableColumnInfo(tableName);
        MyBatisUtil.closeSession(sqlSession);
        return tableColumnInfos;
    }

    @Override
    public List<String> queryTableInfo(String region) {
        SqlSession sqlSession = MyBatisUtil.getSession(region);
        SysTaskMapper mapper = sqlSession.getMapper(SysTaskMapper.class);
        List<String> tables = mapper.queryTableInfo();
        MyBatisUtil.closeSession(sqlSession);
        return tables;
    }

    @Override
    public List<SysTableRelationship> querySysTableRelationship(String region, String tableName) {
        SqlSession sqlSession = MyBatisUtil.getSession(region);
        SysTaskMapper mapper = sqlSession.getMapper(SysTaskMapper.class);
        List<SysTableRelationship> relationships = mapper.querySysTableRelationship(tableName);
        MyBatisUtil.closeSession(sqlSession);
        return relationships;
    }
}
