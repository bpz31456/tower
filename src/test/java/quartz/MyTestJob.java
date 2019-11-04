package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MyTestJob implements Job {

    private String k1;
    private String k2;
    private List<String> list;

    private Logger logger = LoggerFactory.getLogger(MyTestJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        String k1 = jobExecutionContext.getMergedJobDataMap().getString("k1");
        logger.debug("{}，{},{}", k1, k2, "Hello Quartz Job.");
        list.forEach(s -> logger.debug(s));
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }
}
