package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/04/28
 */
public class TmpEleQuan implements ResultSet {
    private String 省;
    private String 市;
    private String 所属区域;
    private String 站点编码;
    private String 站点名称;
    private String 电表编号;
    private String 本次电表读数;
    private String 抄表人;
    private String 抄表日期;
    private String 抄表人联系电话;
    private String 抄表方式;
    private String 本次平均每天用电量;
    private String 上次电表读数;
    private String 是否异常;
    private String 是否上传照片;
    private String 异常审核状态;

    @Override
    public String toString() {
        return "TmpEleQuan{" +
                "省='" + 省 + '\'' +
                ", 市='" + 市 + '\'' +
                ", 所属区域='" + 所属区域 + '\'' +
                ", 站点编码='" + 站点编码 + '\'' +
                ", 站点名称='" + 站点名称 + '\'' +
                ", 电表编号='" + 电表编号 + '\'' +
                ", 本次电表读数='" + 本次电表读数 + '\'' +
                ", 抄表人='" + 抄表人 + '\'' +
                ", 抄表日期='" + 抄表日期 + '\'' +
                ", 抄表人联系电话='" + 抄表人联系电话 + '\'' +
                ", 抄表方式='" + 抄表方式 + '\'' +
                ", 本次平均每天用电量='" + 本次平均每天用电量 + '\'' +
                ", 上次电表读数='" + 上次电表读数 + '\'' +
                ", 是否异常='" + 是否异常 + '\'' +
                ", 是否上传照片='" + 是否上传照片 + '\'' +
                ", 异常审核状态='" + 异常审核状态 + '\'' +
                '}';
    }

    public String get省() {
        return 省;
    }

    public void set省(String 省) {
        this.省 = 省;
    }

    public String get市() {
        return 市;
    }

    public void set市(String 市) {
        this.市 = 市;
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

    public String get电表编号() {
        return 电表编号;
    }

    public void set电表编号(String 电表编号) {
        this.电表编号 = 电表编号;
    }

    public String get本次电表读数() {
        return 本次电表读数;
    }

    public void set本次电表读数(String 本次电表读数) {
        this.本次电表读数 = 本次电表读数;
    }

    public String get抄表人() {
        return 抄表人;
    }

    public void set抄表人(String 抄表人) {
        this.抄表人 = 抄表人;
    }

    public String get抄表日期() {
        return 抄表日期;
    }

    public void set抄表日期(String 抄表日期) {
        this.抄表日期 = 抄表日期;
    }

    public String get抄表人联系电话() {
        return 抄表人联系电话;
    }

    public void set抄表人联系电话(String 抄表人联系电话) {
        this.抄表人联系电话 = 抄表人联系电话;
    }

    public String get抄表方式() {
        return 抄表方式;
    }

    public void set抄表方式(String 抄表方式) {
        this.抄表方式 = 抄表方式;
    }

    public String get本次平均每天用电量() {
        return 本次平均每天用电量;
    }

    public void set本次平均每天用电量(String 本次平均每天用电量) {
        this.本次平均每天用电量 = 本次平均每天用电量;
    }

    public String get上次电表读数() {
        return 上次电表读数;
    }

    public void set上次电表读数(String 上次电表读数) {
        this.上次电表读数 = 上次电表读数;
    }

    public String get是否异常() {
        return 是否异常;
    }

    public void set是否异常(String 是否异常) {
        this.是否异常 = 是否异常;
    }

    public String get是否上传照片() {
        return 是否上传照片;
    }

    public void set是否上传照片(String 是否上传照片) {
        this.是否上传照片 = 是否上传照片;
    }

    public String get异常审核状态() {
        return 异常审核状态;
    }

    public void set异常审核状态(String 异常审核状态) {
        this.异常审核状态 = 异常审核状态;
    }
}
