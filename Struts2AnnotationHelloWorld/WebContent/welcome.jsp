<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
<style>
        body {
            background-color: #c2e9ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        .welcome-container {
            background-color: #7dc2ff;
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        
        h3, h4 {
            color: #333333;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="welcome-card">

<h1>Welcome <s:property value="name"></s:property></h1>

</div></div>
</body>
</html>