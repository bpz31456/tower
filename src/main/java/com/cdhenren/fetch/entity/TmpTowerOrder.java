package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class TmpTowerOrder implements ResultSet {
    private String 序号;
    private String 订单状态;
    private String 订单号;
    private String 运营商;
    private String 省份;
    private String 地市;
    private String 区县;
    private String 是否属于高铁或地铁项目;
    private String 所属高铁或地铁项目名称;
    private String 需求方站点名称;
    private String 铁塔站址名称;
    private String 站址编码;
    private String 运营商自有物理站址编码;
    private String 合并需求单号;
    private String 订单属性;
    private String 需求批次;
    private String 项目建设状态;
    private String 场景划分;
    private String 建设方式;
    private String 产权属性;
    private String 原产权单位;
    private String 维护服务等级;
    private String _0_6点是否上站;
    private String 站点位置情况_经度;
    private String 站点位置情况_纬度;
    private String 站点位置情况_详细地址;
    private String 共享用户情况_是否共享已有站址;
    private String 共享用户情况_原有运营商数户;
    private String 共享用户情况_原有具体运营商;
    private String 共享用户情况_本次新增运营商数户;
    private String 共享用户情况_新增具体运营商;
    private String 交付时间要求;
    private String 实际交付时间;
    private String 交付验收结果;
    private String 铁塔参数_铁塔编码;
    private String 铁塔参数_铁塔种类;
    private String 铁塔参数_铁塔名称;
    private String 铁塔参数_塔是否首家;
    private String 铁塔参数_铁塔高度米;
    private String 铁塔参数_平台或平层数量个;
    private String 机房参数_机房编码;
    private String 机房参数_机房类型;
    private String 机房参数_机房名称;
    private String 机房参数_机房是否首家;
    private String 机房参数_提供机位数个;
    private String BBU参数_系统数个;
    private String BBU参数_BBU数个;
    private String RRU参数_RRU数个;
    private String RRU参数_RRU供电方式;
    private String 产品配置;
    private String 提供客户总功耗KW;
    private String 电力引入方式;
    private String 蓄电池额外保障时长小时;
    private String 实际风压系数;
    private String 算费风压系数;
    private String 是否具备油机发电条件;
    private String 是否选择发电服务;
    private String 铁塔产品单元1_系统名称;
    private String 天铁塔产品单元1_线挂高米;
    private String 铁塔产品单元1_天线数量个;
    private String 铁塔产品单元1_计费系统数个;
    private String 铁塔产品单元1_BBU是否放在铁塔公司机房;
    private String 铁塔产品单元1_RRU是否上塔;
    private String 铁塔产品单元2_系统名称;
    private String 铁塔产品单元2_天线挂高米;
    private String 铁塔产品单元2_天线数量个;
    private String 铁塔产品单元2_计费系统数个;
    private String 铁塔产品单元2_BBU是否放在铁塔公司机房;
    private String 铁塔产品单元2_RRU是否上塔;
    private String 铁塔产品单元3_系统名称;
    private String 铁塔产品单元3_天线挂高米;
    private String 铁塔产品单元3_天线数量个;
    private String 铁塔产品单元3_计费系统数个;
    private String 铁塔产品单元3_BBU是否放在铁塔公司机房;
    private String 铁塔产品单元3_RRU是否上塔;
    private String WLAN天线_天线挂高米;
    private String 微波天线_天线挂高米;
    private String 需求收集日期;
    private String 订单签约日期;
    private String 立项时间;
    private String 完工销项时间;
    private String 起租时间;
    private String 截止时间;
    private String 协议编号;
    private String 备注;
    private String 是否首家;
    private String 备注新;
    private String 终止时间;
    private String 费用信息单位元年_产品单元数;
    private String 费用信息单位元年_铁塔共享折扣;
    private String 费用信息单位元年_铁塔建造成本;
    private String 费用信息单位元年_铁塔成本年标准单价;
    private String 费用信息单位元年_铁塔建造成本原始值;
    private String 费用信息单位元年_机房共享折扣;
    private String 费用信息单位元年_机房建造成本;
    private String 费用信息单位元年_机房成本年标准单价;
    private String 费用信息单位元年_机房建造成本原始值;
    private String 费用信息单位元年_配套共享折扣;
    private String 费用信息单位元年_配套成本;
    private String 费用信息单位元年_配套年标准单价;
    private String 费用信息单位元年_配套建造成本原始值;
    private String 费用信息单位元年_维护费共享折扣;
    private String 费用信息单位元年_维护费;
    private String 费用信息单位元年_维护费年标准单价;
    private String 费用信息单位元年_维护费原始值;
    private String 费用信息单位元年_BBU安装在铁塔机房费用;
    private String 费用信息单位元年_基准价格;
    private String 费用信息单位元年_基准价格年标准单价;
    private String 费用信息单位元年_场地费模式;
    private String 费用信息单位元年_场地费共享折扣;
    private String 费用信息单位元年_场地费是否参与共享;
    private String 费用信息单位元年_场地费;
    private String 费用信息单位元年_场地费年标准单价;
    private String 费用信息单位元年_场地费原始值;
    private String 费用信息单位元年_电力引入费模式;
    private String 费用信息单位元年_电力引入费共享折扣;
    private String 费用信息单位元年_电力引入费是否参与共享;
    private String 费用信息单位元年_电力引入费;
    private String 费用信息单位元年_电力引入费年标准单价;
    private String 费用信息单位元年_电力引入费原始值;
    private String 费用信息单位元年_产品价格;
    private String 费用信息单位元年_用电服务费模式;
    private String 费用信息单位元年_用电服务费;
    private String 费用信息单位元年_用电服务费原始值;
    private String 费用信息单位元年_油机发电费模式;
    private String 费用信息单位元年_油机发电费;
    private String 费用信息单位元年_油机发电费原始值;
    private String 费用信息单位元年_蓄电池额外保障费;
    private String 费用信息单位元年_蓄电池额外保障费原始值;
    private String 费用信息单位元年_高等级额外服务费;
    private String 费用信息单位元年_高等级额外服务费原始值;
    private String 费用信息单位元年_其他折扣RRU优惠;
    private String 费用信息单位元年_其他费用模式;
    private String 费用信息单位元年_其他费用;
    private String 费用信息单位元年_其他费用原始值;
    private String 费用信息单位元年_微波;
    private String 费用信息单位元年_微波原始值;
    private String 费用信息单位元年_WLAN;
    private String 费用信息单位元年_WLAN原始值;
    private String 费用信息单位元年_其他费用_场地费;
    private String 费用信息单位元年_其他费用_场地费原始值;
    private String 费用信息单位元年_其他费用_电力引入费;
    private String 费用信息单位元年_其他费用_电力引入费原始值;
    private String 费用信息单位元年_其他费用_油机发电费;
    private String 费用信息单位元年_其他费用_油机发电费原始值;
    private String 费用信息单位元年_其他费用_用电服务费;
    private String 其他费用_用电服务费原始值;
    private String 费用信息单位元年_其他费用_维护费;
    private String 费用信息单位元年_其他费用_维护费原始值;
    private String 费用信息单位元年_总费用;
    private String 同步信息_物业系统年场租及财务系统无形资产摊销是否同步;
    private String 同步信息_财务系统选址费是否同步;
    private String 建造成本模式;
    private String 铁塔管理区域;
    private String 运营商项目名称;
    private String 项目编码;
    private String 经办状态;

    @Override
    public String toString() {
        return "TmpTowerOrder{" +
                "序号='" + 序号 + '\'' +
                ", 订单状态='" + 订单状态 + '\'' +
                ", 订单号='" + 订单号 + '\'' +
                ", 运营商='" + 运营商 + '\'' +
                ", 省份='" + 省份 + '\'' +
                ", 地市='" + 地市 + '\'' +
                ", 区县='" + 区县 + '\'' +
                ", 是否属于高铁或地铁项目='" + 是否属于高铁或地铁项目 + '\'' +
                ", 所属高铁或地铁项目名称='" + 所属高铁或地铁项目名称 + '\'' +
                ", 需求方站点名称='" + 需求方站点名称 + '\'' +
                ", 铁塔站址名称='" + 铁塔站址名称 + '\'' +
                ", 站址编码='" + 站址编码 + '\'' +
                ", 运营商自有物理站址编码='" + 运营商自有物理站址编码 + '\'' +
                ", 合并需求单号='" + 合并需求单号 + '\'' +
                ", 订单属性='" + 订单属性 + '\'' +
                ", 需求批次='" + 需求批次 + '\'' +
                ", 项目建设状态='" + 项目建设状态 + '\'' +
                ", 场景划分='" + 场景划分 + '\'' +
                ", 建设方式='" + 建设方式 + '\'' +
                ", 产权属性='" + 产权属性 + '\'' +
                ", 原产权单位='" + 原产权单位 + '\'' +
                ", 维护服务等级='" + 维护服务等级 + '\'' +
                ", _0_6点是否上站='" + _0_6点是否上站 + '\'' +
                ", 站点位置情况_经度='" + 站点位置情况_经度 + '\'' +
                ", 站点位置情况_纬度='" + 站点位置情况_纬度 + '\'' +
                ", 站点位置情况_详细地址='" + 站点位置情况_详细地址 + '\'' +
                ", 共享用户情况_是否共享已有站址='" + 共享用户情况_是否共享已有站址 + '\'' +
                ", 共享用户情况_原有运营商数户='" + 共享用户情况_原有运营商数户 + '\'' +
                ", 共享用户情况_原有具体运营商='" + 共享用户情况_原有具体运营商 + '\'' +
                ", 共享用户情况_本次新增运营商数户='" + 共享用户情况_本次新增运营商数户 + '\'' +
                ", 共享用户情况_新增具体运营商='" + 共享用户情况_新增具体运营商 + '\'' +
                ", 交付时间要求='" + 交付时间要求 + '\'' +
                ", 实际交付时间='" + 实际交付时间 + '\'' +
                ", 交付验收结果='" + 交付验收结果 + '\'' +
                ", 铁塔参数_铁塔编码='" + 铁塔参数_铁塔编码 + '\'' +
                ", 铁塔参数_铁塔种类='" + 铁塔参数_铁塔种类 + '\'' +
                ", 铁塔参数_铁塔名称='" + 铁塔参数_铁塔名称 + '\'' +
                ", 铁塔参数_塔是否首家='" + 铁塔参数_塔是否首家 + '\'' +
                ", 铁塔参数_铁塔高度米='" + 铁塔参数_铁塔高度米 + '\'' +
                ", 铁塔参数_平台或平层数量个='" + 铁塔参数_平台或平层数量个 + '\'' +
                ", 机房参数_机房编码='" + 机房参数_机房编码 + '\'' +
                ", 机房参数_机房类型='" + 机房参数_机房类型 + '\'' +
                ", 机房参数_机房名称='" + 机房参数_机房名称 + '\'' +
                ", 机房参数_机房是否首家='" + 机房参数_机房是否首家 + '\'' +
                ", 机房参数_提供机位数个='" + 机房参数_提供机位数个 + '\'' +
                ", BBU参数_系统数个='" + BBU参数_系统数个 + '\'' +
                ", BBU参数_BBU数个='" + BBU参数_BBU数个 + '\'' +
                ", RRU参数_RRU数个='" + RRU参数_RRU数个 + '\'' +
                ", RRU参数_RRU供电方式='" + RRU参数_RRU供电方式 + '\'' +
                ", 产品配置='" + 产品配置 + '\'' +
                ", 提供客户总功耗KW='" + 提供客户总功耗KW + '\'' +
                ", 电力引入方式='" + 电力引入方式 + '\'' +
                ", 蓄电池额外保障时长小时='" + 蓄电池额外保障时长小时 + '\'' +
                ", 实际风压系数='" + 实际风压系数 + '\'' +
                ", 算费风压系数='" + 算费风压系数 + '\'' +
                ", 是否具备油机发电条件='" + 是否具备油机发电条件 + '\'' +
                ", 是否选择发电服务='" + 是否选择发电服务 + '\'' +
                ", 铁塔产品单元1_系统名称='" + 铁塔产品单元1_系统名称 + '\'' +
                ", 天铁塔产品单元1_线挂高米='" + 天铁塔产品单元1_线挂高米 + '\'' +
                ", 铁塔产品单元1_天线数量个='" + 铁塔产品单元1_天线数量个 + '\'' +
                ", 铁塔产品单元1_计费系统数个='" + 铁塔产品单元1_计费系统数个 + '\'' +
                ", 铁塔产品单元1_BBU是否放在铁塔公司机房='" + 铁塔产品单元1_BBU是否放在铁塔公司机房 + '\'' +
                ", 铁塔产品单元1_RRU是否上塔='" + 铁塔产品单元1_RRU是否上塔 + '\'' +
                ", 铁塔产品单元2_系统名称='" + 铁塔产品单元2_系统名称 + '\'' +
                ", 铁塔产品单元2_天线挂高米='" + 铁塔产品单元2_天线挂高米 + '\'' +
                ", 铁塔产品单元2_天线数量个='" + 铁塔产品单元2_天线数量个 + '\'' +
                ", 铁塔产品单元2_计费系统数个='" + 铁塔产品单元2_计费系统数个 + '\'' +
                ", 铁塔产品单元2_BBU是否放在铁塔公司机房='" + 铁塔产品单元2_BBU是否放在铁塔公司机房 + '\'' +
                ", 铁塔产品单元2_RRU是否上塔='" + 铁塔产品单元2_RRU是否上塔 + '\'' +
                ", 铁塔产品单元3_系统名称='" + 铁塔产品单元3_系统名称 + '\'' +
                ", 铁塔产品单元3_天线挂高米='" + 铁塔产品单元3_天线挂高米 + '\'' +
                ", 铁塔产品单元3_天线数量个='" + 铁塔产品单元3_天线数量个 + '\'' +
                ", 铁塔产品单元3_计费系统数个='" + 铁塔产品单元3_计费系统数个 + '\'' +
                ", 铁塔产品单元3_BBU是否放在铁塔公司机房='" + 铁塔产品单元3_BBU是否放在铁塔公司机房 + '\'' +
                ", 铁塔产品单元3_RRU是否上塔='" + 铁塔产品单元3_RRU是否上塔 + '\'' +
                ", WLAN天线_天线挂高米='" + WLAN天线_天线挂高米 + '\'' +
                ", 微波天线_天线挂高米='" + 微波天线_天线挂高米 + '\'' +
                ", 需求收集日期='" + 需求收集日期 + '\'' +
                ", 订单签约日期='" + 订单签约日期 + '\'' +
                ", 立项时间='" + 立项时间 + '\'' +
                ", 完工销项时间='" + 完工销项时间 + '\'' +
                ", 起租时间='" + 起租时间 + '\'' +
                ", 截止时间='" + 截止时间 + '\'' +
                ", 协议编号='" + 协议编号 + '\'' +
                ", 备注='" + 备注 + '\'' +
                ", 是否首家='" + 是否首家 + '\'' +
                ", 备注新='" + 备注新 + '\'' +
                ", 终止时间='" + 终止时间 + '\'' +
                ", 费用信息单位元年_产品单元数='" + 费用信息单位元年_产品单元数 + '\'' +
                ", 费用信息单位元年_铁塔共享折扣='" + 费用信息单位元年_铁塔共享折扣 + '\'' +
                ", 费用信息单位元年_铁塔建造成本='" + 费用信息单位元年_铁塔建造成本 + '\'' +
                ", 费用信息单位元年_铁塔成本年标准单价='" + 费用信息单位元年_铁塔成本年标准单价 + '\'' +
                ", 费用信息单位元年_铁塔建造成本原始值='" + 费用信息单位元年_铁塔建造成本原始值 + '\'' +
                ", 费用信息单位元年_机房共享折扣='" + 费用信息单位元年_机房共享折扣 + '\'' +
                ", 费用信息单位元年_机房建造成本='" + 费用信息单位元年_机房建造成本 + '\'' +
                ", 费用信息单位元年_机房成本年标准单价='" + 费用信息单位元年_机房成本年标准单价 + '\'' +
                ", 费用信息单位元年_机房建造成本原始值='" + 费用信息单位元年_机房建造成本原始值 + '\'' +
                ", 费用信息单位元年_配套共享折扣='" + 费用信息单位元年_配套共享折扣 + '\'' +
                ", 费用信息单位元年_配套成本='" + 费用信息单位元年_配套成本 + '\'' +
                ", 费用信息单位元年_配套年标准单价='" + 费用信息单位元年_配套年标准单价 + '\'' +
                ", 费用信息单位元年_配套建造成本原始值='" + 费用信息单位元年_配套建造成本原始值 + '\'' +
                ", 费用信息单位元年_维护费共享折扣='" + 费用信息单位元年_维护费共享折扣 + '\'' +
                ", 费用信息单位元年_维护费='" + 费用信息单位元年_维护费 + '\'' +
                ", 费用信息单位元年_维护费年标准单价='" + 费用信息单位元年_维护费年标准单价 + '\'' +
                ", 费用信息单位元年_维护费原始值='" + 费用信息单位元年_维护费原始值 + '\'' +
                ", 费用信息单位元年_BBU安装在铁塔机房费用='" + 费用信息单位元年_BBU安装在铁塔机房费用 + '\'' +
                ", 费用信息单位元年_基准价格='" + 费用信息单位元年_基准价格 + '\'' +
                ", 费用信息单位元年_基准价格年标准单价='" + 费用信息单位元年_基准价格年标准单价 + '\'' +
                ", 费用信息单位元年_场地费模式='" + 费用信息单位元年_场地费模式 + '\'' +
                ", 费用信息单位元年_场地费共享折扣='" + 费用信息单位元年_场地费共享折扣 + '\'' +
                ", 费用信息单位元年_场地费是否参与共享='" + 费用信息单位元年_场地费是否参与共享 + '\'' +
                ", 费用信息单位元年_场地费='" + 费用信息单位元年_场地费 + '\'' +
                ", 费用信息单位元年_场地费年标准单价='" + 费用信息单位元年_场地费年标准单价 + '\'' +
                ", 费用信息单位元年_场地费原始值='" + 费用信息单位元年_场地费原始值 + '\'' +
                ", 费用信息单位元年_电力引入费模式='" + 费用信息单位元年_电力引入费模式 + '\'' +
                ", 费用信息单位元年_电力引入费共享折扣='" + 费用信息单位元年_电力引入费共享折扣 + '\'' +
                ", 费用信息单位元年_电力引入费是否参与共享='" + 费用信息单位元年_电力引入费是否参与共享 + '\'' +
                ", 费用信息单位元年_电力引入费='" + 费用信息单位元年_电力引入费 + '\'' +
                ", 费用信息单位元年_电力引入费年标准单价='" + 费用信息单位元年_电力引入费年标准单价 + '\'' +
                ", 费用信息单位元年_电力引入费原始值='" + 费用信息单位元年_电力引入费原始值 + '\'' +
                ", 费用信息单位元年_产品价格='" + 费用信息单位元年_产品价格 + '\'' +
                ", 费用信息单位元年_用电服务费模式='" + 费用信息单位元年_用电服务费模式 + '\'' +
                ", 费用信息单位元年_用电服务费='" + 费用信息单位元年_用电服务费 + '\'' +
                ", 费用信息单位元年_用电服务费原始值='" + 费用信息单位元年_用电服务费原始值 + '\'' +
                ", 费用信息单位元年_油机发电费模式='" + 费用信息单位元年_油机发电费模式 + '\'' +
                ", 费用信息单位元年_油机发电费='" + 费用信息单位元年_油机发电费 + '\'' +
                ", 费用信息单位元年_油机发电费原始值='" + 费用信息单位元年_油机发电费原始值 + '\'' +
                ", 费用信息单位元年_蓄电池额外保障费='" + 费用信息单位元年_蓄电池额外保障费 + '\'' +
                ", 费用信息单位元年_蓄电池额外保障费原始值='" + 费用信息单位元年_蓄电池额外保障费原始值 + '\'' +
                ", 费用信息单位元年_高等级额外服务费='" + 费用信息单位元年_高等级额外服务费 + '\'' +
                ", 费用信息单位元年_高等级额外服务费原始值='" + 费用信息单位元年_高等级额外服务费原始值 + '\'' +
                ", 费用信息单位元年_其他折扣RRU优惠='" + 费用信息单位元年_其他折扣RRU优惠 + '\'' +
                ", 费用信息单位元年_其他费用模式='" + 费用信息单位元年_其他费用模式 + '\'' +
                ", 费用信息单位元年_其他费用='" + 费用信息单位元年_其他费用 + '\'' +
                ", 费用信息单位元年_其他费用原始值='" + 费用信息单位元年_其他费用原始值 + '\'' +
                ", 费用信息单位元年_微波='" + 费用信息单位元年_微波 + '\'' +
                ", 费用信息单位元年_微波原始值='" + 费用信息单位元年_微波原始值 + '\'' +
                ", 费用信息单位元年_WLAN='" + 费用信息单位元年_WLAN + '\'' +
                ", 费用信息单位元年_WLAN原始值='" + 费用信息单位元年_WLAN原始值 + '\'' +
                ", 费用信息单位元年_其他费用_场地费='" + 费用信息单位元年_其他费用_场地费 + '\'' +
                ", 费用信息单位元年_其他费用_场地费原始值='" + 费用信息单位元年_其他费用_场地费原始值 + '\'' +
                ", 费用信息单位元年_其他费用_电力引入费='" + 费用信息单位元年_其他费用_电力引入费 + '\'' +
                ", 费用信息单位元年_其他费用_电力引入费原始值='" + 费用信息单位元年_其他费用_电力引入费原始值 + '\'' +
                ", 费用信息单位元年_其他费用_油机发电费='" + 费用信息单位元年_其他费用_油机发电费 + '\'' +
                ", 费用信息单位元年_其他费用_油机发电费原始值='" + 费用信息单位元年_其他费用_油机发电费原始值 + '\'' +
                ", 费用信息单位元年_其他费用_用电服务费='" + 费用信息单位元年_其他费用_用电服务费 + '\'' +
                ", 其他费用_用电服务费原始值='" + 其他费用_用电服务费原始值 + '\'' +
                ", 费用信息单位元年_其他费用_维护费='" + 费用信息单位元年_其他费用_维护费 + '\'' +
                ", 费用信息单位元年_其他费用_维护费原始值='" + 费用信息单位元年_其他费用_维护费原始值 + '\'' +
                ", 费用信息单位元年_总费用='" + 费用信息单位元年_总费用 + '\'' +
                ", 同步信息_物业系统年场租及财务系统无形资产摊销是否同步='" + 同步信息_物业系统年场租及财务系统无形资产摊销是否同步 + '\'' +
                ", 同步信息_财务系统选址费是否同步='" + 同步信息_财务系统选址费是否同步 + '\'' +
                ", 建造成本模式='" + 建造成本模式 + '\'' +
                ", 铁塔管理区域='" + 铁塔管理区域 + '\'' +
                ", 运营商项目名称='" + 运营商项目名称 + '\'' +
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

    public String get运营商自有物理站址编码() {
        return 运营商自有物理站址编码;
    }

    public void set运营商自有物理站址编码(String 运营商自有物理站址编码) {
        this.运营商自有物理站址编码 = 运营商自有物理站址编码;
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

    public String get共享用户情况_原有运营商数户() {
        return 共享用户情况_原有运营商数户;
    }

    public void set共享用户情况_原有运营商数户(String 共享用户情况_原有运营商数户) {
        this.共享用户情况_原有运营商数户 = 共享用户情况_原有运营商数户;
    }

    public String get共享用户情况_原有具体运营商() {
        return 共享用户情况_原有具体运营商;
    }

    public void set共享用户情况_原有具体运营商(String 共享用户情况_原有具体运营商) {
        this.共享用户情况_原有具体运营商 = 共享用户情况_原有具体运营商;
    }

    public String get共享用户情况_本次新增运营商数户() {
        return 共享用户情况_本次新增运营商数户;
    }

    public void set共享用户情况_本次新增运营商数户(String 共享用户情况_本次新增运营商数户) {
        this.共享用户情况_本次新增运营商数户 = 共享用户情况_本次新增运营商数户;
    }

    public String get共享用户情况_新增具体运营商() {
        return 共享用户情况_新增具体运营商;
    }

    public void set共享用户情况_新增具体运营商(String 共享用户情况_新增具体运营商) {
        this.共享用户情况_新增具体运营商 = 共享用户情况_新增具体运营商;
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

    public String get铁塔参数_铁塔名称() {
        return 铁塔参数_铁塔名称;
    }

    public void set铁塔参数_铁塔名称(String 铁塔参数_铁塔名称) {
        this.铁塔参数_铁塔名称 = 铁塔参数_铁塔名称;
    }

    public String get铁塔参数_塔是否首家() {
        return 铁塔参数_塔是否首家;
    }

    public void set铁塔参数_塔是否首家(String 铁塔参数_塔是否首家) {
        this.铁塔参数_塔是否首家 = 铁塔参数_塔是否首家;
    }

    public String get铁塔参数_铁塔高度米() {
        return 铁塔参数_铁塔高度米;
    }

    public void set铁塔参数_铁塔高度米(String 铁塔参数_铁塔高度米) {
        this.铁塔参数_铁塔高度米 = 铁塔参数_铁塔高度米;
    }

    public String get铁塔参数_平台或平层数量个() {
        return 铁塔参数_平台或平层数量个;
    }

    public void set铁塔参数_平台或平层数量个(String 铁塔参数_平台或平层数量个) {
        this.铁塔参数_平台或平层数量个 = 铁塔参数_平台或平层数量个;
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

    public String get机房参数_机房是否首家() {
        return 机房参数_机房是否首家;
    }

    public void set机房参数_机房是否首家(String 机房参数_机房是否首家) {
        this.机房参数_机房是否首家 = 机房参数_机房是否首家;
    }

    public String get机房参数_提供机位数个() {
        return 机房参数_提供机位数个;
    }

    public void set机房参数_提供机位数个(String 机房参数_提供机位数个) {
        this.机房参数_提供机位数个 = 机房参数_提供机位数个;
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

    public String getRRU参数_RRU供电方式() {
        return RRU参数_RRU供电方式;
    }

    public void setRRU参数_RRU供电方式(String RRU参数_RRU供电方式) {
        this.RRU参数_RRU供电方式 = RRU参数_RRU供电方式;
    }

    public String get产品配置() {
        return 产品配置;
    }

    public void set产品配置(String 产品配置) {
        this.产品配置 = 产品配置;
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

    public String get实际风压系数() {
        return 实际风压系数;
    }

    public void set实际风压系数(String 实际风压系数) {
        this.实际风压系数 = 实际风压系数;
    }

    public String get算费风压系数() {
        return 算费风压系数;
    }

    public void set算费风压系数(String 算费风压系数) {
        this.算费风压系数 = 算费风压系数;
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

    public String get铁塔产品单元1_系统名称() {
        return 铁塔产品单元1_系统名称;
    }

    public void set铁塔产品单元1_系统名称(String 铁塔产品单元1_系统名称) {
        this.铁塔产品单元1_系统名称 = 铁塔产品单元1_系统名称;
    }

    public String get天铁塔产品单元1_线挂高米() {
        return 天铁塔产品单元1_线挂高米;
    }

    public void set天铁塔产品单元1_线挂高米(String 天铁塔产品单元1_线挂高米) {
        this.天铁塔产品单元1_线挂高米 = 天铁塔产品单元1_线挂高米;
    }

    public String get铁塔产品单元1_天线数量个() {
        return 铁塔产品单元1_天线数量个;
    }

    public void set铁塔产品单元1_天线数量个(String 铁塔产品单元1_天线数量个) {
        this.铁塔产品单元1_天线数量个 = 铁塔产品单元1_天线数量个;
    }

    public String get铁塔产品单元1_计费系统数个() {
        return 铁塔产品单元1_计费系统数个;
    }

    public void set铁塔产品单元1_计费系统数个(String 铁塔产品单元1_计费系统数个) {
        this.铁塔产品单元1_计费系统数个 = 铁塔产品单元1_计费系统数个;
    }

    public String get铁塔产品单元1_BBU是否放在铁塔公司机房() {
        return 铁塔产品单元1_BBU是否放在铁塔公司机房;
    }

    public void set铁塔产品单元1_BBU是否放在铁塔公司机房(String 铁塔产品单元1_BBU是否放在铁塔公司机房) {
        this.铁塔产品单元1_BBU是否放在铁塔公司机房 = 铁塔产品单元1_BBU是否放在铁塔公司机房;
    }

    public String get铁塔产品单元1_RRU是否上塔() {
        return 铁塔产品单元1_RRU是否上塔;
    }

    public void set铁塔产品单元1_RRU是否上塔(String 铁塔产品单元1_RRU是否上塔) {
        this.铁塔产品单元1_RRU是否上塔 = 铁塔产品单元1_RRU是否上塔;
    }

    public String get铁塔产品单元2_系统名称() {
        return 铁塔产品单元2_系统名称;
    }

    public void set铁塔产品单元2_系统名称(String 铁塔产品单元2_系统名称) {
        this.铁塔产品单元2_系统名称 = 铁塔产品单元2_系统名称;
    }

    public String get铁塔产品单元2_天线挂高米() {
        return 铁塔产品单元2_天线挂高米;
    }

    public void set铁塔产品单元2_天线挂高米(String 铁塔产品单元2_天线挂高米) {
        this.铁塔产品单元2_天线挂高米 = 铁塔产品单元2_天线挂高米;
    }

    public String get铁塔产品单元2_天线数量个() {
        return 铁塔产品单元2_天线数量个;
    }

    public void set铁塔产品单元2_天线数量个(String 铁塔产品单元2_天线数量个) {
        this.铁塔产品单元2_天线数量个 = 铁塔产品单元2_天线数量个;
    }

    public String get铁塔产品单元2_计费系统数个() {
        return 铁塔产品单元2_计费系统数个;
    }

    public void set铁塔产品单元2_计费系统数个(String 铁塔产品单元2_计费系统数个) {
        this.铁塔产品单元2_计费系统数个 = 铁塔产品单元2_计费系统数个;
    }

    public String get铁塔产品单元2_BBU是否放在铁塔公司机房() {
        return 铁塔产品单元2_BBU是否放在铁塔公司机房;
    }

    public void set铁塔产品单元2_BBU是否放在铁塔公司机房(String 铁塔产品单元2_BBU是否放在铁塔公司机房) {
        this.铁塔产品单元2_BBU是否放在铁塔公司机房 = 铁塔产品单元2_BBU是否放在铁塔公司机房;
    }

    public String get铁塔产品单元2_RRU是否上塔() {
        return 铁塔产品单元2_RRU是否上塔;
    }

    public void set铁塔产品单元2_RRU是否上塔(String 铁塔产品单元2_RRU是否上塔) {
        this.铁塔产品单元2_RRU是否上塔 = 铁塔产品单元2_RRU是否上塔;
    }

    public String get铁塔产品单元3_系统名称() {
        return 铁塔产品单元3_系统名称;
    }

    public void set铁塔产品单元3_系统名称(String 铁塔产品单元3_系统名称) {
        this.铁塔产品单元3_系统名称 = 铁塔产品单元3_系统名称;
    }

    public String get铁塔产品单元3_天线挂高米() {
        return 铁塔产品单元3_天线挂高米;
    }

    public void set铁塔产品单元3_天线挂高米(String 铁塔产品单元3_天线挂高米) {
        this.铁塔产品单元3_天线挂高米 = 铁塔产品单元3_天线挂高米;
    }

    public String get铁塔产品单元3_天线数量个() {
        return 铁塔产品单元3_天线数量个;
    }

    public void set铁塔产品单元3_天线数量个(String 铁塔产品单元3_天线数量个) {
        this.铁塔产品单元3_天线数量个 = 铁塔产品单元3_天线数量个;
    }

    public String get铁塔产品单元3_计费系统数个() {
        return 铁塔产品单元3_计费系统数个;
    }

    public void set铁塔产品单元3_计费系统数个(String 铁塔产品单元3_计费系统数个) {
        this.铁塔产品单元3_计费系统数个 = 铁塔产品单元3_计费系统数个;
    }

    public String get铁塔产品单元3_BBU是否放在铁塔公司机房() {
        return 铁塔产品单元3_BBU是否放在铁塔公司机房;
    }

    public void set铁塔产品单元3_BBU是否放在铁塔公司机房(String 铁塔产品单元3_BBU是否放在铁塔公司机房) {
        this.铁塔产品单元3_BBU是否放在铁塔公司机房 = 铁塔产品单元3_BBU是否放在铁塔公司机房;
    }

    public String get铁塔产品单元3_RRU是否上塔() {
        return 铁塔产品单元3_RRU是否上塔;
    }

    public void set铁塔产品单元3_RRU是否上塔(String 铁塔产品单元3_RRU是否上塔) {
        this.铁塔产品单元3_RRU是否上塔 = 铁塔产品单元3_RRU是否上塔;
    }

    public String getWLAN天线_天线挂高米() {
        return WLAN天线_天线挂高米;
    }

    public void setWLAN天线_天线挂高米(String WLAN天线_天线挂高米) {
        this.WLAN天线_天线挂高米 = WLAN天线_天线挂高米;
    }

    public String get微波天线_天线挂高米() {
        return 微波天线_天线挂高米;
    }

    public void set微波天线_天线挂高米(String 微波天线_天线挂高米) {
        this.微波天线_天线挂高米 = 微波天线_天线挂高米;
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

    public String get是否首家() {
        return 是否首家;
    }

    public void set是否首家(String 是否首家) {
        this.是否首家 = 是否首家;
    }

    public String get备注新() {
        return 备注新;
    }

    public void set备注新(String 备注新) {
        this.备注新 = 备注新;
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

    public String get费用信息单位元年_铁塔共享折扣() {
        return 费用信息单位元年_铁塔共享折扣;
    }

    public void set费用信息单位元年_铁塔共享折扣(String 费用信息单位元年_铁塔共享折扣) {
        this.费用信息单位元年_铁塔共享折扣 = 费用信息单位元年_铁塔共享折扣;
    }

    public String get费用信息单位元年_铁塔建造成本() {
        return 费用信息单位元年_铁塔建造成本;
    }

    public void set费用信息单位元年_铁塔建造成本(String 费用信息单位元年_铁塔建造成本) {
        this.费用信息单位元年_铁塔建造成本 = 费用信息单位元年_铁塔建造成本;
    }

    public String get费用信息单位元年_铁塔成本年标准单价() {
        return 费用信息单位元年_铁塔成本年标准单价;
    }

    public void set费用信息单位元年_铁塔成本年标准单价(String 费用信息单位元年_铁塔成本年标准单价) {
        this.费用信息单位元年_铁塔成本年标准单价 = 费用信息单位元年_铁塔成本年标准单价;
    }

    public String get费用信息单位元年_铁塔建造成本原始值() {
        return 费用信息单位元年_铁塔建造成本原始值;
    }

    public void set费用信息单位元年_铁塔建造成本原始值(String 费用信息单位元年_铁塔建造成本原始值) {
        this.费用信息单位元年_铁塔建造成本原始值 = 费用信息单位元年_铁塔建造成本原始值;
    }

    public String get费用信息单位元年_机房共享折扣() {
        return 费用信息单位元年_机房共享折扣;
    }

    public void set费用信息单位元年_机房共享折扣(String 费用信息单位元年_机房共享折扣) {
        this.费用信息单位元年_机房共享折扣 = 费用信息单位元年_机房共享折扣;
    }

    public String get费用信息单位元年_机房建造成本() {
        return 费用信息单位元年_机房建造成本;
    }

    public void set费用信息单位元年_机房建造成本(String 费用信息单位元年_机房建造成本) {
        this.费用信息单位元年_机房建造成本 = 费用信息单位元年_机房建造成本;
    }

    public String get费用信息单位元年_机房成本年标准单价() {
        return 费用信息单位元年_机房成本年标准单价;
    }

    public void set费用信息单位元年_机房成本年标准单价(String 费用信息单位元年_机房成本年标准单价) {
        this.费用信息单位元年_机房成本年标准单价 = 费用信息单位元年_机房成本年标准单价;
    }

    public String get费用信息单位元年_机房建造成本原始值() {
        return 费用信息单位元年_机房建造成本原始值;
    }

    public void set费用信息单位元年_机房建造成本原始值(String 费用信息单位元年_机房建造成本原始值) {
        this.费用信息单位元年_机房建造成本原始值 = 费用信息单位元年_机房建造成本原始值;
    }

    public String get费用信息单位元年_配套共享折扣() {
        return 费用信息单位元年_配套共享折扣;
    }

    public void set费用信息单位元年_配套共享折扣(String 费用信息单位元年_配套共享折扣) {
        this.费用信息单位元年_配套共享折扣 = 费用信息单位元年_配套共享折扣;
    }

    public String get费用信息单位元年_配套成本() {
        return 费用信息单位元年_配套成本;
    }

    public void set费用信息单位元年_配套成本(String 费用信息单位元年_配套成本) {
        this.费用信息单位元年_配套成本 = 费用信息单位元年_配套成本;
    }

    public String get费用信息单位元年_配套年标准单价() {
        return 费用信息单位元年_配套年标准单价;
    }

    public void set费用信息单位元年_配套年标准单价(String 费用信息单位元年_配套年标准单价) {
        this.费用信息单位元年_配套年标准单价 = 费用信息单位元年_配套年标准单价;
    }

    public String get费用信息单位元年_配套建造成本原始值() {
        return 费用信息单位元年_配套建造成本原始值;
    }

    public void set费用信息单位元年_配套建造成本原始值(String 费用信息单位元年_配套建造成本原始值) {
        this.费用信息单位元年_配套建造成本原始值 = 费用信息单位元年_配套建造成本原始值;
    }

    public String get费用信息单位元年_维护费共享折扣() {
        return 费用信息单位元年_维护费共享折扣;
    }

    public void set费用信息单位元年_维护费共享折扣(String 费用信息单位元年_维护费共享折扣) {
        this.费用信息单位元年_维护费共享折扣 = 费用信息单位元年_维护费共享折扣;
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

    public String get费用信息单位元年_BBU安装在铁塔机房费用() {
        return 费用信息单位元年_BBU安装在铁塔机房费用;
    }

    public void set费用信息单位元年_BBU安装在铁塔机房费用(String 费用信息单位元年_BBU安装在铁塔机房费用) {
        this.费用信息单位元年_BBU安装在铁塔机房费用 = 费用信息单位元年_BBU安装在铁塔机房费用;
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

    public String get费用信息单位元年_场地费共享折扣() {
        return 费用信息单位元年_场地费共享折扣;
    }

    public void set费用信息单位元年_场地费共享折扣(String 费用信息单位元年_场地费共享折扣) {
        this.费用信息单位元年_场地费共享折扣 = 费用信息单位元年_场地费共享折扣;
    }

    public String get费用信息单位元年_场地费是否参与共享() {
        return 费用信息单位元年_场地费是否参与共享;
    }

    public void set费用信息单位元年_场地费是否参与共享(String 费用信息单位元年_场地费是否参与共享) {
        this.费用信息单位元年_场地费是否参与共享 = 费用信息单位元年_场地费是否参与共享;
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

    public String get费用信息单位元年_电力引入费模式() {
        return 费用信息单位元年_电力引入费模式;
    }

    public void set费用信息单位元年_电力引入费模式(String 费用信息单位元年_电力引入费模式) {
        this.费用信息单位元年_电力引入费模式 = 费用信息单位元年_电力引入费模式;
    }

    public String get费用信息单位元年_电力引入费共享折扣() {
        return 费用信息单位元年_电力引入费共享折扣;
    }

    public void set费用信息单位元年_电力引入费共享折扣(String 费用信息单位元年_电力引入费共享折扣) {
        this.费用信息单位元年_电力引入费共享折扣 = 费用信息单位元年_电力引入费共享折扣;
    }

    public String get费用信息单位元年_电力引入费是否参与共享() {
        return 费用信息单位元年_电力引入费是否参与共享;
    }

    public void set费用信息单位元年_电力引入费是否参与共享(String 费用信息单位元年_电力引入费是否参与共享) {
        this.费用信息单位元年_电力引入费是否参与共享 = 费用信息单位元年_电力引入费是否参与共享;
    }

    public String get费用信息单位元年_电力引入费() {
        return 费用信息单位元年_电力引入费;
    }

    public void set费用信息单位元年_电力引入费(String 费用信息单位元年_电力引入费) {
        this.费用信息单位元年_电力引入费 = 费用信息单位元年_电力引入费;
    }

    public String get费用信息单位元年_电力引入费年标准单价() {
        return 费用信息单位元年_电力引入费年标准单价;
    }

    public void set费用信息单位元年_电力引入费年标准单价(String 费用信息单位元年_电力引入费年标准单价) {
        this.费用信息单位元年_电力引入费年标准单价 = 费用信息单位元年_电力引入费年标准单价;
    }

    public String get费用信息单位元年_电力引入费原始值() {
        return 费用信息单位元年_电力引入费原始值;
    }

    public void set费用信息单位元年_电力引入费原始值(String 费用信息单位元年_电力引入费原始值) {
        this.费用信息单位元年_电力引入费原始值 = 费用信息单位元年_电力引入费原始值;
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

    public String get费用信息单位元年_高等级额外服务费() {
        return 费用信息单位元年_高等级额外服务费;
    }

    public void set费用信息单位元年_高等级额外服务费(String 费用信息单位元年_高等级额外服务费) {
        this.费用信息单位元年_高等级额外服务费 = 费用信息单位元年_高等级额外服务费;
    }

    public String get费用信息单位元年_高等级额外服务费原始值() {
        return 费用信息单位元年_高等级额外服务费原始值;
    }

    public void set费用信息单位元年_高等级额外服务费原始值(String 费用信息单位元年_高等级额外服务费原始值) {
        this.费用信息单位元年_高等级额外服务费原始值 = 费用信息单位元年_高等级额外服务费原始值;
    }

    public String get费用信息单位元年_其他折扣RRU优惠() {
        return 费用信息单位元年_其他折扣RRU优惠;
    }

    public void set费用信息单位元年_其他折扣RRU优惠(String 费用信息单位元年_其他折扣RRU优惠) {
        this.费用信息单位元年_其他折扣RRU优惠 = 费用信息单位元年_其他折扣RRU优惠;
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

    public String get费用信息单位元年_微波() {
        return 费用信息单位元年_微波;
    }

    public void set费用信息单位元年_微波(String 费用信息单位元年_微波) {
        this.费用信息单位元年_微波 = 费用信息单位元年_微波;
    }

    public String get费用信息单位元年_微波原始值() {
        return 费用信息单位元年_微波原始值;
    }

    public void set费用信息单位元年_微波原始值(String 费用信息单位元年_微波原始值) {
        this.费用信息单位元年_微波原始值 = 费用信息单位元年_微波原始值;
    }

    public String get费用信息单位元年_WLAN() {
        return 费用信息单位元年_WLAN;
    }

    public void set费用信息单位元年_WLAN(String 费用信息单位元年_WLAN) {
        this.费用信息单位元年_WLAN = 费用信息单位元年_WLAN;
    }

    public String get费用信息单位元年_WLAN原始值() {
        return 费用信息单位元年_WLAN原始值;
    }

    public void set费用信息单位元年_WLAN原始值(String 费用信息单位元年_WLAN原始值) {
        this.费用信息单位元年_WLAN原始值 = 费用信息单位元年_WLAN原始值;
    }

    public String get费用信息单位元年_其他费用_场地费() {
        return 费用信息单位元年_其他费用_场地费;
    }

    public void set费用信息单位元年_其他费用_场地费(String 费用信息单位元年_其他费用_场地费) {
        this.费用信息单位元年_其他费用_场地费 = 费用信息单位元年_其他费用_场地费;
    }

    public String get费用信息单位元年_其他费用_场地费原始值() {
        return 费用信息单位元年_其他费用_场地费原始值;
    }

    public void set费用信息单位元年_其他费用_场地费原始值(String 费用信息单位元年_其他费用_场地费原始值) {
        this.费用信息单位元年_其他费用_场地费原始值 = 费用信息单位元年_其他费用_场地费原始值;
    }

    public String get费用信息单位元年_其他费用_电力引入费() {
        return 费用信息单位元年_其他费用_电力引入费;
    }

    public void set费用信息单位元年_其他费用_电力引入费(String 费用信息单位元年_其他费用_电力引入费) {
        this.费用信息单位元年_其他费用_电力引入费 = 费用信息单位元年_其他费用_电力引入费;
    }

    public String get费用信息单位元年_其他费用_电力引入费原始值() {
        return 费用信息单位元年_其他费用_电力引入费原始值;
    }

    public void set费用信息单位元年_其他费用_电力引入费原始值(String 费用信息单位元年_其他费用_电力引入费原始值) {
        this.费用信息单位元年_其他费用_电力引入费原始值 = 费用信息单位元年_其他费用_电力引入费原始值;
    }

    public String get费用信息单位元年_其他费用_油机发电费() {
        return 费用信息单位元年_其他费用_油机发电费;
    }

    public void set费用信息单位元年_其他费用_油机发电费(String 费用信息单位元年_其他费用_油机发电费) {
        this.费用信息单位元年_其他费用_油机发电费 = 费用信息单位元年_其他费用_油机发电费;
    }

    public String get费用信息单位元年_其他费用_油机发电费原始值() {
        return 费用信息单位元年_其他费用_油机发电费原始值;
    }

    public void set费用信息单位元年_其他费用_油机发电费原始值(String 费用信息单位元年_其他费用_油机发电费原始值) {
        this.费用信息单位元年_其他费用_油机发电费原始值 = 费用信息单位元年_其他费用_油机发电费原始值;
    }

    public String get费用信息单位元年_其他费用_用电服务费() {
        return 费用信息单位元年_其他费用_用电服务费;
    }

    public void set费用信息单位元年_其他费用_用电服务费(String 费用信息单位元年_其他费用_用电服务费) {
        this.费用信息单位元年_其他费用_用电服务费 = 费用信息单位元年_其他费用_用电服务费;
    }

    public String get其他费用_用电服务费原始值() {
        return 其他费用_用电服务费原始值;
    }

    public void set其他费用_用电服务费原始值(String 其他费用_用电服务费原始值) {
        this.其他费用_用电服务费原始值 = 其他费用_用电服务费原始值;
    }

    public String get费用信息单位元年_其他费用_维护费() {
        return 费用信息单位元年_其他费用_维护费;
    }

    public void set费用信息单位元年_其他费用_维护费(String 费用信息单位元年_其他费用_维护费) {
        this.费用信息单位元年_其他费用_维护费 = 费用信息单位元年_其他费用_维护费;
    }

    public String get费用信息单位元年_其他费用_维护费原始值() {
        return 费用信息单位元年_其他费用_维护费原始值;
    }

    public void set费用信息单位元年_其他费用_维护费原始值(String 费用信息单位元年_其他费用_维护费原始值) {
        this.费用信息单位元年_其他费用_维护费原始值 = 费用信息单位元年_其他费用_维护费原始值;
    }

    public String get费用信息单位元年_总费用() {
        return 费用信息单位元年_总费用;
    }

    public void set费用信息单位元年_总费用(String 费用信息单位元年_总费用) {
        this.费用信息单位元年_总费用 = 费用信息单位元年_总费用;
    }

    public String get同步信息_物业系统年场租及财务系统无形资产摊销是否同步() {
        return 同步信息_物业系统年场租及财务系统无形资产摊销是否同步;
    }

    public void set同步信息_物业系统年场租及财务系统无形资产摊销是否同步(String 同步信息_物业系统年场租及财务系统无形资产摊销是否同步) {
        this.同步信息_物业系统年场租及财务系统无形资产摊销是否同步 = 同步信息_物业系统年场租及财务系统无形资产摊销是否同步;
    }

    public String get同步信息_财务系统选址费是否同步() {
        return 同步信息_财务系统选址费是否同步;
    }

    public void set同步信息_财务系统选址费是否同步(String 同步信息_财务系统选址费是否同步) {
        this.同步信息_财务系统选址费是否同步 = 同步信息_财务系统选址费是否同步;
    }

    public String get建造成本模式() {
        return 建造成本模式;
    }

    public void set建造成本模式(String 建造成本模式) {
        this.建造成本模式 = 建造成本模式;
    }

    public String get铁塔管理区域() {
        return 铁塔管理区域;
    }

    public void set铁塔管理区域(String 铁塔管理区域) {
        this.铁塔管理区域 = 铁塔管理区域;
    }

    public String get运营商项目名称() {
        return 运营商项目名称;
    }

    public void set运营商项目名称(String 运营商项目名称) {
        this.运营商项目名称 = 运营商项目名称;
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
