package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Baopz
 * @date 2018/04/27
 */
@Data
@ToString
public class TmpAirCond implements ResultSet {
    private String 资源ID;
    private String 站址编码;
    private String 站址名称;
    private String 机房ID;
    private String 机房名称;
    private String 设备类型;
    private String 空调名称;
    private String 省;
    private String 市;
    private String 所属区域;
    private String 生产厂家;
    private String 型号;
    private String 维护状态;
    private String 业务状态;
    private String 产权性质;
    private String 原产权单位;
    private String 开始使用时间;
    private String 预计报废时间;
    private String 保修起始时间;
    private String 保修截止时间;
    private String 创建人;
    private String 创建时间;
    private String 修改人;
    private String 修改时间;
    private String 物理站址编码;
    private String 空调类型;
    private String 资产接收类型;
    private String 空调制冷量;
    private String 空调制热量;
    private String 额定输入功率;
    private String 空调制冷功率KW;
    private String 空调制热功率KW;
    private String 备注;
    private String 资产编号;
    private String 资产来源;


}
