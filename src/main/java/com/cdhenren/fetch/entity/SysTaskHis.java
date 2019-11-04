package com.cdhenren.fetch.entity;

import java.sql.Timestamp;

/**
 * @since 1.0.0
 * version 2.0.0 /2018.07.26
 * @author Baopz
 * @date 2018/04/23
 */
public class SysTaskHis {

    private String location;
    private int keyId;
    private String taskCode;
    private int state;
    private Timestamp crtDate;
    private Timestamp beginTime;
    private Timestamp endTime;
    private String detail;
    private String reTry;
    private int total;

    @Override
    public String toString() {
        return "SysTaskHis{" +
                "location='" + location + '\'' +
                ", keyId=" + keyId +
                ", taskCode='" + taskCode + '\'' +
                ", state=" + state +
                ", crtDate=" + crtDate +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", detail='" + detail + '\'' +
                ", reTry='" + reTry + '\'' +
                ", total=" + total +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getReTry() {
        return reTry;
    }

    public void setReTry(String reTry) {
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
