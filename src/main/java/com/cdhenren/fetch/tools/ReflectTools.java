package com.cdhenren.fetch.tools;

import com.cdhenren.fetch.entity.ResultSet;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class ReflectTools {

    /**
     * 通过反射，把数据直接填充到类里面
     * @param result 实体
     * @param values 数据
     */
    public static void reflectEntity(ResultSet result, List<String> values) {
        Field[] fields = result.getClass().getDeclaredFields();
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            if (i == fields.length) {
                break;
            }
            try {
                fields[i].setAccessible(true);
                fields[i].set(result, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
