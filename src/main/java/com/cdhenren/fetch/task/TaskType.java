package com.cdhenren.fetch.task;

import com.cdhenren.fetch.driver.*;
import com.cdhenren.fetch.driver.assetsManagement.*;
import com.cdhenren.fetch.driver.enhancer.assetsManagement.SiteDemolitionRateDriver;
import com.cdhenren.fetch.driver.enhancer.operationsManagement.HistoryWarnHbaseDriver;
import com.cdhenren.fetch.driver.property.*;

/**
 * 任务《===》driver对应
 * @author Baopz
 * @date 2018/04/23
 */
public enum  TaskType {
    /** 资管-站址采集**/
    DCM_SITE(SiteDriver.class),
    /**资管-铁塔采集 **/
    DCM_TOWER(TowerDriver.class),
    /** 资管-机房采集**/
    DCM_MROOM(MroomDriver.class),
    /** 资管-开关电源采集**/
    DCM_SWITCHP(SwitchpDriver.class),
    /** 资管-平面采集**/
    DCM_PLANE(PlaneDriver.class),
    /** 资管-蓄电池组采集**/
    DCM_BATTERY(BatteryDriver.class),
    /** 资管-空调采集**/
    DCM_AIR_COND(AirCondDriver.class),
    /** 资管-资产卡片**/
    DCM_ASSET(AssetDriver.class),
    /**资管-站址拆除率**/
    SITE_DEMOLITION_RATE(SiteDemolitionRateDriver.class),

    /**物业-基础信息**/
    DCM_PCMS(BasicInformationDownloadDriver.class),
    /** 物业-电表采集**/
    DCM_ELE_METER(EleMeterDownloadDriver.class),
    /**物业-电量采集 **/
    DCM_ELE_QUAN(EleQuanDownloadDriver.class),
    /**物业-卡片采集 **/
    DCM_CARD(CardDownloadDriver.class),
    /** 物业-站址物业编码**/
    DCM_PROPERTY_R(PropertyRDriver.class),
    /** 物业-站址承接电费**/
    DCM_ELE_FEE_R(EleFeeRDownloadDriver.class),
    /** 物业-合同信息**/
    DCM_CONTRACT_R(ContractRDownloadDriver.class),
    /** 物业-租金台账**/
    DCM_RENT(RentDownloadDriver.class),
    /** 物业-电费台账采集1**/
    DCM_ELE_FEE1(EleFee1DownloadDriver.class),
    /** 物业-电费台账采集2**/
    DCM_ELE_FEE2(EleFee2DownloadDriver.class),
    /** 物业-电费台账采集3**/
    DCM_ELE_FEE3(EleFee3DownloadDriver.class),

    /**运营管理-日数据-历史告警Hbase**/
    HISTORY_WARN_HBASE(HistoryWarnHbaseDriver.class),


    /** 项目-项目**/
    DCM_PROJ(ProjDownloadDriver.class),
    /** 项目-销项项目**/
    DCM_RE_PROJ(ReProjDownloadDriver.class),
    /** CRM-综合查询**/
    DCM_CRM(CrmComprehensiveQueryDriver.class),
    /**合同-综合查询**/
    DCM_CONTRACT(ContractDriver.class),
    /**已经锁定**/
    DCM_COLKSITE(SiteLockedDownloadDriver.class),

    /**未锁定**/
    DCM_UNCOLKSITE(SiteUnLockedDownloadDriver.class),
    /**代维合同**/
    DCM_SERV(SiteRelevanceCostDriver.class),
    /**本月代维费预览**/
    DCM_SERVFEE(SiteDavyPreviewDriver.class),
    /**物业-场租支付**/
    DCM_RENT_PAY(PayRentDownloadDriver.class),
    /**物业-电费预付-无票**/
    DCM_ELE_PREPAY(ElectricChargePrepayDriver.class),
    /**物业-电费支付-有票**/
    DCM_ELE_PAY(ElectricChargePayDriver.class),
    /**抽取数据的校验**/
    ETL_P_CHECK(PCheckDriver.class),
    /**资管-站址照片**/
    DCM_PHOTO(PhotoDownloadDriver.class),
    /**调用过程**/
    CALL_PROCESS(CallProcessDriver.class)
    ;
    private Class clazz;

    TaskType(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
