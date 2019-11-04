package com.cdhenren.fetch.entity;

import java.sql.Timestamp;

/**
 * @author Baopz
 * @date 2018/04/23
 */
public class SysTask {
    /**状态,0-未处理，1-正在处理，2-执行异常，3-正常结束**/
    public static final int STATE_0 = 0;
    /**状态,0-未处理，1-正在处理，2-执行异常，3-正常结束**/
    public static final int STATE_1 = 1;
    /**状态,0-未处理，1-正在处理，2-执行异常，3-正常结束**/
    public static final int STATE_2 = 2;
    /**状态,0-未处理，1-正在处理，2-执行异常，3-正常结束**/
    public static final int STATE_3 = 3;

    /**0.临时，1.按天，2按月，3.其他调用过程**/
    public static final int FIX_TYPE_0 = 0;
    /**0.临时，1.按天，2按月，3.其他调用过程**/
    public static final int FIX_TYPE_1 = 1;
    /**0.临时，1.按天，2按月，3.其他调用过程**/
    public static final int FIX_TYPE_2 = 2;
    /**0.临时，1.按天，2按月，3.其他调用过程**/
    public static final int FIX_TYPE_3 = 3;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @since 2.0.0 2018.07.26
     */
    private String location;
    private int keyId;
    private String taskCode;
    private int state;
    private Timestamp crtDate;
    private Timestamp beginTime;
    private Timestamp endTime;
    private String detail;
    private int reTry;
    private int reTryMax;
    private String user;
    private String pwd;
    private int fixType;
    private String tmpTable;

    /**
     * @date 2019.09.22
     * @since 3.0.0
     */
    private String firstRegion;
    private String secRegion;

    @Override
    public String toString() {
        return "SysTask{" +
                "taskCode='" + taskCode + '\'' +
                ",keyId=" + keyId +
                ", state=" + state +
                ", crtDate=" + crtDate +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", detail='" + detail + '\'' +
                ", reTry=" + reTry +
                ", reTryMax=" + reTryMax +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", fixType=" + fixType +
                '}';
    }

    public String getTmpTable() {
        return tmpTable;
    }

    public void setTmpTable(String tmpTable) {
        this.tmpTable = tmpTable;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFixType() {
        return fixType;
    }

    public void setFixType(int fixType) {
        this.fixType = fixType;
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

    public int getReTryMax() {
        return reTryMax;
    }

    public void setReTryMax(int reTryMax) {
        this.reTryMax = reTryMax;
    }

    public int getReTry() {
        return reTry;
    }

    public void setReTry(int reTry) {
        this.reTry = reTry;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
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

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
