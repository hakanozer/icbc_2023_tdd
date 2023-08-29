import models.ModelCurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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

}
