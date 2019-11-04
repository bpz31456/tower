package com.cdhenren.fetch.tools;

import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.insert.BatchInsertDSL;
import org.mybatis.dynamic.sql.insert.render.BatchInsert;
import org.mybatis.dynamic.sql.render.RenderingStrategies;

import java.sql.Date;
import java.sql.JDBCType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.insert;

/**
 * @author Fuhj
 */
public final class DynamicSqlUtils {

    /**
     * @param records   数据
     * @param tableName 表名
     * @param columns   字段
     * @return batchInsert
     */
    public static BatchInsert<Object> batchInsert(Collection<Object> records,
                                                  String tableName,
                                                  List<TableColumnInfo> columns,
                                                  TableColumnInfoInterceptor... interceptors) {
        if (tableName == null || "".equals(tableName)) {
            throw new IllegalArgumentException("表名不能为空。");
        }
        if (columns == null || columns.isEmpty()) {
            throw new IllegalArgumentException("属性名不能为空。");
        }
        SqlTable sqlTable = SqlTable.of(tableName);
        BatchInsertDSL<Object> into = insert(records).into(sqlTable);
        columns.forEach(column -> {
            if (interceptors == null || interceptors.length == 0) {
                SqlColumn<Object> col = sqlTable.column(column.getColumnName(), jdbcType(column.getDataType()));
                into.map(col).toProperty(column.getColumnName());
            } else {
                for (TableColumnInfoInterceptor interceptor : interceptors) {
                    if (interceptor.isPass(column.getColumnName())) {
                        SqlColumn<Object> col = sqlTable.column(column.getColumnName(), jdbcType(column.getDataType()));
                        into.map(col).toProperty(column.getColumnName());
                    }
                }
            }
        });
        return into.build().render(RenderingStrategies.MYBATIS3);
    }

    public static Map<String, Class> propertiesGenerator(List<TableColumnInfo> tableColumnInfos, TableColumnInfoInterceptor... interceptors) {
        Map<String, Class> properties = new HashMap<>(1 << 5);
        tableColumnInfos.forEach(tableColumnInfo -> {
            if (interceptors == null || interceptors.length == 0) {
                properties.put(tableColumnInfo.getColumnName(), javaType(tableColumnInfo.getDataType()));
            } else {
                for (TableColumnInfoInterceptor interceptor : interceptors) {
                    if (interceptor.isPass(tableColumnInfo.getColumnName())) {
                        properties.put(tableColumnInfo.getColumnName(), javaType(tableColumnInfo.getDataType()));
                    }
                }
            }
        });
        return properties;
    }

    private static Class javaType(String dataType) {
        Class clazz = String.class;
        switch (dataType) {
            case "int":
                clazz = Integer.class;
                break;
            case "varchar":
                break;
            case "timestamp":
            case "datetime":
                clazz = Date.class;
                break;
            case "double":
                clazz = Double.class;
                break;
            default:
        }
        return clazz;
    }

    private static JDBCType jdbcType(String dataType) {
        JDBCType jdbcType = JDBCType.VARCHAR;
        switch (dataType) {
            case "int":
                jdbcType = JDBCType.INTEGER;
                break;
            case "varchar":
                break;
            case "timestamp":
            case "datetime":
                jdbcType = JDBCType.DATE;
                break;
            case "double":
                jdbcType = JDBCType.DOUBLE;
                break;
            default:
        }
        return jdbcType;
    }
}
