package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/04/28
 */
public class TmpContractR implements ResultSet {
    private String 省份;
    private String 地市;
    private String 区县;
    private String 省分公司;
    private String 地市公司;
    private String 站点编码;
    private String 站点名称;
    private String 站点性质;
    private String 建设场景;
    private String 物业编码;
    private String 物业名称;
    private String 合同编码;
    private String 合同名称;
    private String 合同类型;
    private String 合同属性;
    private String 所属业主名称甲方;
    private String 客商编号;
    private String 业主电话;
    private String 证件号码;
    private String 业主所属地市公司;
    private String 业主类型;
    private String 业主证件类型;
    private String 业主证件号码;
    private String 合同乙方;
    private String 合同签订日期;
    private String 合同起始日期原始;
    private String 合同支付计提起始日期;
    private String 合同终止日期;
    private String 合同录入日期;
    private String 合同总金额;
    private String 经办人;
    private String 经办部门;
    private String 合同状态;
    private String 是否代持;
    private String 站点是否删除;
    private String 被续签合同编码;
    private String 是否需要续签;
    private String 是否关联框架合同;
    private String 最后修改时间;
    private String 房屋租赁面积平方米;
    private String 场地租赁面积平方米;
    private String 基本年租金元年;
    private String 租金支付方式;
    private String 租金支付周期月;
    private String 租金约定首次支付日期;
    private String 租金收款账号;
    private String 租金收款户名;
    private String 所属银行租金收款;
    private String 租金收款银行;
    private String 租金票据类型;
    private String 我方代开票;
    private String 代开票税点;
    private String 电费单价元度;
    private String 电价标准;
    private String 电费支付方式;
    private String 电费支付周期月;
    private String 电费约定首次支付日期;
    private String 电费收款账号;
    private String 电费收款户名;
    private String 所属银行电费收款;
    private String 电费收款银行;
    private String 电费票据类型;
    private String 押金金额元;

    @Override
    public String toString() {
        return "TmpContractR{" +
                "省份='" + 省份 + '\'' +
                ", 地市='" + 地市 + '\'' +
                ", 区县='" + 区县 + '\'' +
                ", 省分公司='" + 省分公司 + '\'' +
                ", 地市公司='" + 地市公司 + '\'' +
                ", 站点编码='" + 站点编码 + '\'' +
                ", 站点名称='" + 站点名称 + '\'' +
                ", 站点性质='" + 站点性质 + '\'' +
                ", 建设场景='" + 建设场景 + '\'' +
                ", 物业编码='" + 物业编码 + '\'' +
                ", 物业名称='" + 物业名称 + '\'' +
                ", 合同编码='" + 合同编码 + '\'' +
                ", 合同名称='" + 合同名称 + '\'' +
                ", 合同类型='" + 合同类型 + '\'' +
                ", 合同属性='" + 合同属性 + '\'' +
                ", 所属业主名称甲方='" + 所属业主名称甲方 + '\'' +
                ", 客商编号='" + 客商编号 + '\'' +
                ", 业主电话='" + 业主电话 + '\'' +
                ", 证件号码='" + 证件号码 + '\'' +
                ", 业主所属地市公司='" + 业主所属地市公司 + '\'' +
                ", 业主类型='" + 业主类型 + '\'' +
                ", 业主证件类型='" + 业主证件类型 + '\'' +
                ", 业主证件号码='" + 业主证件号码 + '\'' +
                ", 合同乙方='" + 合同乙方 + '\'' +
                ", 合同签订日期='" + 合同签订日期 + '\'' +
                ", 合同起始日期原始='" + 合同起始日期原始 + '\'' +
                ", 合同支付计提起始日期='" + 合同支付计提起始日期 + '\'' +
                ", 合同终止日期='" + 合同终止日期 + '\'' +
                ", 合同录入日期='" + 合同录入日期 + '\'' +
                ", 合同总金额='" + 合同总金额 + '\'' +
                ", 经办人='" + 经办人 + '\'' +
                ", 经办部门='" + 经办部门 + '\'' +
                ", 合同状态='" + 合同状态 + '\'' +
                ", 是否代持='" + 是否代持 + '\'' +
                ", 站点是否删除='" + 站点是否删除 + '\'' +
                ", 被续签合同编码='" + 被续签合同编码 + '\'' +
                ", 是否需要续签='" + 是否需要续签 + '\'' +
                ", 是否关联框架合同='" + 是否关联框架合同 + '\'' +
                ", 最后修改时间='" + 最后修改时间 + '\'' +
                ", 房屋租赁面积平方米='" + 房屋租赁面积平方米 + '\'' +
                ", 场地租赁面积平方米='" + 场地租赁面积平方米 + '\'' +
                ", 基本年租金元年='" + 基本年租金元年 + '\'' +
                ", 租金支付方式='" + 租金支付方式 + '\'' +
                ", 租金支付周期月='" + 租金支付周期月 + '\'' +
                ", 租金约定首次支付日期='" + 租金约定首次支付日期 + '\'' +
                ", 租金收款账号='" + 租金收款账号 + '\'' +
                ", 租金收款户名='" + 租金收款户名 + '\'' +
                ", 所属银行租金收款='" + 所属银行租金收款 + '\'' +
                ", 租金收款银行='" + 租金收款银行 + '\'' +
                ", 租金票据类型='" + 租金票据类型 + '\'' +
                ", 我方代开票='" + 我方代开票 + '\'' +
                ", 代开票税点='" + 代开票税点 + '\'' +
                ", 电费单价元度='" + 电费单价元度 + '\'' +
                ", 电价标准='" + 电价标准 + '\'' +
                ", 电费支付方式='" + 电费支付方式 + '\'' +
                ", 电费支付周期月='" + 电费支付周期月 + '\'' +
                ", 电费约定首次支付日期='" + 电费约定首次支付日期 + '\'' +
                ", 电费收款账号='" + 电费收款账号 + '\'' +
                ", 电费收款户名='" + 电费收款户名 + '\'' +
                ", 所属银行电费收款='" + 所属银行电费收款 + '\'' +
                ", 电费收款银行='" + 电费收款银行 + '\'' +
                ", 电费票据类型='" + 电费票据类型 + '\'' +
                ", 押金金额元='" + 押金金额元 + '\'' +
                '}';
    }

