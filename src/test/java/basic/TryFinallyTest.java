package basic;

/**
 * @author Baopz
 * @date 2018/05/18
 */
public class TryFinallyTest {
    public static void main(String[] args) {
        try {
            new TryFinallyTest().function();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void function() throws Exception {
        try {
            int i = 1 / 0;
        } finally {
            System.out.println("执行finally");
        }
    }
}
