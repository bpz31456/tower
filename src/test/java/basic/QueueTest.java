package basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Baopz
 * @date 2018/05/09
 */
public class QueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> integers = new ArrayBlockingQueue<>(10);
        try {
            integers.put("1");
            integers.put("2");
            integers.put("3");
            integers.put("4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        integers.poll();
        integers.poll();
        integers.poll();

        //System.out.println("长度"+integers.size());

    }
}
