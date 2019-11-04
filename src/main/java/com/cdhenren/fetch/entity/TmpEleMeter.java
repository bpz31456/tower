package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/04/28
 */
public class TmpEleMeter implements ResultSet {
    private String 省;
    private String 市;
    private String 所属区域;
    private String 电表编码;
    private String 使用运营商;
    private String 电表名称;
    private String 站点编码;
    private String 站点名称;
    private String 所属物业;
    private String 物业编码;
    private String 供电方;
    private String 客商编码;
    private String 供电方式;
    private String 供电用户号;
    private String 供电用户名;
    private String 电表倍率;
    private String 是否对外支付;
    private String 电表类型;
    private String 电表状态;
    private String 电表启用时间;
    private String 电表属性;
    private String 电表初始化读数;
    private String 电表最高限额;
    private String 电表归属方;
    private String 归属供电线路;
    private String 电表属性1;
    private String 电表位置;
    private String 直供电付款方式;
    private String 直供电支付方式;
    private String 电价类型;
    private String 电价标识;
    private String 峰值单价;
    private String 谷值单价;
    private String 平值单价;
    private String 尖值单价;
    private String 是否为换表;
    private String 原电表编号;
    private String 换表日期;
    private String 托收号;
    private String 录入人;
    private String 创建时间;
    private String 归属站址类型;

    @Override
    public String toString() {
        return "TmpEleMeter{" +
                "省='" + 省 + '\'' +
                ", 市='" + 市 + '\'' +
                ", 所属区域='" + 所属区域 + '\'' +
                ", 电表编码='" + 电表编码 + '\'' +
                ", 使用运营商='" + 使用运营商 + '\'' +
                ", 电表名称='" + 电表名称 + '\'' +
                ", 站点编码='" + 站点编码 + '\'' +
                ", 站点名称='" + 站点名称 + '\'' +
                ", 所属物业='" + 所属物业 + '\'' +
                ", 物业编码='" + 物业编码 + '\'' +
                ", 供电方='" + 供电方 + '\'' +
                ", 客商编码='" + 客商编码 + '\'' +
                ", 供电方式='" + 供电方式 + '\'' +
                ", 供电用户号='" + 供电用户号 + '\'' +
                ", 供电用户名='" + 供电用户名 + '\'' +
                ", 电表倍率='" + 电表倍率 + '\'' +
                ", 是否对外支付='" + 是否对外支付 + '\'' +
                ", 电表类型='" + 电表类型 + '\'' +
                ", 电表状态='" + 电表状态 + '\'' +
                ", 电表启用时间='" + 电表启用时间 + '\'' +
                ", 电表属性='" + 电表属性 + '\'' +
                ", 电表初始化读数='" + 电表初始化读数 + '\'' +
                ", 电表最高限额='" + 电表最高限额 + '\'' +
                ", 电表归属方='" + 电表归属方 + '\'' +
                ", 归属供电线路='" + 归属供电线路 + '\'' +
                ", 电表属性1='" + 电表属性1 + '\'' +
                ", 电表位置='" + 电表位置 + '\'' +
                ", 直供电付款方式='" + 直供电付款方式 + '\'' +
                ", 直供电支付方式='" + 直供电支付方式 + '\'' +
                ", 电价类型='" + 电价类型 + '\'' +
                ", 电价标识='" + 电价标识 + '\'' +
                ", 峰值单价='" + 峰值单价 + '\'' +
                ", 谷值单价='" + 谷值单价 + '\'' +
                ", 平值单价='" + 平值单价 + '\'' +
                ", 尖值单价='" + 尖值单价 + '\'' +
                ", 是否为换表='" + 是否为换表 + '\'' +
                ", 原电表编号='" + 原电表编号 + '\'' +
                ", 换表日期='" + 换表日期 + '\'' +
                ", 托收号='" + 托收号 + '\'' +
                ", 录入人='" + 录入人 + '\'' +
                ", 创建时间='" + 创建时间 + '\'' +
                ", 归属站址类型='" + 归属站址类型 + '\'' +
                '}';
    }

    public String get省() {
        return 省;
    }

    public void set省(String 省) {
        this.省 = 省;
    }

    public String get市() {
        return 市;
    }

    public void set市(String 市) {
        this.市 = 市;
    }

    public String get所属区域() {
        return 所属区域;
    }

    public void set所属区域(String 所属区域) {
        this.所属区域 = 所属区域;
    }

    public String get电表编码() {
        return 电表编码;
    }

    public void set电表编码(String 电表编码) {
        this.电表编码 = 电表编码;
    }

    public String get使用运营商() {
        return 使用运营商;
    }

    public void set使用运营商(String 使用运营商) {
        this.使用运营商 = 使用运营商;
    }

    public String get电表名称() {
        return 电表名称;
    }

