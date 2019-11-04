package basic;

import org.junit.Test;

public class ClassTest {
    @Test
    public void test() {
        /*Supper supper = new Sub();
        supper.print();*/
        System.out.println(ClassTest.class.getName());
    }

    public static abstract class Supper {
        public void print() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    public static class Sub extends Supper {

    }
}
