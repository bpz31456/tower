package com.cdhenren.fetch.server.impl;

import com.cdhenren.fetch.dao.xml.TmpMapper;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.*;
import com.cdhenren.fetch.server.TmpService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * version1.1.5
 *
 * @author Baopz
 * @date 2018/04/26
 */
public class TmpServiceImpl implements TmpService {

    private Logger logger = LoggerFactory.getLogger(TmpServiceImpl.class);
    private TmpMapper tmpMapper = null;
    private final ExecutorType executeModelBatch = ExecutorType.BATCH;

    @Override
    public int insertTmpSite(List<TmpSite> tmpSites) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpSites.forEach(tmpSite -> tmpMapper.insertTmpSite(tmpSite));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpSites.size();
    }

    @Override
    public int insertTmpTower(List<TmpTower> tmpTowers) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpTowers.forEach(tmpTower -> {
                tmpMapper.insertTmpTower(tmpTower);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpTowers.size();
    }

    @Override
    public int insertTmpMroom(List<TmpMroom> tmpMrooms) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpMrooms.forEach(tmpMroom -> {
                tmpMapper.insertTmpMroom(tmpMroom);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpMrooms.size();
    }

    @Override
    public int insertTmpSwitchp(List<TmpSwitchp> tmpSwitchps) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpSwitchps.forEach(tmpSwitchp -> {
                tmpMapper.insertTmpSwitchp(tmpSwitchp);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpSwitchps.size();
    }

    @Override
    public int insertTmpPlanes(List<TmpPlane> tmpPlanes) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpPlanes.forEach(tmpPlane -> {
                tmpMapper.insertTmpPlane(tmpPlane);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpPlanes.size();
    }

    @Override
    public int insertTmpBatterys(List<TmpBattery> tmpBatterys) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpBatterys.forEach(tmpBattery -> {
                tmpMapper.inserttmpBattery(tmpBattery);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpBatterys.size();
    }

    @Override
    public int insertTmpAirConds(List<TmpAirCond> tmpAirConds) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpAirConds.forEach(tmpAirCond -> {
                tmpMapper.insertTmpAirCond(tmpAirCond);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpAirConds.size();
    }

    @Override
    public int insertTmpAssets(List<TmpAsset> tmpAssets) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpAssets.forEach(tmpAsset -> {
                tmpMapper.insertTmpAsset(tmpAsset);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpAssets.size();
    }

    @Override
    public int insertTmpEleMeters(List<TmpEleMeter> tmpEleMeters) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpEleMeters.forEach(tmpEleMeter -> {
                tmpMapper.insertTmpEleMeter(tmpEleMeter);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpEleMeters.size();
    }

    @Override
    public int insertTmpEleQuans(List<TmpEleQuan> tmpEleQuans) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpEleQuans.forEach(tmpEleQuan -> {
                tmpMapper.insertTmpEleQuan(tmpEleQuan);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpEleQuans.size();
    }

    @Override
    public int insertTmpEleFee3s(List<TmpEleFee3> tmpEleFee3s) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpEleFee3s.forEach(tmpEleFee3 -> {
                tmpMapper.insertTmpEleFee3(tmpEleFee3);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpEleFee3s.size();
    }


    @Override
    public int insertTmpEleFee2s(List<TmpEleFee2> tmpEleFee2s) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpEleFee2s.forEach(tmpEleFee2 -> {
                tmpMapper.insertTmpEleFee2(tmpEleFee2);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpEleFee2s.size();
    }

    @Override
    public int insertTmpEleFee1s(List<TmpEleFee1> tmpEleFee1s) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpEleFee1s.forEach(tmpEleFee1 -> {
                tmpMapper.insertTmpEleFee1(tmpEleFee1);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpEleFee1s.size();
    }

    @Override
    public int insertTmpRents(List<TmpRent> tmpRents) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpRents.forEach(tmpRent -> {
                tmpMapper.insertTmpRent(tmpRent);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpRents.size();
    }

    @Override
    public int insertTmpContractRs(List<TmpContractR> tmpContractRs) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpContractRs.forEach(tmpContractR -> tmpMapper.insertTmpContractR(tmpContractR));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpContractRs.size();
    }

    @Override
    public int insertTmpEleFeeRs(List<TmpEleFeeR> tmpEleFeeRs) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpEleFeeRs.forEach(tmpEleFeeR -> tmpMapper.insertTmpEleFeeR(tmpEleFeeR));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpEleFeeRs.size();
    }

    @Override
    public int insertTmpPropertyRs(List<TmpPropertyR> tmpPropertyRs) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpPropertyRs.forEach(tmpPropertyR -> tmpMapper.insertTmpPropertyR(tmpPropertyR));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpPropertyRs.size();
    }

    @Override
    public int insertTmpCards(List<TmpCard> tmpCards) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpCards.forEach(tmpCard -> tmpMapper.insertTmpCard(tmpCard));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpCards.size();
    }

    @Override
    public int insertTmpFallViews(List<TmpFallView> tmpFallViews) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpFallViews.forEach(tmpFallView -> tmpMapper.insertTmpFallView(tmpFallView));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpFallViews.size();
    }

    @Override
    public int insertTmpReProjs(List<TmpReProj> tmpReProjs) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpReProjs.forEach(tmpReProj -> tmpMapper.insertTmpReProj(tmpReProj));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpReProjs.size();
    }

    @Override
    public int insertTmpContracts(List<TmpContract> tmpContracts) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpContracts.forEach(tmpContract -> tmpMapper.insertTmpContract(tmpContract));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpContracts.size();
    }

    @Override
    public int insertTmpTowerOrder(List<TmpTowerOrder> tmpTowerOrders) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpTowerOrders.forEach(tmpTowerOrder -> tmpMapper.insertTmpTowerOrder(tmpTowerOrder));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpTowerOrders.size();
    }

    @Override
    public int insertTmpRoomClassify(List<TmpRoomClassify> tmpRoomClassifys) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpRoomClassifys.forEach(tmpRoomClassify -> tmpMapper.insertTmpRoomClassify(tmpRoomClassify));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpRoomClassifys.size();
    }

    @Override
    public int insertTmpTransferOrder(List<TmpTransferOrder> tmpTransferOrders) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpTransferOrders.forEach(tmpTransferOrder -> tmpMapper.insertTmpTransferOrder(tmpTransferOrder));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpTransferOrders.size();
    }

    @Override
    public int insertTmpNonSignOrder(List<TmpNonSignOrder> tmpNonSignOrders) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpNonSignOrders.forEach(tmpNonSignOrder -> tmpMapper.insertTmpNonSignOrder(tmpNonSignOrder));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpNonSignOrders.size();
    }

    @Override
    public int insertTmpTinySiteOrder(List<TmpTinySiteOrder> tmpTinySiteOrders) throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpTinySiteOrders.forEach(tmpTinySiteOrder -> tmpMapper.insertTmpTinySiteOrder(tmpTinySiteOrder));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpTinySiteOrders.size();
    }

    @Override
    public void callPCheck() throws Exception {
        callProcess("P_CHECK()");
    }

    @Override
    public Map callProcess(String process) {
        SqlSession sqlSession = MyBatisUtil.getSession();
        Map result;
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            logger.debug("正式调用存储过程{}", process);
            result = tmpMapper.callProcess(process);
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return result;
    }

    @Override
    public int insertTmpSizeLockeds(List<TmpSiteLocked> tmpSiteLockeds) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpSiteLockeds.forEach(tmpSiteLocked -> tmpMapper.insertTmpSiteLocked(tmpSiteLocked));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpSiteLockeds.size();
    }

    @Override
    public int insertTmpSiteUnLockeds(List<TmpSiteUnLocked> tmpSiteUnLockeds) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpSiteUnLockeds.forEach(tmpSiteUnLocked -> tmpMapper.insertTmpSiteUnLocked(tmpSiteUnLocked));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpSiteUnLockeds.size();
    }

    @Override
    public int insertTmpDavyContracts(List<TmpDavyContract> tmpDavyContracts) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpDavyContracts.forEach(tmpDavyContract -> tmpMapper.insertTmpDavyContract(tmpDavyContract));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpDavyContracts.size();
    }

    @Override
    public int insertTmpSiteDavyPreviews(List<TmpSiteDavyPreview> tmpSiteDavyPreviews) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpSiteDavyPreviews.forEach(tmpSiteDavyPreview -> tmpMapper.insertTmpSiteDavyPreview(tmpSiteDavyPreview));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpSiteDavyPreviews.size();
    }

    @Override
    public int insertTmpPayRents(List<TmpPayRent> tmpPayRents) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpPayRents.forEach(tmpPayRent -> tmpMapper.insertTmpPayRent(tmpPayRent));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpPayRents.size();
    }

    @Override
    public int insertTmpElectricChargePrepays(List<TmpElectricChargePrepay> tmpElectricChargePrepays) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpElectricChargePrepays.forEach(tmpElectricChargePrepay -> tmpMapper.insertTmpElectricChargePrepay(tmpElectricChargePrepay));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpElectricChargePrepays.size();
    }

    @Override
    public int insertTmpElectricChargePays(List<TmpElectricChargePay> tmpElectricChargePays) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpElectricChargePays.forEach(tmpElectricChargePay -> tmpMapper.inserttmpElectricChargePay(tmpElectricChargePay));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpElectricChargePays.size();
    }

    @Override
    public int insertTmpBasicInformations(List<TmpBasicInformation> tmpBasicInformations) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpBasicInformations.forEach(tmpBasicInformation -> tmpMapper.insertTmpBasicInformation(tmpBasicInformation));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpBasicInformations.size();
    }

    @Override
    public int insertTmpPhotos(List<TmpPhoto> tmpPhotos) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpPhotos.forEach(tmpPhoto -> {
                if(StringUtils.isEmpty(tmpPhoto.get站址编码())){
                    logger.info("站址编码为空的photo,{}",tmpPhoto);
                }
                tmpMapper.insertTmpPhoto(tmpPhoto);
            });
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpPhotos.size();
    }

    @Override
    public int insertTmpProjects(List<TmpProject> tmpProjects) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpProjects.forEach(tmpProject -> tmpMapper.insertTmpProject(tmpProject));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpProjects.size();
    }

    @Override
    public int truncateTable(String tableName) {
        SqlSession sqlSession = MyBatisUtil.getSession();
        int count = 0;
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            count = tmpMapper.truncateTable(tableName);
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return count;
    }

    @Override
    public int insertTmpPropertyContracts(List<TmpPropertyContract> tmpPropertyContracts) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpPropertyContracts.forEach(tmpPropertyContract -> tmpMapper.insertTmpPropertyContract(tmpPropertyContract));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpPropertyContracts.size();
    }
    @Override
    public int insertTmpSiteRemovalRates(List<TmpSiteRemovalRate> tmpSiteRemovalRates) {
        SqlSession sqlSession = MyBatisUtil.getSession(executeModelBatch);
        try {
            //TmpSiteRemovalRate
            tmpMapper = sqlSession.getMapper(TmpMapper.class);
            tmpSiteRemovalRates.forEach(tmpSiteRemovalRate -> tmpMapper.insertTmpSiteRemovalRate(tmpSiteRemovalRate));
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return tmpSiteRemovalRates.size();
    }

}
