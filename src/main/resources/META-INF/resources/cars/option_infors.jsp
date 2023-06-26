<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <%
         String search = (String) request.getAttribute("search");
        %>
        <form action="http://192.168.0.41:8080/optionsInforsServlet">     
            <label>검색
                <input type="text" name="search" value="<%= search %>">
            </label>
        <input type="text" name ="search" value="<%= search %>">
        <button>검색 하기</button>
        </form>
    </div>
    <div class="container">
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>OPTION_INFOR_ID</th>
                    <th>OPTION_NAME</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <%
             ArrayList<HashMap> optionInforList = (ArrayList<HashMap>) request.getAttribute("optionInforList");  
            %>
            <form action="">
                <tbody>
                    <% for(int i=0; i< optionInforList.size(); i=i+1) { %>
                        <%
                        HashMap optionInforRecord = new HashMap<>();
                        optionInforRecord = (HashMap) optionInforList.get(i);
                        %>
                    <form>
                        <input type="hidden" name="unique_id" value="<%= optionInforRecord.get("OPTION_INFOR_ID") %>">
                    <tr>
                        <td><%= optionInforRecord.get("OPTION_INFOR_ID") %></td>
                        <td><%= optionInforRecord.get("OPTION_NAME") %></td>
                        <td>
                            <button type="submit" formaction="/optionInforsDeleteServlet">
                                <%= optionInforRecord.get("OPTION_INFOR_ID") %>
                            </button>
                        </td>
                    </tr>
                    </form>
                <% } %>
                </tbody><!--<tbody>안에 line by line으로 딜리트, 상세보기, 업데이트의 의미는 id가 동일하다.
                            그래서 form 태그로 감쌌다. <tr>로 감쌈. -->
            </form>
        </table>
    </div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
