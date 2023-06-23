package com.journaldev.struts2.actions;


import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Action(value = "teacherRegister", results = {
		@Result(name = "success", location = "/teacherlogin.jsp"),
		@Result(name = "error", location = "/error.jsp") })
@Namespaces(value={@Namespace("/User"),@Namespace("/")})
public class TeacherAction extends ActionSupport {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String username;

    public String execute() throws Exception {
        try {
            // Database connection setup
        	Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","1234");
            
            // SQL query to insert teacher details
            String sql = "INSERT INTO teacher (fname, lname, email, password,username) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, username);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();
            
            // Close database connections
            stmt.close();
            conn.close();

            if (rowsAffected > 0) {
                return "success"; // Registration successful
            } else {
                return "error"; // Registration failed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    // Getters and Setters for the form parameters
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
        this.password = password;
    }
}
