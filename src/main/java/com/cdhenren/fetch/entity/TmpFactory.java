package com.cdhenren.fetch.entity;

import com.cdhenren.fetch.task.TaskType;

/**
 * @author Baopz
 * @date 2018/05/24
 */
public class TmpFactory {
    public static TaskWrap getTmp(String sysTaskCode) {
        SysTask sysTask = getSysTask(sysTaskCode);
        TaskType taskType = getTaskType(sysTaskCode);
        return new TaskWrap(sysTask, taskType);
    }

    private static TaskType getTaskType(String sysTaskCode) {
        TaskType[] taskTypes = TaskType.values();
        for(int i = 0; i< taskTypes.length; i++){
            if(taskTypes[i].name().contains(sysTaskCode)){
                return taskTypes[i];
            }
        }
        return null;
    }


    //DCM_COLKSITE
    private static SysTask getSysTask(String systaskCode) {
        SysTask sysTask = new SysTask();
        sysTask.setKeyId(-1);
        sysTask.setDetail("");
        sysTask.setEndTime(null);
        sysTask.setFixType(1);
        sysTask.setUser("wangrf");
        sysTask.setPwd("ffjj1314.");
        sysTask.setTaskCode(systaskCode);
        return sysTask;
    }
}
