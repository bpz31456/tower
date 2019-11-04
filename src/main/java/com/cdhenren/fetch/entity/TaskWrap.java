package com.cdhenren.fetch.entity;

import com.cdhenren.fetch.task.TaskType;

import java.util.Objects;

/**
 * @author Baopz
 * @date 2018/04/23
 */
public class TaskWrap {
    private TaskType taskType;
    private SysTask sysTask;

    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskWrap taskWrap = (TaskWrap) o;
        return sysTask.equals(taskWrap.sysTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysTask);
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskWrap(SysTask sysTask, TaskType taskType) {
        this.sysTask = sysTask;
        this.taskType = taskType;
    }


    public SysTask getSysTask() {
        return sysTask;
    }

    public void setSysTask(SysTask sysTask) {
        this.sysTask = sysTask;
    }

    @Override
    public String toString() {
        return "TaskWrap{" +
                "sysTask=" + sysTask +
                ",taskType=" + taskType +
                '}';
    }
}
