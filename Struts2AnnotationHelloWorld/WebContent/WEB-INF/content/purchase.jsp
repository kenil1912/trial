<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Purchase Confirmation</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        
        .purchase-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #E1E8F0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            text-align: center;
        }
        
        h2 {
            color: #325B80;
        }
        
        h3 {
            color: #3F83B3;
        }
        
        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        
        li {
            margin-bottom: 10px;
            color: #5488B4;
        }
        
        p {
            color: #5488B4;
        }
    </style>
</head>
<body>
    <div class="purchase-container">
        <h2>Thank you for your purchase!</h2>
        
        <h3>Product: <%= request.getAttribute("product") %></h3>
        
        <p>Your purchase details:</p>
        <ul>
            <li>Product: <%= request.getAttribute("product") %></li>
            <li>Customer: <%= request.getParameter("customer") %></li>
        </ul>
        
        <p>We will process your order shortly.</p>
    </div>
</body>
</html>
