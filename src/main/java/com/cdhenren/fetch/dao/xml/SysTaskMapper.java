package com.cdhenren.fetch.dao.xml;


import com.cdhenren.fetch.entity.SysTask;
import com.cdhenren.fetch.entity.SysTaskHis;
import com.cdhenren.fetch.entity.SysTaskPama;
import com.cdhenren.fetch.entity.enhancer.SysTableRelationship;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Baopz
 * @date 2018/04/23
 */
public interface SysTaskMapper {

    /**
     * 获取任务参数
     *
     * @return
     */
    List<SysTaskPama> taskPamas();

    /**
     * 插入到任务表中
     * @param sysTask
     * @return
     */
    int insertSysTask(SysTask sysTask);

    /**
     * 更新任务实例
     * @param sysTask
     * @return
     */
    int updateTask(SysTask sysTask);

    /**
     * 删除对应的任务记录
     * @param sysTask
     */
    void deleteSysTask(SysTask sysTask);

    /**
     * 插入历史表
     * @param sysTaskHis
     */
    void insertSysTaskHis(SysTaskHis sysTaskHis);

    /**
     * 获得任务列表任务
     * @return
     */
    List<SysTask> sysTasks();

    /**
     * 查询表字段信息
     * @param tableName 表名
     * @return
     */
    List<TableColumnInfo> queryTableColumnInfo(@Param("tableName") String tableName);

    /**
     * 查询当前连接的所有表名
     * @return
     */
    List<String> queryTableInfo();

    /**
     * 查询系统表关系
     * @param tableName
     * @return
     */
    List<SysTableRelationship> querySysTableRelationship(@Param("tableName") String tableName);
}
