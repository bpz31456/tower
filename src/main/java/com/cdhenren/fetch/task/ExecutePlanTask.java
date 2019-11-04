package com.cdhenren.fetch.task;

import com.cdhenren.fetch.config.CatchThreadPoolFactory;
import com.cdhenren.fetch.config.TaskQueueFactory;
import com.cdhenren.fetch.driver.AbstractDriverTemplate;
import com.cdhenren.fetch.entity.TaskWrap;
import org.apache.http.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * queue -> executePool,execute
 *
 * @author baopz
 * @since 1.0.0
 * version2.0.0 /2018.07.27
 * 执行采集计划
 */
public class ExecutePlanTask implements Runnable {
    private Logger logger = LoggerFactory.getLogger(ExecutePlanTask.class);
    /**
     * 控制每个线程池中的并行线程数量
     */
    private int concurrenceThreads;
    private Map<String, Semaphore> semaphores;

    public ExecutePlanTask(int concurrenceThreads) {
        this.concurrenceThreads = concurrenceThreads;
        this.semaphores = new HashMap<>(2 << 4);
    }

    @Override
    public void run() {
        for (String key : TaskQueueFactory.getKeys()) {
            BlockingQueue<TaskWrap> queue = TaskQueueFactory.getInstance(key);
            assert queue != null;
            TaskWrap taskWrap = queue.poll();
            if (taskWrap != null) {
                ThreadPoolExecutor threadPool =  CatchThreadPoolFactory.getInstance("任务队列分发","任务队列分发");
                threadPool.execute(() -> {
                    execute(taskWrap);
                });
            }
        }
    }

    /**
     * 每个区域获取一个线程池
     * @param taskWrap
     */
    private void execute(TaskWrap taskWrap) {
        //根据地区来开启线程池，每个线程池对应一个semaphore
        String location = taskWrap.getSysTask().getLocation();
        //根据location得到的threadPool
        ThreadPoolExecutor threadPool = CatchThreadPoolFactory.getInstance(location, "数据获取_" + location + "_");
        //每个location对应的semaphore
        Semaphore semaphore = getSemaphore(location);
        AbstractDriverTemplate abstractDriverTemplate = null;
        try {
            logger.debug("task_type:{}", taskWrap.getTaskType());
            Class driver = taskWrap.getTaskType().getClazz();
            Asserts.check(driver != null, TaskType.class.getName() + "任务类型没有添加到枚举.");
            Constructor[] constructors = driver.getConstructors();
            Asserts.check(constructors.length == 2, "类型" + driver.getName() + "public构造函数数量不为2个带参函数。");
            Constructor<AbstractDriverTemplate> constructor = driver.getConstructor(new Class[]{TaskWrap.class, Semaphore.class});
            abstractDriverTemplate = constructor.newInstance(taskWrap, semaphore);
        } catch (NoSuchMethodException e) {
            logger.error("检测TaskType是否配置相应的driver。{}", e);
        } catch (ReflectiveOperationException e) {
            logger.error("{}", e);
        }

        logger.info(location+"等待队列长度{},提交到线程池。{}", Objects.requireNonNull(TaskQueueFactory.getInstance(location)).size() + 1, taskWrap);
        if (abstractDriverTemplate != null) {
            threadPool.execute(abstractDriverTemplate);
        }
    }

    protected Semaphore getSemaphore(String locationOrName){
       return semaphores.computeIfAbsent(locationOrName, s -> new Semaphore(concurrenceThreads));
    }
}
