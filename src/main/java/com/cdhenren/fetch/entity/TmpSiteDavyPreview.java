package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/24
 */
public class TmpSiteDavyPreview implements ResultSet{
    private String 省;
    private String 市;
    private String 区;
    private String 站址运维ID;
    private String 资源系统站址编码;
    private String 站址名称;
    private String 合同编号;
    private String 合同名称;
    private String 对方主体编号;
    private String 供应商名称;
    private String 费用类型;
    private String 金额元;

    @Override
    public String toString() {
        return "TmpSiteDavyPreview{" +
                "省='" + 省 + '\'' +
                ", 市='" + 市 + '\'' +
                ", 区='" + 区 + '\'' +
                ", 站址运维ID='" + 站址运维ID + '\'' +
                ", 资源系统站址编码='" + 资源系统站址编码 + '\'' +
                ", 站址名称='" + 站址名称 + '\'' +
                ", 合同编号='" + 合同编号 + '\'' +
                ", 合同名称='" + 合同名称 + '\'' +
                ", 对方主体编号='" + 对方主体编号 + '\'' +
                ", 供应商名称='" + 供应商名称 + '\'' +
                ", 费用类型='" + 费用类型 + '\'' +
                ", 金额元='" + 金额元 + '\'' +
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

    public String get区() {
        return 区;
    }

    public void set区(String 区) {
        this.区 = 区;
    }

    public String get站址运维ID() {
        return 站址运维ID;
    }

    public void set站址运维ID(String 站址运维ID) {
        this.站址运维ID = 站址运维ID;
    }

    public String get资源系统站址编码() {
        return 资源系统站址编码;
    }

    public void set资源系统站址编码(String 资源系统站址编码) {
        this.资源系统站址编码 = 资源系统站址编码;
    }

    public String get站址名称() {
        return 站址名称;
    }

    public void set站址名称(String 站址名称) {
        this.站址名称 = 站址名称;
    }

    public String get合同编号() {
        return 合同编号;
    }

    public void set合同编号(String 合同编号) {
        this.合同编号 = 合同编号;
    }

    public String get合同名称() {
        return 合同名称;
    }

    public void set合同名称(String 合同名称) {
        this.合同名称 = 合同名称;
    }

    public String get对方主体编号() {
        return 对方主体编号;
    }

    public void set对方主体编号(String 对方主体编号) {
        this.对方主体编号 = 对方主体编号;
    }

    public String get供应商名称() {
        return 供应商名称;
    }

    public void set供应商名称(String 供应商名称) {
        this.供应商名称 = 供应商名称;
    }

    public String get费用类型() {
        return 费用类型;
    }

    public void set费用类型(String 费用类型) {
        this.费用类型 = 费用类型;
    }

    public String get金额元() {
        return 金额元;
    }

    public void set金额元(String 金额元) {
        this.金额元 = 金额元;
    }
}
