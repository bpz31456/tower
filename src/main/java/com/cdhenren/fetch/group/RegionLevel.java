package com.cdhenren.fetch.group;

/**
 * 区域登记
 *
 * @author Fuhj
 * @since 3.0.0
 */
public enum RegionLevel {
    FIRST_REGION("FIRST_REGION"),
    SEC_REGION("SEC_REGION");

    private String code;

    RegionLevel(String code) {
        this.code = code;
    }
}
