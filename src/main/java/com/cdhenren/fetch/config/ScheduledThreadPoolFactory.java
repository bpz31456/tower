package com.cdhenren.fetch.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Baopz
 * @date 2018/04/24
 */
public class ScheduledThreadPoolFactory {

    private static Map<String,ScheduledExecutorService> scheduledExecutorServiceMap = new ConcurrentHashMap<>(2);

    /**
     * 定时器线程%d
     * @param nameFormat
     * @return
     */
    public static synchronized ScheduledExecutorService getInstance(String nameFormat) {
        ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceMap.get(nameFormat);
        if (scheduledExecutorService == null) {
            //定时器线程池
            ThreadFactory scheduledNameFactory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
            scheduledExecutorService = new ScheduledThreadPoolExecutor(1, scheduledNameFactory, new ThreadPoolExecutor.AbortPolicy());
            scheduledExecutorServiceMap.put(nameFormat,scheduledExecutorService);
        }
        return scheduledExecutorService;
    }
}
