package quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;

public class QuartzTest {
    @Test
    public void test() {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.start();

            ArrayList list =  new ArrayList<String>();
            list.add("a");
            list.add("b");
            list.add("c");
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("list",list);

            JobDetail jobDetail = JobBuilder
                    .newJob()
                    .ofType(MyTestJob.class)
                    .withIdentity("myTestJob", "job_key")
                    .usingJobData("k1", "v1")
                    .usingJobData("k2", "v2")
                    .usingJobData(jobDataMap)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1))
                    .build();

            SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                    .startAt(null)
                    .withSchedule(null)
                    .endAt(null)
                    .build();

            defaultScheduler.scheduleJob(jobDetail, trigger);

//            defaultScheduler.shutdown(true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new QuartzTest().test();
    }
}
