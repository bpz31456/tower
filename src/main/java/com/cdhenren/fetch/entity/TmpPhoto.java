package com.cdhenren.fetch.entity;

/**
 * @author Baopz
 * @date 2018/05/31
 */
public class TmpPhoto implements ResultSet{
    private String 省分名称;
    private String 地市名称;
    private String 区县名称;
    private String 站址编码;
    private String 站址名称;
    private String 站址位置;
    private String 是否已上传照片;
    private String 已上传照片数量;

    @Override
    public String toString() {
        return "TmpPhoto{" +
                "省分名称='" + 省分名称 + '\'' +
                ", 地市名称='" + 地市名称 + '\'' +
                ", 区县名称='" + 区县名称 + '\'' +
                ", 站址编码='" + 站址编码 + '\'' +
                ", 站址名称='" + 站址名称 + '\'' +
                ", 站址位置='" + 站址位置 + '\'' +
                ", 是否已上传照片='" + 是否已上传照片 + '\'' +
                ", 已上传照片数量='" + 已上传照片数量 + '\'' +
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

    public String get区县名称() {
        return 区县名称;
    }

    public void set区县名称(String 区县名称) {
        this.区县名称 = 区县名称;
    }

    public String get站址编码() {
        return 站址编码;
    }

    public void set站址编码(String 站址编码) {
        this.站址编码 = 站址编码;
    }

    public String get站址名称() {
        return 站址名称;
    }

    public void set站址名称(String 站址名称) {
        this.站址名称 = 站址名称;
    }

    public String get站址位置() {
        return 站址位置;
    }

    public void set站址位置(String 站址位置) {
        this.站址位置 = 站址位置;
    }

    public String get是否已上传照片() {
        return 是否已上传照片;
    }

    public void set是否已上传照片(String 是否已上传照片) {
        this.是否已上传照片 = 是否已上传照片;
    }

    public String get已上传照片数量() {
        return 已上传照片数量;
    }

    public void set已上传照片数量(String 已上传照片数量) {
        this.已上传照片数量 = 已上传照片数量;
    }
}
