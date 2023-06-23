package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mynameRequestServletJSP")
public class MynameRequestServletJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
          /*servlet JSP로 분리되니까 필요없으므로 삭제
           *디스패처한테 리스팩트, 리스폰스를 던져줌. 원래 요청자 클라이언트가 직접 정보를 넣어url로 쏨 request
           우리가 원하는 정보로 변환시켜야 함
           리퀘스트 던저주기 */
          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myname_request.jsp");
          requestDispatcher.forward(request, response);
          // 추가로 uri를 바꿔줘야함. 중복되지 않게하기위해
        } catch (Exception e) {
        System.out.println(e.getMessage());
       }
    }
}
