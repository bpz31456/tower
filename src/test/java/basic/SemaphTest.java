package basic;

import com.cdhenren.fetch.config.CatchThreadPoolFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/09
 */
public class SemaphTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(7);
        ExecutorService poolExecutor = /*Executors.newFixedThreadPool(20);*/ CatchThreadPoolFactory.getInstance("test","test");
        for (int i = 0; i < 10000; i++) {
            try {
                Constructor<SubTeskTask> testTaskConstructor = SubTeskTask.class.getConstructor(int.class,Semaphore.class);
                SubTeskTask subTeskTask = testTaskConstructor.newInstance(i,semaphore);
                poolExecutor.execute(subTeskTask);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        poolExecutor.shutdown();
    }

    public static class SubTeskTask extends TestTask {

        public SubTeskTask(int i, Semaphore semaphore) {
            super(i, semaphore);
        }

        @Override
        public void next() {
            //System.out.println(Thread.currentThread().getName() + "Sub任务" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class TestTask implements Runnable {
        private Semaphore semaphore;
        protected int i;

        public TestTask(int i, Semaphore semaphore) {
            this.semaphore = semaphore;
            this.i = i;
        }

        protected void next(){
            //System.out.println(Thread.currentThread().getName() + "测试任务." + i);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           next();
            semaphore.release();
        }
    }
}
