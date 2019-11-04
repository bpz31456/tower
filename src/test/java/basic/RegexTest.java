package basic;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {
    private static String regex = "com.cdhenren.fetch.driver.\\w+.\\w+Driver";
    @Test
    public void test(){
        Assert.assertTrue(RegexTest.class.getSimpleName().equals("RegexTest"));
        Assert.assertTrue("com.cdhenren.fetch.driver.property.BasicInformationDownloadDriver".matches(regex));
        Assert.assertTrue("com.cdhenren.fetch.driver.enhancer.EnhancerOldDriver".matches(regex));
    }
}