    public String get是否关联框架合同() {
        return 是否关联框架合同;
    }

    public void set是否关联框架合同(String 是否关联框架合同) {
        this.是否关联框架合同 = 是否关联框架合同;
    }

    public String get是否需要续签() {
        return 是否需要续签;
    }

    public void set是否需要续签(String 是否需要续签) {
        this.是否需要续签 = 是否需要续签;
    }

    public String get省份() {
        return 省份;
    }

    public void set省份(String 省份) {
        this.省份 = 省份;
    }

    public String get地市() {
        return 地市;
    }

    public void set地市(String 地市) {
        this.地市 = 地市;
    }

    public String get区县() {
        return 区县;
    }

    public void set区县(String 区县) {
        this.区县 = 区县;
    }

    public String get省分公司() {
        return 省分公司;
    }

    public void set省分公司(String 省分公司) {
        this.省分公司 = 省分公司;
    }

    public String get地市公司() {
        return 地市公司;
    }

    public void set地市公司(String 地市公司) {
        this.地市公司 = 地市公司;
    }

    public String get站点编码() {
        return 站点编码;
    }

    public void set站点编码(String 站点编码) {
        this.站点编码 = 站点编码;
    }

    public String get站点名称() {
        return 站点名称;
    }

    public void set站点名称(String 站点名称) {
        this.站点名称 = 站点名称;
    }

    public String get站点性质() {
        return 站点性质;
    }

    public void set站点性质(String 站点性质) {
        this.站点性质 = 站点性质;
    }

    public String get建设场景() {
        return 建设场景;
    }

    public void set建设场景(String 建设场景) {
        this.建设场景 = 建设场景;
    }

    public String get物业编码() {
        return 物业编码;
    }

    public void set物业编码(String 物业编码) {
        this.物业编码 = 物业编码;
    }

    public String get物业名称() {
        return 物业名称;
    }

    public void set物业名称(String 物业名称) {
        this.物业名称 = 物业名称;
    }

    public String get合同编码() {
        return 合同编码;
    }

    public void set合同编码(String 合同编码) {
        this.合同编码 = 合同编码;
    }

    public String get合同名称() {
        return 合同名称;
    }

    public void set合同名称(String 合同名称) {
        this.合同名称 = 合同名称;
    }

    public String get合同类型() {
        return 合同类型;
    }

    public void set合同类型(String 合同类型) {
        this.合同类型 = 合同类型;
    }

