package basic;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Baopz
 * @date 2018/05/29
 */
public class UrlDecoderTest {
    public static void main(String[] args) {
        try {
            String txt = URLDecoder.decode("电表信息.xls", "UTF-8");
            System.out.println(txt);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
