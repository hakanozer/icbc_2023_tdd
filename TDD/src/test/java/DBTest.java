import org.junit.jupiter.api.*;
import services.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DBTest {

    DB db;
    Connection con;

    @BeforeAll
    public void beforeAll() {
        db = new DB();
    }

    @Order(1)
    @Test
    public void dbTest() {
        con = db.connect();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(con),
                () -> Assertions.assertEquals( !con.isClosed(), true )
        );
    }

    @Order(2)
    @Test
    public void createTableTest() {
        String sql = "CREATE TABLE IF NOT EXISTS customer ( \n" +
                "   id INT NOT NULL, \n" +
                "   name VARCHAR(50) NOT NULL, \n" +
                "   email VARCHAR(150) NOT NULL,\n" +
                "   password VARCHAR(150) NOT NULL\n" +
                ");";
        try {
            Statement st = con.createStatement();
            boolean executeStatus = st.execute(sql);
            //Assertions.assertEquals(executeStatus, true);
        }catch (Exception ex) {
            System.err.println("createTableTest error: " + ex);
        }

    }


}
