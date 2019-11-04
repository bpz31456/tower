package com.cdhenren.fetch.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Baopz
 * @date 2018/04/24
 * version.2.0.0,/2018.07.26修改之前版本的单配置文件获取
 * @since 1.0.0
 */
public class MyBatisUtil {

    /**
     * 线程里面缓存地市编号
     */
    private static ThreadLocal<String> locationThreadLocal = new ThreadLocal<>();
    private static Logger logger = LoggerFactory.getLogger(MyBatisUtil.class);

    /**
     * @since 1.0.0
     * version 2.0.0/2018.07.26
     * 创建连接
     */
    public synchronized static SqlSession getSession() {
        String location = getLocation();
        if (location != null) {
            return getSession(location);
        }
        return null;
    }

    public static synchronized void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }

    /**
     * @since 2.0.0
     * 得到所有配置的地区
     * @return
     */
    public static String[] getRegionals(){
        String[] regionals = SqlSessionFactoryManager.regionals;
        if(regionals==null || regionals.length==0){
            logger.error("regionals不能为空");
        }
        return regionals;
    }

    /**
     * @param location
     * @return
     * @since 2.0.0
     */
    public static SqlSession getSession(String location) {
        return SqlSessionFactoryManager.getSqlSessionFactory(location).openSession();
    }

    /**
     * @since 2.0.0
     * @param location
     */
    public static void setLocation(String location){
        locationThreadLocal.set(location);
    }

    /**
     * @since 2.0.0
     * @return
     */
    public static String getLocation(){
        return locationThreadLocal.get();
    }

    /**
     * 执行模式version1.1.5
     * @param executeModelBatch
     * @return
     */
    public static SqlSession getSession(ExecutorType executeModelBatch) {
        return SqlSessionFactoryManager
                .getSqlSessionFactory(MyBatisUtil.getLocation())
                .openSession(executeModelBatch);
    }
}
