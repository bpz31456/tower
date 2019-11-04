package lombok;

import com.cdhenren.fetch.entity.TmpMroom;
import org.junit.Test;

public class LombokTest {

    @Test
    public void test(){
        TmpMroom tmpMroom = new TmpMroom();
        System.out.println(tmpMroom);
    }
}
