package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session/DeleteServlet")
public class SessionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // expires session
            HttpSession httpSession = request.getSession();
            httpSession.invalidate(); // 세션 아웃. Server side

            // delete cookies
            Cookie[] cookies = request.getCookies();
            String content = "<div>CookiesGetAndDeleteServle</div>";
            for (Cookie cookie : cookies) { // 포문 내에서 쿠키스는 array로 되어있음. 그 안에 쿠키가 담겨있음
                                            // 그 쿠키는 hashMap방식과 매우 유사하다
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("JSESSIONID")) { // 쿠키 삭제  - client side
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                } 
            }

            PrintWriter printWriter = response.getWriter();
            String contents = "<div>Logout !</div>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        super.doGet(request, response);
    }

}
