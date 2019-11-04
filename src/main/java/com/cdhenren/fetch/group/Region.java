package com.cdhenren.fetch.group;

import com.cdhenren.fetch.entity.SysTask;

/**
 * 同一个子系统
 *
 * @author Fuhj
 * version 3.0.0
 */
public class Region {
    private TaskRegion curRegion;
    private boolean enter;
    private Region subRegion;

    public Region(TaskRegion taskRegion,boolean enter) {
        this.curRegion = taskRegion;
        this.enter = enter;
    }
    public Region getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(Region subRegion) {
        this.subRegion = subRegion;
    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public boolean isCurRegion(String region){
       return curRegion.name().equals(region);
    }

    public TaskRegion getCurRegion() {
        return curRegion;
    }
}
