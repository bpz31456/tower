package com.cdhenren.fetch.entity;

import lombok.Data;

/**
 * 历史警戒Hbase
 */
@Data
public class TmpHistoryWarnHbase implements ResultSet {
    private String ID;
    private String 告警等级;
    private String 故障单编号;
    private String 省;
    private String 市;
    private String 区县;
    private String 站址;
    private String 站址状态;
    private String 站址运维ID;
    private String 告警来源;
    private String 告警名称;
    private String FSU名称;
    private String FSU运维ID;
    private String FSU厂家;
    private String 子设备名称;
    private String 告警详情;
    private String 告警发生时间;
    private String 告警清除时间;
    private String 告警清除人;
    private String 设备名称;
    private String 设备IP;
    private String 告警类别;
    private String 告警对象类型;
    private String 告警原因;
    private String 告警摘要;
    private String 告警附加信息;
    private String 告警入库时间;
    private String 告警重复次数;
    private String 是否已确认;
    private String 确认时间;
    private String 确认人;
    private String 确认原因;
    private String 用户备注信息;
    private String 是否已恢复;
    private String 是否转故障;
    private String 告警流水号;
    private String 告警说明;
    private String 故障现象描述;
    private String 站址来源;
    private String 代维公司;
    private String 站址编码;
    private String 告警开始时间FSU;
    private String 告警结束时间FSU;
    private String 告警历时;
    private String 是否手工清除;
}
