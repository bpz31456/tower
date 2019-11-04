package threadTest;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("tangsan");
        ThreadLocal<String> stringThreadLocal1 = new ThreadLocal<>();
        System.out.println(stringThreadLocal.get());
    }
}
