package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/02
 */
@Deprecated
public class TmpFallView implements ResultSet {
    private String 序号;
    private String 需求单编号;
    private String 站址编码;
    private String 站点名称;
    private String 项目类型;
    private String 建设方式;
    private String 所属专项;
    private String 项目名称;
    private String 建设单位;
    private String 客户经理;
    private String 项目经理;
    private String 项目状态;

    @Override
    public String toString() {
        return "TmpFallView{" +
                "序号='" + 序号 + '\'' +
                ", 需求单编号='" + 需求单编号 + '\'' +
                ", 站址编码='" + 站址编码 + '\'' +
                ", 站点名称='" + 站点名称 + '\'' +
                ", 项目类型='" + 项目类型 + '\'' +
                ", 建设方式='" + 建设方式 + '\'' +
                ", 所属专项='" + 所属专项 + '\'' +
                ", 项目名称='" + 项目名称 + '\'' +
                ", 建设单位='" + 建设单位 + '\'' +
                ", 客户经理='" + 客户经理 + '\'' +
                ", 项目经理='" + 项目经理 + '\'' +
                ", 项目状态='" + 项目状态 + '\'' +
                '}';
    }

    public String get序号() {
        return 序号;
    }

    public void set序号(String 序号) {
        this.序号 = 序号;
    }

    public String get需求单编号() {
        return 需求单编号;
    }

    public void set需求单编号(String 需求单编号) {
        this.需求单编号 = 需求单编号;
    }

    public String get站址编码() {
        return 站址编码;
    }

    public void set站址编码(String 站址编码) {
        this.站址编码 = 站址编码;
    }

    public String get站点名称() {
        return 站点名称;
    }

    public void set站点名称(String 站点名称) {
        this.站点名称 = 站点名称;
    }

    public String get项目类型() {
        return 项目类型;
    }

    public void set项目类型(String 项目类型) {
        this.项目类型 = 项目类型;
    }

    public String get建设方式() {
        return 建设方式;
    }

    public void set建设方式(String 建设方式) {
        this.建设方式 = 建设方式;
    }

    public String get所属专项() {
        return 所属专项;
    }

    public void set所属专项(String 所属专项) {
        this.所属专项 = 所属专项;
    }

    public String get项目名称() {
        return 项目名称;
    }

    public void set项目名称(String 项目名称) {
        this.项目名称 = 项目名称;
    }

    public String get建设单位() {
        return 建设单位;
    }

    public void set建设单位(String 建设单位) {
        this.建设单位 = 建设单位;
    }

    public String get客户经理() {
        return 客户经理;
    }

    public void set客户经理(String 客户经理) {
        this.客户经理 = 客户经理;
    }

    public String get项目经理() {
        return 项目经理;
    }

    public void set项目经理(String 项目经理) {
        this.项目经理 = 项目经理;
    }

    public String get项目状态() {
        return 项目状态;
    }

    public void set项目状态(String 项目状态) {
        this.项目状态 = 项目状态;
    }
}
