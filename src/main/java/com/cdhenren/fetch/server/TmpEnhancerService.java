package com.cdhenren.fetch.server;

import com.cdhenren.fetch.entity.SysTask;

import java.util.List;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public interface TmpEnhancerService {

    /**
     * 插入文件
     * @param sysTask 任务
     * @param list 数据
     */
    void insert(SysTask sysTask, List<Object> list);


}
