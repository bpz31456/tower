package basic;

import com.cdhenren.fetch.server.TmpService;
import com.cdhenren.fetch.server.impl.TmpServiceImpl;
import org.junit.Test;

import java.util.Map;

/**
 * @author Baopz
 * @date 2018/05/17
 */
public class CallTest {
//    private static Logger logger = LoggerFactory.getLogger(basic.CallTest.class);

    @Test
    public void test() {
        TmpService sysTaskService = new TmpServiceImpl();
        String process = "P_FEE()";
        Map map = sysTaskService.callProcess(process);
//        logger.info(map.toString());
        System.out.println(map);
    }

}
