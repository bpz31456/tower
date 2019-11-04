package basic;

/**
 * @author Baopz
 * @date 2018/05/18
 */
public class ErrorTest {
    public static void main(String[] args) {
        while(true){
            try {
                throw new OutOfMemoryError("测试");
            }catch (Exception e){
                System.out.println("测试1");
            }
        }
    }
}
