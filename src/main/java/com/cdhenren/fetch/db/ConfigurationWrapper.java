package com.cdhenren.fetch.db;

import org.apache.ibatis.session.Configuration;

/**
 * Configuration的包装类
 * @author baopz
 */
public class ConfigurationWrapper implements Cloneable{
    private Configuration configuration;

    public ConfigurationWrapper(Configuration configuration){
        try {
            Object o =  clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        this.configuration = configuration;
    }

}
