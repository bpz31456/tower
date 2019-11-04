package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class TmpTransferOrder implements ResultSet {
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
    private String 维护服务等级;
    private String 产权属性;
    private String 原产权单位;
    private String 站点位置情况_经度;
    private String 站点位置情况_纬度;
    private String 站点位置情况_详细地址;
    private String 管道_管道起点;
    private String 管道_管道终点;
    private String 管道_管道长度子孔公里;
    private String 光缆_光缆起点;
    private String 光缆_光缆终点;
    private String 光缆_光缆长度芯每公里;
    private String 杆路_杆路起点;
    private String 杆路_杆路终点;
    private String 杆路_杆路长度杆路公里;
    private String 交付起租时间_应交付日期;
    private String 交付起租时间_实际交付日期;
    private String 交付起租时间_终止时间;
    private String 交付起租时间_起租生效日期;
    private String 费用信息单位元年_传输建造成本;
    private String 费用信息单位元年_传输维护费;
    private String 费用信息单位元年_总费用;
    private String 铁塔管理区域;
    private String 项目编码;
    private String 大型项目类别;
    private String 所属大型项目名称;
    private String 经办状态;

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

    public String get维护服务等级() {
        return 维护服务等级;
    }

    public void set维护服务等级(String 维护服务等级) {
        this.维护服务等级 = 维护服务等级;
    }

    public String get产权属性() {
        return 产权属性;
    }

    public void set产权属性(String 产权属性) {
        this.产权属性 = 产权属性;
    }

    @Override
    public String toString() {
        return "TmpTransferOrder{" +
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
                ", 维护服务等级='" + 维护服务等级 + '\'' +
                ", 产权属性='" + 产权属性 + '\'' +
                ", 原产权单位='" + 原产权单位 + '\'' +
                ", 站点位置情况_经度='" + 站点位置情况_经度 + '\'' +
                ", 站点位置情况_纬度='" + 站点位置情况_纬度 + '\'' +
                ", 站点位置情况_详细地址='" + 站点位置情况_详细地址 + '\'' +
                ", 管道_管道起点='" + 管道_管道起点 + '\'' +
                ", 管道_管道终点='" + 管道_管道终点 + '\'' +
                ", 管道_管道长度子孔公里='" + 管道_管道长度子孔公里 + '\'' +
                ", 光缆_光缆起点='" + 光缆_光缆起点 + '\'' +
                ", 光缆_光缆终点='" + 光缆_光缆终点 + '\'' +
                ", 光缆_光缆长度芯每公里='" + 光缆_光缆长度芯每公里 + '\'' +
                ", 杆路_杆路起点='" + 杆路_杆路起点 + '\'' +
                ", 杆路_杆路终点='" + 杆路_杆路终点 + '\'' +
                ", 杆路_杆路长度杆路公里='" + 杆路_杆路长度杆路公里 + '\'' +
                ", 交付起租时间_应交付日期='" + 交付起租时间_应交付日期 + '\'' +
                ", 交付起租时间_实际交付日期='" + 交付起租时间_实际交付日期 + '\'' +
                ", 交付起租时间_终止时间='" + 交付起租时间_终止时间 + '\'' +
                ", 交付起租时间_起租生效日期='" + 交付起租时间_起租生效日期 + '\'' +
                ", 费用信息单位元年_传输建造成本='" + 费用信息单位元年_传输建造成本 + '\'' +
                ", 费用信息单位元年_传输维护费='" + 费用信息单位元年_传输维护费 + '\'' +
                ", 费用信息单位元年_总费用='" + 费用信息单位元年_总费用 + '\'' +
                ", 铁塔管理区域='" + 铁塔管理区域 + '\'' +
                ", 项目编码='" + 项目编码 + '\'' +
                ", 大型项目类别='" + 大型项目类别 + '\'' +
                ", 所属大型项目名称='" + 所属大型项目名称 + '\'' +
                ", 经办状态='" + 经办状态 + '\'' +
                '}';
    }

    public String get原产权单位() {
        return 原产权单位;
    }

    public void set原产权单位(String 原产权单位) {
        this.原产权单位 = 原产权单位;
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

    public String get管道_管道起点() {
        return 管道_管道起点;
    }

    public void set管道_管道起点(String 管道_管道起点) {
        this.管道_管道起点 = 管道_管道起点;
    }

    public String get管道_管道终点() {
        return 管道_管道终点;
    }

    public void set管道_管道终点(String 管道_管道终点) {
        this.管道_管道终点 = 管道_管道终点;
    }

    public String get管道_管道长度子孔公里() {
        return 管道_管道长度子孔公里;
    }

    public void set管道_管道长度子孔公里(String 管道_管道长度子孔公里) {
        this.管道_管道长度子孔公里 = 管道_管道长度子孔公里;
    }

    public String get光缆_光缆起点() {
        return 光缆_光缆起点;
    }

    public void set光缆_光缆起点(String 光缆_光缆起点) {
        this.光缆_光缆起点 = 光缆_光缆起点;
    }

    public String get光缆_光缆终点() {
        return 光缆_光缆终点;
    }

    public void set光缆_光缆终点(String 光缆_光缆终点) {
        this.光缆_光缆终点 = 光缆_光缆终点;
    }

    public String get光缆_光缆长度芯每公里() {
        return 光缆_光缆长度芯每公里;
    }

    public void set光缆_光缆长度芯每公里(String 光缆_光缆长度芯每公里) {
        this.光缆_光缆长度芯每公里 = 光缆_光缆长度芯每公里;
    }

    public String get杆路_杆路起点() {
        return 杆路_杆路起点;
    }

    public void set杆路_杆路起点(String 杆路_杆路起点) {
        this.杆路_杆路起点 = 杆路_杆路起点;
    }

    public String get杆路_杆路终点() {
        return 杆路_杆路终点;
    }

    public void set杆路_杆路终点(String 杆路_杆路终点) {
        this.杆路_杆路终点 = 杆路_杆路终点;
    }

    public String get杆路_杆路长度杆路公里() {
        return 杆路_杆路长度杆路公里;
    }

    public void set杆路_杆路长度杆路公里(String 杆路_杆路长度杆路公里) {
        this.杆路_杆路长度杆路公里 = 杆路_杆路长度杆路公里;
    }

    public String get交付起租时间_应交付日期() {
        return 交付起租时间_应交付日期;
    }

    public void set交付起租时间_应交付日期(String 交付起租时间_应交付日期) {
        this.交付起租时间_应交付日期 = 交付起租时间_应交付日期;
    }

    public String get交付起租时间_实际交付日期() {
        return 交付起租时间_实际交付日期;
    }

    public void set交付起租时间_实际交付日期(String 交付起租时间_实际交付日期) {
        this.交付起租时间_实际交付日期 = 交付起租时间_实际交付日期;
    }

    public String get交付起租时间_终止时间() {
        return 交付起租时间_终止时间;
    }

    public void set交付起租时间_终止时间(String 交付起租时间_终止时间) {
        this.交付起租时间_终止时间 = 交付起租时间_终止时间;
    }

    public String get交付起租时间_起租生效日期() {
        return 交付起租时间_起租生效日期;
    }

    public void set交付起租时间_起租生效日期(String 交付起租时间_起租生效日期) {
        this.交付起租时间_起租生效日期 = 交付起租时间_起租生效日期;
    }

    public String get费用信息单位元年_传输建造成本() {
        return 费用信息单位元年_传输建造成本;
    }

    public void set费用信息单位元年_传输建造成本(String 费用信息单位元年_传输建造成本) {
        this.费用信息单位元年_传输建造成本 = 费用信息单位元年_传输建造成本;
    }

    public String get费用信息单位元年_传输维护费() {
        return 费用信息单位元年_传输维护费;
    }

    public void set费用信息单位元年_传输维护费(String 费用信息单位元年_传输维护费) {
        this.费用信息单位元年_传输维护费 = 费用信息单位元年_传输维护费;
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

    public String get大型项目类别() {
        return 大型项目类别;
    }

    public void set大型项目类别(String 大型项目类别) {
        this.大型项目类别 = 大型项目类别;
    }

    public String get所属大型项目名称() {
        return 所属大型项目名称;
    }

    public void set所属大型项目名称(String 所属大型项目名称) {
        this.所属大型项目名称 = 所属大型项目名称;
    }

    public String get经办状态() {
        return 经办状态;
    }

    public void set经办状态(String 经办状态) {
        this.经办状态 = 经办状态;
    }
}
