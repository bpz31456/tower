package com.cdhenren.fetch.entity;

import lombok.Data;

/**
 * @author Fuhj
 */
@Data
public class TmpWrongEquipment implements ResultSet {
    private String 站址名称;
    private String 站址运维ID;
    private String 省;
    private String 市;
    private String 区县;
    private String FSU厂家;
    private String FSU运维ID;
    private String 设备运维ID;
    private String 设备类型;
    private String 异常类型;
    private String 数据异常内容;
    private String 数据稽核时间;
    private String 代维厂家;
}
