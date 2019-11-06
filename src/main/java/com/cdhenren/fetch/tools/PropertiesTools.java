package com.cdhenren.fetch.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author baopz
 * @date 2018.07.09
 */
public final class PropertiesTools {
    private static Logger logger = LoggerFactory.getLogger(PropertiesTools.class);
    private volatile static Properties prop;

    private static String getProperty(String config, String key, String superAddition) {
        if (prop == null) {
            getProperties(config);
        }
        String s;
        synchronized (PropertiesTools.class) {
            s = prop.getProperty(key);
            if (superAddition != null) {
                s += superAddition;
            }
        }
        return s;
    }

    /**
     * 得到配置参数
     *
     * @param config
     * @param key
     * @return
     */
    public static String getProperty(String config, String key) {
        return getProperty(config, key, null);
    }

    /**
     * 得到配置信息
     * @param config
     * @return
     */
    public static Properties getProperties(String config){
        synchronized (PropertiesTools.class) {
            if (prop == null) {
                prop = new Properties();
                InputStream inputStream = null;
                inputStream = PropertiesTools.class.getClassLoader().getResourceAsStream(config);
                if (inputStream == null) {
                    logger.warn("没有发现配置文件。{}", config);
                    return null;
                }
                try {
                    prop.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("读取文件未知错误.{}", e);
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("关闭文件出错");
                    }
                }
            }
        }
        return prop;
    }
}
