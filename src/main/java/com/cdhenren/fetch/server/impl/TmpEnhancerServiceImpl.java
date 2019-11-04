package com.cdhenren.fetch.server.impl;

import com.cdhenren.fetch.dao.bean.CommonMapper;
import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.SysTask;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import com.cdhenren.fetch.server.TmpEnhancerService;
import com.cdhenren.fetch.tools.DbUtils;
import com.cdhenren.fetch.tools.DynamicSqlUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Fuhj
 */
public class TmpEnhancerServiceImpl implements TmpEnhancerService {
    @Override
    public void insert(SysTask sysTask, List<Object> list) {
        List<TableColumnInfo> tableColumnInfos = DbUtils.getTableColumns(sysTask.getLocation(), sysTask.getTmpTable());
        MyBatisUtil.setLocation(sysTask.getLocation());
        SqlSession sqlSession = MyBatisUtil.getSession(ExecutorType.BATCH);
        CommonMapper mapper = sqlSession.getMapper(CommonMapper.class);
        DynamicSqlUtils.batchInsert(list, sysTask.getTmpTable(), tableColumnInfos)
                .insertStatements().forEach(mapper::insert);
        sqlSession.commit();
        MyBatisUtil.closeSession(sqlSession);
    }
}