    public String get合同属性() {
        return 合同属性;
    }

    public void set合同属性(String 合同属性) {
        this.合同属性 = 合同属性;
    }

    public String get所属业主名称甲方() {
        return 所属业主名称甲方;
    }

    public void set所属业主名称甲方(String 所属业主名称甲方) {
        this.所属业主名称甲方 = 所属业主名称甲方;
    }

    public String get客商编号() {
        return 客商编号;
    }

    public void set客商编号(String 客商编号) {
        this.客商编号 = 客商编号;
    }

    public String get业主电话() {
        return 业主电话;
    }

    public void set业主电话(String 业主电话) {
        this.业主电话 = 业主电话;
    }

    public String get证件号码() {
        return 证件号码;
    }

    public void set证件号码(String 证件号码) {
        this.证件号码 = 证件号码;
    }

    public String get业主所属地市公司() {
        return 业主所属地市公司;
    }

    public void set业主所属地市公司(String 业主所属地市公司) {
        this.业主所属地市公司 = 业主所属地市公司;
    }

    public String get业主类型() {
        return 业主类型;
    }

    public void set业主类型(String 业主类型) {
        this.业主类型 = 业主类型;
    }

    public String get业主证件类型() {
        return 业主证件类型;
    }

    public void set业主证件类型(String 业主证件类型) {
        this.业主证件类型 = 业主证件类型;
    }

    public String get业主证件号码() {
        return 业主证件号码;
    }

    public void set业主证件号码(String 业主证件号码) {
        this.业主证件号码 = 业主证件号码;
    }

    public String get合同乙方() {
        return 合同乙方;
    }

    public void set合同乙方(String 合同乙方) {
        this.合同乙方 = 合同乙方;
    }

    public String get合同签订日期() {
        return 合同签订日期;
    }

    public void set合同签订日期(String 合同签订日期) {
        this.合同签订日期 = 合同签订日期;
    }

    public String get合同起始日期原始() {
        return 合同起始日期原始;
    }

    public void set合同起始日期原始(String 合同起始日期原始) {
        this.合同起始日期原始 = 合同起始日期原始;
    }

    public String get合同支付计提起始日期() {
        return 合同支付计提起始日期;
    }

    public void set合同支付计提起始日期(String 合同支付计提起始日期) {
        this.合同支付计提起始日期 = 合同支付计提起始日期;
    }

    public String get合同终止日期() {
        return 合同终止日期;
    }

    public void set合同终止日期(String 合同终止日期) {
        this.合同终止日期 = 合同终止日期;
    }

    public String get合同录入日期() {
        return 合同录入日期;
    }

    public void set合同录入日期(String 合同录入日期) {
        this.合同录入日期 = 合同录入日期;
    }

    public String get合同总金额() {
        return 合同总金额;
    }

    public void set合同总金额(String 合同总金额) {
        this.合同总金额 = 合同总金额;
    }

    public String get经办人() {
        return 经办人;
    }

    public void set经办人(String 经办人) {
        this.经办人 = 经办人;
    }

    public String get经办部门() {
        return 经办部门;
    }

    public void set经办部门(String 经办部门) {
        this.经办部门 = 经办部门;
    }

    public String get合同状态() {
        return 合同状态;
    }

    public void set合同状态(String 合同状态) {
        this.合同状态 = 合同状态;
    }

    public String get是否代持() {
        return 是否代持;
    }

    public void set是否代持(String 是否代持) {
        this.是否代持 = 是否代持;
    }

    public String get站点是否删除() {
        return 站点是否删除;
    }

    public void set站点是否删除(String 站点是否删除) {
        this.站点是否删除 = 站点是否删除;
    }

    public String get被续签合同编码() {
        return 被续签合同编码;
    }

    public void set被续签合同编码(String 被续签合同编码) {
        this.被续签合同编码 = 被续签合同编码;
    }

    public String get最后修改时间() {
        return 最后修改时间;
    }

    public void set最后修改时间(String 最后修改时间) {
        this.最后修改时间 = 最后修改时间;
    }

    public String get房屋租赁面积平方米() {
        return 房屋租赁面积平方米;
    }

    public void set房屋租赁面积平方米(String 房屋租赁面积平方米) {
        this.房屋租赁面积平方米 = 房屋租赁面积平方米;
    }

