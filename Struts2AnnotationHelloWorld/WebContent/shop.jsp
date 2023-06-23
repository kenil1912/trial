<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
   <style>
        body {
            background-color: #c2e9ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        
        .shop-container {
            background-color: #7dc2ff;
            padding: 20px;
            width: 600px;
            text-align: center;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }
        
        h2 {
            color: #333333;
        }
        
        .item {
            margin: 20px;
            padding: 10px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        .item h3 {
            margin-bottom: 10px;
            color: #333333;
        }
        
        .item p {
            color: #666666;
        }
        
        .buy-button {
            background-color: #4d94ff;
            color: #ffffff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        .buy-button:hover {
            background-color: #3385ff;
        }
    </style>
</head>
<body>
    <div class="shop-container">
        <h2>Welcome to our Shop!</h2>
        
        <div class="item">
            <h3>Product 1</h3>
            <p>Price: $10</p>
            <p>Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            <s:form action="buy">
                <s:hidden name="product" value="Product 1" />
                <s:hidden name="customer" value="%{#request.name}" />
                <s:submit value="Buy" cssClass="buy-button" />
            </s:form>
        </div>
        
        <div class="item">
            <h3>Product 2</h3>
            <p>Price: $20</p>
            <p>Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            <s:form action="buy">
                <s:hidden name="product" value="Product 2" />
                <s:hidden name="customer" value="%{#request.name}" />
                <s:submit value="Buy" cssClass="buy-button" />
            </s:form>
        </div>
        
        <div class="item">
            <h3>Product 3</h3>
            <p>Price: $30</p>
            <p>Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            <s:form action="buy">
                <s:hidden name="product" value="Product 3" />
                <s:hidden name="customer" value="%{#request.name}" />
                <s:submit value="Buy" cssClass="buy-button" />
            </s:form>
        </div>
    </div>
</body>
</html>
