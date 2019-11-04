package driver;

import com.cdhenren.fetch.group.TaskRegion;
import com.cdhenren.fetch.task.TaskType;
import com.cdhenren.fetch.task.TaskTypeComparison;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicClassTest {

    private Logger logger = LoggerFactory.getLogger(BasicClassTest.class);

    @Test
    public void test() {
        Class clazz = TaskType.ETL_P_CHECK.getClazz();
        logger.debug(clazz.getName());
        String oldDriver = clazz.getName();
        Assert.assertTrue(oldDriver.matches("com.cdhenren.fetch.driver.\\w+Driver"));

        oldDriver = oldDriver.replaceFirst("driver", "driver.enhancer");
        oldDriver = oldDriver.replaceFirst("Driver", "EnhancerDriver");
        String enhancerDriver = oldDriver;
        logger.debug(enhancerDriver);
    }

    @Test
    public void test01(){
        logger.debug(TaskRegion.AUDIT_MANAGEMENT.name());
    }
}
