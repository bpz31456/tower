package com.cdhenren.fetch.entity.enhancer;

import com.cdhenren.fetch.entity.ResultSet;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;
import java.util.Set;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public class CommonBean{
    private Object source;
    private BeanMap properties;

    public CommonBean() {
    }

    public CommonBean(Map<String, Class> property) {
        this.source = generateBean(property);
        this.properties = BeanMap.create(this.source);
    }

    private Object generateBean(Map propertyMap) {
        BeanGenerator generator = new BeanGenerator();
        Set keySet = propertyMap.keySet();
        for (Object o : keySet) {
            String key = (String) o;
            generator.addProperty(key, (Class) propertyMap.get(key));
        }
        return generator.create();
    }

    /**
     * 设置值
     *
     * @param property
     * @param value
     */
    public void setValue(String property, Object value) {
        properties.put(property, value);
    }

    /**
     * 通过属性名得到属性值
     *
     * @param property 属性名
     * @return 值
     */
    public Object getValue(String property) {
        return properties.get(property);
    }

    /**
     * 得到该实体bean对象
     *
     * @return
     */
    public Object getObject() {
        return this.source;
    }

}