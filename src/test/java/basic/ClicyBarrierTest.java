package basic;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author Baopz
 * @date 2018/05/16
 */
public class ClicyBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("-----------------"+Thread.currentThread().getName()+"最后执行");
        });

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 21; i++) {
            service.execute(new TeskTaks(cyclicBarrier));
        }
        service.shutdown();
    }

    public static class TeskTaks implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public TeskTaks(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"到来");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                try {
                    cyclicBarrier.await(2, TimeUnit.SECONDS);
                } catch (TimeoutException e) {
                    System.out.println(Thread.currentThread().getName()+"等待失败");
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"离去");
        }
    }
}
