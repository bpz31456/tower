package com.cdhenren.fetch.db;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * SqlSessionFactory的多例模式
 *
 * @author baopz
 * @since 2.0.0
 */
public class SqlSessionFactoryManager {
    private static Logger logger = LoggerFactory.getLogger(SqlSessionFactoryManager.class);
    private static Map<String, String[]> regionalConfigs = new HashMap<>(1<<4);
    private static Map<String, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>(1<<4);
    static String[] regionals = null;
    private static String[] originals = new String[]{"jdbc.?.driverClassName", "jdbc.?.url", "jdbc.?.username", "jdbc.?.password"};

    static {
        Properties properties = null;
        try {
            properties = Resources.getResourceAsProperties("tower.properties");
            regionals = properties.getProperty("regional").split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("regionals参数长度{}", regionals.length);
        if (regionals == null || regionals.length == 0) {
            logger.error("tower.properties中regional参数不能为空。");
        }
        for (String regional : regionals) {
            List<String> regionalConfig = new ArrayList<>();
            for (String original : originals) {
                regionalConfig.add(original.replace("?", regional));
            }
            List<String> cleared = new ArrayList<>();
            for (String key : regionalConfig) {
                assert properties != null;
                if (StringUtils.isEmpty(properties.getProperty(key))){
                    cleared.add(key);
                }
            }
            regionalConfig.removeAll(cleared);
            regionalConfigs.put(regional, regionalConfig.toArray(new String[0]));
        }
        //初始化
        initSqlSessionFactoryMap();
    }

    private static void initSqlSessionFactoryMap() {
        logger.debug("进入SqlSessionFactory初始化");
        for (String regional : regionals) {
            String configSource = "mybatis.xml";
            SqlSessionFactory sqlSessionFactory = getRegionalInputStreamAsSource(configSource, regionalConfigs.get(regional));
            logger.debug("完成一次构建");
            sqlSessionFactoryMap.put(regional, sqlSessionFactory);
        }
        logger.debug("sqlSessionFactoryMap长度{}", sqlSessionFactoryMap.size());
    }

   public static SqlSessionFactory getSqlSessionFactory(String regional) {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryMap.get(regional);
        if (sqlSessionFactory == null) {
            logger.warn("获取sqlSessionFactory为空,查询地区{}", regional);
        }
        return sqlSessionFactory;
    }

    private static SqlSessionFactory getRegionalInputStreamAsSource(String source, String[] configs) {
        logger.debug("根据mybatis配置文件，构造需要的配置信息，并返回SqlSessionFactory");
        SqlSessionFactory sqlSessionFactory = null;
        try {
            StringBuilder stringBuilder = getStringBuilder(source, configs);
            if (stringBuilder.length() != 0) {
                String configInfo = stringBuilder.toString();
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(new ByteArrayInputStream(configInfo.getBytes()));
                logger.debug("是否爲空sqlSessionFactory{}", sqlSessionFactory);
            }
        } catch (IOException e) {
            logger.error("异常情况{}", e.getMessage());
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    private static StringBuilder getStringBuilder(String source, String[] configs) throws IOException {
        try (
                InputStream inputStream = Resources.getResourceAsStream(source);
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            String line;
            StringBuilder stringBuilder = new StringBuilder(1024);
            while ((line = bufferedReader.readLine()) != null) {
                //驱动
                if (line.contains("${jdbc.driverClassName}")) {
                    for (String s : configs) {
                        if (s.contains("driverClassName")) {
                            line = line.replace("jdbc.driverClassName", s);
                            break;
                        }
                    }
                }
                //url
                if (line.contains("${jdbc.url}")) {
                    for (String s : configs) {
                        if (s.contains("url")) {
                            line = line.replaceAll("jdbc.url", s);
                            break;
                        }
                    }
                }
                //username
                if (line.contains("${jdbc.username}")) {
                    for (String s : configs) {
                        if (s.contains("username")) {
                            line = line.replaceAll("jdbc.username", s);
                            break;
                        }
                    }
                }
                //password
                if (line.contains("${jdbc.password}")) {
                    for (String s : configs) {
                        if (s.contains("password")) {
                            line = line.replaceAll("jdbc.password", s);
                            break;
                        }
                    }
                }
                stringBuilder.append(line);
            }
            return stringBuilder;
        }
    }
}
