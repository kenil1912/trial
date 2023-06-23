package com.journaldev.struts2.actions;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherSelectAction extends ActionSupport {

    private String subject;

    // Getter and Setter for subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String execute() throws Exception {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the database
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Prepare the SQL statement to insert the subject into the database
            String sql = "INSERT INTO subjects (subject) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subject);

            // Execute the SQL statement
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                // Subject inserted successfully
                return "SUCCESS";
            } else {
                // Error occurred while inserting the subject
                return "ERROR";
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle any exceptions that occur during database operations
            e.printStackTrace();
            return "ERROR";
        } finally {
            // Close the statement and connection in the finally block to ensure they are always closed
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
