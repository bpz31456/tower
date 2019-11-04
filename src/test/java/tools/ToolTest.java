package tools;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TmpSiteRemovalRate;
import com.cdhenren.fetch.tools.FileTools;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ToolTest {

    @Test
    public void test(){
        try {
            FileTools.list("C:\\Users\\Fuhj\\Desktop\\down\\891\\2130747209","站址拆除率").forEach(s -> {
                try {
                    List<? extends ResultSet> rs = ExcelUtils.readFile(new File(s), new int[]{4}, new Class[]{TmpSiteRemovalRate.class}).get(TmpSiteRemovalRate.class);
                    rs.forEach(System.out::println);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01(){
        List<? extends ResultSet> rs = null;
        try {
            Map<Class, List<? extends ResultSet>> classListMap =
                    ExcelUtils.readFile(new File("C:\\Users\\Fuhj\\Desktop\\down\\891\\2130747209\\2.xlsx"), new int[]{1}, new Class[]{TmpSiteRemovalRate.class});
            classListMap.forEach((aClass, resultSets) -> {
                classListMap.get(TmpSiteRemovalRate.class).forEach(System.out::println);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
