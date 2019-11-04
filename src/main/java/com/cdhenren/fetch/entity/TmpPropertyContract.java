package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 物业管理，合同信息管理
 * @author baopz
 * @date 2019.09.07
 */
@Data
@ToString
public class TmpPropertyContract implements ResultSet {
    private String 合同基础信息省份;
    private String 合同基础信息地市;
    private String 合同基础信息区县;
    private String 合同基础信息省分公司;
    private String 合同基础信息地市公司;
    private String 合同基础信息站点编码;
    private String 合同基础信息站点名称;
    private String 合同基础信息站点性质;
    private String 合同基础信息建设场景;
    private String 合同基础信息物业编码;
    private String 合同基础信息物业名称;
    private String 合同基础信息合同编码;
    private String 合同基础信息合同名称;
    private String 业务大类;
    private String 合同基础信息合同类型;
    private String 合同基础信息合同属性;
    private String 合同基础信息所属业主名称甲方;
    private String 合同基础信息客商编号;
    private String 合同基础信息业主电话;
    private String 合同基础信息证件号码;
    private String 合同基础信息业主所属地市公司;
    private String 合同基础信息业主类型;
    private String 合同基础信息业主证件类型;
    private String 合同基础信息业主证件号码;
    private String 合同基础信息合同乙方;
    private String 合同基础信息合同签订日期;
    private String 合同基础信息合同起始日期原始;
    private String 合同基础信息合同支付计提起始日期;
    private String 合同基础信息合同终止日期;
    private String 合同基础信息合同录入日期;
    private String 合同基础信息合同总金额;
    private String 合同基础信息经办人;
    private String 合同基础信息经办部门;
    private String 合同基础信息合同状态;
    private String 合同基础信息是否代持;
    private String 合同基础信息站点是否删除;
    private String 合同基础信息被续签合同编码;
    private String 合同基础信息是否需要续签;
    private String 是否关联框架合同;
    private String 合同基础信息最后修改时间;
    private String 合同租金信息房屋租赁面积平方米;
    private String 合同租金信息场地租赁面积平方米;
    private String 合同租金信息基本年租金元年;
    private String 合同租金信息租金支付方式;
    private String 合同租金信息租金支付周期月;
    private String 合同租金信息租金约定首次支付日期;
    private String 合同租金信息租金收款账号;
    private String 合同租金信息租金收款户名;
    private String 合同租金信息所属银行租金收款;
    private String 合同租金信息租金收款银行;
    private String 合同租金信息租金票据类型;
    private String 合同租金信息我方代开票;
    private String 合同租金信息代开票税点;
    private String 电费单价元度;
    private String 合同电费信息电价标准;
    private String 合同电费信息电费支付方式;
    private String 合同电费信息电费支付周期月;
    private String 合同电费信息电费约定首次支付日期;
    private String 合同电费信息电费收款账号;
    private String 合同电费信息电费收款户名;
    private String 合同电费信息所属银行电费收款;
    private String 合同电费信息电费收款银行;
    private String 合同电费信息电费票据类型;
    private String 押金信息押金金额元;
}
