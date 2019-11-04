package com.cdhenren.fetch.config;


import com.cdhenren.fetch.entity.TaskWrap;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 贯穿所有线程池的共享区域，通过blockingQueue来保证线程安全
 * @author Baopz
 * @date 2018/04/23
 */
public final class TaskQueueFactory {
    private static Map<String, BlockingQueue<TaskWrap>> queues = new HashMap<>(1<<3);

    private TaskQueueFactory() {
    }

    public static synchronized Set<String> getKeys() {
        return queues.keySet();
    }

    public static synchronized BlockingQueue<TaskWrap> getInstance(String locationOrName) {
        if (StringUtils.isEmpty(locationOrName)) {
            return null;
        }
        return queues.computeIfAbsent(locationOrName, s -> new LinkedBlockingQueue<>(1<<10));
    }

    public static synchronized void removeByKey(String key){
        queues.remove(key);
    }
}
