package com.cdhenren.fetch.entity;

/**
 * @author Fuhj
 * @date 2019.11.03
 */
public enum FunctionName2Table {

    TMP_SITE("tmp_资源_站址", "insertTmpSite"),
    TMP_TOWER("tmp_资源_铁塔", "insertTmpTower"),
    TMP_MROOM("tmp_资源_机房", "insertTmpMroom"),
    TMP_SWITCHP("tmp_资源_开关电源", "insertTmpSwitchp"),
    TMP_ASSET("tmp_资产卡片", "insertTmpAssets"),
    TMP_BATTERY("tmp_资源_蓄电池", "insertTmpBatterys"),
    TMP_AIR_COND("tmp_资源_空调", "insertTmpAirConds"),
    SITE_DEMOLITION_RATE("tmp_站址拆除率", "insertTmpSiteRemovalRates"),

    TMP_TRANSFER_ORDER("tmp_传输类订单确认表", "insertTmpTransferOrder"),
    TMP_CONTRACT("tmp_合同", "insertTmpContracts"),
    TMP_CARD("tmp_物业_场租卡片", "insertTmpCards"),
    TMP_ROOM_CLASSIFY("tmp_室分类订单确认表", "insertTmpRoomClassify"),
    TMP_PLANE("tmp_平面", "insertTmpPlanes"),

    TMP_TINY_SITE_ORDER("tmp_微站订单确认表", "insertTmpTinySiteOrder"),
    TMP_SITE_DAVY_PREVIEW("tmp_本月代维费预览", "insertTmpSiteDavyPreviews"),
    TMP_BASIC_INFORMATION("tmp_物业基础信息", "insertTmpBasicInformations"),
    TMP_ELE_METER("tmp_电表", "insertTmpEleMeters"),
    TMP_ELE_FEE1("tmp_电费支付台账_直供", "insertTmpEleFee1s"),
    TMP_ELE_FEE2("tmp_电费支付台账_转供", "insertTmpEleFee2s"),
    TMP_ELE_FEE3("tmp_电费支付台账_预付", "insertTmpEleFee3s"),
    TMP_ELECTRIC_CHARGE_PAY("tmp_电费支付", "insertTmpElectricChargePays"),
    TMP_ELECTRIC_CHARGE_PREPAY("tmp_电费预付", "insertTmpElectricChargePrepays"),
    TMP_ELE_QUAN("tmp_电量", "insertTmpEleQuans"),
    TMP_RENT("tmp_租金台账", "insertTmpRents"),
    TMP_PAY_RENT("tmp_租金支付", "insertTmpPayRents"),


    //站址合同
//    TMP_CONTRACT_R("tmp_站址合同物业", "insertTmpContractRs"),
    TMP_CONTRACT_R("`tmp_物业合同`", "insertTmpPropertyContracts"),

    TMP_ELE_FEE_R("tmp_站址承接电费", "insertTmpEleFeeRs"),
    TMP_PROPERTY_R("tmp_站址物业编码", "insertTmpPropertyRs"),
    TMP_DAVY_CONTRACT("tmp_站址_代维合同", "insertTmpDavyContracts"),
    TMP_SITE_LOCKED("tmp_站址_已锁定", "insertTmpSizeLockeds"),
    TMP_SITE_UNLOCKED("tmp_站址_未锁定", "insertTmpSiteUnLockeds"),
    TMP_PHOTO("tmp_站址_照片", "insertTmpPhotos"),

    TMP_TOWER_ORDER("tmp_铁塔类订单确认表", "insertTmpTowerOrder"),
    TMP_REPROJ("tmp_销项项目", "insertTmpReProjs"),
    TMP_NON_SIGN_ORDER("tmp_非标类订单确认表", "insertTmpNonSignOrder"),
    TMP_PROJECT("tmp_项目", "insertTmpProjects");
    private String functionName;
    private String tableName;

    FunctionName2Table(String tableName, String functionName) {
        this.functionName = functionName;
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "FunctionName2Table{" +
                "functionName='" + functionName + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
