package basic;

import com.cdhenren.fetch.config.TaskQueueFactory;
import com.cdhenren.fetch.entity.TaskWrap;

import java.util.concurrent.Semaphore;

/**
 * @author Baopz
 * @date 2018/05/17
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        TaskWrap taskWrap = new TaskWrap(null,null);
        TaskQueueFactory.getInstance("test").offer(taskWrap);
        while(true){
            TaskWrap tt = TaskQueueFactory.getInstance("test").poll();
            if(tt==null){
                continue;
            }
            new Thread(new SemaphoreTest.TestTask(semaphore,tt)).start();
        }
    }

    public static class TestTask implements Runnable {
        private Semaphore semaphore;
        private TaskWrap taskWrap;

        public TestTask(Semaphore semaphore, TaskWrap taskWrap) {
            this.semaphore = semaphore;
            this.taskWrap = taskWrap;
        }

        @Override
        public void run() {
            System.out.println("进入任务");
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try{ int i = 1/0;}catch (RuntimeException e){
                try {
                    TaskQueueFactory.getInstance("test").put(taskWrap);
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println("释放成功。");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            semaphore.release();
        }
    }
}
