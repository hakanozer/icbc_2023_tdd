import models.ModelCurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.*;
import utils.Xml;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class XmlTest {

    Xml xml;

    @BeforeAll
    public void beforeAll() {
        xml = new Xml();
    }

    @Test
    public void xmlTest() {
        List<ModelCurrency> ls = xml.result();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(ls),
                () -> Assertions.assertEquals(ls.size() > 0, true, "Currency Empty!"),
                () -> Assertions.assertEquals(ls.get(0).getBanknoteBuying().equals(""),  false, "Dollar Empty!")
        );
    }


    @Test
    @EnabledOnOs(OS.MAC)
    public void enabledOnOsMac() {
        System.out.println("Mac OS call");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void enabledOnOsWindows() {
        System.out.println("Windows OS call");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void jreText8() {
        System.out.println("JAVA_8 Call");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_9)
    public void jreText9() {
        System.out.println("JAVA_9 Call");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    public void rangeJRE() {
        System.out.println("JAVA_8 range JAVA_11");
    }

}
