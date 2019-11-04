package basic;

import com.cdhenren.fetch.tools.PropertiesTools;

public class PropertiesTest {
    public static void main(String[] args) {
        System.out.println(PropertiesTools.getProperty("tower.properties","driver"));
    }
}
