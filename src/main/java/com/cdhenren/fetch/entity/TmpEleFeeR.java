package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/04/28
 */
public class TmpEleFeeR implements ResultSet {
    private String 省分名称;
    private String 地市名称;
    private String 所属区域;
    private String 站点编码;
    private String 站点名称;
    private String 地址;
    private String 经度;
    private String 纬度;
    private String 站点类型;
    private String 站点等级;
    private String 建设日期;
    private String 入网日期;
    private String 是否承接电费;
    private String 未承接原因;
    private String 未承接备注;

    @Override
    public String toString() {
        return "TmpEleFeeR{" +
                "省分名称='" + 省分名称 + '\'' +
                ", 地市名称='" + 地市名称 + '\'' +
                ", 所属区域='" + 所属区域 + '\'' +
                ", 站点编码='" + 站点编码 + '\'' +
                ", 站点名称='" + 站点名称 + '\'' +
                ", 地址='" + 地址 + '\'' +
                ", 经度='" + 经度 + '\'' +
                ", 纬度='" + 纬度 + '\'' +
                ", 站点类型='" + 站点类型 + '\'' +
                ", 站点等级='" + 站点等级 + '\'' +
                ", 建设日期='" + 建设日期 + '\'' +
                ", 入网日期='" + 入网日期 + '\'' +
                ", 是否承接电费='" + 是否承接电费 + '\'' +
                ", 未承接原因='" + 未承接原因 + '\'' +
                ", 未承接备注='" + 未承接备注 + '\'' +
                '}';
    }

    public String get省分名称() {
        return 省分名称;
    }

    public void set省分名称(String 省分名称) {
        this.省分名称 = 省分名称;
    }

    public String get地市名称() {
        return 地市名称;
    }

    public void set地市名称(String 地市名称) {
        this.地市名称 = 地市名称;
    }

    public String get所属区域() {
        return 所属区域;
    }

    public void set所属区域(String 所属区域) {
        this.所属区域 = 所属区域;
    }

    public String get站点编码() {
        return 站点编码;
    }

    public void set站点编码(String 站点编码) {
        this.站点编码 = 站点编码;
    }

    public String get站点名称() {
        return 站点名称;
    }

    public void set站点名称(String 站点名称) {
        this.站点名称 = 站点名称;
    }

    public String get地址() {
        return 地址;
    }

    public void set地址(String 地址) {
        this.地址 = 地址;
    }

    public String get经度() {
        return 经度;
    }

    public void set经度(String 经度) {
        this.经度 = 经度;
    }

    public String get纬度() {
        return 纬度;
    }

    public void set纬度(String 纬度) {
        this.纬度 = 纬度;
    }

    public String get站点类型() {
        return 站点类型;
    }

    public void set站点类型(String 站点类型) {
        this.站点类型 = 站点类型;
    }

    public String get站点等级() {
        return 站点等级;
    }

    public void set站点等级(String 站点等级) {
        this.站点等级 = 站点等级;
    }

    public String get建设日期() {
        return 建设日期;
    }

    public void set建设日期(String 建设日期) {
        this.建设日期 = 建设日期;
    }

    public String get入网日期() {
        return 入网日期;
    }

    public void set入网日期(String 入网日期) {
        this.入网日期 = 入网日期;
    }

    public String get是否承接电费() {
        return 是否承接电费;
    }

    public void set是否承接电费(String 是否承接电费) {
        this.是否承接电费 = 是否承接电费;
    }

    public String get未承接原因() {
        return 未承接原因;
    }

    public void set未承接原因(String 未承接原因) {
        this.未承接原因 = 未承接原因;
    }

    public String get未承接备注() {
        return 未承接备注;
    }

    public void set未承接备注(String 未承接备注) {
        this.未承接备注 = 未承接备注;
    }
}
