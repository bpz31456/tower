package com.cdhenren.fetch.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Fuhj
 */
@Data
@ToString
public class TmpSiteRemovalRate implements ResultSet{
    private String 省份名称;
    private String 地市名称;
    private String 区县名称;
    private String 站址id;
    private String 站址编码;
    private String 站址名称;
    private String 所在地址;
}
