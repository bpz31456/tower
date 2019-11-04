package driver;

import driver.sub.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;

public class ClassLoaderTest {
    Person person;
    private Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);


    @Before
    public void test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, FileNotFoundException {
        File file = new File("C:\\Users\\Fuhj\\Desktop\\tower\\SubPerson.class");
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("driver.sub.SubPerson", file);
        person = (Person) aClass.newInstance();
        logger.debug(person.getProperty());
    }

    @Test
    public void test1() {
        Assert.assertNotNull(person);
        String name = person.getClass().getName();
        logger.debug(name);
    }

    static class MyClassLoader extends ClassLoader {

        public synchronized Class<?> loadClass(String name, File file) throws FileNotFoundException {
            Class<?> cls = findLoadedClass(name);
            if (cls != null) {
                return cls;
            }
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            try {
                while (true) {
                    len = fis.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    baos.write(buffer, 0, len);
                }
                //FileInputStream的flush是空操作，因为flush的作用是把缓存中的东西写入实体(硬盘或网络流)中，这里没有这种必要所以为空
                //baos.flush();
                byte[] data = baos.toByteArray();
                return defineClass(null, data, 0, data.length);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}

