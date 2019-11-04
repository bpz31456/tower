package com.cdhenren.fetch;

import com.cdhenren.fetch.config.ScheduledThreadPoolFactory;
import com.cdhenren.fetch.config.SingleThreadPoolFactory;
import com.cdhenren.fetch.task.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/04/24
 * @since 1.0.0
 * version 2.0.0
 */
public class FetchApplication {
    private static Logger logger = LoggerFactory.getLogger(FetchApplication.class);

    public static void main(String[] args) {
        int concurrenceThreads = 1;
        assert args != null;
        for (String arg : args) {
            if (arg.contains("threads")) {
                try {
                    concurrenceThreads = Integer.valueOf(arg.split("=")[1]);
                } catch (NumberFormatException e) {
                    logger.warn("并行线程数threads类型转化失败{}", e.getMessage());
                }
                break;
            }
        }

        ThreadPoolExecutor silent = SingleThreadPoolFactory.shareSingleThread("静默线程%d");
        silent.execute(new SilentTask());

        //产生任务，添加到任务表中,sys_task_pama -> sys_task
        ScheduledExecutorService generateScheduledExecutor = ScheduledThreadPoolFactory.getInstance("sys_task_pama -> sys_task %d");
        generateScheduledExecutor.scheduleWithFixedDelay(new GeneratePlanedTask(), 0L, 60, TimeUnit.SECONDS);

        //获取任务,添加到任务队列中 sys-task -> queue
        ScheduledExecutorService appendScheduledExecutor = ScheduledThreadPoolFactory.getInstance("sys_task -> queue %d");
        appendScheduledExecutor.scheduleWithFixedDelay(new AppendPlanedTask(), 0L, 30, TimeUnit.SECONDS);

        //执行任务,queue -> executePool
        ScheduledExecutorService planExecutor = ScheduledThreadPoolFactory.getInstance("queue -> executePool %d");
        planExecutor.scheduleWithFixedDelay(new ExecutePlanEnhancerTask(1), 0L, 10, TimeUnit.SECONDS);
    }
}
