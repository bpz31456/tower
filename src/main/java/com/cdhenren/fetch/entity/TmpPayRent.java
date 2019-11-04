package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/25
 */
public class TmpPayRent implements ResultSet {
    private String 省分公司;
    private String 地市分公司;
    private String 区县;
    private String 批次号;
    private String 支付单号;
    private String 支付单标题;
    private String 报账单号;
    private String 合同名称;
    private String 合同编码;
    private String 合同开始日期;
    private String 合同结束日期;
    private String 站点名称;
    private String 站点编码;
    private String 业主名称;
    private String 有无票据;
    private String 票据总金额支付单;
    private String 支付给业主的场租及其他税金金额支付单;
    private String 增值税专用发票的进项税金额支付单;
    private String 员工代垫的场租及其他税金支付单;
    private String 总支付金额支付单;
    private String 支付给业主的场租及其他税金金额支付明细;
    private String 增值税专用发票的进项税金额支付明细;
    private String 员工代垫的场租及其他税金支付明细;
    private String 总支付金额支付明细;
    private String 申请日期;
    private String 支付区间起始;
    private String 支付区间终止;
    private String 申请人;
    private String 录入人;
    private String 收款户名;
    private String 收款账号;
    private String 付款方式;
    private String 开户行名称;
    private String 所属户行名称;
    private String 单据状态;
    private String 报账状态;
    private String 报账时间;
    private String 备注;

    @Override
    public String toString() {
        return "TmpPayRent{" +
                "省分公司='" + 省分公司 + '\'' +
                ", 地市分公司='" + 地市分公司 + '\'' +
                ", 区县='" + 区县 + '\'' +
                ", 批次号='" + 批次号 + '\'' +
                ", 支付单号='" + 支付单号 + '\'' +
                ", 支付单标题='" + 支付单标题 + '\'' +
                ", 报账单号='" + 报账单号 + '\'' +
                ", 合同名称='" + 合同名称 + '\'' +
                ", 合同编码='" + 合同编码 + '\'' +
                ", 合同开始日期='" + 合同开始日期 + '\'' +
                ", 合同结束日期='" + 合同结束日期 + '\'' +
                ", 站点名称='" + 站点名称 + '\'' +
                ", 站点编码='" + 站点编码 + '\'' +
                ", 业主名称='" + 业主名称 + '\'' +
                ", 有无票据='" + 有无票据 + '\'' +
                ", 票据总金额支付单='" + 票据总金额支付单 + '\'' +
                ", 支付给业主的场租及其他税金金额支付单='" + 支付给业主的场租及其他税金金额支付单 + '\'' +
                ", 增值税专用发票的进项税金额支付单='" + 增值税专用发票的进项税金额支付单 + '\'' +
                ", 员工代垫的场租及其他税金支付单='" + 员工代垫的场租及其他税金支付单 + '\'' +
                ", 总支付金额支付单='" + 总支付金额支付单 + '\'' +
                ", 支付给业主的场租及其他税金金额支付明细='" + 支付给业主的场租及其他税金金额支付明细 + '\'' +
                ", 增值税专用发票的进项税金额支付明细='" + 增值税专用发票的进项税金额支付明细 + '\'' +
                ", 员工代垫的场租及其他税金支付明细='" + 员工代垫的场租及其他税金支付明细 + '\'' +
                ", 总支付金额支付明细='" + 总支付金额支付明细 + '\'' +
                ", 申请日期='" + 申请日期 + '\'' +
                ", 支付区间起始='" + 支付区间起始 + '\'' +
                ", 支付区间终止='" + 支付区间终止 + '\'' +
                ", 申请人='" + 申请人 + '\'' +
                ", 录入人='" + 录入人 + '\'' +
                ", 收款户名='" + 收款户名 + '\'' +
                ", 收款账号='" + 收款账号 + '\'' +
                ", 付款方式='" + 付款方式 + '\'' +
                ", 开户行名称='" + 开户行名称 + '\'' +
                ", 所属户行名称='" + 所属户行名称 + '\'' +
                ", 单据状态='" + 单据状态 + '\'' +
                ", 报账状态='" + 报账状态 + '\'' +
                ", 报账时间='" + 报账时间 + '\'' +
                ", 备注='" + 备注 + '\'' +
                '}';
    }

    public String get支付单号() {
        return 支付单号;
    }

    public void set支付单号(String 支付单号) {
        this.支付单号 = 支付单号;
    }

    public String get支付单标题() {
        return 支付单标题;
    }

    public void set支付单标题(String 支付单标题) {
        this.支付单标题 = 支付单标题;
    }

    public String get报账单号() {
        return 报账单号;
    }

    public void set报账单号(String 报账单号) {
        this.报账单号 = 报账单号;
    }

    public String get合同名称() {
        return 合同名称;
    }

    public void set合同名称(String 合同名称) {
        this.合同名称 = 合同名称;
    }

    public String get合同编码() {
        return 合同编码;
    }

    public void set合同编码(String 合同编码) {
        this.合同编码 = 合同编码;
    }

    public String get合同开始日期() {
        return 合同开始日期;
    }

    public void set合同开始日期(String 合同开始日期) {
        this.合同开始日期 = 合同开始日期;
    }

    public String get合同结束日期() {
        return 合同结束日期;
    }

    public void set合同结束日期(String 合同结束日期) {
        this.合同结束日期 = 合同结束日期;
    }

