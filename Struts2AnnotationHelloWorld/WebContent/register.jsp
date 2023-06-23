<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <style>
        body {
            background-color: #e4f0f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        form {
            background-color: #c4e1fa;
            padding: 20px;
            width: 300px;
            text-align: left;
        }
        
        label, input[type="text"], input[type="password"], input[type="email"] {
            display: block;
            margin-bottom: 5px;
            color: #333333;
        }
        
        input[type="submit"] {
            background-color: #1c8adb;
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
    <h2>User Registration</h2>
    <form action="register.action" method="post">
         <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname" required><br>
        
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname" required><br>
        
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        
        

        <input type="submit" value="Register">
    </form>
    </div></div>
</body>
</html>
