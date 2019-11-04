package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/02
 */
public class TmpContract implements ResultSet {
    private String 合同编号;
    private String 合同名称;
    private String 我方主体;
    private String 对方主体;
    private String 合同金额;
    private String 承办部门;
    private String 承办人;
    private String 合同类型;
    private String 签订盖章日期;
    private String 合同状态;
    private String 合同履行起始日期;
    private String 合同履行终止日期;
    private String 合同收支大类;
    private String 合同一级分类;
    private String 对方选择方式;
    private String 费用支出类型;
    private String 签订依据类型;
    private String 是否使用范本;
    private String 是否框架合同;
    private String 是否关联框架合同;
    private String 关联框架合同编号;
    private String 合同性质;
    private String 税率;
    private String 原签约运营商;
    private String 运营商原合同金额;
    private String 原合同履行开始日期;
    private String 是否固定金额;
    private String 当前处理人;
    private String 重要程度;
    private String 合同拟稿时间;
    private String 合同审批完成时间;
    private String 合同流水号;
    private String 合同有效期开始日期;
    private String 合同有效期结束日期;
    private String 续签合同;
    private String 当前审核环节;
    private String 关联合同;
    private String 合同归档时间;

    @Override
    public String toString() {
        return "TmpContract{" +
                "合同编号='" + 合同编号 + '\'' +
                ", 合同名称='" + 合同名称 + '\'' +
                ", 我方主体='" + 我方主体 + '\'' +
                ", 对方主体='" + 对方主体 + '\'' +
                ", 合同金额='" + 合同金额 + '\'' +
                ", 承办部门='" + 承办部门 + '\'' +
                ", 承办人='" + 承办人 + '\'' +
                ", 合同类型='" + 合同类型 + '\'' +
                ", 签订盖章日期='" + 签订盖章日期 + '\'' +
                ", 合同状态='" + 合同状态 + '\'' +
                ", 合同履行起始日期='" + 合同履行起始日期 + '\'' +
                ", 合同履行终止日期='" + 合同履行终止日期 + '\'' +
                ", 合同收支大类='" + 合同收支大类 + '\'' +
                ", 合同一级分类='" + 合同一级分类 + '\'' +
                ", 对方选择方式='" + 对方选择方式 + '\'' +
                ", 费用支出类型='" + 费用支出类型 + '\'' +
                ", 签订依据类型='" + 签订依据类型 + '\'' +
                ", 是否使用范本='" + 是否使用范本 + '\'' +
                ", 是否框架合同='" + 是否框架合同 + '\'' +
                ", 是否关联框架合同='" + 是否关联框架合同 + '\'' +
                ", 关联框架合同编号='" + 关联框架合同编号 + '\'' +
                ", 合同性质='" + 合同性质 + '\'' +
                ", 税率='" + 税率 + '\'' +
                ", 原签约运营商='" + 原签约运营商 + '\'' +
                ", 运营商原合同金额='" + 运营商原合同金额 + '\'' +
                ", 原合同履行开始日期='" + 原合同履行开始日期 + '\'' +
                ", 是否固定金额='" + 是否固定金额 + '\'' +
                ", 当前处理人='" + 当前处理人 + '\'' +
                ", 重要程度='" + 重要程度 + '\'' +
                ", 合同拟稿时间='" + 合同拟稿时间 + '\'' +
                ", 合同审批完成时间='" + 合同审批完成时间 + '\'' +
                ", 合同流水号='" + 合同流水号 + '\'' +
                ", 合同有效期开始日期='" + 合同有效期开始日期 + '\'' +
                ", 合同有效期结束日期='" + 合同有效期结束日期 + '\'' +
                ", 续签合同='" + 续签合同 + '\'' +
                ", 当前审核环节='" + 当前审核环节 + '\'' +
                ", 关联合同='" + 关联合同 + '\'' +
                ", 合同归档时间='" + 合同归档时间 + '\'' +
                '}';
    }

    public String get合同编号() {
        return 合同编号;
    }

    public void set合同编号(String 合同编号) {
        this.合同编号 = 合同编号;
    }

    public String get合同名称() {
        return 合同名称;
    }

    public void set合同名称(String 合同名称) {
        this.合同名称 = 合同名称;
    }

    public String get我方主体() {
        return 我方主体;
    }

    public void set我方主体(String 我方主体) {
        this.我方主体 = 我方主体;
    }

    public String get对方主体() {
        return 对方主体;
    }

    public void set对方主体(String 对方主体) {
        this.对方主体 = 对方主体;
    }

    public String get合同金额() {
        return 合同金额;
    }

    public void set合同金额(String 合同金额) {
        this.合同金额 = 合同金额;
    }

    public String get承办部门() {
        return 承办部门;
    }

    public void set承办部门(String 承办部门) {
        this.承办部门 = 承办部门;
    }

    public String get承办人() {
        return 承办人;
    }

    public void set承办人(String 承办人) {
        this.承办人 = 承办人;
    }

    public String get合同类型() {
        return 合同类型;
    }

    public void set合同类型(String 合同类型) {
        this.合同类型 = 合同类型;
    }

    public String get签订盖章日期() {
        return 签订盖章日期;
    }

    public void set签订盖章日期(String 签订盖章日期) {
        this.签订盖章日期 = 签订盖章日期;
    }

