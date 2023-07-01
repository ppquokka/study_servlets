// 23.06.26(월)
package com.example.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet")
public class HelloWorldServlet_jsp extends HttpServlet {               
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("HelloWorldServlet - doGet()");            // html 밖에 있으므로
        try {                                                         // helloworldJSP.jsp
            response.setContentType("text/html;charset=UTF-8");  // html 글자깨짐 방지
            PrintWriter printWriter = response.getWriter();   // html 시작
            String contents = "Yoju Lab !";
            printWriter.println(contents); 
            printWriter.close();                             // html 끝
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");      //html 밖
    }    
}