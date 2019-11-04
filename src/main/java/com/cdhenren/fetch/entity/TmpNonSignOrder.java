package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class TmpNonSignOrder implements ResultSet {
    private String 序号;
    private String 订单状态;
    private String 订单号;
    private String 运营商;
    private String 省份;
    private String 地市;
    private String 区县;
    private String 管理区;
    private String 需求方站点名称;
    private String 铁塔站址名称;
    private String 站址编码;
    private String 合并需求单号;
    private String 订单属性;
    private String 需求批次;
    private String 项目建设状态;
    private String 场景划分;
    private String 建设方式;
    private String 风压系数;
    private String 产权属性;
    private String 原产权单位;
    private String _0_6点是否上站;
    private String 产品配置;
    private String 站点位置情况_经度;
    private String 站点位置情况_纬度;
    private String 站点位置情况_详细地址;
    private String 铁塔参数_铁塔编码;
    private String 铁塔参数_铁塔种类;
    private String 铁塔参数_铁塔细分种类;
    private String 铁塔参数_铁塔名称;
    private String 机房参数_机房编码;
    private String 机房参数_机房类型;
    private String 机房参数_机房名称;
    private String 项目信息_项目类型;
    private String 项目信息_所属高铁或地铁线路名称;
    private String 项目信息_项目批次;
    private String 项目信息_应交付时间;
    private String 机房改造_改造内容;
    private String 机房改造_备注;
    private String 配套改造_改造内容;
    private String 配套改造_备注;
    private String 电力改造_改造内容;
    private String 电力改造_备注;
    private String 天WLAN_线挂高米;
    private String 天WLAN_天线数量个;
    private String 天WLAN_备注;
    private String 微波_天线挂高米;
    private String 微波_天线数量个;
    private String 微波_对端微波说明;
    private String 微波_备注;
    private String 起租时间;
    private String 实际交付时间;
    private String 终止时间;
    private String 费用信息单位元年_机房建造成本;
    private String 费用信息单位元年_配套建造成本;
    private String 费用信息单位元年_维护费;
    private String 费用信息单位元年_电力引入费;
    private String 费用信息单位元年_其它机房改造费;
    private String 费用信息单位元年_其它配套改造费;
    private String 费用信息单位元年_其它场地费;
    private String 费用信息单位元年_其它电力引入费;
    private String 费用信息单位元年_WLAN;
    private String 费用信息单位元年_微波;
    private String 费用信息单位元年_总费用;
    private String 铁塔管理区域;
    private String 项目编码;
    private String 经办状态;

    @Override
    public String toString() {
        return "TmpNonSignOrder{" +
                "序号='" + 序号 + '\'' +
                ", 订单状态='" + 订单状态 + '\'' +
                ", 订单号='" + 订单号 + '\'' +
                ", 运营商='" + 运营商 + '\'' +
                ", 省份='" + 省份 + '\'' +
                ", 地市='" + 地市 + '\'' +
                ", 区县='" + 区县 + '\'' +
                ", 管理区='" + 管理区 + '\'' +
                ", 需求方站点名称='" + 需求方站点名称 + '\'' +
                ", 铁塔站址名称='" + 铁塔站址名称 + '\'' +
                ", 站址编码='" + 站址编码 + '\'' +
                ", 合并需求单号='" + 合并需求单号 + '\'' +
                ", 订单属性='" + 订单属性 + '\'' +
                ", 需求批次='" + 需求批次 + '\'' +
                ", 项目建设状态='" + 项目建设状态 + '\'' +
                ", 场景划分='" + 场景划分 + '\'' +
                ", 建设方式='" + 建设方式 + '\'' +
                ", 风压系数='" + 风压系数 + '\'' +
                ", 产权属性='" + 产权属性 + '\'' +
                ", 原产权单位='" + 原产权单位 + '\'' +
                ", _0_6点是否上站='" + _0_6点是否上站 + '\'' +
                ", 产品配置='" + 产品配置 + '\'' +
                ", 站点位置情况_经度='" + 站点位置情况_经度 + '\'' +
                ", 站点位置情况_纬度='" + 站点位置情况_纬度 + '\'' +
                ", 站点位置情况_详细地址='" + 站点位置情况_详细地址 + '\'' +
                ", 铁塔参数_铁塔编码='" + 铁塔参数_铁塔编码 + '\'' +
                ", 铁塔参数_铁塔种类='" + 铁塔参数_铁塔种类 + '\'' +
                ", 铁塔参数_铁塔细分种类='" + 铁塔参数_铁塔细分种类 + '\'' +
                ", 铁塔参数_铁塔名称='" + 铁塔参数_铁塔名称 + '\'' +
                ", 机房参数_机房编码='" + 机房参数_机房编码 + '\'' +
                ", 机房参数_机房类型='" + 机房参数_机房类型 + '\'' +
                ", 机房参数_机房名称='" + 机房参数_机房名称 + '\'' +
                ", 项目信息_项目类型='" + 项目信息_项目类型 + '\'' +
                ", 项目信息_所属高铁或地铁线路名称='" + 项目信息_所属高铁或地铁线路名称 + '\'' +
                ", 项目信息_项目批次='" + 项目信息_项目批次 + '\'' +
                ", 项目信息_应交付时间='" + 项目信息_应交付时间 + '\'' +
                ", 机房改造_改造内容='" + 机房改造_改造内容 + '\'' +
                ", 机房改造_备注='" + 机房改造_备注 + '\'' +
                ", 配套改造_改造内容='" + 配套改造_改造内容 + '\'' +
                ", 配套改造_备注='" + 配套改造_备注 + '\'' +
                ", 电力改造_改造内容='" + 电力改造_改造内容 + '\'' +
                ", 电力改造_备注='" + 电力改造_备注 + '\'' +
                ", 天WLAN_线挂高米='" + 天WLAN_线挂高米 + '\'' +
                ", 天WLAN_天线数量个='" + 天WLAN_天线数量个 + '\'' +
                ", 天WLAN_备注='" + 天WLAN_备注 + '\'' +
                ", 微波_天线挂高米='" + 微波_天线挂高米 + '\'' +
                ", 微波_天线数量个='" + 微波_天线数量个 + '\'' +
                ", 微波_对端微波说明='" + 微波_对端微波说明 + '\'' +
                ", 微波_备注='" + 微波_备注 + '\'' +
                ", 起租时间='" + 起租时间 + '\'' +
                ", 实际交付时间='" + 实际交付时间 + '\'' +
                ", 终止时间='" + 终止时间 + '\'' +
                ", 费用信息单位元年_机房建造成本='" + 费用信息单位元年_机房建造成本 + '\'' +
                ", 费用信息单位元年_配套建造成本='" + 费用信息单位元年_配套建造成本 + '\'' +
                ", 费用信息单位元年_维护费='" + 费用信息单位元年_维护费 + '\'' +
                ", 费用信息单位元年_电力引入费='" + 费用信息单位元年_电力引入费 + '\'' +
                ", 费用信息单位元年_其它机房改造费='" + 费用信息单位元年_其它机房改造费 + '\'' +
                ", 费用信息单位元年_其它配套改造费='" + 费用信息单位元年_其它配套改造费 + '\'' +
                ", 费用信息单位元年_其它场地费='" + 费用信息单位元年_其它场地费 + '\'' +
                ", 费用信息单位元年_其它电力引入费='" + 费用信息单位元年_其它电力引入费 + '\'' +
                ", 费用信息单位元年_WLAN='" + 费用信息单位元年_WLAN + '\'' +
                ", 费用信息单位元年_微波='" + 费用信息单位元年_微波 + '\'' +
                ", 费用信息单位元年_总费用='" + 费用信息单位元年_总费用 + '\'' +
                ", 铁塔管理区域='" + 铁塔管理区域 + '\'' +
                ", 项目编码='" + 项目编码 + '\'' +
                ", 经办状态='" + 经办状态 + '\'' +
                '}';
    }

    public String get序号() {
        return 序号;
    }

    public void set序号(String 序号) {
        this.序号 = 序号;
    }

    public String get订单状态() {
        return 订单状态;
    }

    public void set订单状态(String 订单状态) {
        this.订单状态 = 订单状态;
    }

    public String get订单号() {
        return 订单号;
    }

    public void set订单号(String 订单号) {
        this.订单号 = 订单号;
    }

    public String get运营商() {
        return 运营商;
    }

    public void set运营商(String 运营商) {
        this.运营商 = 运营商;
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

    public String get管理区() {
        return 管理区;
    }

    public void set管理区(String 管理区) {
        this.管理区 = 管理区;
    }

    public String get需求方站点名称() {
        return 需求方站点名称;
    }

    public void set需求方站点名称(String 需求方站点名称) {
        this.需求方站点名称 = 需求方站点名称;
    }

    public String get铁塔站址名称() {
        return 铁塔站址名称;
    }

    public void set铁塔站址名称(String 铁塔站址名称) {
        this.铁塔站址名称 = 铁塔站址名称;
    }

    public String get站址编码() {
        return 站址编码;
    }

    public void set站址编码(String 站址编码) {
        this.站址编码 = 站址编码;
    }

    public String get合并需求单号() {
        return 合并需求单号;
    }

    public void set合并需求单号(String 合并需求单号) {
        this.合并需求单号 = 合并需求单号;
    }

    public String get订单属性() {
        return 订单属性;
    }

    public void set订单属性(String 订单属性) {
        this.订单属性 = 订单属性;
    }

    public String get需求批次() {
        return 需求批次;
    }

    public void set需求批次(String 需求批次) {
        this.需求批次 = 需求批次;
    }

    public String get项目建设状态() {
        return 项目建设状态;
    }

    public void set项目建设状态(String 项目建设状态) {
        this.项目建设状态 = 项目建设状态;
    }

    public String get场景划分() {
        return 场景划分;
    }

    public void set场景划分(String 场景划分) {
        this.场景划分 = 场景划分;
    }

    public String get建设方式() {
        return 建设方式;
    }

    public void set建设方式(String 建设方式) {
        this.建设方式 = 建设方式;
    }

    public String get风压系数() {
        return 风压系数;
    }

    public void set风压系数(String 风压系数) {
        this.风压系数 = 风压系数;
    }

    public String get产权属性() {
        return 产权属性;
    }

    public void set产权属性(String 产权属性) {
        this.产权属性 = 产权属性;
    }

    public String get原产权单位() {
        return 原产权单位;
    }

    public void set原产权单位(String 原产权单位) {
        this.原产权单位 = 原产权单位;
    }

    public String get_0_6点是否上站() {
        return _0_6点是否上站;
    }

    public void set_0_6点是否上站(String _0_6点是否上站) {
        this._0_6点是否上站 = _0_6点是否上站;
    }

    public String get产品配置() {
        return 产品配置;
    }

    public void set产品配置(String 产品配置) {
        this.产品配置 = 产品配置;
    }

    public String get站点位置情况_经度() {
        return 站点位置情况_经度;
    }

    public void set站点位置情况_经度(String 站点位置情况_经度) {
        this.站点位置情况_经度 = 站点位置情况_经度;
    }

    public String get站点位置情况_纬度() {
        return 站点位置情况_纬度;
    }

    public void set站点位置情况_纬度(String 站点位置情况_纬度) {
        this.站点位置情况_纬度 = 站点位置情况_纬度;
    }

    public String get站点位置情况_详细地址() {
        return 站点位置情况_详细地址;
    }

    public void set站点位置情况_详细地址(String 站点位置情况_详细地址) {
        this.站点位置情况_详细地址 = 站点位置情况_详细地址;
    }

    public String get铁塔参数_铁塔编码() {
        return 铁塔参数_铁塔编码;
    }

    public void set铁塔参数_铁塔编码(String 铁塔参数_铁塔编码) {
        this.铁塔参数_铁塔编码 = 铁塔参数_铁塔编码;
    }

    public String get铁塔参数_铁塔种类() {
        return 铁塔参数_铁塔种类;
    }

    public void set铁塔参数_铁塔种类(String 铁塔参数_铁塔种类) {
        this.铁塔参数_铁塔种类 = 铁塔参数_铁塔种类;
    }

    public String get铁塔参数_铁塔细分种类() {
        return 铁塔参数_铁塔细分种类;
    }

    public void set铁塔参数_铁塔细分种类(String 铁塔参数_铁塔细分种类) {
        this.铁塔参数_铁塔细分种类 = 铁塔参数_铁塔细分种类;
    }

    public String get铁塔参数_铁塔名称() {
        return 铁塔参数_铁塔名称;
    }

    public void set铁塔参数_铁塔名称(String 铁塔参数_铁塔名称) {
        this.铁塔参数_铁塔名称 = 铁塔参数_铁塔名称;
    }

    public String get机房参数_机房编码() {
        return 机房参数_机房编码;
    }

    public void set机房参数_机房编码(String 机房参数_机房编码) {
        this.机房参数_机房编码 = 机房参数_机房编码;
    }

    public String get机房参数_机房类型() {
        return 机房参数_机房类型;
    }

    public void set机房参数_机房类型(String 机房参数_机房类型) {
        this.机房参数_机房类型 = 机房参数_机房类型;
    }

    public String get机房参数_机房名称() {
        return 机房参数_机房名称;
    }

    public void set机房参数_机房名称(String 机房参数_机房名称) {
        this.机房参数_机房名称 = 机房参数_机房名称;
    }

    public String get项目信息_项目类型() {
        return 项目信息_项目类型;
    }

    public void set项目信息_项目类型(String 项目信息_项目类型) {
        this.项目信息_项目类型 = 项目信息_项目类型;
    }

    public String get项目信息_所属高铁或地铁线路名称() {
        return 项目信息_所属高铁或地铁线路名称;
    }

    public void set项目信息_所属高铁或地铁线路名称(String 项目信息_所属高铁或地铁线路名称) {
        this.项目信息_所属高铁或地铁线路名称 = 项目信息_所属高铁或地铁线路名称;
    }

    public String get项目信息_项目批次() {
        return 项目信息_项目批次;
    }

    public void set项目信息_项目批次(String 项目信息_项目批次) {
        this.项目信息_项目批次 = 项目信息_项目批次;
    }

    public String get项目信息_应交付时间() {
        return 项目信息_应交付时间;
    }

    public void set项目信息_应交付时间(String 项目信息_应交付时间) {
        this.项目信息_应交付时间 = 项目信息_应交付时间;
    }

    public String get机房改造_改造内容() {
        return 机房改造_改造内容;
    }

    public void set机房改造_改造内容(String 机房改造_改造内容) {
        this.机房改造_改造内容 = 机房改造_改造内容;
    }

    public String get机房改造_备注() {
        return 机房改造_备注;
    }

    public void set机房改造_备注(String 机房改造_备注) {
        this.机房改造_备注 = 机房改造_备注;
    }

    public String get配套改造_改造内容() {
        return 配套改造_改造内容;
    }

    public void set配套改造_改造内容(String 配套改造_改造内容) {
        this.配套改造_改造内容 = 配套改造_改造内容;
    }

    public String get配套改造_备注() {
        return 配套改造_备注;
    }

    public void set配套改造_备注(String 配套改造_备注) {
        this.配套改造_备注 = 配套改造_备注;
    }

    public String get电力改造_改造内容() {
        return 电力改造_改造内容;
    }

    public void set电力改造_改造内容(String 电力改造_改造内容) {
        this.电力改造_改造内容 = 电力改造_改造内容;
    }

    public String get电力改造_备注() {
        return 电力改造_备注;
    }

    public void set电力改造_备注(String 电力改造_备注) {
        this.电力改造_备注 = 电力改造_备注;
    }

    public String get天WLAN_线挂高米() {
        return 天WLAN_线挂高米;
    }

    public void set天WLAN_线挂高米(String 天WLAN_线挂高米) {
        this.天WLAN_线挂高米 = 天WLAN_线挂高米;
    }

    public String get天WLAN_天线数量个() {
        return 天WLAN_天线数量个;
    }

    public void set天WLAN_天线数量个(String 天WLAN_天线数量个) {
        this.天WLAN_天线数量个 = 天WLAN_天线数量个;
    }

    public String get天WLAN_备注() {
        return 天WLAN_备注;
    }

    public void set天WLAN_备注(String 天WLAN_备注) {
        this.天WLAN_备注 = 天WLAN_备注;
    }

    public String get微波_天线挂高米() {
        return 微波_天线挂高米;
    }

    public void set微波_天线挂高米(String 微波_天线挂高米) {
        this.微波_天线挂高米 = 微波_天线挂高米;
    }

    public String get微波_天线数量个() {
        return 微波_天线数量个;
    }

    public void set微波_天线数量个(String 微波_天线数量个) {
        this.微波_天线数量个 = 微波_天线数量个;
    }

    public String get微波_对端微波说明() {
        return 微波_对端微波说明;
    }

    public void set微波_对端微波说明(String 微波_对端微波说明) {
        this.微波_对端微波说明 = 微波_对端微波说明;
    }

    public String get微波_备注() {
        return 微波_备注;
    }

    public void set微波_备注(String 微波_备注) {
        this.微波_备注 = 微波_备注;
    }

    public String get起租时间() {
        return 起租时间;
    }

    public void set起租时间(String 起租时间) {
        this.起租时间 = 起租时间;
    }

    public String get实际交付时间() {
        return 实际交付时间;
    }

    public void set实际交付时间(String 实际交付时间) {
        this.实际交付时间 = 实际交付时间;
    }

    public String get终止时间() {
        return 终止时间;
    }

    public void set终止时间(String 终止时间) {
        this.终止时间 = 终止时间;
    }

    public String get费用信息单位元年_机房建造成本() {
        return 费用信息单位元年_机房建造成本;
    }

    public void set费用信息单位元年_机房建造成本(String 费用信息单位元年_机房建造成本) {
        this.费用信息单位元年_机房建造成本 = 费用信息单位元年_机房建造成本;
    }

    public String get费用信息单位元年_配套建造成本() {
        return 费用信息单位元年_配套建造成本;
    }

    public void set费用信息单位元年_配套建造成本(String 费用信息单位元年_配套建造成本) {
        this.费用信息单位元年_配套建造成本 = 费用信息单位元年_配套建造成本;
    }

    public String get费用信息单位元年_维护费() {
        return 费用信息单位元年_维护费;
    }

    public void set费用信息单位元年_维护费(String 费用信息单位元年_维护费) {
        this.费用信息单位元年_维护费 = 费用信息单位元年_维护费;
    }

    public String get费用信息单位元年_电力引入费() {
        return 费用信息单位元年_电力引入费;
    }

    public void set费用信息单位元年_电力引入费(String 费用信息单位元年_电力引入费) {
        this.费用信息单位元年_电力引入费 = 费用信息单位元年_电力引入费;
    }

    public String get费用信息单位元年_其它机房改造费() {
        return 费用信息单位元年_其它机房改造费;
    }

    public void set费用信息单位元年_其它机房改造费(String 费用信息单位元年_其它机房改造费) {
        this.费用信息单位元年_其它机房改造费 = 费用信息单位元年_其它机房改造费;
    }

    public String get费用信息单位元年_其它配套改造费() {
        return 费用信息单位元年_其它配套改造费;
    }

    public void set费用信息单位元年_其它配套改造费(String 费用信息单位元年_其它配套改造费) {
        this.费用信息单位元年_其它配套改造费 = 费用信息单位元年_其它配套改造费;
    }

    public String get费用信息单位元年_其它场地费() {
        return 费用信息单位元年_其它场地费;
    }

    public void set费用信息单位元年_其它场地费(String 费用信息单位元年_其它场地费) {
        this.费用信息单位元年_其它场地费 = 费用信息单位元年_其它场地费;
    }

    public String get费用信息单位元年_其它电力引入费() {
        return 费用信息单位元年_其它电力引入费;
    }

    public void set费用信息单位元年_其它电力引入费(String 费用信息单位元年_其它电力引入费) {
        this.费用信息单位元年_其它电力引入费 = 费用信息单位元年_其它电力引入费;
    }

    public String get费用信息单位元年_WLAN() {
        return 费用信息单位元年_WLAN;
    }

    public void set费用信息单位元年_WLAN(String 费用信息单位元年_WLAN) {
        this.费用信息单位元年_WLAN = 费用信息单位元年_WLAN;
    }

    public String get费用信息单位元年_微波() {
        return 费用信息单位元年_微波;
    }

    public void set费用信息单位元年_微波(String 费用信息单位元年_微波) {
        this.费用信息单位元年_微波 = 费用信息单位元年_微波;
    }

    public String get费用信息单位元年_总费用() {
        return 费用信息单位元年_总费用;
    }

    public void set费用信息单位元年_总费用(String 费用信息单位元年_总费用) {
        this.费用信息单位元年_总费用 = 费用信息单位元年_总费用;
    }

    public String get铁塔管理区域() {
        return 铁塔管理区域;
    }

    public void set铁塔管理区域(String 铁塔管理区域) {
        this.铁塔管理区域 = 铁塔管理区域;
    }

    public String get项目编码() {
        return 项目编码;
    }

    public void set项目编码(String 项目编码) {
        this.项目编码 = 项目编码;
    }

    public String get经办状态() {
        return 经办状态;
    }

    public void set经办状态(String 经办状态) {
        this.经办状态 = 经办状态;
    }
}