    public void set电表名称(String 电表名称) {
        this.电表名称 = 电表名称;
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

    public String get所属物业() {
        return 所属物业;
    }

    public void set所属物业(String 所属物业) {
        this.所属物业 = 所属物业;
    }

    public String get物业编码() {
        return 物业编码;
    }

    public void set物业编码(String 物业编码) {
        this.物业编码 = 物业编码;
    }

    public String get供电方() {
        return 供电方;
    }

    public void set供电方(String 供电方) {
        this.供电方 = 供电方;
    }

    public String get客商编码() {
        return 客商编码;
    }

    public void set客商编码(String 客商编码) {
        this.客商编码 = 客商编码;
    }

    public String get供电方式() {
        return 供电方式;
    }

    public void set供电方式(String 供电方式) {
        this.供电方式 = 供电方式;
    }

    public String get供电用户号() {
        return 供电用户号;
    }

    public void set供电用户号(String 供电用户号) {
        this.供电用户号 = 供电用户号;
    }

    public String get供电用户名() {
        return 供电用户名;
    }

    public void set供电用户名(String 供电用户名) {
        this.供电用户名 = 供电用户名;
    }

    public String get电表倍率() {
        return 电表倍率;
    }

    public void set电表倍率(String 电表倍率) {
        this.电表倍率 = 电表倍率;
    }

    public String get是否对外支付() {
        return 是否对外支付;
    }

    public void set是否对外支付(String 是否对外支付) {
        this.是否对外支付 = 是否对外支付;
    }

    public String get电表类型() {
        return 电表类型;
    }

    public void set电表类型(String 电表类型) {
        this.电表类型 = 电表类型;
    }

    public String get电表状态() {
        return 电表状态;
    }

    public void set电表状态(String 电表状态) {
        this.电表状态 = 电表状态;
    }

    public String get电表启用时间() {
        return 电表启用时间;
    }

    public void set电表启用时间(String 电表启用时间) {
        this.电表启用时间 = 电表启用时间;
    }

    public String get电表属性() {
        return 电表属性;
    }

    public void set电表属性(String 电表属性) {
        this.电表属性 = 电表属性;
    }

    public String get电表初始化读数() {
        return 电表初始化读数;
    }

    public void set电表初始化读数(String 电表初始化读数) {
        this.电表初始化读数 = 电表初始化读数;
    }

    public String get电表最高限额() {
        return 电表最高限额;
    }

    public void set电表最高限额(String 电表最高限额) {
        this.电表最高限额 = 电表最高限额;
    }

    public String get电表归属方() {
        return 电表归属方;
    }

    public void set电表归属方(String 电表归属方) {
        this.电表归属方 = 电表归属方;
    }

    public String get归属供电线路() {
        return 归属供电线路;
    }

    public void set归属供电线路(String 归属供电线路) {
        this.归属供电线路 = 归属供电线路;
    }

    public String get电表属性1() {
        return 电表属性1;
    }

    public void set电表属性1(String 电表属性1) {
        this.电表属性1 = 电表属性1;
    }

    public String get电表位置() {
        return 电表位置;
    }

    public void set电表位置(String 电表位置) {
        this.电表位置 = 电表位置;
    }

    public String get直供电付款方式() {
        return 直供电付款方式;
    }

    public void set直供电付款方式(String 直供电付款方式) {
        this.直供电付款方式 = 直供电付款方式;
    }

    public String get直供电支付方式() {
        return 直供电支付方式;
    }

    public void set直供电支付方式(String 直供电支付方式) {
        this.直供电支付方式 = 直供电支付方式;
    }

    public String get电价类型() {
        return 电价类型;
    }

    public void set电价类型(String 电价类型) {
        this.电价类型 = 电价类型;
    }

    public String get电价标识() {
        return 电价标识;
    }

    public void set电价标识(String 电价标识) {
        this.电价标识 = 电价标识;
    }

    public String get峰值单价() {
        return 峰值单价;
    }

    public void set峰值单价(String 峰值单价) {
        this.峰值单价 = 峰值单价;
    }

    public String get谷值单价() {
        return 谷值单价;
    }

    public void set谷值单价(String 谷值单价) {
        this.谷值单价 = 谷值单价;
    }

    public String get平值单价() {
        return 平值单价;
    }

    public void set平值单价(String 平值单价) {
        this.平值单价 = 平值单价;
    }

    public String get尖值单价() {
        return 尖值单价;
    }

    public void set尖值单价(String 尖值单价) {
        this.尖值单价 = 尖值单价;
    }

    public String get是否为换表() {
        return 是否为换表;
    }

    public void set是否为换表(String 是否为换表) {
        this.是否为换表 = 是否为换表;
    }

    public String get原电表编号() {
        return 原电表编号;
    }

    public void set原电表编号(String 原电表编号) {
        this.原电表编号 = 原电表编号;
    }

    public String get换表日期() {
        return 换表日期;
    }

    public void set换表日期(String 换表日期) {
        this.换表日期 = 换表日期;
    }

    public String get托收号() {
        return 托收号;
    }

    public void set托收号(String 托收号) {
        this.托收号 = 托收号;
    }

    public String get录入人() {
        return 录入人;
    }

    public void set录入人(String 录入人) {
        this.录入人 = 录入人;
    }

    public String get创建时间() {
        return 创建时间;
    }

    public void set创建时间(String 创建时间) {
        this.创建时间 = 创建时间;
    }

    public String get归属站址类型() {
        return 归属站址类型;
    }

    public void set归属站址类型(String 归属站址类型) {
        this.归属站址类型 = 归属站址类型;
    }
}
