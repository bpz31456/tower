package com.cdhenren.fetch.tools;

import com.cdhenren.fetch.entity.enhancer.SysTableRelationship;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public class DbUtils {

    /**
     * 所有表名
     */
    private static Map<String, List<String>> tables = new ConcurrentHashMap<>(1 << 5);

    /**
     * region,table,table_column
     */
    private static Map<String, Map<String, List<TableColumnInfo>>> tableColumnMap =
            new ConcurrentHashMap<>(1 << 5);

    /**
     * region,table,relationship
     */
    private static Map<String, Map<String, List<SysTableRelationship>>> relationships =
            new ConcurrentHashMap<>(1 << 5);

    /**
     * 获取表名
     *
     * @param region
     * @return
     */
    private synchronized static List<String> getTables(String region) {
        List<String> regionTables = tables.get(region);
        if (regionTables == null) {
            SysTaskService sysTaskService = new SysTaskServiceImpl();
            tables.put(region, sysTaskService.queryTableInfo(region));
        }
        return tables.get(region);
    }

    /**
     * 关系对照
     *
     * @param region
     * @param tableName
     * @return
     */
    public synchronized static List<SysTableRelationship> getRelationships(String region, String tableName) {
        relationships.putIfAbsent(region, new ConcurrentHashMap<>(1 << 5));
        Map<String, List<SysTableRelationship>> relationshipsMap = relationships.get(region);

        List<SysTableRelationship> relationships = relationshipsMap.get(tableName);
        if (relationships == null) {
            SysTaskService sysTaskService = new SysTaskServiceImpl();
            List<String> tables = getTables(region);
            tables.forEach(tb -> {
                List<SysTableRelationship> relationship = sysTaskService.querySysTableRelationship(region, tb);
                relationshipsMap.putIfAbsent(tb, relationship);
            });
        }
        return relationshipsMap.get(tableName);
    }

    public synchronized static List<TableColumnInfo> getTableColumns(String region, String tableName) {
        tableColumnMap.putIfAbsent(region, new ConcurrentHashMap<>(1 << 5));
        Map<String, List<TableColumnInfo>> regionTableColumnMap = tableColumnMap.get(region);

        List<TableColumnInfo> tbColumnInfos = regionTableColumnMap.get(tableName);
        if (tbColumnInfos == null) {
            SysTaskService sysTaskService = new SysTaskServiceImpl();
            List<String> tables = getTables(region);
            tables.forEach(tb -> {
                List<TableColumnInfo> tableColumnInfos = sysTaskService.queryTableColumnInfo(region, tb);
                regionTableColumnMap.putIfAbsent(tb, tableColumnInfos);
            });
        }
        return regionTableColumnMap.get(tableName);
    }
}