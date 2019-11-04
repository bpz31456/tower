package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class TmpTinySiteOrder implements ResultSet {
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
    private String 需求批次;
    private String 场景划分;
    private String 建设方式;
    private String 产权属性;
    private String 维护服务等级;
    private String _0_6点是否上站;
    private String 经度;
    private String 纬度;
    private String 详细地址;
    private String 应交付时间;
    private String 实际交付时间;
    private String 塔高;
    private String 产品类型;
    private String 提供客户总功耗KW;
    private String 电力引入方式;
    private String 蓄电池额外保障时长小时;
    private String 是否具备油机发电条件;
    private String 是否选择发电服务;
    private String 系统名称;
    private String 天线挂高米;
    private String 天线数量个;
    private String 计费系统数个;
    private String 起租时间;
    private String 截止时间;
    private String 是否需天馈及安装;
    private String 供电方式;
    private String 备注;
    private String 费用信息_杆塔价格;
    private String 费用信息_维护费;
    private String 费用信息_场地费;
    private String 费用信息_电力引入费;
    private String 费用信息_电源配套产品服务费;
    private String 费用信息_天馈及安装服务费;
    private String 费用信息_电力保障服务费;
    private String 费用信息_油机发电服务费;
    private String 费用信息_其他费用;
    private String 费用信息_总费用;
    private String 其他说明;
    private String 铁塔管理区域;
    private String 项目编码;
    private String 终止时间;
    private String 经办状态;
    private String 点位总数;
    private String 点位编号;
    private String 铁塔类型;
    private String 铁塔细分种类;
    private String 经度2;
    private String 纬度2;
    private String 是否社会资源;
    private String 社会资源类型;

    @Override
    public String toString() {
        return "TmpTinySiteOrder{" +
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
                ", 需求批次='" + 需求批次 + '\'' +
                ", 场景划分='" + 场景划分 + '\'' +
                ", 建设方式='" + 建设方式 + '\'' +
                ", 产权属性='" + 产权属性 + '\'' +
                ", 维护服务等级='" + 维护服务等级 + '\'' +
                ", _0_6点是否上站='" + _0_6点是否上站 + '\'' +
                ", 经度='" + 经度 + '\'' +
                ", 纬度='" + 纬度 + '\'' +
                ", 详细地址='" + 详细地址 + '\'' +
                ", 应交付时间='" + 应交付时间 + '\'' +
                ", 实际交付时间='" + 实际交付时间 + '\'' +
                ", 塔高='" + 塔高 + '\'' +
                ", 产品类型='" + 产品类型 + '\'' +
                ", 提供客户总功耗KW='" + 提供客户总功耗KW + '\'' +
                ", 电力引入方式='" + 电力引入方式 + '\'' +
                ", 蓄电池额外保障时长小时='" + 蓄电池额外保障时长小时 + '\'' +
                ", 是否具备油机发电条件='" + 是否具备油机发电条件 + '\'' +
                ", 是否选择发电服务='" + 是否选择发电服务 + '\'' +
                ", 系统名称='" + 系统名称 + '\'' +
                ", 天线挂高米='" + 天线挂高米 + '\'' +
                ", 天线数量个='" + 天线数量个 + '\'' +
                ", 计费系统数个='" + 计费系统数个 + '\'' +
                ", 起租时间='" + 起租时间 + '\'' +
                ", 截止时间='" + 截止时间 + '\'' +
                ", 是否需天馈及安装='" + 是否需天馈及安装 + '\'' +
                ", 供电方式='" + 供电方式 + '\'' +
                ", 备注='" + 备注 + '\'' +
                ", 费用信息_杆塔价格='" + 费用信息_杆塔价格 + '\'' +
                ", 费用信息_维护费='" + 费用信息_维护费 + '\'' +
                ", 费用信息_场地费='" + 费用信息_场地费 + '\'' +
                ", 费用信息_电力引入费='" + 费用信息_电力引入费 + '\'' +
                ", 费用信息_电源配套产品服务费='" + 费用信息_电源配套产品服务费 + '\'' +
                ", 费用信息_天馈及安装服务费='" + 费用信息_天馈及安装服务费 + '\'' +
                ", 费用信息_电力保障服务费='" + 费用信息_电力保障服务费 + '\'' +
                ", 费用信息_油机发电服务费='" + 费用信息_油机发电服务费 + '\'' +
                ", 费用信息_其他费用='" + 费用信息_其他费用 + '\'' +
                ", 费用信息_总费用='" + 费用信息_总费用 + '\'' +
                ", 其他说明='" + 其他说明 + '\'' +
                ", 铁塔管理区域='" + 铁塔管理区域 + '\'' +
                ", 项目编码='" + 项目编码 + '\'' +
                ", 终止时间='" + 终止时间 + '\'' +
                ", 经办状态='" + 经办状态 + '\'' +
                ", 点位总数='" + 点位总数 + '\'' +
                ", 点位编号='" + 点位编号 + '\'' +
                ", 铁塔类型='" + 铁塔类型 + '\'' +
                ", 铁塔细分种类='" + 铁塔细分种类 + '\'' +
                ", 经度2='" + 经度2 + '\'' +
                ", 纬度2='" + 纬度2 + '\'' +
                ", 是否社会资源='" + 是否社会资源 + '\'' +
                ", 社会资源类型='" + 社会资源类型 + '\'' +
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

    public String get需求批次() {
        return 需求批次;
    }

    public void set需求批次(String 需求批次) {
        this.需求批次 = 需求批次;
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

    public String get产权属性() {
        return 产权属性;
    }

    public void set产权属性(String 产权属性) {
        this.产权属性 = 产权属性;
    }

    public String get维护服务等级() {
        return 维护服务等级;
    }

    public void set维护服务等级(String 维护服务等级) {
        this.维护服务等级 = 维护服务等级;
    }

    public String get_0_6点是否上站() {
        return _0_6点是否上站;
    }

    public void set_0_6点是否上站(String _0_6点是否上站) {
        this._0_6点是否上站 = _0_6点是否上站;
    }

    public String get经度() {
        return 经度;
    }

    public void set经度(String 经度) {
        this.经度 = 经度;
    }

    public String get纬度() {
        return 纬度;
    }

    public void set纬度(String 纬度) {
        this.纬度 = 纬度;
    }

    public String get详细地址() {
        return 详细地址;
    }

    public void set详细地址(String 详细地址) {
        this.详细地址 = 详细地址;
    }

    public String get应交付时间() {
        return 应交付时间;
    }

    public void set应交付时间(String 应交付时间) {
        this.应交付时间 = 应交付时间;
    }

    public String get实际交付时间() {
        return 实际交付时间;
    }

    public void set实际交付时间(String 实际交付时间) {
        this.实际交付时间 = 实际交付时间;
    }

    public String get塔高() {
        return 塔高;
    }

    public void set塔高(String 塔高) {
        this.塔高 = 塔高;
    }

    public String get产品类型() {
        return 产品类型;
    }

    public void set产品类型(String 产品类型) {
        this.产品类型 = 产品类型;
    }

    public String get提供客户总功耗KW() {
        return 提供客户总功耗KW;
    }

    public void set提供客户总功耗KW(String 提供客户总功耗KW) {
        this.提供客户总功耗KW = 提供客户总功耗KW;
    }

    public String get电力引入方式() {
        return 电力引入方式;
    }

    public void set电力引入方式(String 电力引入方式) {
        this.电力引入方式 = 电力引入方式;
    }

    public String get蓄电池额外保障时长小时() {
        return 蓄电池额外保障时长小时;
    }

    public void set蓄电池额外保障时长小时(String 蓄电池额外保障时长小时) {
        this.蓄电池额外保障时长小时 = 蓄电池额外保障时长小时;
    }

    public String get是否具备油机发电条件() {
        return 是否具备油机发电条件;
    }

    public void set是否具备油机发电条件(String 是否具备油机发电条件) {
        this.是否具备油机发电条件 = 是否具备油机发电条件;
    }

    public String get是否选择发电服务() {
        return 是否选择发电服务;
    }

    public void set是否选择发电服务(String 是否选择发电服务) {
        this.是否选择发电服务 = 是否选择发电服务;
    }

    public String get系统名称() {
        return 系统名称;
    }

    public void set系统名称(String 系统名称) {
        this.系统名称 = 系统名称;
    }

    public String get天线挂高米() {
        return 天线挂高米;
    }

    public void set天线挂高米(String 天线挂高米) {
        this.天线挂高米 = 天线挂高米;
    }

    public String get天线数量个() {
        return 天线数量个;
    }

    public void set天线数量个(String 天线数量个) {
        this.天线数量个 = 天线数量个;
    }

    public String get计费系统数个() {
        return 计费系统数个;
    }

    public void set计费系统数个(String 计费系统数个) {
        this.计费系统数个 = 计费系统数个;
    }

    public String get起租时间() {
        return 起租时间;
    }

    public void set起租时间(String 起租时间) {
        this.起租时间 = 起租时间;
    }

    public String get截止时间() {
        return 截止时间;
    }

    public void set截止时间(String 截止时间) {
        this.截止时间 = 截止时间;
    }

    public String get是否需天馈及安装() {
        return 是否需天馈及安装;
    }

    public void set是否需天馈及安装(String 是否需天馈及安装) {
        this.是否需天馈及安装 = 是否需天馈及安装;
    }

    public String get供电方式() {
        return 供电方式;
    }

    public void set供电方式(String 供电方式) {
        this.供电方式 = 供电方式;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    public String get费用信息_杆塔价格() {
        return 费用信息_杆塔价格;
    }

    public void set费用信息_杆塔价格(String 费用信息_杆塔价格) {
        this.费用信息_杆塔价格 = 费用信息_杆塔价格;
    }

    public String get费用信息_维护费() {
        return 费用信息_维护费;
    }

    public void set费用信息_维护费(String 费用信息_维护费) {
        this.费用信息_维护费 = 费用信息_维护费;
    }

    public String get费用信息_场地费() {
        return 费用信息_场地费;
    }

    public void set费用信息_场地费(String 费用信息_场地费) {
        this.费用信息_场地费 = 费用信息_场地费;
    }

    public String get费用信息_电力引入费() {
        return 费用信息_电力引入费;
    }

    public void set费用信息_电力引入费(String 费用信息_电力引入费) {
        this.费用信息_电力引入费 = 费用信息_电力引入费;
    }

    public String get费用信息_电源配套产品服务费() {
        return 费用信息_电源配套产品服务费;
    }

    public void set费用信息_电源配套产品服务费(String 费用信息_电源配套产品服务费) {
        this.费用信息_电源配套产品服务费 = 费用信息_电源配套产品服务费;
    }

    public String get费用信息_天馈及安装服务费() {
        return 费用信息_天馈及安装服务费;
    }

    public void set费用信息_天馈及安装服务费(String 费用信息_天馈及安装服务费) {
        this.费用信息_天馈及安装服务费 = 费用信息_天馈及安装服务费;
    }

    public String get费用信息_电力保障服务费() {
        return 费用信息_电力保障服务费;
    }

    public void set费用信息_电力保障服务费(String 费用信息_电力保障服务费) {
        this.费用信息_电力保障服务费 = 费用信息_电力保障服务费;
    }

    public String get费用信息_油机发电服务费() {
        return 费用信息_油机发电服务费;
    }

    public void set费用信息_油机发电服务费(String 费用信息_油机发电服务费) {
        this.费用信息_油机发电服务费 = 费用信息_油机发电服务费;
    }

    public String get费用信息_其他费用() {
        return 费用信息_其他费用;
    }

    public void set费用信息_其他费用(String 费用信息_其他费用) {
        this.费用信息_其他费用 = 费用信息_其他费用;
    }

    public String get费用信息_总费用() {
        return 费用信息_总费用;
    }

    public void set费用信息_总费用(String 费用信息_总费用) {
        this.费用信息_总费用 = 费用信息_总费用;
    }

    public String get其他说明() {
        return 其他说明;
    }

    public void set其他说明(String 其他说明) {
        this.其他说明 = 其他说明;
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

    public String get终止时间() {
        return 终止时间;
    }

    public void set终止时间(String 终止时间) {
        this.终止时间 = 终止时间;
    }

    public String get经办状态() {
        return 经办状态;
    }

    public void set经办状态(String 经办状态) {
        this.经办状态 = 经办状态;
    }

    public String get点位总数() {
        return 点位总数;
    }

    public void set点位总数(String 点位总数) {
        this.点位总数 = 点位总数;
    }

    public String get点位编号() {
        return 点位编号;
    }

    public void set点位编号(String 点位编号) {
        this.点位编号 = 点位编号;
    }

    public String get铁塔类型() {
        return 铁塔类型;
    }

    public void set铁塔类型(String 铁塔类型) {
        this.铁塔类型 = 铁塔类型;
    }

    public String get铁塔细分种类() {
        return 铁塔细分种类;
    }

    public void set铁塔细分种类(String 铁塔细分种类) {
        this.铁塔细分种类 = 铁塔细分种类;
    }

    public String get经度2() {
        return 经度2;
    }

    public void set经度2(String 经度2) {
        this.经度2 = 经度2;
    }

    public String get纬度2() {
        return 纬度2;
    }

    public void set纬度2(String 纬度2) {
        this.纬度2 = 纬度2;
    }

    public String get是否社会资源() {
        return 是否社会资源;
    }

    public void set是否社会资源(String 是否社会资源) {
        this.是否社会资源 = 是否社会资源;
    }

    public String get社会资源类型() {
        return 社会资源类型;
    }

    public void set社会资源类型(String 社会资源类型) {
        this.社会资源类型 = 社会资源类型;
    }
}
