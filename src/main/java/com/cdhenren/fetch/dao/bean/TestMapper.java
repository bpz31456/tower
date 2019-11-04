package com.cdhenren.fetch.dao.bean;

import com.cdhenren.fetch.entity.enhancer.TestBean;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

/**
 * 测试用的结构
 *
 * @author Fuhj
 */
@Mapper
public interface TestMapper {
    /**
     * 保存测试Bean
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    void insert(InsertStatementProvider<TestBean> testBeanInsertStatementProvider);

}
