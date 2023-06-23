package com.journaldev.struts2.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;


@Action(value = "teacherlogin", results = {
		@Result(name = "SUCCESS", location = "/teacherselect.jsp"),
		@Result(name = "ERROR", location = "/error.jsp") })
@Namespaces(value={@Namespace("/User"),@Namespace("/")})
public class TeacherLoginAction {

	public String execute() throws Exception {
//		if("kenil".equals(getName()) && "1234".equals(getPwd()))
//		return "SUCCESS";
//		else return "ERROR";
		
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","1234");

	      String sql = "SELECT * FROM teacher WHERE username = ? AND password = ?";
	      stmt = conn.prepareStatement(sql);
	      stmt.setString(1, getName());
	      stmt.setString(2, getPwd());

	      rs = stmt.executeQuery();
	      if (rs.next()) {
	    	  ServletActionContext.getRequest().setAttribute("fname", getFname());
	    	  ServletActionContext.getRequest().setAttribute("lname", getLname());
	        return "SUCCESS"; // Login successful
	      } else {
	        return "ERROR"; // Login failed
	      }
	}
	 catch (Exception e) {
	      e.printStackTrace();
	      return "ERROR";
	    } 
	}
	//Java Bean to hold the form parameters
	private String name;
	private String pwd;
	public String fname;
	public String lname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
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
}
