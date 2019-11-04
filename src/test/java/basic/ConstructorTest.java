package basic;

import com.cdhenren.fetch.driver.assetsManagement.AirCondDriver;
import org.apache.http.util.Asserts;

import java.lang.reflect.Constructor;

/**
 * @author Baopz
 * @date 2018/05/04
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Constructor[] constructors = AirCondDriver.class.getConstructors();
        Asserts.check(constructors.length == 1, "1");
    }
}
