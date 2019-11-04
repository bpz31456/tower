package com.cdhenren.fetch.dao.xml;

import com.cdhenren.fetch.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Baopz
 * @date 2018/04/26
 */
public interface TmpMapper {
    /**
     * 插入tmpSite
     * @param tmpSite
     */
    int insertTmpSite(TmpSite tmpSite);

    /**
     * 插入tmpTower
     * @param tmpTower
     * @return
     */
    int insertTmpTower(TmpTower tmpTower);

    /**
     * 插入tmpMroom
     * @param tmpMroom
     * @return
     */
    int insertTmpMroom(TmpMroom tmpMroom);

    /**
     * 插入tmpSwitchp
     * @param tmpSwitchp
     * @return
     */
    int insertTmpSwitchp(TmpSwitchp tmpSwitchp);

    /**
     * 插入tmpPlane
     * @param tmpPlane
     * @return
     */
    int insertTmpPlane(TmpPlane tmpPlane);

    /**
     * 插入tmpBattery
     * @param tmpBattery
     * @return
     */
    int inserttmpBattery(TmpBattery tmpBattery);

    /**
     * 插入airCond
     * @param airCond
     * @return
     */
    int insertTmpAirCond(TmpAirCond airCond);

    /**
     * 插入tmpAsset
     * @param tmpAsset
     * @return
     */
    int insertTmpAsset(TmpAsset tmpAsset);

    /**
     * 插入tmpEleMeter
     * @param tmpEleMeter
     * @return
     */
    int insertTmpEleMeter(TmpEleMeter tmpEleMeter);

    /**
     * insertTmpEleQuan
     * @param tmpEleQuan
     * @return
     */
    int insertTmpEleQuan(TmpEleQuan tmpEleQuan);

    /**
     * insertTmpCard
     * @param tmpCard
     * @return
     */
    int insertTmpCard(TmpCard tmpCard);

    /**
     * insertTmpPropertyR
     * @param tmpPropertyR
     * @return
     */
    int insertTmpPropertyR(TmpPropertyR tmpPropertyR);

    /**
     * insertTmpEleFeeR
     * @param tmpEleFeeR
     * @return
     */
    int insertTmpEleFeeR(TmpEleFeeR tmpEleFeeR);

    /**
     * insertTmpContractR
     * @param tmpContractR
     * @return
     */
    int insertTmpContractR(TmpContractR tmpContractR);

    /**
     * insertTmpRent
     * @param tmpRent
     * @return
     */
    int insertTmpRent(TmpRent tmpRent);

    /**
     * insertTmpEleFee1
     * @param tmpEleFee1
     * @return
     */
    int insertTmpEleFee1(TmpEleFee1 tmpEleFee1);

    /**
     * insertTmpEleFee2
     * @param tmpEleFee2
     * @return
     */
    int insertTmpEleFee2(TmpEleFee2 tmpEleFee2);

    /**
     * insertTmpEleFee3
     * @param tmpEleFee3
     * @return
     */
    int insertTmpEleFee3(TmpEleFee3 tmpEleFee3);

    /**
     * insertTmpFallView
     * @param tmpFallView
     * @return
     */
    int insertTmpFallView(TmpFallView tmpFallView);

    /**
     * insertTmpReProj
     * @param tmpReProj
     * @return
     */
    int insertTmpReProj(TmpReProj tmpReProj);

    /**
     * insertTmpContract
     * @param tmpContract
     * @return
     */
    int insertTmpContract(TmpContract tmpContract);

    /**
     * insertTmpRoomClassify
     * @param tmpRoomClassify
     * @return
     */
    int insertTmpRoomClassify(TmpRoomClassify tmpRoomClassify);

    /**
     * insertTmpTowerOrder
     * @param tmpTowerOrder
     * @return
     */
    int insertTmpTowerOrder(TmpTowerOrder tmpTowerOrder);

    /**
     * insertTmpTransferOrder
     * @param tmpTransferOrder
     * @return
     */
    int insertTmpTransferOrder(TmpTransferOrder tmpTransferOrder);

    /**
     * insertTmpNonSignOrder
     * @param tmpNonSignOrder
     * @return
     */
    int insertTmpNonSignOrder(TmpNonSignOrder tmpNonSignOrder);

    /**
     * insertTmpTinySiteOrder
     * @param tinySiteOrder
     * @return
     */
    int insertTmpTinySiteOrder(TmpTinySiteOrder tinySiteOrder);

    /**
     * 调用check
     * @return
     */
    Map callPCheck();

    /**
     * sms
     * @return
     */
    Map callPSms();

    /**
     * 调用存储过程
     * @param process
     * @return
     */
    Map callProcess(@Param("process") String process);

    /**
     * 插入锁定站址
     * @param tmpSiteLocked
     * @return
     */
    int insertTmpSiteLocked(TmpSiteLocked tmpSiteLocked);

    /**
     * 插入未锁定站址
     * @param tmpSiteUnLocked
     * @return
     */
    int insertTmpSiteUnLocked(TmpSiteUnLocked tmpSiteUnLocked);

    /**
     * 代维合同
     * @param tmpDavyContract
     * @return
     */
    int insertTmpDavyContract(TmpDavyContract tmpDavyContract);

    /**
     * 代维费预览
     * @param tmpSiteDavyPreview
     * @return
     */
    int insertTmpSiteDavyPreview(TmpSiteDavyPreview tmpSiteDavyPreview);

    /**
     * 租金支付
     * @param tmpPayRent
     * @return
     */
    int insertTmpPayRent(TmpPayRent tmpPayRent);

    /**
     * 电费预付
     * @param tmpElectricChargePrepay
     * @return
     */
    int insertTmpElectricChargePrepay(TmpElectricChargePrepay tmpElectricChargePrepay);

    /**
     * 电费支付
     * @param tmpElectricChargePay
     * @return
     */
    int inserttmpElectricChargePay(TmpElectricChargePay tmpElectricChargePay);

    /**
     * 基础信息
     * @param tmpBasicInformation
     * @return
     */
    int insertTmpBasicInformation(TmpBasicInformation tmpBasicInformation);

    /**
     * 站址照片
     * @param tmpPhoto
     * @return
     */
    int insertTmpPhoto(TmpPhoto tmpPhoto);

    /**
     * 项目
     * @param tmpProject
     * @return
     */
    int insertTmpProject(TmpProject tmpProject);

    /**
     * 清空表数据
     * @param tableName
     * @return
     */
    int truncateTable(@Param("tableName") String tableName);

    /**
     * 物业合同
     * @param tmpPropertyContract
     * @return
     */
    int insertTmpPropertyContract(TmpPropertyContract tmpPropertyContract);

    /**
     * 资管-站址拆除率
     * @param tmpSiteRemovalRate
     * @return
     */
    int insertTmpSiteRemovalRate(TmpSiteRemovalRate tmpSiteRemovalRate);
}
