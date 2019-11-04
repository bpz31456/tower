package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 资产卡片
 *
 * @author Baopz
 * @date 2018/04/27
 */
@Data
@ToString
public class TmpAsset implements ResultSet {
    private String 资产ID;
    private String 资产编号;
    private String 资产名称;
    private String 固定资产目录;
    private String 责任人;
    private String 规格型号;
    private String 原价值;
    private String 实际启用日期;
    private String 使用时间;
    private String 使用部门;
    private String 站址名称;
    private String 站址编码;
    private String 工程编号;
    private String 是否生产类;
    private String 资产类型;
    private String 资产状态;
    private String 闲置资产可用性;
    private String 资产接收类型;
    private String 资产备注;
    private String 专业管理部门;
    private String 所属区域;
    private String 区域ID;
    private String 原站址编码;
    private String 原站址名称;
    private String 是否父子卡片;
    private String 资源类型;
    private String 资产地址;
    private String 是否已入库;
    private String 闲置日期;
    private String 是否站址用;
    private String 所属项目;
}
