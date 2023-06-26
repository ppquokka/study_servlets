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
            
            request.setAttribute("contents", contents); //애는 "contents" 구분자 뒤에놈이 진짜 값
            //다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("helloworldJSP.jsp"); //방향
            requestDispatcher.forward(request, response); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}
/* terminal에서 받는 방식과 동일하다. 얘는 웹으로 받을 수 없는 상태
 * 그래서 얘를 이 기능으로 사용할게! 라고 래핑함 = @
 * 인식할 때 얘를 사용. 랩핑되었기 때문에 url에서 사용하는 주소 패턴을 넣어줌: ip, port, 주소
 * 내부는 클래스이름(인스턴스화 된 상태에서 접근해야 함)으로 접근하지만, 
 * 외부는 클래스로 인식불가능하므로 url방식으로 접근해서 인식함
*/