    public String get站点名称() {
        return 站点名称;
    }

    public void set站点名称(String 站点名称) {
        this.站点名称 = 站点名称;
    }

    public String get站点编码() {
        return 站点编码;
    }

    public void set站点编码(String 站点编码) {
        this.站点编码 = 站点编码;
    }

    public String get业主名称() {
        return 业主名称;
    }

    public void set业主名称(String 业主名称) {
        this.业主名称 = 业主名称;
    }

    public String get有无票据() {
        return 有无票据;
    }

    public void set有无票据(String 有无票据) {
        this.有无票据 = 有无票据;
    }

    public String get票据总金额支付单() {
        return 票据总金额支付单;
    }

    public void set票据总金额支付单(String 票据总金额支付单) {
        this.票据总金额支付单 = 票据总金额支付单;
    }

    public String get支付给业主的场租及其他税金金额支付单() {
        return 支付给业主的场租及其他税金金额支付单;
    }

    public void set支付给业主的场租及其他税金金额支付单(String 支付给业主的场租及其他税金金额支付单) {
        this.支付给业主的场租及其他税金金额支付单 = 支付给业主的场租及其他税金金额支付单;
    }

    public String get增值税专用发票的进项税金额支付单() {
        return 增值税专用发票的进项税金额支付单;
    }

    public void set增值税专用发票的进项税金额支付单(String 增值税专用发票的进项税金额支付单) {
        this.增值税专用发票的进项税金额支付单 = 增值税专用发票的进项税金额支付单;
    }

    public String get员工代垫的场租及其他税金支付单() {
        return 员工代垫的场租及其他税金支付单;
    }

    public void set员工代垫的场租及其他税金支付单(String 员工代垫的场租及其他税金支付单) {
        this.员工代垫的场租及其他税金支付单 = 员工代垫的场租及其他税金支付单;
    }

    public String get总支付金额支付单() {
        return 总支付金额支付单;
    }

    public void set总支付金额支付单(String 总支付金额支付单) {
        this.总支付金额支付单 = 总支付金额支付单;
    }

    public String get支付给业主的场租及其他税金金额支付明细() {
        return 支付给业主的场租及其他税金金额支付明细;
    }

    public void set支付给业主的场租及其他税金金额支付明细(String 支付给业主的场租及其他税金金额支付明细) {
        this.支付给业主的场租及其他税金金额支付明细 = 支付给业主的场租及其他税金金额支付明细;
    }

    public String get增值税专用发票的进项税金额支付明细() {
        return 增值税专用发票的进项税金额支付明细;
    }

    public void set增值税专用发票的进项税金额支付明细(String 增值税专用发票的进项税金额支付明细) {
        this.增值税专用发票的进项税金额支付明细 = 增值税专用发票的进项税金额支付明细;
    }

    public String get员工代垫的场租及其他税金支付明细() {
        return 员工代垫的场租及其他税金支付明细;
    }

    public void set员工代垫的场租及其他税金支付明细(String 员工代垫的场租及其他税金支付明细) {
        this.员工代垫的场租及其他税金支付明细 = 员工代垫的场租及其他税金支付明细;
    }

    public String get总支付金额支付明细() {
        return 总支付金额支付明细;
    }

    public void set总支付金额支付明细(String 总支付金额支付明细) {
        this.总支付金额支付明细 = 总支付金额支付明细;
    }

    public String get申请日期() {
        return 申请日期;
    }

    public void set申请日期(String 申请日期) {
        this.申请日期 = 申请日期;
    }

    public String get支付区间起始() {
        return 支付区间起始;
    }

    public void set支付区间起始(String 支付区间起始) {
        this.支付区间起始 = 支付区间起始;
    }

    public String get支付区间终止() {
        return 支付区间终止;
    }

    public void set支付区间终止(String 支付区间终止) {
        this.支付区间终止 = 支付区间终止;
    }

    public String get申请人() {
        return 申请人;
    }

    public void set申请人(String 申请人) {
        this.申请人 = 申请人;
    }

    public String get录入人() {
        return 录入人;
    }

    public void set录入人(String 录入人) {
        this.录入人 = 录入人;
    }

    public String get收款户名() {
        return 收款户名;
    }

    public void set收款户名(String 收款户名) {
        this.收款户名 = 收款户名;
    }

    public String get收款账号() {
        return 收款账号;
    }

    public void set收款账号(String 收款账号) {
        this.收款账号 = 收款账号;
    }

    public String get付款方式() {
        return 付款方式;
    }

    public void set付款方式(String 付款方式) {
        this.付款方式 = 付款方式;
    }

    public String get开户行名称() {
        return 开户行名称;
    }

    public void set开户行名称(String 开户行名称) {
        this.开户行名称 = 开户行名称;
    }

    public String get所属户行名称() {
        return 所属户行名称;
    }

    public void set所属户行名称(String 所属户行名称) {
        this.所属户行名称 = 所属户行名称;
    }

    public String get单据状态() {
        return 单据状态;
    }

    public void set单据状态(String 单据状态) {
        this.单据状态 = 单据状态;
    }

    public String get报账状态() {
        return 报账状态;
    }

    public void set报账状态(String 报账状态) {
        this.报账状态 = 报账状态;
    }

    public String get报账时间() {
        return 报账时间;
    }

    public void set报账时间(String 报账时间) {
        this.报账时间 = 报账时间;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }
}
