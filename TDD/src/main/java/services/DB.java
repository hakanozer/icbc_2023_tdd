package services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public Connection connect() {
        try {
            String driver = "org.h2.Driver";
            String url = "jdbc:h2:file:~/icbc_2023_tdd";
            String username = "sa";
            String password = "sa";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        }catch (Exception ex) {
            System.err.println("DB Error : " + ex);
            return null;
        }
    }


}
