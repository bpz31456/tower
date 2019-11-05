package com.cdhenren.fetch.task;

import com.cdhenren.fetch.entity.SysTask;
import com.cdhenren.fetch.entity.SysTaskPama;
import com.cdhenren.fetch.server.SysTaskService;
import com.cdhenren.fetch.server.impl.SysTaskServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * sys_task_pama -> sys_task
 * insert table
 * @author Baopz
 */
public class GeneratePlanedTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(GeneratePlanedTask.class);
    private SysTaskService sysTaskService;
    private static final String TIME_SPACE_CHARACTER = ":";

    public GeneratePlanedTask() {
        sysTaskService = new SysTaskServiceImpl();
    }

    @Override
    public void run() {
        logger.info("参数表数据轮询。");
        try {
            List<SysTaskPama> sysTaskPamaList = sysTaskService.taskPamas();
            if (sysTaskPamaList != null && sysTaskPamaList.size() > 0) {
                for (SysTaskPama sysTaskPama : sysTaskPamaList) {
                    if (!isLegitimate(sysTaskPama)) {
                        continue;
                    }
                    logger.debug("任务添加到任务表中。");
                    SysTask sysTask = getSysTask(sysTaskPama);
                    int result = sysTaskService.insertSysTask(sysTask);
                    if (result > 0) {
                        logger.info("任务实体表{}添加成功。",sysTask);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * 是否合法,只会负责为每日类型
     *
     * @param taskPama 配置参数
     * @return boolean
     */
    private boolean isLegitimate(SysTaskPama taskPama) {
        if (SysTaskPama.STATE_0_INVALID == taskPama.getState()) {
            return false;
        }
        if (taskPama.getFixType() == SysTaskPama.FIX_TYPE_DAY) {
            return dayPlaned(taskPama.getFixTime());
        }
        return false;
    }

    /**
     * 按天
     *
     * @param fixTime，格式5:00
     * @return 是否符合按天的计划
     */
    private boolean dayPlaned(String fixTime) {
        if (StringUtils.isEmpty(fixTime)) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        int nowMin = calendar.get(Calendar.MINUTE);
        int nowHour = calendar.get(Calendar.HOUR_OF_DAY);

        long planedTime = getPlanedTime(fixTime);
        if (planedTime == 0L) {
            return false;
        }
        calendar.setTime(new Date(planedTime));
        int planedMin = calendar.get(Calendar.MINUTE);
        int planedHour = calendar.get(Calendar.HOUR_OF_DAY);
        return (planedMin == nowMin) && (planedHour == nowHour);
    }

    /**
     * 计算毫秒
     *
     * @param time，格式5:00
     * @return 根据time得到代表的long时间戳
     */
    private long getPlanedTime(String time) {
        if (!time.contains(TIME_SPACE_CHARACTER)) {
            logger.warn("计划时间格式有误。{}", time);
            return 0L;
        }
        Calendar calendar = Calendar.getInstance();
        String[] planedTime = time.split(":");
        int hour = Integer.valueOf(planedTime[0]);
        int min = Integer.valueOf(planedTime[1]);

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    private SysTask getSysTask(SysTaskPama e) {
        SysTask sysTask = new SysTask();
        sysTask.setState(SysTask.STATE_0);
        sysTask.setCrtDate(new Timestamp(System.currentTimeMillis()));
        sysTask.setTaskCode(e.getTaskCode());
        sysTask.setPwd(e.getPwd());
        sysTask.setUser(e.getUser());
        sysTask.setReTryMax(e.getReTryMax());
        sysTask.setFixType(e.getFixType());
        sysTask.setLocation(e.getLocation());
        sysTask.setTmpTable(e.getTmpTable());
        sysTask.setFirstRegion(e.getFirstRegion());
        sysTask.setSecRegion(e.getSecRegion());
        return sysTask;
    }
}
