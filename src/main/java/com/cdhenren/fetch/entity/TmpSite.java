package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/04/26
 * 与页面结构不一致，已经删除部分不一致字段
 */
public class TmpSite implements ResultSet {
    private String 站址名称;
    private String 站址编码;
    private String 省;
    private String 市;
    private String 所属区域;
    private String 行政区域名称;
    private String 所属组织;
    private String 站址类型;
    private String 经度;
    private String 纬度;
    private String 所在地址;
    private String 维护等级;
    private String 维护状态;
    private String 是否封锁;
    //private String 维护单位;
    private String 业务场景;
    private String 站址地形;
    private String 场景划分;
    private String 产权性质;
    private String 原产权单位;
    private String 是否共享;
    private String 使用单位;
    private String 物理站址编码;
    // private String 中文简称;
    private String 是否起租;
    private String 录入人员;
    private String 录入时间;
    private String 修改人;
    private String 修改时间;
    private String 站址接收标记;
    //  private String 管理人员上次巡查日期;
//    private String 专业人员上次巡查日期;
//    private String 历史累计巡查次数;
//    private String 代维整改结果;
    private String 备注;
    //    private String FSU状态;
//    private String FSU验收交付日期;
//    private String 站址起租时间;
//    private String 供电方式;
    private String 站址是否具备发电条件;
    //    private String 区域经理;
//    private String 区域经理联系电话;
//    private String 运营商维护服务等级;
//    private String 是否为免责站址;
//    private String 是否夜间免责站;
//    private String 运营商购买发电服务;
    private String 室分站点RRU数量;
    private String 要求夜间上站;
    private String 发电等待时长;
    private String 发电电压门限值;
    private String 基本备电约定;
    private String 固定油机配备;
    private String 蓄电池额外保障服务;
    private String 是否有动环监控;
    private String 是否公共库位;

    @Override
    public String toString() {
        return "TmpSite{" +
                "站址名称='" + 站址名称 + '\'' +
                ", 站址编码='" + 站址编码 + '\'' +
                ", 省='" + 省 + '\'' +
                ", 市='" + 市 + '\'' +
                ", 所属区域='" + 所属区域 + '\'' +
                ", 行政区域名称='" + 行政区域名称 + '\'' +
                ", 所属组织='" + 所属组织 + '\'' +
                ", 站址类型='" + 站址类型 + '\'' +
                ", 经度='" + 经度 + '\'' +
                ", 纬度='" + 纬度 + '\'' +
                ", 所在地址='" + 所在地址 + '\'' +
                ", 维护等级='" + 维护等级 + '\'' +
                ", 维护状态='" + 维护状态 + '\'' +
                ", 是否封锁='" + 是否封锁 + '\'' +
                ", 业务场景='" + 业务场景 + '\'' +
                ", 站址地形='" + 站址地形 + '\'' +
                ", 场景划分='" + 场景划分 + '\'' +
                ", 产权性质='" + 产权性质 + '\'' +
                ", 原产权单位='" + 原产权单位 + '\'' +
                ", 是否共享='" + 是否共享 + '\'' +
                ", 使用单位='" + 使用单位 + '\'' +
                ", 物理站址编码='" + 物理站址编码 + '\'' +
                ", 是否起租='" + 是否起租 + '\'' +
                ", 录入人员='" + 录入人员 + '\'' +
                ", 录入时间='" + 录入时间 + '\'' +
                ", 修改人='" + 修改人 + '\'' +
                ", 修改时间='" + 修改时间 + '\'' +
                ", 站址接收标记='" + 站址接收标记 + '\'' +
                ", 备注='" + 备注 + '\'' +
                ", 站址是否具备发电条件='" + 站址是否具备发电条件 + '\'' +
                ", 室分站点RRU数量='" + 室分站点RRU数量 + '\'' +
                ", 要求夜间上站='" + 要求夜间上站 + '\'' +
                ", 发电等待时长='" + 发电等待时长 + '\'' +
                ", 发电电压门限值='" + 发电电压门限值 + '\'' +
                ", 基本备电约定='" + 基本备电约定 + '\'' +
                ", 固定油机配备='" + 固定油机配备 + '\'' +
                ", 蓄电池额外保障服务='" + 蓄电池额外保障服务 + '\'' +
                ", 是否有动环监控='" + 是否有动环监控 + '\'' +
                ", 是否公共库位='" + 是否公共库位 + '\'' +
                '}';
    }

    public String get站址名称() {
        return 站址名称;
    }

    public void set站址名称(String 站址名称) {
        this.站址名称 = 站址名称;
    }

    public String get站址编码() {
        return 站址编码;
    }

