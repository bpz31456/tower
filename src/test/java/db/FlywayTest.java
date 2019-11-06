package db;

import com.cdhenren.fetch.tools.PropertiesTools;
import org.flywaydb.core.Flyway;
import org.junit.Test;

/**
 * @author bpz777@163.com
 */
public class FlywayTest {
    @Test
    public void test(){
        Flyway flyway = Flyway.configure()
                .configuration(PropertiesTools.getProperties("tower.properties"))
                .load();
        flyway.migrate();
    }
}
