package basic;

import com.cdhenren.fetch.config.CatchThreadPoolFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/11
 */
public class ThreadpoolTest {
    public static void main(String[] args) {
        Semaphore semaphore= new Semaphore(5);
        ExecutorService poolExecutor = CatchThreadPoolFactory.getInstance("test","test");
        for (int i = 0; i < 50; i++) {
            poolExecutor.execute(new TestTask(semaphore));
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
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName());
            semaphore.release();
        }
    }
}
