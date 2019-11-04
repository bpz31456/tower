package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Baopz
 * @date 2018/05/30
 */
@Data
@ToString
public class TmpBasicInformation implements ResultSet {
    private String 省;
    private String 市;
    private String 所属区域;
    private String 地市公司;
    private String 管理区;
    private String 站点编码;
    private String 站点名称;
    private String 物业编码;
    private String 物业管理员铁塔;
    private String 物业状态;
    private String 所属业主名称;
    private String 产权性质;
    private String 业主类型;
    private String 业主证件类型;
    private String 业主证件号码;
    private String 业主组织机构代码;
    private String 客商编码;
    private String 业主税号;
    private String 录入人;
    private String 是否需要签订合同;
    private String 用地获取方式;
    private String 备注;
    private String 产权单位;
    private String 预估年租金;
    private String 零场租原因;
    private String 是否有效;
    private String 备注1;
}
