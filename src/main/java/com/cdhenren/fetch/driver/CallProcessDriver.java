package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.db.MyBatisUtil;
import com.cdhenren.fetch.entity.SysTask;
import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.server.TmpService;
import com.cdhenren.fetch.server.impl.TmpServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.concurrent.Semaphore;
import java.util.regex.Pattern;

/**
 * @author Baopz
 * @date 2018/05/17
 */
public class CallProcessDriver extends AbstractDriverTemplate {
    Logger logger = LoggerFactory.getLogger(CallProcessDriver.class);
    private TmpService tmpService = new TmpServiceImpl();

    public CallProcessDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public CallProcessDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected void setup() throws Exception {
        //设置区域
        MyBatisUtil.setLocation(taskWrap.getSysTask().getLocation());
        logger.debug("正式调用过程:{}", taskWrap.getSysTask().getDetail());
        String process = taskWrap.getSysTask().getDetail();
        if (!isValid(process.trim())) {
            if(StringUtils.isEmpty(process)){
                process = "过程名为空。";
            }
            logger.warn("过程名称无效。{}", process);
            throw new Exception("过程名称无效，请确认sys_task表中Detail字段是否填写正确的过程名。格式如：P_PROJECTXX()");
        }
        tmpService.callProcess(process);
        taskWrap.getSysTask().setEndTime(new Timestamp(System.currentTimeMillis()));
        taskWrap.getSysTask().setState(SysTask.STATE_3);
        taskWrap.getSysTask().setDetail(taskWrap.getSysTask().getDetail() + "执行完毕。");
        sysTaskService.updateTask(taskWrap, null);
    }

    private static boolean isValid(String process) {
        return StringUtils.isNotEmpty(process) && Pattern.matches("^P_\\w*\\(\\)$", process);
    }

    @Override
    protected boolean isLoginExclude() {
        return true;
    }
}
