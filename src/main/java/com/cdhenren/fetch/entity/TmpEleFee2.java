package com.cdhenren.fetch.entity;

import lombok.Data;

/**
 * 转供
 * @author Baopz
 * @date 2018/04/28
 * version 1.1.5
 */
@Data
public class TmpEleFee2 implements ResultSet {
    private String 省;
    private String 市;
    private String 所属区域;
    private String 站点编码;
    private String 站点名称;
    private String 电表编码;
    private String 供电用户号;
    private String 支付单号;
    private String 提单时间;
    private String 报账单号;
    private String 供电方式;
    private String 供电方名称;
    private String 公共客商编号;
    private String 电表倍率;
    private String 支付电量;
    private String 平均单价;
    private String 支付电费金额;
    private String 线损金额;
    private String 其他应付或减免金额;
    private String 付款日期;
    private String 购电起始读数;
    private String 购电截止读数;
    private String 是否换表复位;
    private String 换表复位截至读数;
    private String 购电起始日期;
    private String 购电截止日期;
    private String 票据补录状态;
    private String 区域经理;
    private String 付款方式;
    private String 收款账号;
    private String 收款户名;
    private String 开户行名称;
    private String 摘要;
}
