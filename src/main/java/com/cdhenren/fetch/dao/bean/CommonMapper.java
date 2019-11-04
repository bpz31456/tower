package com.cdhenren.fetch.dao.bean;

import com.cdhenren.fetch.entity.ResultSet;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
@Mapper
public interface CommonMapper {

    /**
     * 插入
     *
     * @param beanInsertStatementProvider
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    void insert(InsertStatementProvider<Object> beanInsertStatementProvider);
}
