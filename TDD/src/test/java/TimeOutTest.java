import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
public class TimeOutTest {

    @Test
    @Tag("db")
    public void timeTest() {
        try {
            Thread.sleep(3000);
            Assertions.assertTrue(true, "TimeTest Succsess");
        }catch (Exception ex) {}
    }

    @Test
    public void timeTest_1() {
        try {
            Thread.sleep(1500);
            Assertions.assertTrue(true, "timeTest_1 Succsess");
        }catch (Exception ex) {}
    }


}
