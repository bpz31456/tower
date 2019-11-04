package com.cdhenren.fetch.server;


import com.cdhenren.fetch.entity.*;
import com.cdhenren.fetch.entity.enhancer.SysTableRelationship;
import com.cdhenren.fetch.entity.enhancer.TableColumnInfo;

import java.util.List;

/**
 * @author Baopz
 * @date 2018/04/23
 */
public interface SysTaskService {

    /**
     * 任务查询
     * @return
     */
    List<SysTask> sysTasks() throws Exception;

    /**
     * 获取任务参数
     *
     * @return
     */
    List<SysTaskPama> taskPamas()throws Exception;

    /**
     * 历史任务
     * @return
     */
    List<SysTaskHis> taskHis()throws Exception;

    /**
     * 插入完成的
     * @param sysTaskHis
     */
    void insertCompletedTask(SysTaskHis sysTaskHis)throws Exception;

    /**
     * 更新task
     * @param sysTask
     * @param resultSet
     * @return
     */
    int updateTask(TaskWrap sysTask, Object resultSet)throws Exception;

    /**
     * 插入到任务表中
     * @param sysTask
     * @return
     */
    int insertSysTask(SysTask sysTask)throws Exception;

    /**
     * 查询表字段信息
     * @param tableName 表名
     * @param region 区域
     * @return
     */
    List<TableColumnInfo> queryTableColumnInfo(String region,String tableName);

    /**
     * 查询当前连接的所有表名
     * @param region 区域
     * @return
     */
    List<String> queryTableInfo(String region);

    /**
     * 查询表列对应关系
     * @param tableName 表名
     * @return
     */
    List<SysTableRelationship> querySysTableRelationship(String region,String tableName);
}
