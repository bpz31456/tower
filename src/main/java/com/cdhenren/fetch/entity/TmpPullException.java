package com.cdhenren.fetch.entity;

import lombok.Data;

/**
 * 取信异常
 * @author Fuhj
 */
@Data
public class TmpPullException implements ResultSet {
    private String 站址名称;
    private String 站址运维ID;
    private String 设备名称;
    private String 设备运维ID;
    private String 省;
    private String 市;
    private String 区县;
    private String FSU厂家;
    private String 缺失信号量;
    private String 最小上报次数;
    private String 缺失时间;
    private String 稽核时间;
    private String 站址资源ID;
    private String 站址状态;
    private String FSU名称;
    private String FSU编码;
    private String FSU注册状态;
    private String FSU注册时间;
    private String 设备资源ID;
    private String 代维厂家;
}
