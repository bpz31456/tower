package com.cdhenren.fetch.db;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * HikariC数据库连接池
 * https://github.com/brettwooldridge/HikariCP
 * @author Fuhj
 * @date 2019.11.04
 */
@Slf4j
public class HikariDataSourceFactory extends PooledDataSourceFactory {
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        log.info("HikariCP数据库连接池参数配置");
    }

    @Override
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }
}