    public String get场地租赁面积平方米() {
        return 场地租赁面积平方米;
    }

    public void set场地租赁面积平方米(String 场地租赁面积平方米) {
        this.场地租赁面积平方米 = 场地租赁面积平方米;
    }

    public String get基本年租金元年() {
        return 基本年租金元年;
    }

    public void set基本年租金元年(String 基本年租金元年) {
        this.基本年租金元年 = 基本年租金元年;
    }

    public String get租金支付方式() {
        return 租金支付方式;
    }

    public void set租金支付方式(String 租金支付方式) {
        this.租金支付方式 = 租金支付方式;
    }

    public String get租金支付周期月() {
        return 租金支付周期月;
    }

    public void set租金支付周期月(String 租金支付周期月) {
        this.租金支付周期月 = 租金支付周期月;
    }

    public String get租金约定首次支付日期() {
        return 租金约定首次支付日期;
    }

    public void set租金约定首次支付日期(String 租金约定首次支付日期) {
        this.租金约定首次支付日期 = 租金约定首次支付日期;
    }

    public String get租金收款账号() {
        return 租金收款账号;
    }

    public void set租金收款账号(String 租金收款账号) {
        this.租金收款账号 = 租金收款账号;
    }

    public String get租金收款户名() {
        return 租金收款户名;
    }

    public void set租金收款户名(String 租金收款户名) {
        this.租金收款户名 = 租金收款户名;
    }

    public String get所属银行租金收款() {
        return 所属银行租金收款;
    }

    public void set所属银行租金收款(String 所属银行租金收款) {
        this.所属银行租金收款 = 所属银行租金收款;
    }

    public String get租金收款银行() {
        return 租金收款银行;
    }

    public void set租金收款银行(String 租金收款银行) {
        this.租金收款银行 = 租金收款银行;
    }

    public String get租金票据类型() {
        return 租金票据类型;
    }

    public void set租金票据类型(String 租金票据类型) {
        this.租金票据类型 = 租金票据类型;
    }

    public String get我方代开票() {
        return 我方代开票;
    }

    public void set我方代开票(String 我方代开票) {
        this.我方代开票 = 我方代开票;
    }

    public String get代开票税点() {
        return 代开票税点;
    }

    public void set代开票税点(String 代开票税点) {
        this.代开票税点 = 代开票税点;
    }

    public String get电费单价元度() {
        return 电费单价元度;
    }

    public void set电费单价元度(String 电费单价元度) {
        this.电费单价元度 = 电费单价元度;
    }

    public String get电价标准() {
        return 电价标准;
    }

    public void set电价标准(String 电价标准) {
        this.电价标准 = 电价标准;
    }

    public String get电费支付方式() {
        return 电费支付方式;
    }

    public void set电费支付方式(String 电费支付方式) {
        this.电费支付方式 = 电费支付方式;
    }

    public String get电费支付周期月() {
        return 电费支付周期月;
    }

    public void set电费支付周期月(String 电费支付周期月) {
        this.电费支付周期月 = 电费支付周期月;
    }

    public String get电费约定首次支付日期() {
        return 电费约定首次支付日期;
    }

    public void set电费约定首次支付日期(String 电费约定首次支付日期) {
        this.电费约定首次支付日期 = 电费约定首次支付日期;
    }

    public String get电费收款账号() {
        return 电费收款账号;
    }

    public void set电费收款账号(String 电费收款账号) {
        this.电费收款账号 = 电费收款账号;
    }

    public String get电费收款户名() {
        return 电费收款户名;
    }

    public void set电费收款户名(String 电费收款户名) {
        this.电费收款户名 = 电费收款户名;
    }

    public String get所属银行电费收款() {
        return 所属银行电费收款;
    }

    public void set所属银行电费收款(String 所属银行电费收款) {
        this.所属银行电费收款 = 所属银行电费收款;
    }

    public String get电费收款银行() {
        return 电费收款银行;
    }

    public void set电费收款银行(String 电费收款银行) {
        this.电费收款银行 = 电费收款银行;
    }

    public String get电费票据类型() {
        return 电费票据类型;
    }

    public void set电费票据类型(String 电费票据类型) {
        this.电费票据类型 = 电费票据类型;
    }

    public String get押金金额元() {
        return 押金金额元;
    }

    public void set押金金额元(String 押金金额元) {
        this.押金金额元 = 押金金额元;
    }
}
