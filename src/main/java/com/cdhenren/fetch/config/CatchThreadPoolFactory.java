package com.cdhenren.fetch.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author Baopz
 * @date 2018/04/23
 * @since 1.0.0
 */
public class CatchThreadPoolFactory {

    protected static Map<String, ThreadPoolExecutor> poolExecutors = new HashMap<>(2 << 4);

    /**
     * @since 2.0.0
     * 得到线程池
     * @param key
     * @param threadName
     * @return
     */
    public static synchronized ThreadPoolExecutor getInstance(String key,String threadName) {
        return poolExecutors.computeIfAbsent(key, s->iniPoolExecutor(threadName));
    }

    /**
     * 这里的LinkedBlockingQueue与ArrayBlockingQueue区别
     **/
    private static ThreadPoolExecutor iniPoolExecutor(String threadName) {
        ThreadFactory threadNameFactory = new ThreadFactoryBuilder().setNameFormat(threadName+"%d").build();
        return new ThreadPoolExecutor(4,
                35,
                35L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                threadNameFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
