package poi;

import com.cdhenren.fetch.tools.poi.ExcelEnhancerUtils;
import com.cdhenren.fetch.tools.poi.Relationship;
import com.cdhenren.fetch.tools.poi.RelationshipFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PoiTest {
    private Logger logger = LoggerFactory.getLogger(PoiTest.class);

    @Test
    public void test() {
        Relationship relationship = RelationshipFactory.generator("891", "test_bean");

        try {
            Map<String, List<Object>> stringListMap =
                    ExcelEnhancerUtils.readFile("C:\\Users\\Fuhj\\Desktop\\tower\\user.xls",
                            new int[]{1},
                            relationship,
                            new String[]{"test_bean"});
            stringListMap.forEach((s, objects) -> {
                logger.info("tableName:{},size:{}", s, objects.size());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
