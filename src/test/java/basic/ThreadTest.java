package basic;

import com.cdhenren.fetch.config.ScheduledThreadPoolFactory;
import com.cdhenren.fetch.config.SingleThreadPoolFactory;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author Baopz
 * @date 2018/05/17
 */
public class ThreadTest {
    @Test
    public void test() {
        try {
            int i = 1 / 0;
        } catch (RuntimeException e) {
            int x = 2 / 0;
        } finally {
            int y = 3 / 0;
        }
        System.out.println("运行结束");
    }

    static BlockingQueue<String> strings = new LinkedBlockingQueue<>(3);

    public static void main(String[] args) {
        /*ScheduledExecutorService planExecutor = ScheduledThreadPoolFactory.getInstance("remove %d");
        ScheduledExecutorService planExecutor2 = ScheduledThreadPoolFactory.getInstance("add %d");
        Semaphore semaphore = new Semaphore(1);
        TestTask testTask = new TestTask(semaphore);
        planExecutor.scheduleWithFixedDelay(new TestTask2(), 0L, 2, TimeUnit.SECONDS);
        planExecutor2.scheduleWithFixedDelay(new TestTask3(), 0L, 1, TimeUnit.SECONDS);*/
        ThreadPoolExecutor session = SingleThreadPoolFactory.shareSingleThread("Session");
        for(int i = 0;i<10;i++){
            session.execute(()->{
                try {
                    Thread.sleep(1000);
                    ThreadPoolExecutor ss = SingleThreadPoolFactory.shareSingleThread("Session");
//                    System.out.println(ss.getTaskCount());
//                    System.out.println(ss.getPoolSize());
//                    System.out.println(ss.getLargestPoolSize());
                    System.out.println(ss.getQueue().size());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static class TestTask3 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                strings.offer(i + "");
            }
        }
    }

    public static class TestTask2 implements Runnable {

        @Override
        public void run() {
            String tmp;
            try {
                while ((tmp = strings.poll()) != null) {
                    System.out.println(tmp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class TestTask implements Runnable {

        private Semaphore semaphore;

        public TestTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xxxx");
            semaphore.release();
            semaphore.release();
        }
    }

}
