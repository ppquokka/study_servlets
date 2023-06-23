package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/cookies/GetAndDeleteServlet")
public class CookiesGetAndDeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /* cookies.  쿠키만드는 방법은 쿠키클래스이용하기 */
            Cookie[] cookies = request.getCookies();
            String content = "<div>CookiesGetAndDeleteServle</div>";
            for(Cookie cookie: cookies){   // 포문 내에서 쿠키스는 array로 되어있음. 그 안에 쿠키가 담겨있음
                                           // 그 쿠키는 hashMap방식과 매우 유사하다
                String name = cookie.getName();
                String value = cookie.getValue();
                if(name.equals("secondName")){   // 쿠키 삭제
                   cookie.setMaxAge(0);
                   response.addCookie(cookie); 
                } else{   // 출력
                   content = content + "<div>" + name + ", " + value + "</div>";     
                }                
            }           

            // display.   화면에 아무것도 안나오면 이상하니까 넣어주기. html관련 된 것. 프린트 롸잇트 기본구조
        PrintWriter printWriter = response.getWriter();        
        printWriter.println(content);
        printWriter.close();
            /*list로 올라옴. 그래서 키를 알고있으면 찍으면됨.하지만 이게 어려우므로
             쿠키가 클라이언트쪽에서 들어올 땐 list 방식으로 들어오고, 키를 명확하게 알 수 없다.
             루핑을 돌려서 알아낸다. list안에 쿠키가 들어있다
             */
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        super.doGet(request, response);
    }
     
}
