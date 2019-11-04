package basic;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TmpContract;
import com.cdhenren.fetch.tools.poi.ExcelUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Baopz
 * @date 2018/05/07
 */
public class ExcelUtilTest {
    public static void main(String[] args) {
        test01();


    }

    private static void test01() {
        Class[] classes = new Class[]{TmpContract.class};
        int[] skipLines = new int[]{1};
        try {
            Map<Class, List<? extends ResultSet>> map = ExcelUtils.
                    readFile("C:\\Users\\Baopz\\Downloads\\综合查询.xlsx", skipLines, classes);
//            //System.out.println(map.get(TmpContract.class).size());
            Map<Class, List<? extends ResultSet>> classListMap = new HashMap<>();

            mapMarge(classListMap,map);
            //System.out.println(classListMap.get(TmpContract.class).size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mapMarge(Map<Class, List<? extends ResultSet>> tmpMap, Map<Class, List<? extends ResultSet>> sub) {
        if (tmpMap.isEmpty()) {
            //System.out.println("tmpMap:" + tmpMap + "subMap:" + sub);
            tmpMap.putAll(sub);
        }

        for (Iterator<Class> iterator = tmpMap.keySet().iterator(); iterator.hasNext(); ) {
            Class parClass = iterator.next();
            for (Iterator<Class> subIt = sub.keySet().iterator(); subIt.hasNext(); ) {
                Class subClass = subIt.next();
                if (parClass.equals(subClass)) {
                    List<? extends ResultSet> rsList = tmpMap.get(parClass);
                    List<? extends ResultSet> subList = sub.get(subClass);
                    rsList.addAll(convert(subList));
                }
            }
        }
    }

    private static <T> List<T> convert(List<?> list) {
        return (List<T>) list;
    }
}
