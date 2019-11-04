package com.cdhenren.fetch.server;

import com.cdhenren.fetch.entity.*;

import java.util.List;
import java.util.Map;

/**
 * @author Baopz
 * @date 2018/04/26
 */
public interface TmpService {
    /**
     * 插入tmpSite表
     *
     * @param tmpSites
     * @return
     */
    int insertTmpSite(List<TmpSite> tmpSites) throws Exception;

    /**
     * 插入tmpTower表
     *
     * @param tmpTowers
     * @return
     */
    int insertTmpTower(List<TmpTower> tmpTowers) throws Exception;

    /**
     * 插入TmpMroom
     *
     * @param tmpMroom
     * @return
     */
    int insertTmpMroom(List<TmpMroom> tmpMroom) throws Exception;

    /**
     * 插入TmpSwitchp
     *
     * @param tmpSwitchp
     */
    int insertTmpSwitchp(List<TmpSwitchp> tmpSwitchp) throws Exception;

    /**
     * 插入TmpPlane
     *
     * @param tmpPlanes
     */
    int insertTmpPlanes(List<TmpPlane> tmpPlanes) throws Exception;

    /**
     * 插入
     *
     * @param tmpBatterys
     * @return
     */
    int insertTmpBatterys(List<TmpBattery> tmpBatterys) throws Exception;

    /**
     * 插入tmpAirConds
     *
     * @param tmpAirConds
     * @return
     */
    int insertTmpAirConds(List<TmpAirCond> tmpAirConds) throws Exception;

    /**
     * 插入 tmpAssets
     *
     * @param tmpAssets
     */
    int insertTmpAssets(List<TmpAsset> tmpAssets) throws Exception;

    /**
     * 插入
     *
     * @param tmpEleMeters
     * @return
     */
    int insertTmpEleMeters(List<TmpEleMeter> tmpEleMeters) throws Exception;

    /**
     * insertTmpEleQuans
     *
     * @param tmpEleQuans
     */
    int insertTmpEleQuans(List<TmpEleQuan> tmpEleQuans) throws Exception;

    /**
     * insertTmpEleFee3s
     *
     * @param r
     * @return
     */
    int insertTmpEleFee3s(List<TmpEleFee3> r) throws Exception;

    /**
     * insertTmpEleFee2s
     *
     * @param r
     * @return
     */
    int insertTmpEleFee2s(List<TmpEleFee2> r) throws Exception;

    /**
     * insertTmpEleFee1s
     *
     * @param r
     * @return
     */
    int insertTmpEleFee1s(List<TmpEleFee1> r) throws Exception;

    /**
     * insertTmpRents
     *
     * @param r
     * @return
     */
    int insertTmpRents(List<TmpRent> r) throws Exception;

    /**
     * insertTmpContractRs
     *
     * @param r
     * @return
     */
    int insertTmpContractRs(List<TmpContractR> r) throws Exception;

    /**
     * insertTmpEleFeeRs
     *
     * @param r
     * @return
     */
    int insertTmpEleFeeRs(List<TmpEleFeeR> r) throws Exception;

    /**
     * insertTmpPropertyRs
     *
     * @param r
     * @return
     */
    int insertTmpPropertyRs(List<TmpPropertyR> r) throws Exception;

    /**
     * insertTmpCards
     *
     * @param r
     * @return
     */
    int insertTmpCards(List<TmpCard> r) throws Exception;

    /**
     * insertTmpFallViews
     *
     * @param r
     * @return
     */
    int insertTmpFallViews(List<TmpFallView> r) throws Exception;

    /**
     * insertTmpReProjs
     *
     * @param r
     * @return
     */
    int insertTmpReProjs(List<TmpReProj> r) throws Exception;

    /**
     * insertTmpContracts
     *
     * @param tmpContracts
     * @return
     */
    int insertTmpContracts(List<TmpContract> tmpContracts) throws Exception;

    /**
     * insertTmpTowerOrder
     *
     * @param o
     * @return
     */
    int insertTmpTowerOrder(List<TmpTowerOrder> o) throws Exception;

    /**
     * insertTmpRoomClassify
     *
     * @param o
     * @return
     */
    int insertTmpRoomClassify(List<TmpRoomClassify> o) throws Exception;

    /**
     * insertTmpTransferOrder
     *
     * @param o
     * @return
     */
    int insertTmpTransferOrder(List<TmpTransferOrder> o) throws Exception;

    /**
     * insertTmpNonSignOrder
     *
     * @param o
     * @return
     */
    int insertTmpNonSignOrder(List<TmpNonSignOrder> o) throws Exception;

    /**
     * insertTmpTinySiteOrder
     *
     * @param o
     * @return
     */
    int insertTmpTinySiteOrder(List<TmpTinySiteOrder> o) throws Exception;

    /**
     * 调用过程检查数据
     */
    void callPCheck() throws Exception;

    /**
     * 调用存储过程
     * @param process
     */
    Map callProcess(String process);

    /**
     * 站址锁定
     * @param tmpSiteLockeds
     * @return
     */
    int insertTmpSizeLockeds(List<TmpSiteLocked> tmpSiteLockeds);

    /**
     * 站址未锁定
     * @param tmpSiteUnLockeds
     * @return
     */
    int insertTmpSiteUnLockeds(List<TmpSiteUnLocked> tmpSiteUnLockeds);

    /**
     *代维合同
     * @param tmpDavyContracts
     * @return
     */
    int insertTmpDavyContracts(List<TmpDavyContract> tmpDavyContracts);

    /**
     * 代维费预览
     * @param tmpSiteDavyPreviews
     * @return
     */
    int insertTmpSiteDavyPreviews(List<TmpSiteDavyPreview> tmpSiteDavyPreviews);

    /**
     * 租金支付
     * @param tmpPayRents
     * @return
     */
    int insertTmpPayRents(List<TmpPayRent> tmpPayRents);

    /**
     * 电费预付
     * @param tmpElectricChargePrepays
     * @return
     */
    int insertTmpElectricChargePrepays(List<TmpElectricChargePrepay> tmpElectricChargePrepays);

    /**
     * 电费支付
     * @param tmpElectricChargePays
     * @return
     */
    int insertTmpElectricChargePays(List<TmpElectricChargePay> tmpElectricChargePays);

    /**
     * 物业基础信息
     * @param tmpBasicInformations
     * @return
     */
    int insertTmpBasicInformations(List<TmpBasicInformation> tmpBasicInformations);

    /**
     * 站址，照片
     * @param tmpPhotos
     * @return
     */
    int insertTmpPhotos(List<TmpPhoto> tmpPhotos);

    /**
     * 项目
     * @param r
     * @return
     */
    int insertTmpProjects(List<TmpProject> r);

    /**
     * 清空表
     * @param tableName
     * @return
     */
    int truncateTable(String tableName);

    /**
     * 物业合同
     * @param r
     * @return
     */
    int insertTmpPropertyContracts(List<TmpPropertyContract> r);

    /**
     * 站址拆除率
     * @param r
     * @return
     */
    int insertTmpSiteRemovalRates(List<TmpSiteRemovalRate> r);
}
