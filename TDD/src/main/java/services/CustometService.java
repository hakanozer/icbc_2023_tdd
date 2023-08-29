package services;

import models.Customer;

import javax.swing.text.Style;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustometService {

    public List<Customer> customerList(Connection con) {
        List<Customer> ls = new ArrayList<>();
        try {
            String sql = "select * from customer";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Customer c = new Customer(id, name, email, password);
                ls.add(c);
            }
        }catch (Exception ex) {
            System.err.println("customer list error :" + ex);
        }
        return ls;
    }

}
