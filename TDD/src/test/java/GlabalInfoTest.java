import org.junit.jupiter.api.*;
import utils.Util;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GlabalInfoTest {

    Util util = null;
    Random rnd = null;
    int i = 0;

    @BeforeAll
    public void beforeAll() {
        util = new Util();
        System.out.println( "beforeAll Call" );
    }

    @BeforeEach
    public void beforeEach() {
        rnd = new Random();
        System.out.println("beforeEach call");
    }

    @Order(1)
    @Test
    @DisplayName("A test")
    @Tag("security")
    public void aTest() {
        System.out.println("aTest call");
    }

    @Order(2)
    @Test
    @DisplayName("2 params int sum")
    @Tag(Config.rest)
    public void sumTest() {
        int sum = util.sum(100, 50);
        Assertions.assertEquals(sum, 151, "Sum Not Equals");
        System.out.println( util.hashCode() );
        System.out.println( rnd.hashCode() + "Rnd:" + rnd.nextInt(100) );
        i++;
    }

    @Order(3)
    @Test
    @DisplayName("random test")
    @Tag(Config.secuirty)
    public void test_1() {
        util.sum(44,33);
        System.out.println( util.hashCode() );
        System.out.println( rnd.hashCode() +  "Rnd:" + rnd.nextInt(100) );
        i++;
    }



    @AfterEach
    public void afterEach() {
        rnd = null;
    }

    @AfterAll
    public void afterAll() {
        System.out.println("afterAll call: " + i);
        util = null;
    }

}
