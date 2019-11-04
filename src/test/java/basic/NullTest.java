package basic;

/**
 * @author Baopz
 * @date 2018/05/25
 */
public class NullTest {
    public static void main(String[] args) {
        System.out.println(new Integer(2) > getNull());

    }

    public  static  Integer getNull(){
        return  null;
    }
}
