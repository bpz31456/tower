package com.cdhenren.fetch.driver;

import com.cdhenren.fetch.entity.TaskWrap;
import com.cdhenren.fetch.server.TmpService;
import com.cdhenren.fetch.server.impl.TmpServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * @author Baopz
 * @date 2018/05/07
 */
@Deprecated
public class PCheckDriver extends AbstractDriverTemplate {
    Logger logger = LoggerFactory.getLogger(PCheckDriver.class);
    private TmpService tmpService = new TmpServiceImpl();

    public PCheckDriver(TaskWrap taskWrap) {
        super(taskWrap);
    }

    public PCheckDriver(TaskWrap taskWrap, Semaphore semaphore) {
        super(taskWrap, semaphore);
    }

    @Override
    protected void setup() throws Exception {
        tmpService.callPCheck();
        //不做状态处理，过程自己会去处理
//        taskWrap.getSysTask().setEndTime(new Timestamp(System.currentTimeMillis()));
//        taskWrap.getSysTask().setState(SysTask.STATE_3);
//        taskWrap.getSysTask().setDetail("执行完毕。");
//        sysTaskService.updateTask(taskWrap, null);
    }

    @Override
    protected boolean isLoginExclude() {
        return true;
    }
}
