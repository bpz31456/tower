package basic;

import com.cdhenren.fetch.config.ScheduledThreadPoolFactory;
import com.mysql.cj.jdbc.util.TimeUtil;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/04/24
 */
public class DbTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolFactory().getInstance("testd%");
        scheduledExecutor.scheduleAtFixedRate(()->{
            //System.out.println("测试时间.");
        },1L,2L, TimeUnit.SECONDS);
    }
}
