package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/getRequestParamsServlets")
public class GetRequestParamsServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("first_name");
            String secondName = request.getParameter("second_name");
            PrintWriter printWriter = response.getWriter(); 
            // String contents = "Jiwon Kim ! ";
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title> Hello World ! </title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div> first Name : "+firstName+" </div>\r\n" + //  위에 변수를 만들어서 넣어줌
                    "    <div>second Name : "+secondName+" </div>\r\n" + //
                    "</body>\r\n" + //
                    "</html> ";
            printWriter.println(contents); 
            printWriter.close();
            //  PrintWriter printWriter = response.getWriter();
            //  String contents = "";
            //  printWriter.println(contents);
            //  printWriter.close();             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//@WebServlet(urlPatterns = "/getRequestServlets") 1번
// extends HttpServlet 2번
// doGet method 3번
// 파라미터 훔칠때 이름이 중심임