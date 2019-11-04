package basic;

import java.util.concurrent.*;

/**
 * @author Baopz
 * @date 2018/05/16
 */
public class CountDownlatchTst {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(2);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new TestTask(countDownLatch,semaphore));
        }
        try {
            countDownLatch.await();
            service.execute(()->{
                System.out.println("完成所有任务");
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    public static class TestTask implements Runnable {
        private CountDownLatch countDownLatch;
        private Semaphore semaphore;

        public TestTask(CountDownLatch countDownLatch,Semaphore semaphore) {
            this.countDownLatch = countDownLatch;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"进入任务");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"完成");
            semaphore.release();
            countDownLatch.countDown();
        }
    }
}
