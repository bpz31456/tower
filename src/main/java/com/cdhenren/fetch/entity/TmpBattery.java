package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Baopz
 * @date 2018/04/27
 */
@Data
@ToString
public class TmpBattery implements ResultSet {
    private String 资源ID;
    private String 站址名称;
    private String 站址编码;
    private String 机房名称;
    private String 机房ID;
    private String 蓄电池组名称;
    private String 蓄电池类型;
    private String 型号;
    private String 生产厂家;
    private String 原产权单位;
    private String 产权性质;
    private String 蓄电池组额定容量AH;
    private String 单节电池电压等级;
    private String 蓄电池个数;
    private String 单节电池设备尺寸;
    private String 入网时间;
    private String 是否故障;
    private String 省份;
    private String 地市;
    private String 所属区域;
    private String 保修截止时间;
    private String 保修级别;
    private String 创建人;
    private String 创建时间;
    private String 修改人;
    private String 修改时间;
    private String 物理站址编码;
    private String 资产接收类型;
    private String 备注;
    private String 资产编号;
    private String 生产日期;
    private String 资产来源;
    private String 站址类型;
    private String 站址状态;
    private String 维护状态;
}
