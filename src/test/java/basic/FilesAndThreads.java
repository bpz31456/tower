package basic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Baopz
 * @date 2018/05/07
 */
public class FilesAndThreads {
    public static void main(String[] args) {
        File fi = new File("C:\\Users\\Baopz\\Desktop\\dcm\\download");

        new Thread(()->{
            for (File file : fi.listFiles()) {
                //System.out.println("文件名："+file.getName());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                File file = new File("C:\\Users\\Baopz\\Desktop\\dcm\\download\\"+i);
                if(!file.exists()){
                    try {
                        file.createNewFile();
                        //System.out.println("添加成功.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }
}
