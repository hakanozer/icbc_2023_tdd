import models.Customer;
import org.junit.jupiter.api.*;
import services.CustometService;
import services.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DBTest {

    DB db;
    Connection con;
    CustometService custometService;

    @BeforeAll
    public void beforeAll() {
        db = new DB();
        custometService = new CustometService();
    }

    @BeforeEach
    public void beforeEach() {
        con = db.connect();
    }

    @Order(1)
    @Test
    public void dbTest() {
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


    @Order(3)
    @RepeatedTest(10)
    public void insertTest() throws SQLException {
        String sql = "insert into customer (name, email, password) values (?, ?, ?)";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, "Ali Bilmem");
        pre.setString(2, "ali@mail.com");
        pre.setString(3, "12345");
        int status = pre.executeUpdate();
        Assertions.assertEquals(status, 1, "Customer insert error");
    }

    @Order(4)
    @Test
    public void customerList() {
        List<Customer> ls = custometService.customerList(con);
        Assertions.assertEquals(ls.size() > 1750, true, "Customer Size not equals 1750");
    }

    @AfterEach
    public void afterEach() throws SQLException {
        if ( con != null && !con.isClosed() ) {
            con.close();
        }
    }

}
