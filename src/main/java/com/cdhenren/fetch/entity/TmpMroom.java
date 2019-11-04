package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 機房
 * @author Baopz
 * @date 2018/04/27
 */
@Data
@ToString
public class TmpMroom implements ResultSet {
    private String 资源ID;
    private String 机房名称;
    private String 站址编码;
    private String 站址名称;
    private String 省;
    private String 市;
    private String 区域名称;
    private String 机房类型;
    private String 产品大类;
    private String 地址;
    private String 使用单位;
    private String 产权性质;
    private String 原产权单位;
    private String 是否有油机房;
    private String 是否封锁;
    private String 备注;
    private String 机房面积平米;
    private String 进深米;
    private String 机房净高米;
    private String 机房所在楼层;
    private String 开间米;
    private String 监理单位;
    private String 施工单位;
    private String 联系人;
    private String 联系电话;
    private String 入网时间;
    private String 入局光缆是否有空位;
    private String 馈线框总孔数;
    private String 馈线窗剩余孔位数;
    private String 馈线窗占用孔位数;
    private String 防雷箱品牌;
    private String 防雷箱型号;
    private String 灭火器型号;
    private String 灭火器数量;
    private String 维护状态;
    private String 进站路况;
    private String 进站难易程度;
    private String 进站困难原因;
    private String 车辆能否到达;
    private String 能否上站发电;
    private String 不能发电原因;
    private String 钥匙类型;
    private String 是否能扩建油机房;
    private String 机房治安环境;
    private String 是否有围墙;
    private String 允许发电时长小时;
    private String 录入人员;
    private String 录入时间;
    private String 修改人员;
    private String 物理站址编码;
    private String 资产接收类型;
    private String 机房等级;
    private String 总机位数;
    private String 空闲机位数;
    private String 资产编号;
    private String 资产来源;
    private String 站址类型;
    private String 站址状态;
}
