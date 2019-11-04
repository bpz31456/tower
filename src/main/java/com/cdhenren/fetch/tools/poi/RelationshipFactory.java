package com.cdhenren.fetch.tools.poi;

import com.cdhenren.fetch.entity.enhancer.SysTableRelationship;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import com.cdhenren.fetch.tools.DbUtils;
import com.cdhenren.fetch.tools.DynamicSqlUtils;
import com.cdhenren.fetch.tools.TableColumnInfoInterceptor;

import java.util.List;
import java.util.Map;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public final class RelationshipFactory {

    public static Relationship generator(String region, String tableName, TableColumnInfoInterceptor ... interceptors) {
        List<TableColumnInfo> tableColumnInfos = DbUtils.getTableColumns(region, tableName);
        //构造属性
        Map<String, Class> map = DynamicSqlUtils.propertiesGenerator(tableColumnInfos,interceptors);
        //对照关系
        List<SysTableRelationship> relationships = DbUtils.getRelationships(region, tableName);
        Relationship relationship = new Relationship();
        relationship.setPropertiesMap(map);
        relationship.setRelationships(relationships);
        return relationship;
    }
}
