package basic;

import com.cdhenren.fetch.entity.ResultSet;
import com.cdhenren.fetch.entity.TmpPropertyContract;
import com.cdhenren.fetch.tools.poi.ExcelUtils;
import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @author Baopz
 * @date 2018/05/07
 */
public class FileTest {
    @Test
    public void test1() {
        String filename = "C:\\Users\\Fuhj\\Desktop\\包鹏泽\\";
        fileRename(filename);
        /*try {
            System.out.println(FileTools.rename(new File[]{new File(filename)}));
        } catch (UnsupportedEncodingException | InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void test2(){
        Path path = Paths.get("C:\\Users\\Fuhj\\Desktop\\包鹏泽");
        System.out.println(path.toString());
    }

    @Test
    public void readFile() {
        String filename = "C:\\Users\\Fuhj\\Desktop\\tower\\合同信息.xls";
        try {
            Map<Class, List<? extends ResultSet>> classListMap = ExcelUtils.readFile(filename, new int[]{2}, new Class[]{TmpPropertyContract.class});
            assert classListMap != null;
            classListMap.keySet().forEach(aClass -> classListMap.get(aClass).forEach(System.out::println));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        boolean deleted = true;
        //清空下载的文件
        if (file.exists() && file.isFile()) {
            deleted = file.delete();
        }
        return deleted;
    }

    public static boolean deleteFile(File file) {
        boolean deleted = true;
        //清空下载的文件
        if (file.exists() && file.isFile()) {
            deleted = file.delete();
        }
        return deleted;
    }

    public  void fileRename(String path) {
        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                try {
                    String txt = URLDecoder.decode(file.getAbsolutePath(), "UTF-8");
                    System.out.println(txt);
                    file.renameTo(new File(txt));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
