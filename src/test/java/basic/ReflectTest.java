package basic;

import com.cdhenren.fetch.entity.TmpSite;

import java.lang.reflect.Field;

/**
 * @author Baopz
 * @date 2018/05/23
 */
public class ReflectTest {
    public static void main(String[] args) {
        Field[] fields = TmpSite.class.getDeclaredFields();
        for(int i = 0;i<fields.length;i++){
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName());
        }
    }
}
