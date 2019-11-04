package driver;

import net.sf.cglib.beans.BeanGenerator;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DynamicTest {

    @Test
    public void test() {
        Map<String, Class> properties = new HashMap<>();
        properties.put("id", String.class);
        properties.put("name", String.class);
        properties.put("sex", String.class);

        DynamicBean bean = new DynamicBean(properties);
        bean.setValue("id", "t1");
        bean.setValue("name", "tangsan");
        bean.setValue("sex", "nan");
        Object object = bean.getObject();
        for (Field declaredField : object.getClass().getDeclaredFields()) {
            try {
                declaredField.setAccessible(true);
                String o = (String) declaredField.get(object);
                System.out.println(declaredField.getName() + ":" + o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test01(){
        BeanGenerator beanGenerator= new BeanGenerator();
        beanGenerator.addProperty("name",String.class);
        Object o = beanGenerator.create();
        for (Field declaredField : o.getClass().getDeclaredFields()) {
            System.out.println(declaredField);
        }

        for (Method declaredMethod : o.getClass().getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
    }
}
