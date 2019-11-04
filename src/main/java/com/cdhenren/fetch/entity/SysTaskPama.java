package com.cdhenren.fetch.entity;

import java.sql.Timestamp;

/**
 * @since 1.0.0
 * @author Baopz
 * version 2.0.0/2018.07.26
 * @date 2018/04/23
 */
public class SysTaskPama {
    /**
     * version2.0.0 2018.07.26
     */
    private String location;
    private int keyId;
    private String taskName;
    private String taskCode;
    private int fixType;
    private String fixTime;
    private String user;
    private String pwd;
    private String url;
    private String requestPama;
    private String tmpTable;
    private String insSql;
    private int state;
    private Timestamp crtDate;
    private Timestamp modDate;
    private int reTryMax;
    /**
     * @date 2019.09.28
     * @since 3.0.0
     */
    private String firstRegion;
    private String secRegion;

    public static final int STATE_1_VALID  = 1;

    public static final int STATE_0_INVALID  = 0;

    /**
     * 天
     */
    public static final int FIX_TYPE_DAY =1;
    /**
     * 月
     */
    public static final int FIX_TYPE_MONTH =2;
    /**
     * 实时，程序暂时不管
     */
    public static final int FIX_TYPE_RUNTIME =0;

    /**
     * 系统自动调用的存储过程，程序暂时不管
     */
    public static final int FIX_TYPE_CALL =3;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getReTryMax() {
        return reTryMax;
    }

    public void setReTryMax(int reTryMax) {
        this.reTryMax = reTryMax;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public int getFixType() {
        return fixType;
    }

    public void setFixType(int fixType) {
        this.fixType = fixType;
    }

    public String getFixTime() {
        return fixTime;
    }

    public void setFixTime(String fixTime) {
        this.fixTime = fixTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestPama() {
        return requestPama;
    }

    public void setRequestPama(String requestPama) {
        this.requestPama = requestPama;
    }

    public String getTmpTable() {
        return tmpTable;
    }

    public void setTmpTable(String tmpTable) {
        this.tmpTable = tmpTable;
    }

    public String getInsSql() {
        return insSql;
    }

    public void setInsSql(String insSql) {
        this.insSql = insSql;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Timestamp crtDate) {
        this.crtDate = crtDate;
    }

    public Timestamp getModDate() {
        return modDate;
    }

    public void setModDate(Timestamp modDate) {
        this.modDate = modDate;
    }

    public String getFirstRegion() {
        return firstRegion;
    }

    public void setFirstRegion(String firstRegion) {
        this.firstRegion = firstRegion;
    }

    public String getSecRegion() {
        return secRegion;
    }

    public void setSecRegion(String secRegion) {
        this.secRegion = secRegion;
    }

    @Override
    public String toString() {
        return "SysTaskPama{" +
                "location='" + location + '\'' +
                ", keyId=" + keyId +
                ", taskName='" + taskName + '\'' +
                ", taskCode='" + taskCode + '\'' +
                ", fixType=" + fixType +
                ", fixTime='" + fixTime + '\'' +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", url='" + url + '\'' +
                ", requestPama='" + requestPama + '\'' +
                ", tmpTable='" + tmpTable + '\'' +
                ", insSql='" + insSql + '\'' +
                ", state=" + state +
                ", crtDate=" + crtDate +
                ", modDate=" + modDate +
                ", reTryMax=" + reTryMax +
                '}';
    }
}
