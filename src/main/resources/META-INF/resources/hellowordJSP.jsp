<!-- 23.06.26(월) -->
<!-- 똑같은 servlet을 jsp로 구성해보기 -->
<!-- HelloWorldServlet_jsp -->
<!-- 아래 코드가 jsp의 기본 틀 -->

<!--'contentType="text/html; charset=UTF-8' 페이지에 넣어도 한글 오류 잡아줌-->

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
    <% String contents = (String)request.getAttribute("contents"); %>   <!-- 넘어온 것 받음. java 형식 그대로임 -->
    <div>
        HTML Value : Yoju Lab !
    </div>
    <div>
        Code value : <%= contents %>   <!--변수 사용하기. 확인할 방법은 프린트밖에 없음. 1.코드블럭으로 하기 2.jsp호출하기-->
    </div>
    </body>
</html>
<%  System.out.println("HelloWorldJSP - doGet() done."); %>