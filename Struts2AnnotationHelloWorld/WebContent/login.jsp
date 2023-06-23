<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
<style>
        body {
            background-color: #eef4fd;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 120vh;
            margin: 0;
        }
        
        form {
            background-color: #cfe8fd;
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        
        label, input[type="text"], input[type="password"] {
            display: block;
            margin-bottom: 10px;
            color: #333333;
        }
        
        input[type="submit"] {
            background-color: #428bca;
            color: #ffffff;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
<h3>Welcome Student, please login below</h3>
<h1> Hello just for check!!!</h1>
<s:form action="login">
	<s:textfield name="name" label="User Name"></s:textfield>
	<s:textfield name="pwd" label="Password" type="password"></s:textfield>
	<s:submit value="Login"></s:submit>
</s:form>
<form action="teacherlogin.jsp">
<input type="submit" value="Teacher Login">
</form>
<a href="register.jsp">Register</a>
</div></div>
</body>
</html>