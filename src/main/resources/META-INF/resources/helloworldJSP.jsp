<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% System.out.println("HelloWorldJSP - doGet()"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% String contents = (String) request.getAttribute("contents"); %>
    <div>
        HTML Value: GoNi Lab! 배고프다!
    </div>
    <div>
        Code Value : <%= contents %>
    </div>
</body>
</html>
<% System.out.println("HelloWorldJSP - doGet() done."); %>