    public String get合同状态() {
        return 合同状态;
    }

    public void set合同状态(String 合同状态) {
        this.合同状态 = 合同状态;
    }

    public String get合同履行起始日期() {
        return 合同履行起始日期;
    }

    public void set合同履行起始日期(String 合同履行起始日期) {
        this.合同履行起始日期 = 合同履行起始日期;
    }

    public String get合同履行终止日期() {
        return 合同履行终止日期;
    }

    public void set合同履行终止日期(String 合同履行终止日期) {
        this.合同履行终止日期 = 合同履行终止日期;
    }

    public String get合同收支大类() {
        return 合同收支大类;
    }

    public void set合同收支大类(String 合同收支大类) {
        this.合同收支大类 = 合同收支大类;
    }

    public String get合同一级分类() {
        return 合同一级分类;
    }

    public void set合同一级分类(String 合同一级分类) {
        this.合同一级分类 = 合同一级分类;
    }

    public String get对方选择方式() {
        return 对方选择方式;
    }

    public void set对方选择方式(String 对方选择方式) {
        this.对方选择方式 = 对方选择方式;
    }

    public String get费用支出类型() {
        return 费用支出类型;
    }

    public void set费用支出类型(String 费用支出类型) {
        this.费用支出类型 = 费用支出类型;
    }

    public String get签订依据类型() {
        return 签订依据类型;
    }

    public void set签订依据类型(String 签订依据类型) {
        this.签订依据类型 = 签订依据类型;
    }

    public String get是否使用范本() {
        return 是否使用范本;
    }

    public void set是否使用范本(String 是否使用范本) {
        this.是否使用范本 = 是否使用范本;
    }

    public String get是否框架合同() {
        return 是否框架合同;
    }

    public void set是否框架合同(String 是否框架合同) {
        this.是否框架合同 = 是否框架合同;
    }

    public String get是否关联框架合同() {
        return 是否关联框架合同;
    }

    public void set是否关联框架合同(String 是否关联框架合同) {
        this.是否关联框架合同 = 是否关联框架合同;
    }

    public String get关联框架合同编号() {
        return 关联框架合同编号;
    }

    public void set关联框架合同编号(String 关联框架合同编号) {
        this.关联框架合同编号 = 关联框架合同编号;
    }

    public String get合同性质() {
        return 合同性质;
    }

    public void set合同性质(String 合同性质) {
        this.合同性质 = 合同性质;
    }

    public String get税率() {
        return 税率;
    }

    public void set税率(String 税率) {
        this.税率 = 税率;
    }

    public String get原签约运营商() {
        return 原签约运营商;
    }

    public void set原签约运营商(String 原签约运营商) {
        this.原签约运营商 = 原签约运营商;
    }

    public String get运营商原合同金额() {
        return 运营商原合同金额;
    }

    public void set运营商原合同金额(String 运营商原合同金额) {
        this.运营商原合同金额 = 运营商原合同金额;
    }

    public String get原合同履行开始日期() {
        return 原合同履行开始日期;
    }

    public void set原合同履行开始日期(String 原合同履行开始日期) {
        this.原合同履行开始日期 = 原合同履行开始日期;
    }

    public String get是否固定金额() {
        return 是否固定金额;
    }

    public void set是否固定金额(String 是否固定金额) {
        this.是否固定金额 = 是否固定金额;
    }

    public String get当前处理人() {
        return 当前处理人;
    }

    public void set当前处理人(String 当前处理人) {
        this.当前处理人 = 当前处理人;
    }

    public String get重要程度() {
        return 重要程度;
    }

    public void set重要程度(String 重要程度) {
        this.重要程度 = 重要程度;
    }

    public String get合同拟稿时间() {
        return 合同拟稿时间;
    }

    public void set合同拟稿时间(String 合同拟稿时间) {
        this.合同拟稿时间 = 合同拟稿时间;
    }

    public String get合同审批完成时间() {
        return 合同审批完成时间;
    }

    public void set合同审批完成时间(String 合同审批完成时间) {
        this.合同审批完成时间 = 合同审批完成时间;
    }

    public String get合同流水号() {
        return 合同流水号;
    }

    public void set合同流水号(String 合同流水号) {
        this.合同流水号 = 合同流水号;
    }

    public String get合同有效期开始日期() {
        return 合同有效期开始日期;
    }

    public void set合同有效期开始日期(String 合同有效期开始日期) {
        this.合同有效期开始日期 = 合同有效期开始日期;
    }

    public String get合同有效期结束日期() {
        return 合同有效期结束日期;
    }

    public void set合同有效期结束日期(String 合同有效期结束日期) {
        this.合同有效期结束日期 = 合同有效期结束日期;
    }

    public String get续签合同() {
        return 续签合同;
    }

    public void set续签合同(String 续签合同) {
        this.续签合同 = 续签合同;
    }

    public String get当前审核环节() {
        return 当前审核环节;
    }

    public void set当前审核环节(String 当前审核环节) {
        this.当前审核环节 = 当前审核环节;
    }

    public String get关联合同() {
        return 关联合同;
    }

    public void set关联合同(String 关联合同) {
        this.关联合同 = 关联合同;
    }

    public String get合同归档时间() {
        return 合同归档时间;
    }

    public void set合同归档时间(String 合同归档时间) {
        this.合同归档时间 = 合同归档时间;
    }
}
