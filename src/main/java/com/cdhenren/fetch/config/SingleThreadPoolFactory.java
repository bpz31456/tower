package com.cdhenren.fetch.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Baopz
 * @date 2018/05/04
 */
public class SingleThreadPoolFactory {

    private static Map<String, ThreadPoolExecutor> shareThreads = new HashMap<>();

    public static synchronized ThreadPoolExecutor shareSingleThread(String nameFormat) {
        ThreadPoolExecutor singleThreadPool = shareThreads.get(nameFormat);
        if (singleThreadPool == null) {
            ThreadFactory threadNameFactory = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                    1,
                    20L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(1<<10),
                    threadNameFactory,
                    new ThreadPoolExecutor.AbortPolicy());
            shareThreads.put(nameFormat, poolExecutor);
        }
        return shareThreads.get(nameFormat);
    }
}
