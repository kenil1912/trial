package com.journaldev.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Namespace("/")
@Results({
    @Result(name = "SUCCESS", location = "purchase.jsp"),
    @Result(name = "ERROR ", location = "error.jsp")
})
@Namespaces(value={@Namespace("/User"),@Namespace("/")})
public class BuyAction  {
    private String product;
    private String customer;

    // Getters and setters for product and customer
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Action(value = "buy")
    public String buy() {
        // Database code to store data
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish database connection 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "1234");

            // Prepare SQL statement
            String sql = "INSERT INTO purchases (product, username) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, product);
            statement.setString(2, customer);

            // Execute the statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "SUCCESS";
            } else {
               
                return "ERROR";
            }
        } catch (SQLException e) {
            return "ERROR";
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                
            }
        }
    }
}

