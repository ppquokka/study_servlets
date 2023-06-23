package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/cookies/CreateServlet")
public class CookiesCreateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /* cookies.  쿠키만드는 방법은 쿠키클래스이용하기 */
            Cookie cookie_first = new Cookie("firstName", "Jiwon!");     // 인스턴스화하면 컨스트럭트를 만듦. (예: 상품 상품명)
            Cookie cookie_second = new Cookie("secondName", "Kim!");     // 입력값의 공백을 허락하지 않는다
            
            // 얘가 클라이언트에 보내져야 함
            response.addCookie(cookie_first);
            response.addCookie(cookie_second);

            // display.   화면에 아무것도 안나오면 이상하니까 넣어주기. html관련 된 것. 프린트 롸잇트 기본구조
        PrintWriter printWriter = response.getWriter();
        String content = "<div>CreateCookieServlets</div>";
        printWriter.println(content);
        printWriter.close();
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        super.doGet(request, response);
    }
     
}

/*  chatGPT가 알려준 수정사항
package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/CreateServlet")
public class CookiesCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Cookie cookie_first = new Cookie("firstName", "Jiwon!");
            Cookie cookie_second = new Cookie("secondName", "Kim!");

            response.addCookie(cookie_first);
            response.addCookie(cookie_second);

            PrintWriter printWriter = response.getWriter();
            String content = "<div>CreateCookieServlet</div>";
            printWriter.println(content);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

 */
