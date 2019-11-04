package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Baopz
 * @date 2018/04/28
 */
@Data
@ToString
public class TmpCard implements ResultSet {
    private String 省分公司;
    private String 地市公司;
    private String 管理区域;
    private String 卡片编码;
    private String 卡片会计科目;
    private String 卡片状态;
    private String 卡片来源;
    private String 站点编码;
    private String 站点名称;
    private String 站点接收标记;
    private String 物业编码;
    private String 合同编码;
    private String 原值;
    private String 月摊销额;
    private String 累计摊销;
    private String 应付款;
    private String 摊销起始年月;
    private String 摊销终止年月;
    private String 摊销期月;
    private String 已摊销月数;
    private String 剩余摊销月数;
    private String 卡片生成日期;
    private String 卡片结转日期;
    private String 暂估计提日期;
    private String 卡片整体余额;

}
