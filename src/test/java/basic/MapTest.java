package basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Baopz
 * @date 2018/05/04
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> par = new HashMap<>();
        Map<String, String> sub = new HashMap<>();
        par.putAll(sub);


        Map<String, TeskClass> stringTeskClassMap = new HashMap<>();
        stringTeskClassMap.put("key", new TeskClass());


        stringTeskClassMap.get("key").setName("tangsan");
        System.out.println(stringTeskClassMap);
    }

    public static class TeskClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TeskClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
