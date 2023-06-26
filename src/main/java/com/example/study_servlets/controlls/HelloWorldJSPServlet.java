// 23.06.26(월)
package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {               
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {                                                         
            String contents = "Yoju Lab !";
            request.setAttribute("contents", contents);  // (키, 밸류(변수값))hashMap과 유사하다. 같지는 않다.

            // 다음 파일 호출 : 위의 특정한 항목을 지정, 리퀘스트디스패처에 실어보냄 
            // (HttpServletRequest request, HttpServletResponse response)이 정보를 forward(request,response)에 실어보냄
            // 여기에 내가 알고있는 method를 같이 실어보내면 받는 애는 좋지
            // 상대가 받을 때 추가로 어디에 정보를 실어보내야 하나? JSP는 호출되는(받는)입장에서는 request로 정보가 들어옴
            // JSP 입장에서는 servelt에서는 request에 실어 보내고, JSP는 거기에서 받음
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hellowordJSP.jsp"); // 가는 방향 결정남
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());  // 클라이언트가 얘를 부름. 얘는 변수로 담은 컨텐츠를 JSP를 호출하면서 거기에 값을 넘겨줌
                                                 // 원래 요주랩 하드코딩이 서블렛에서 넘어온 변수를 뿌려줌. servlet에서 JSP가 호출되고, 
                                                 // 서블렛에서 넘어온 변수를뿌림. 결국 JSP는 클라이언트와 접점이다. 내부적으로는 print & write다.
        }
        System.out.println("HelloWorldServlet - doGet() done.");    
    }
}