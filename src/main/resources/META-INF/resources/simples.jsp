<!-- 230626(월) -->
<!-- servlet으로 말하면 이 한 뭉치가 한 block = method이다 -->

<% int day = 3; %> 
<html> 
   <head><title>IF...ELSE Example</title></head> 
   
   <body>
         <div>
            dat value : <%= day%>
         </div>
      <% if (day == 1 || day == 7) { %>
         <p> Today is weekend</p>
      <% } else { %>
         <p> Today is not weekend</p>
      <% } %>
   </body> 
</html>