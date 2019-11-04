package basic;

import com.cdhenren.fetch.entity.TmpSite;

import java.lang.reflect.Field;

/**
 * 反射测试
 *
 * @author Baopz
 * @date 2018/04/26
 */
public class FTest {
    public static void main(String[] args) {
        TmpSite tmpSite = new TmpSite();
        Field[] fields = tmpSite.getClass().getFields();
        for (Field field : fields) {
//            field.set(tmpSite,"");
        }
    }
}
