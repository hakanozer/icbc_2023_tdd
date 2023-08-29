import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Action;

public class ThreadTest {

    @ParameterizedTest
    @ValueSource(strings = {"1.jpg","2.jpg","3.jpg","4.jpg"})
    @Tag("db")
    public void threadTest( String path ) {
        try {
            Action action = new Action(path);
            action.start();
            action.join();
            Assertions.assertTrue(true, "Thread Fail");
        }catch (Exception ex) {
            Assertions.assertTrue(false, ex.getMessage());
        }
    }

}
