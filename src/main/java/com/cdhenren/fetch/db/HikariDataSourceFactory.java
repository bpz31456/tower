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
    private Properties props;
    @Override
    public void setProperties(Properties properties) {
        props = properties;
        log.info("HikariCP数据库连接池参数配置");
        properties.forEach((o, o2) -> log.debug("参数设置:{}={}",o,o2));
    }

    @Override
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(this.props.getProperty("url"));
        dataSource.setUsername(this.props.getProperty("username"));
        dataSource.setPassword(this.props.getProperty("password"));
        return dataSource;
    }
}
