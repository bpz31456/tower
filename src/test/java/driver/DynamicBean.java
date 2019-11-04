package driver;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;

public class DynamicBean {
    private Object object;
    private BeanMap beanMap;


    public DynamicBean(Map beanMap) {
        this.object = generateBean(beanMap);
        this.beanMap = BeanMap.create(object);
    }

    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    public Object getValue(String key) {
        return beanMap.get(key);
    }

    public Object getObject() {
        return object;
    }

    private Object generateBean(Map<String, Class> propertyMap) {
        BeanGenerator beanGenerator = new BeanGenerator();
        propertyMap.keySet().forEach(o -> {
            beanGenerator.addProperty(o, propertyMap.get(o));
        });
        return beanGenerator.create();
    }

}
