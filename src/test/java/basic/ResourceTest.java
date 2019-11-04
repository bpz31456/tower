package basic;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Baopz
 * @date 2018/05/18
 */
public class ResourceTest {
    private Properties properties;

    public InputStream getResource() {
        ClassLoader classLoader;
        return null;
    }

    ClassLoader[] getClassLoaders(ClassLoader classLoader) {
        return new ClassLoader[]{classLoader, Thread.currentThread().getContextClassLoader(),
                this.getClass().getClassLoader(), ClassLoader.getSystemClassLoader()};
    }

    InputStream getResourceAsStream(String resource, ClassLoader[] classLoader) {
        ClassLoader[] var3 = classLoader;
        int var4 = classLoader.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            ClassLoader cl = var3[var5];
            if (null != cl) {
                InputStream returnValue = cl.getResourceAsStream(resource);
                if (null == returnValue) {
                    returnValue = cl.getResourceAsStream("/" + resource);
                }

                if (null != returnValue) {
                    return returnValue;
                }
            }
        }

        return null;
    }

}
