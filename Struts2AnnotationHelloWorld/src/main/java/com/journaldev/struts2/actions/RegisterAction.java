package com.journaldev.struts2.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "register", results = {
		@Result(name = "SUCCESS", location = "/regesterSucessful.jsp"),
		@Result(name = "ERROR", location = "/error.jsp")
})

@Namespaces(value={@Namespace("/User"),@Namespace("/")})
public class RegisterAction {

	private String username;
	private String password;
	private String email;
	public String fname;
	public String lname;

	

	public String execute() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "1234");

			String sql = "INSERT INTO student (username, password, email, fname, lname) VALUES (?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, getUsername());
			stmt.setString(2, getPassword());
			stmt.setString(3, getEmail());
			stmt.setString(4, getFname());
			stmt.setString(5, getLname());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				ServletActionContext.getRequest().setAttribute("fname", getFname());
				ServletActionContext.getRequest().setAttribute("lname", getLname());

				return "SUCCESS"; // Registration successful
			} else {
				return "ERROR"; // Registration failed
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} 
//		finally {
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
