package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /session/CreateServlet?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/CreateServlet")
public class SessionCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // 직접 처볼것
            // display
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<div>Create Session Servlets</div>"); // 네트워크에 println을 계속 쏴줌
            
            // login. JSessionID
            HttpSession httpSession = request.getSession(false); // 클라이언트의 상태에 따라 만들어낼지말지 결정함
            if (httpSession != null) { // JSESSION 있음 : 로그인 되었다는 표시  /  = 해당되는 사항에 이미 서버에 똑같은게 있다.  해당 정보를 가져오기만 하면 됨
                String usernameSession = (String) httpSession.getAttribute("username");
                printWriter.println("<dis>username : "+usernameSession+"</div>");
            } else { // 없음 : 로그인
                httpSession = request.getSession();   //오류 방어 코드
                if ("yojulab".equals(username) && "1234".equals(password)) {
                    httpSession.setAttribute("username", username);
                    httpSession.setAttribute("password", password);
                    printWriter.println("<div>" + username + ", " + password + "</div>");
                } else {
                    printWriter.println("<div>Faild</div>");
                }
            }

            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
