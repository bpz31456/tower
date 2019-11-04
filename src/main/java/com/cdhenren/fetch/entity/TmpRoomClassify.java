package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class TmpRoomClassify implements ResultSet {
    private String 序号;
    private String 订单状态;
    private String 订单号;
    private String 运营商;
    private String 省份;
    private String 地市;
    private String 区县;
    private String 是否属于高铁或地铁项目;
    private String 所属高铁或地铁项目名称;
    private String 站址名称;
    private String 站址编码;
    private String 合并需求单号;
    private String 项目批次;
    private String 项目建设状态;
    private String 建设方式;
    private String 产权属性;
    private String 建筑物类型;
    private String 覆盖面积平米;
    private String 隧道长度公里;
    private String 站点位置情况_经度;
    private String 站点位置情况_纬度;
    private String 站点位置情况_详细地址;
    private String 共享用户情况_是否共享已有站址;
    private String 共享用户情况_原有客户数户;
    private String 共享用户情况_原有客户明细;
    private String 共享用户情况_本次新增客户数户;
    private String 共享用户情况_新增客户明细;
    private String 交付时间要求;
    private String 实际交付时间;
    private String 交付验收结果;
    private String 提供机位数个;
    private String BBU参数_系统数个;
    private String BBU参数_BBU数个;
    private String RRU参数_RRU数个;
    private String RRU参数_信源频段;
    private String RRU参数_RRU供电方式;
    private String 产品类型;
    private String 提供客户总功耗KW;
    private String POI合路器单端口最小输入功率dBm;
    private String POI合路器类型;
    private String POI最大输入端口数个;
    private String 是否双路;
    private String 电力引入方式;
    private String 后备电源额外保障时长小时;
    private String 是否特殊调整情况;
    private String 需求收集日期;
    private String 订单签约日期;
    private String 立项时间;
    private String 完工销项时间;
    private String 起租时间;
    private String 截止时间;
    private String 协议编号;
    private String 备注;
    private String 终止时间;
    private String 费用信息单位元年_产品单元数;
    private String 费用信息单位元年_共享折扣;
    private String 费用信息单位元年_室分建造成本;
    private String 费用信息单位元年_室分成本年标准单价;
    private String 费用信息单位元年_室分建造成本原始值;
    private String 费用信息单位元年_维护费;
    private String 费用信息单位元年_维护费年标准单价;
    private String 费用信息单位元年_维护费原始值;
    private String 费用信息单位元年_基准价格;
    private String 费用信息单位元年_基准价格年标准单价;
    private String 费用信息单位元年_场地费模式;
    private String 费用信息单位元年_场地费;
    private String 费用信息单位元年_场地费年标准单价;
    private String 费用信息单位元年_场地费原始值;
    private String 费用信息单位元年_产品价格;
    private String 费用信息单位元年_用电服务费模式;
    private String 费用信息单位元年_用电服务费;
    private String 费用信息单位元年_用电服务费原始值;
    private String 费用信息单位元年_油机发电费模式;
    private String 费用信息单位元年_油机发电费;
    private String 费用信息单位元年_油机发电费原始值;
    private String 费用信息单位元年_蓄电池额外保障费;
    private String 费用信息单位元年_蓄电池额外保障费原始值;
    private String 费用信息单位元年_其他费用模式;
    private String 费用信息单位元年_其他费用;
    private String 费用信息单位元年_其他费用原始值;
    private String 费用信息单位元年_总费用;
    private String 费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步;
    private String 费用信息单位元年_财务系统选址费是否同步;
    private String 费用信息单位元年_铁塔管理区域;
    private String 费用信息单位元年_运营商项目名称;
    private String 费用信息单位元年_项目编码;
    private String 费用信息单位元年_经办状态;

    @Override
    public String toString() {
        return "TmpRoomClassify{" +
                "序号='" + 序号 + '\'' +
                ", 订单状态='" + 订单状态 + '\'' +
                ", 订单号='" + 订单号 + '\'' +
                ", 运营商='" + 运营商 + '\'' +
                ", 省份='" + 省份 + '\'' +
                ", 地市='" + 地市 + '\'' +
                ", 区县='" + 区县 + '\'' +
                ", 是否属于高铁或地铁项目='" + 是否属于高铁或地铁项目 + '\'' +
                ", 所属高铁或地铁项目名称='" + 所属高铁或地铁项目名称 + '\'' +
                ", 站址名称='" + 站址名称 + '\'' +
                ", 站址编码='" + 站址编码 + '\'' +
                ", 合并需求单号='" + 合并需求单号 + '\'' +
                ", 项目批次='" + 项目批次 + '\'' +
                ", 项目建设状态='" + 项目建设状态 + '\'' +
                ", 建设方式='" + 建设方式 + '\'' +
                ", 产权属性='" + 产权属性 + '\'' +
                ", 建筑物类型='" + 建筑物类型 + '\'' +
                ", 覆盖面积平米='" + 覆盖面积平米 + '\'' +
                ", 隧道长度公里='" + 隧道长度公里 + '\'' +
                ", 站点位置情况_经度='" + 站点位置情况_经度 + '\'' +
                ", 站点位置情况_纬度='" + 站点位置情况_纬度 + '\'' +
                ", 站点位置情况_详细地址='" + 站点位置情况_详细地址 + '\'' +
                ", 共享用户情况_是否共享已有站址='" + 共享用户情况_是否共享已有站址 + '\'' +
                ", 共享用户情况_原有客户数户='" + 共享用户情况_原有客户数户 + '\'' +
                ", 共享用户情况_原有客户明细='" + 共享用户情况_原有客户明细 + '\'' +
                ", 共享用户情况_本次新增客户数户='" + 共享用户情况_本次新增客户数户 + '\'' +
                ", 共享用户情况_新增客户明细='" + 共享用户情况_新增客户明细 + '\'' +
                ", 交付时间要求='" + 交付时间要求 + '\'' +
                ", 实际交付时间='" + 实际交付时间 + '\'' +
                ", 交付验收结果='" + 交付验收结果 + '\'' +
                ", 提供机位数个='" + 提供机位数个 + '\'' +
                ", BBU参数_系统数个='" + BBU参数_系统数个 + '\'' +
                ", BBU参数_BBU数个='" + BBU参数_BBU数个 + '\'' +
                ", RRU参数_RRU数个='" + RRU参数_RRU数个 + '\'' +
                ", RRU参数_信源频段='" + RRU参数_信源频段 + '\'' +
                ", RRU参数_RRU供电方式='" + RRU参数_RRU供电方式 + '\'' +
                ", 产品类型='" + 产品类型 + '\'' +
                ", 提供客户总功耗KW='" + 提供客户总功耗KW + '\'' +
                ", POI合路器单端口最小输入功率dBm='" + POI合路器单端口最小输入功率dBm + '\'' +
                ", POI合路器类型='" + POI合路器类型 + '\'' +
                ", POI最大输入端口数个='" + POI最大输入端口数个 + '\'' +
                ", 是否双路='" + 是否双路 + '\'' +
                ", 电力引入方式='" + 电力引入方式 + '\'' +
                ", 后备电源额外保障时长小时='" + 后备电源额外保障时长小时 + '\'' +
                ", 是否特殊调整情况='" + 是否特殊调整情况 + '\'' +
                ", 需求收集日期='" + 需求收集日期 + '\'' +
                ", 订单签约日期='" + 订单签约日期 + '\'' +
                ", 立项时间='" + 立项时间 + '\'' +
                ", 完工销项时间='" + 完工销项时间 + '\'' +
                ", 起租时间='" + 起租时间 + '\'' +
                ", 截止时间='" + 截止时间 + '\'' +
                ", 协议编号='" + 协议编号 + '\'' +
                ", 备注='" + 备注 + '\'' +
                ", 终止时间='" + 终止时间 + '\'' +
                ", 费用信息单位元年_产品单元数='" + 费用信息单位元年_产品单元数 + '\'' +
                ", 费用信息单位元年_共享折扣='" + 费用信息单位元年_共享折扣 + '\'' +
                ", 费用信息单位元年_室分建造成本='" + 费用信息单位元年_室分建造成本 + '\'' +
                ", 费用信息单位元年_室分成本年标准单价='" + 费用信息单位元年_室分成本年标准单价 + '\'' +
                ", 费用信息单位元年_室分建造成本原始值='" + 费用信息单位元年_室分建造成本原始值 + '\'' +
                ", 费用信息单位元年_维护费='" + 费用信息单位元年_维护费 + '\'' +
                ", 费用信息单位元年_维护费年标准单价='" + 费用信息单位元年_维护费年标准单价 + '\'' +
                ", 费用信息单位元年_维护费原始值='" + 费用信息单位元年_维护费原始值 + '\'' +
                ", 费用信息单位元年_基准价格='" + 费用信息单位元年_基准价格 + '\'' +
                ", 费用信息单位元年_基准价格年标准单价='" + 费用信息单位元年_基准价格年标准单价 + '\'' +
                ", 费用信息单位元年_场地费模式='" + 费用信息单位元年_场地费模式 + '\'' +
                ", 费用信息单位元年_场地费='" + 费用信息单位元年_场地费 + '\'' +
                ", 费用信息单位元年_场地费年标准单价='" + 费用信息单位元年_场地费年标准单价 + '\'' +
                ", 费用信息单位元年_场地费原始值='" + 费用信息单位元年_场地费原始值 + '\'' +
                ", 费用信息单位元年_产品价格='" + 费用信息单位元年_产品价格 + '\'' +
                ", 费用信息单位元年_用电服务费模式='" + 费用信息单位元年_用电服务费模式 + '\'' +
                ", 费用信息单位元年_用电服务费='" + 费用信息单位元年_用电服务费 + '\'' +
                ", 费用信息单位元年_用电服务费原始值='" + 费用信息单位元年_用电服务费原始值 + '\'' +
                ", 费用信息单位元年_油机发电费模式='" + 费用信息单位元年_油机发电费模式 + '\'' +
                ", 费用信息单位元年_油机发电费='" + 费用信息单位元年_油机发电费 + '\'' +
                ", 费用信息单位元年_油机发电费原始值='" + 费用信息单位元年_油机发电费原始值 + '\'' +
                ", 费用信息单位元年_蓄电池额外保障费='" + 费用信息单位元年_蓄电池额外保障费 + '\'' +
                ", 费用信息单位元年_蓄电池额外保障费原始值='" + 费用信息单位元年_蓄电池额外保障费原始值 + '\'' +
                ", 费用信息单位元年_其他费用模式='" + 费用信息单位元年_其他费用模式 + '\'' +
                ", 费用信息单位元年_其他费用='" + 费用信息单位元年_其他费用 + '\'' +
                ", 费用信息单位元年_其他费用原始值='" + 费用信息单位元年_其他费用原始值 + '\'' +
                ", 费用信息单位元年_总费用='" + 费用信息单位元年_总费用 + '\'' +
                ", 费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步='" + 费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步 + '\'' +
                ", 费用信息单位元年_财务系统选址费是否同步='" + 费用信息单位元年_财务系统选址费是否同步 + '\'' +
                ", 费用信息单位元年_铁塔管理区域='" + 费用信息单位元年_铁塔管理区域 + '\'' +
                ", 费用信息单位元年_运营商项目名称='" + 费用信息单位元年_运营商项目名称 + '\'' +
                ", 费用信息单位元年_项目编码='" + 费用信息单位元年_项目编码 + '\'' +
                ", 费用信息单位元年_经办状态='" + 费用信息单位元年_经办状态 + '\'' +
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

    public String get是否属于高铁或地铁项目() {
        return 是否属于高铁或地铁项目;
    }

    public void set是否属于高铁或地铁项目(String 是否属于高铁或地铁项目) {
        this.是否属于高铁或地铁项目 = 是否属于高铁或地铁项目;
    }

    public String get所属高铁或地铁项目名称() {
        return 所属高铁或地铁项目名称;
    }

    public void set所属高铁或地铁项目名称(String 所属高铁或地铁项目名称) {
        this.所属高铁或地铁项目名称 = 所属高铁或地铁项目名称;
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

    public String get合并需求单号() {
        return 合并需求单号;
    }

    public void set合并需求单号(String 合并需求单号) {
        this.合并需求单号 = 合并需求单号;
    }

    public String get项目批次() {
        return 项目批次;
    }

    public void set项目批次(String 项目批次) {
        this.项目批次 = 项目批次;
    }

    public String get项目建设状态() {
        return 项目建设状态;
    }

    public void set项目建设状态(String 项目建设状态) {
        this.项目建设状态 = 项目建设状态;
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

    public String get建筑物类型() {
        return 建筑物类型;
    }

    public void set建筑物类型(String 建筑物类型) {
        this.建筑物类型 = 建筑物类型;
    }

    public String get覆盖面积平米() {
        return 覆盖面积平米;
    }

    public void set覆盖面积平米(String 覆盖面积平米) {
        this.覆盖面积平米 = 覆盖面积平米;
    }

    public String get隧道长度公里() {
        return 隧道长度公里;
    }

    public void set隧道长度公里(String 隧道长度公里) {
        this.隧道长度公里 = 隧道长度公里;
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

    public String get共享用户情况_是否共享已有站址() {
        return 共享用户情况_是否共享已有站址;
    }

    public void set共享用户情况_是否共享已有站址(String 共享用户情况_是否共享已有站址) {
        this.共享用户情况_是否共享已有站址 = 共享用户情况_是否共享已有站址;
    }

    public String get共享用户情况_原有客户数户() {
        return 共享用户情况_原有客户数户;
    }

    public void set共享用户情况_原有客户数户(String 共享用户情况_原有客户数户) {
        this.共享用户情况_原有客户数户 = 共享用户情况_原有客户数户;
    }

    public String get共享用户情况_原有客户明细() {
        return 共享用户情况_原有客户明细;
    }

    public void set共享用户情况_原有客户明细(String 共享用户情况_原有客户明细) {
        this.共享用户情况_原有客户明细 = 共享用户情况_原有客户明细;
    }

    public String get共享用户情况_本次新增客户数户() {
        return 共享用户情况_本次新增客户数户;
    }

    public void set共享用户情况_本次新增客户数户(String 共享用户情况_本次新增客户数户) {
        this.共享用户情况_本次新增客户数户 = 共享用户情况_本次新增客户数户;
    }

    public String get共享用户情况_新增客户明细() {
        return 共享用户情况_新增客户明细;
    }

    public void set共享用户情况_新增客户明细(String 共享用户情况_新增客户明细) {
        this.共享用户情况_新增客户明细 = 共享用户情况_新增客户明细;
    }

    public String get交付时间要求() {
        return 交付时间要求;
    }

    public void set交付时间要求(String 交付时间要求) {
        this.交付时间要求 = 交付时间要求;
    }

    public String get实际交付时间() {
        return 实际交付时间;
    }

    public void set实际交付时间(String 实际交付时间) {
        this.实际交付时间 = 实际交付时间;
    }

    public String get交付验收结果() {
        return 交付验收结果;
    }

    public void set交付验收结果(String 交付验收结果) {
        this.交付验收结果 = 交付验收结果;
    }

    public String get提供机位数个() {
        return 提供机位数个;
    }

    public void set提供机位数个(String 提供机位数个) {
        this.提供机位数个 = 提供机位数个;
    }

    public String getBBU参数_系统数个() {
        return BBU参数_系统数个;
    }

    public void setBBU参数_系统数个(String BBU参数_系统数个) {
        this.BBU参数_系统数个 = BBU参数_系统数个;
    }

    public String getBBU参数_BBU数个() {
        return BBU参数_BBU数个;
    }

    public void setBBU参数_BBU数个(String BBU参数_BBU数个) {
        this.BBU参数_BBU数个 = BBU参数_BBU数个;
    }

    public String getRRU参数_RRU数个() {
        return RRU参数_RRU数个;
    }

    public void setRRU参数_RRU数个(String RRU参数_RRU数个) {
        this.RRU参数_RRU数个 = RRU参数_RRU数个;
    }

    public String getRRU参数_信源频段() {
        return RRU参数_信源频段;
    }

    public void setRRU参数_信源频段(String RRU参数_信源频段) {
        this.RRU参数_信源频段 = RRU参数_信源频段;
    }

    public String getRRU参数_RRU供电方式() {
        return RRU参数_RRU供电方式;
    }

    public void setRRU参数_RRU供电方式(String RRU参数_RRU供电方式) {
        this.RRU参数_RRU供电方式 = RRU参数_RRU供电方式;
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

    public String getPOI合路器单端口最小输入功率dBm() {
        return POI合路器单端口最小输入功率dBm;
    }

    public void setPOI合路器单端口最小输入功率dBm(String POI合路器单端口最小输入功率dBm) {
        this.POI合路器单端口最小输入功率dBm = POI合路器单端口最小输入功率dBm;
    }

    public String getPOI合路器类型() {
        return POI合路器类型;
    }

    public void setPOI合路器类型(String POI合路器类型) {
        this.POI合路器类型 = POI合路器类型;
    }

    public String getPOI最大输入端口数个() {
        return POI最大输入端口数个;
    }

    public void setPOI最大输入端口数个(String POI最大输入端口数个) {
        this.POI最大输入端口数个 = POI最大输入端口数个;
    }

    public String get是否双路() {
        return 是否双路;
    }

    public void set是否双路(String 是否双路) {
        this.是否双路 = 是否双路;
    }

    public String get电力引入方式() {
        return 电力引入方式;
    }

    public void set电力引入方式(String 电力引入方式) {
        this.电力引入方式 = 电力引入方式;
    }

    public String get后备电源额外保障时长小时() {
        return 后备电源额外保障时长小时;
    }

    public void set后备电源额外保障时长小时(String 后备电源额外保障时长小时) {
        this.后备电源额外保障时长小时 = 后备电源额外保障时长小时;
    }

    public String get是否特殊调整情况() {
        return 是否特殊调整情况;
    }

    public void set是否特殊调整情况(String 是否特殊调整情况) {
        this.是否特殊调整情况 = 是否特殊调整情况;
    }

    public String get需求收集日期() {
        return 需求收集日期;
    }

    public void set需求收集日期(String 需求收集日期) {
        this.需求收集日期 = 需求收集日期;
    }

    public String get订单签约日期() {
        return 订单签约日期;
    }

    public void set订单签约日期(String 订单签约日期) {
        this.订单签约日期 = 订单签约日期;
    }

    public String get立项时间() {
        return 立项时间;
    }

    public void set立项时间(String 立项时间) {
        this.立项时间 = 立项时间;
    }

    public String get完工销项时间() {
        return 完工销项时间;
    }

    public void set完工销项时间(String 完工销项时间) {
        this.完工销项时间 = 完工销项时间;
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

    public String get协议编号() {
        return 协议编号;
    }

    public void set协议编号(String 协议编号) {
        this.协议编号 = 协议编号;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    public String get终止时间() {
        return 终止时间;
    }

    public void set终止时间(String 终止时间) {
        this.终止时间 = 终止时间;
    }

    public String get费用信息单位元年_产品单元数() {
        return 费用信息单位元年_产品单元数;
    }

    public void set费用信息单位元年_产品单元数(String 费用信息单位元年_产品单元数) {
        this.费用信息单位元年_产品单元数 = 费用信息单位元年_产品单元数;
    }

    public String get费用信息单位元年_共享折扣() {
        return 费用信息单位元年_共享折扣;
    }

    public void set费用信息单位元年_共享折扣(String 费用信息单位元年_共享折扣) {
        this.费用信息单位元年_共享折扣 = 费用信息单位元年_共享折扣;
    }

    public String get费用信息单位元年_室分建造成本() {
        return 费用信息单位元年_室分建造成本;
    }

    public void set费用信息单位元年_室分建造成本(String 费用信息单位元年_室分建造成本) {
        this.费用信息单位元年_室分建造成本 = 费用信息单位元年_室分建造成本;
    }

    public String get费用信息单位元年_室分成本年标准单价() {
        return 费用信息单位元年_室分成本年标准单价;
    }

    public void set费用信息单位元年_室分成本年标准单价(String 费用信息单位元年_室分成本年标准单价) {
        this.费用信息单位元年_室分成本年标准单价 = 费用信息单位元年_室分成本年标准单价;
    }

    public String get费用信息单位元年_室分建造成本原始值() {
        return 费用信息单位元年_室分建造成本原始值;
    }

    public void set费用信息单位元年_室分建造成本原始值(String 费用信息单位元年_室分建造成本原始值) {
        this.费用信息单位元年_室分建造成本原始值 = 费用信息单位元年_室分建造成本原始值;
    }

    public String get费用信息单位元年_维护费() {
        return 费用信息单位元年_维护费;
    }

    public void set费用信息单位元年_维护费(String 费用信息单位元年_维护费) {
        this.费用信息单位元年_维护费 = 费用信息单位元年_维护费;
    }

    public String get费用信息单位元年_维护费年标准单价() {
        return 费用信息单位元年_维护费年标准单价;
    }

    public void set费用信息单位元年_维护费年标准单价(String 费用信息单位元年_维护费年标准单价) {
        this.费用信息单位元年_维护费年标准单价 = 费用信息单位元年_维护费年标准单价;
    }

    public String get费用信息单位元年_维护费原始值() {
        return 费用信息单位元年_维护费原始值;
    }

    public void set费用信息单位元年_维护费原始值(String 费用信息单位元年_维护费原始值) {
        this.费用信息单位元年_维护费原始值 = 费用信息单位元年_维护费原始值;
    }

    public String get费用信息单位元年_基准价格() {
        return 费用信息单位元年_基准价格;
    }

    public void set费用信息单位元年_基准价格(String 费用信息单位元年_基准价格) {
        this.费用信息单位元年_基准价格 = 费用信息单位元年_基准价格;
    }

    public String get费用信息单位元年_基准价格年标准单价() {
        return 费用信息单位元年_基准价格年标准单价;
    }

    public void set费用信息单位元年_基准价格年标准单价(String 费用信息单位元年_基准价格年标准单价) {
        this.费用信息单位元年_基准价格年标准单价 = 费用信息单位元年_基准价格年标准单价;
    }

    public String get费用信息单位元年_场地费模式() {
        return 费用信息单位元年_场地费模式;
    }

    public void set费用信息单位元年_场地费模式(String 费用信息单位元年_场地费模式) {
        this.费用信息单位元年_场地费模式 = 费用信息单位元年_场地费模式;
    }

    public String get费用信息单位元年_场地费() {
        return 费用信息单位元年_场地费;
    }

    public void set费用信息单位元年_场地费(String 费用信息单位元年_场地费) {
        this.费用信息单位元年_场地费 = 费用信息单位元年_场地费;
    }

    public String get费用信息单位元年_场地费年标准单价() {
        return 费用信息单位元年_场地费年标准单价;
    }

    public void set费用信息单位元年_场地费年标准单价(String 费用信息单位元年_场地费年标准单价) {
        this.费用信息单位元年_场地费年标准单价 = 费用信息单位元年_场地费年标准单价;
    }

    public String get费用信息单位元年_场地费原始值() {
        return 费用信息单位元年_场地费原始值;
    }

    public void set费用信息单位元年_场地费原始值(String 费用信息单位元年_场地费原始值) {
        this.费用信息单位元年_场地费原始值 = 费用信息单位元年_场地费原始值;
    }

    public String get费用信息单位元年_产品价格() {
        return 费用信息单位元年_产品价格;
    }

    public void set费用信息单位元年_产品价格(String 费用信息单位元年_产品价格) {
        this.费用信息单位元年_产品价格 = 费用信息单位元年_产品价格;
    }

    public String get费用信息单位元年_用电服务费模式() {
        return 费用信息单位元年_用电服务费模式;
    }

    public void set费用信息单位元年_用电服务费模式(String 费用信息单位元年_用电服务费模式) {
        this.费用信息单位元年_用电服务费模式 = 费用信息单位元年_用电服务费模式;
    }

    public String get费用信息单位元年_用电服务费() {
        return 费用信息单位元年_用电服务费;
    }

    public void set费用信息单位元年_用电服务费(String 费用信息单位元年_用电服务费) {
        this.费用信息单位元年_用电服务费 = 费用信息单位元年_用电服务费;
    }

    public String get费用信息单位元年_用电服务费原始值() {
        return 费用信息单位元年_用电服务费原始值;
    }

    public void set费用信息单位元年_用电服务费原始值(String 费用信息单位元年_用电服务费原始值) {
        this.费用信息单位元年_用电服务费原始值 = 费用信息单位元年_用电服务费原始值;
    }

    public String get费用信息单位元年_油机发电费模式() {
        return 费用信息单位元年_油机发电费模式;
    }

    public void set费用信息单位元年_油机发电费模式(String 费用信息单位元年_油机发电费模式) {
        this.费用信息单位元年_油机发电费模式 = 费用信息单位元年_油机发电费模式;
    }

    public String get费用信息单位元年_油机发电费() {
        return 费用信息单位元年_油机发电费;
    }

    public void set费用信息单位元年_油机发电费(String 费用信息单位元年_油机发电费) {
        this.费用信息单位元年_油机发电费 = 费用信息单位元年_油机发电费;
    }

    public String get费用信息单位元年_油机发电费原始值() {
        return 费用信息单位元年_油机发电费原始值;
    }

    public void set费用信息单位元年_油机发电费原始值(String 费用信息单位元年_油机发电费原始值) {
        this.费用信息单位元年_油机发电费原始值 = 费用信息单位元年_油机发电费原始值;
    }

    public String get费用信息单位元年_蓄电池额外保障费() {
        return 费用信息单位元年_蓄电池额外保障费;
    }

    public void set费用信息单位元年_蓄电池额外保障费(String 费用信息单位元年_蓄电池额外保障费) {
        this.费用信息单位元年_蓄电池额外保障费 = 费用信息单位元年_蓄电池额外保障费;
    }

    public String get费用信息单位元年_蓄电池额外保障费原始值() {
        return 费用信息单位元年_蓄电池额外保障费原始值;
    }

    public void set费用信息单位元年_蓄电池额外保障费原始值(String 费用信息单位元年_蓄电池额外保障费原始值) {
        this.费用信息单位元年_蓄电池额外保障费原始值 = 费用信息单位元年_蓄电池额外保障费原始值;
    }

    public String get费用信息单位元年_其他费用模式() {
        return 费用信息单位元年_其他费用模式;
    }

    public void set费用信息单位元年_其他费用模式(String 费用信息单位元年_其他费用模式) {
        this.费用信息单位元年_其他费用模式 = 费用信息单位元年_其他费用模式;
    }

    public String get费用信息单位元年_其他费用() {
        return 费用信息单位元年_其他费用;
    }

    public void set费用信息单位元年_其他费用(String 费用信息单位元年_其他费用) {
        this.费用信息单位元年_其他费用 = 费用信息单位元年_其他费用;
    }

    public String get费用信息单位元年_其他费用原始值() {
        return 费用信息单位元年_其他费用原始值;
    }

    public void set费用信息单位元年_其他费用原始值(String 费用信息单位元年_其他费用原始值) {
        this.费用信息单位元年_其他费用原始值 = 费用信息单位元年_其他费用原始值;
    }

    public String get费用信息单位元年_总费用() {
        return 费用信息单位元年_总费用;
    }

    public void set费用信息单位元年_总费用(String 费用信息单位元年_总费用) {
        this.费用信息单位元年_总费用 = 费用信息单位元年_总费用;
    }

    public String get费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步() {
        return 费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步;
    }

    public void set费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步(String 费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步) {
        this.费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步 = 费用信息单位元年_物业系统年场租及财务系统无形资产摊销是否同步;
    }

    public String get费用信息单位元年_财务系统选址费是否同步() {
        return 费用信息单位元年_财务系统选址费是否同步;
    }

    public void set费用信息单位元年_财务系统选址费是否同步(String 费用信息单位元年_财务系统选址费是否同步) {
        this.费用信息单位元年_财务系统选址费是否同步 = 费用信息单位元年_财务系统选址费是否同步;
    }

    public String get费用信息单位元年_铁塔管理区域() {
        return 费用信息单位元年_铁塔管理区域;
    }

    public void set费用信息单位元年_铁塔管理区域(String 费用信息单位元年_铁塔管理区域) {
        this.费用信息单位元年_铁塔管理区域 = 费用信息单位元年_铁塔管理区域;
    }

    public String get费用信息单位元年_运营商项目名称() {
        return 费用信息单位元年_运营商项目名称;
    }

    public void set费用信息单位元年_运营商项目名称(String 费用信息单位元年_运营商项目名称) {
        this.费用信息单位元年_运营商项目名称 = 费用信息单位元年_运营商项目名称;
    }

    public String get费用信息单位元年_项目编码() {
        return 费用信息单位元年_项目编码;
    }

    public void set费用信息单位元年_项目编码(String 费用信息单位元年_项目编码) {
        this.费用信息单位元年_项目编码 = 费用信息单位元年_项目编码;
    }

    public String get费用信息单位元年_经办状态() {
        return 费用信息单位元年_经办状态;
    }

    public void set费用信息单位元年_经办状态(String 费用信息单位元年_经办状态) {
        this.费用信息单位元年_经办状态 = 费用信息单位元年_经办状态;
    }
}
