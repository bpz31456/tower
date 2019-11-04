package com.cdhenren.fetch.task;

import com.cdhenren.fetch.config.SingleThreadPoolFactory;
import com.cdhenren.fetch.config.TaskQueueFactory;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.group.SessionFactory;
import com.cdhenren.fetch.group.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 新增Session(是否同一个账号)，Region(是否同一个子系统)
 * version 3.0.0
 * queue -> executePool,execute
 *
 * @author Fuhj
 */
public class ExecutePlanEnhancerTask extends ExecutePlanTask {

    private Logger logger = LoggerFactory.getLogger(ExecutePlanEnhancerTask.class);

    public ExecutePlanEnhancerTask(int concurrenceThreads) {
        super(concurrenceThreads);
    }

    @Override
    public void run() {
        //构造Session分组
        sessionGroup();
        //每个Session构造一个单线程池
        logger.info("每个user为一个线程池，当前线程池数量：{}", SessionManager.getKeys().size());

        for (String user : SessionManager.getKeys()) {
            ThreadPoolExecutor threadPoolExecutor = SingleThreadPoolFactory.shareSingleThread("["+user + "]Session");
            Semaphore semaphore = getSemaphore(user);
            //分组添加任务到各个单线程池中执行任务
            BlockingQueue<TaskWrap> workers = TaskQueueFactory.getInstance(user);
            TaskWrap tmp;
            if (workers == null || workers.size() == 0) {
                return;
            }
            while ((tmp = workers.poll()) != null) {
                try {
                    threadPoolExecutor.execute(
                            TaskFactory.createEnhancerTask(tmp, semaphore)
                    );
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sessionGroup() {
        for (String location : MyBatisUtil.getRegionals()) {
            BlockingQueue<TaskWrap> queue = TaskQueueFactory.getInstance(location);
            if (queue == null) {
                break;
            }

            TaskWrap taskWrap;
            while ((taskWrap = queue.poll()) != null) {
                SessionManager.addSession(SessionFactory.getInstance(taskWrap));
                if (!Objects.requireNonNull(TaskQueueFactory.getInstance(taskWrap.getSysTask().getUser())).contains(taskWrap)) {
                    Objects.requireNonNull(TaskQueueFactory.getInstance(taskWrap.getSysTask().getUser())).offer(taskWrap);
                }
            }
        }
    }
}
