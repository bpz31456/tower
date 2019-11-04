package basic;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author Baopz
 * @date 2018/04/27
 */
public class DateTest {
    public static void main(String[] args) {
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        //System.out.println(timestamp.getTime());

        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
