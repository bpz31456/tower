package com.cdhenren.fetch.entity;

import lombok.Data;

/**
 * @author Fuhj
 */
@Data
public class TmpPerformance implements ResultSet {
    private String 省;
    private String 市;
    private String 区县;
    private String 站址;
    private String 站址运维ID;
    private String 设备名称;
    private String 设备厂家;
    private String 设备型号;
    private String 设备ID;
    private String 监控点;
    private String 时间;
    private String 实测值;
    private String 单位;
    private String 状态;
}