    public void set站址编码(String 站址编码) {
        this.站址编码 = 站址编码;
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

    public String get行政区域名称() {
        return 行政区域名称;
    }

    public void set行政区域名称(String 行政区域名称) {
        this.行政区域名称 = 行政区域名称;
    }

    public String get所属组织() {
        return 所属组织;
    }

    public void set所属组织(String 所属组织) {
        this.所属组织 = 所属组织;
    }

    public String get站址类型() {
        return 站址类型;
    }

    public void set站址类型(String 站址类型) {
        this.站址类型 = 站址类型;
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

    public String get所在地址() {
        return 所在地址;
    }

    public void set所在地址(String 所在地址) {
        this.所在地址 = 所在地址;
    }

    public String get维护等级() {
        return 维护等级;
    }

    public void set维护等级(String 维护等级) {
        this.维护等级 = 维护等级;
    }

    public String get维护状态() {
        return 维护状态;
    }

    public void set维护状态(String 维护状态) {
        this.维护状态 = 维护状态;
    }

    public String get是否封锁() {
        return 是否封锁;
    }

    public void set是否封锁(String 是否封锁) {
        this.是否封锁 = 是否封锁;
    }


    public String get业务场景() {
        return 业务场景;
    }

    public void set业务场景(String 业务场景) {
        this.业务场景 = 业务场景;
    }

    public String get站址地形() {
        return 站址地形;
    }

    public void set站址地形(String 站址地形) {
        this.站址地形 = 站址地形;
    }

    public String get场景划分() {
        return 场景划分;
    }

    public void set场景划分(String 场景划分) {
        this.场景划分 = 场景划分;
    }

    public String get产权性质() {
        return 产权性质;
    }

    public void set产权性质(String 产权性质) {
        this.产权性质 = 产权性质;
    }

    public String get原产权单位() {
        return 原产权单位;
    }

    public void set原产权单位(String 原产权单位) {
        this.原产权单位 = 原产权单位;
    }

    public String get是否共享() {
        return 是否共享;
    }

    public void set是否共享(String 是否共享) {
        this.是否共享 = 是否共享;
    }

    public String get使用单位() {
        return 使用单位;
    }

    public void set使用单位(String 使用单位) {
        this.使用单位 = 使用单位;
    }

    public String get物理站址编码() {
        return 物理站址编码;
    }

    public void set物理站址编码(String 物理站址编码) {
        this.物理站址编码 = 物理站址编码;
    }


    public String get是否起租() {
        return 是否起租;
    }

    public void set是否起租(String 是否起租) {
        this.是否起租 = 是否起租;
    }

    public String get录入人员() {
        return 录入人员;
    }

    public void set录入人员(String 录入人员) {
        this.录入人员 = 录入人员;
    }

    public String get录入时间() {
        return 录入时间;
    }

    public void set录入时间(String 录入时间) {
        this.录入时间 = 录入时间;
    }

    public String get修改人() {
        return 修改人;
    }

    public void set修改人(String 修改人) {
        this.修改人 = 修改人;
    }

    public String get修改时间() {
        return 修改时间;
    }

    public void set修改时间(String 修改时间) {
        this.修改时间 = 修改时间;
    }

    public String get站址接收标记() {
        return 站址接收标记;
    }

    public void set站址接收标记(String 站址接收标记) {
        this.站址接收标记 = 站址接收标记;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    public String get站址是否具备发电条件() {
        return 站址是否具备发电条件;
    }

    public void set站址是否具备发电条件(String 站址是否具备发电条件) {
        this.站址是否具备发电条件 = 站址是否具备发电条件;
    }

    public String get室分站点RRU数量() {
        return 室分站点RRU数量;
    }

    public void set室分站点RRU数量(String 室分站点RRU数量) {
        this.室分站点RRU数量 = 室分站点RRU数量;
    }

    public String get要求夜间上站() {
        return 要求夜间上站;
    }

    public void set要求夜间上站(String 要求夜间上站) {
        this.要求夜间上站 = 要求夜间上站;
    }

    public String get发电等待时长() {
        return 发电等待时长;
    }

    public void set发电等待时长(String 发电等待时长) {
        this.发电等待时长 = 发电等待时长;
    }

    public String get发电电压门限值() {
        return 发电电压门限值;
    }

    public void set发电电压门限值(String 发电电压门限值) {
        this.发电电压门限值 = 发电电压门限值;
    }

    public String get基本备电约定() {
        return 基本备电约定;
    }

    public void set基本备电约定(String 基本备电约定) {
        this.基本备电约定 = 基本备电约定;
    }

    public String get固定油机配备() {
        return 固定油机配备;
    }

    public void set固定油机配备(String 固定油机配备) {
        this.固定油机配备 = 固定油机配备;
    }

    public String get蓄电池额外保障服务() {
        return 蓄电池额外保障服务;
    }

    public void set蓄电池额外保障服务(String 蓄电池额外保障服务) {
        this.蓄电池额外保障服务 = 蓄电池额外保障服务;
    }

    public String get是否有动环监控() {
        return 是否有动环监控;
    }

    public void set是否有动环监控(String 是否有动环监控) {
        this.是否有动环监控 = 是否有动环监控;
    }

    public String get是否公共库位() {
        return 是否公共库位;
    }

    public void set是否公共库位(String 是否公共库位) {
        this.是否公共库位 = 是否公共库位;
    }
}
