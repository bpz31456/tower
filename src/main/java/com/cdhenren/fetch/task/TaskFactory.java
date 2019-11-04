package com.cdhenren.fetch.task;

import com.cdhenren.fetch.driver.enhancer.AbstractDriverEnhancerTemplate;
import com.cdhenren.fetch.entity.TaskWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Semaphore;

/**
 * @author Fuhj
 */
final class TaskFactory {
    private static Logger logger = LoggerFactory.getLogger(TaskFactory.class);
    private static String regex = "com.cdhenren.fetch.driver.\\w+.\\w+Driver";

    /**
     * 暂时不用从数据库加载class文件的classLoader方式
     *
     * @param taskWrap
     * @param semaphore
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    static Runnable createEnhancerTask(TaskWrap taskWrap, Semaphore semaphore) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //替换新的任务
        replace2TaskEnhancerType(taskWrap);
        Class clazz = taskWrap.getTaskType().getClazz();
        Constructor<AbstractDriverEnhancerTemplate> driverConstructor
                = clazz.getConstructor(new Class[]{TaskWrap.class, Semaphore.class});
        return driverConstructor.newInstance(taskWrap, semaphore);
    }

    /**
     * cglib动态代理到新的类当中，改变taskWrap的TaskTypeDriver
     *
     * @param taskWrap 原始类型
     */
    private static void replace2TaskEnhancerType(TaskWrap taskWrap) {
        logger.debug("执行替换任务。");
        try {
            Class<?> newClass = typeFilter(taskWrap.getTaskType().getClazz());
            taskWrap.getTaskType().setClazz(newClass);
        } catch (ClassNotFoundException e) {
            //ignore
            logger.warn("com.cdhenren.fetch.task.TaskTypeComparison中没有发现增强类。");
        }
    }

    /**
     * 得到应有的类型
     *
     * @param aClass
     * @return
     * @throws ClassNotFoundException
     */
    private static Class<?> typeFilter(Class aClass) throws ClassNotFoundException {
        String oldClazzName = aClass.getName();
        String newClazzName;
        logger.debug("需要替换的oldClazz:{}", oldClazzName);
        //原始驱动配置
        if (oldClazzName.matches(regex)) {
            newClazzName = TaskTypeComparison.getProxy(aClass);
        } else {
            logger.debug("没有替换的class");
            return aClass;
        }
        logger.debug("替换后新的class:{}", newClazzName);
        return Thread.currentThread().getContextClassLoader().loadClass(newClazzName);
    }
}