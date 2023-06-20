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
    @Override//상속이 된 걸 확장하는구나!! 알 수 있음
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
             /* doGet이라는 메소드에서 url와 클래스가 맵핑될 때, 클라이언트가 추가적으로 전하는 정보가 날아옴
             * 해당하는 부분이 서버가 들 때(예 메인 펑션뜸) 자기가 사용하는 리소스를 인스턴스화 시킴(new. 그래야 쓸 수 있음)
             * 전체적으로 올라와 있는 상태에서 doGet으로 불러서 parameter로 던져줌
             * getparameter를 사용해서 name구분자로 원하는 값을 꺼낼 수 있음. 이러한 이유로 "name, value, name, value..."함
             */
            String firstName = request.getParameter("first_name");
            String secondName = request.getParameter("second_name");
            PrintWriter printWriter = response.getWriter(); 
            // String contents = "Jiwon Kim ! ";
               // 변수 내부 지정
            // firstName은 내부 변수, first_name은 외부 변수.  이를 알아보기 위해 변수명이 다름
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