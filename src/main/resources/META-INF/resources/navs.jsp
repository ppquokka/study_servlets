<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap CDN template</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css">
    <link rel="stylesheet" href="">
</head>

<body>
    <!-- <div class="container">-->
        <!-- end(우측정렬) center(가은데) nav-tabs(가운데)-->
        <!--'nav-pills' 자바 스크립트에서...-->
         <!--<ul class="nav justify-content-center">-->
             <!--<li class="nav-item">-->
                 <!--<a class="nav-link" aria-current="page" href="#">Active</a>-->
             <!--</li>-->
             <!--<li class="nav-item">-->
                <!--현재 선택된 메뉴 표시 nav-link active 굳이 안넣어도된다-->
                 <!--<a class="nav-link" href="#">Link</a>-->
             <!--</li>-->
             <!--<li class="nav-item">-->
                 <!--<a class="nav-link" href="#">Link</a>-->
            <!-- </li>-->
             <!--<li class="nav-item">-->
                <!--링크조차도 클릭되지 않음 disabled-->
                 <!--<a class="nav-link disabled">Disabled</a>-->
             <!--</li>-->
         <!--</ul>-->
     <!--</div> -->
     
    <!-- top menu -->
    <%@ include file="/top_menus.jsp" %> <!--static 아래의 파일도 넣어줄 수 있음-->
    <div class="container">
       <div class="h1">메인 페이지</div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>

</html>