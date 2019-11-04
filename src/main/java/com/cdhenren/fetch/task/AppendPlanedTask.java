package com.cdhenren.fetch.task;

import com.cdhenren.fetch.config.TaskQueueFactory;
import com.cdhenren.fetch.entity.SysTask;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * sys-task -> queue
 *
 * @author Baopz
 * @date 2018/05/16
 */
public class AppendPlanedTask implements Runnable {
    Logger logger = LoggerFactory.getLogger(AppendPlanedTask.class);
    private BlockingQueue<TaskWrap> workBlockingQueue;
    private SysTaskService sysTaskService;

    public AppendPlanedTask() {
        sysTaskService = new SysTaskServiceImpl();
    }

    @Override
    public void run() {
        logger.info("任务表数据轮询。");
        List<SysTask> sysTasks = null;
        try {
            sysTasks = sysTaskService.sysTasks();
        } catch (Exception e) {
            logger.error("异常状态：{}", e);
        }
        assert sysTasks != null;

        //version1.1.2当前查询出来的任务中是否包含多种类型的任务，如果是，则抛弃CALL_PROCESS任务，等待下一次查询
        for (SysTask sysTask : sysTasks) {
            TaskType taskType = getTaskType(sysTask);
            if (sysTask.getState() == SysTask.STATE_0) {
                try {
                    if (taskType == null) {
                        sysTask.setState(SysTask.STATE_2);
                        sysTask.setReTry(sysTask.getReTryMax());
                        sysTask.setDetail("操作类型未设置,需要在com.cdhenren.fetch.task.TaskType设置任务编码对应关系.");
                        sysTaskService.updateTask(new TaskWrap(sysTask, null), null);
                        break;
                    }
                    sysTask.setState(SysTask.STATE_1);
                    sysTaskService.updateTask(new TaskWrap(sysTask, taskType), null);
                    workBlockingQueue = TaskQueueFactory.getInstance(sysTask.getLocation());
                    workBlockingQueue.put(new TaskWrap(sysTask, taskType));
                    logger.info("任务表数据{}添加成功。队列长度{}", sysTask, workBlockingQueue.size());
                } catch (Exception e) {
                    logger.error("{}", e);
                    sysTask.setDetail("任务加入队列失败。");
                    logger.error("没有放入任务队列中。{}", sysTask);
                    sysTask.setState(SysTask.STATE_2);
                    sysTask.setEndTime(new Timestamp(System.currentTimeMillis()));
                    try {
                        sysTaskService.updateTask(new TaskWrap(sysTask, taskType), null);
                    } catch (Exception e1) {
                        logger.error("{}", e1);
                    }
                }
            }
        }
    }

    /**
     * @param sysTasks
     * @return
     * @since 1.1.2
     */
    private List<SysTask> clearTasks(List<SysTask> sysTasks) {
        List<SysTask> callTasks = new ArrayList<>(sysTasks.size());
        List<SysTask> nonCallTasks = new ArrayList<>(sysTasks.size());
        for (SysTask sysTask : sysTasks) {
            TaskType taskType = getTaskType(sysTask);
            if (taskType == TaskType.CALL_PROCESS) {
                callTasks.add(sysTask);
            } else {
                nonCallTasks.add(sysTask);
            }
        }
        if (nonCallTasks.isEmpty()) {
            return callTasks;
        }
        return nonCallTasks;
    }

    private TaskType getTaskType(SysTask sysTask) {
        switch (sysTask.getFixType()) {
            case SysTask.FIX_TYPE_1: {
                for (TaskType taskType : TaskType.values()) {
                    if (taskType.name().equals(sysTask.getTaskCode())) {
                        return taskType;
                    }
                }
                break;
            }
            case SysTask.FIX_TYPE_2:
            case SysTask.FIX_TYPE_3: {
                return TaskType.CALL_PROCESS;
            }
            default:
                break;
        }
        return null;
    }
}
