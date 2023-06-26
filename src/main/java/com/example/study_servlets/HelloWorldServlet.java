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
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          // HTML을 완성한 다음, 이를 상대에게 보내줄때... return역할을 해주는 애↑(HttpServletResponse resp)
        System.out.println("HelloWorldServlet - doGet()");
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter(); 
            String contents = "Yoju Lab !";
            /*
            // 파일을 특정 라인을 잘라서 넣어 네트워크로보냄. 왜냐 컴퓨터 자원을 나 혼자 쓰지않기때문.
            String firstName = "request.getParameter(firstName)";
            String secondName = "request.getParameter(secondName)";
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
            */
            printWriter.println(contents); 
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
    }    
}
/* terminal에서 받는 방식과 동일하다. 얘는 웹으로 받을 수 없는 상태
 * 그래서 얘를 이 기능으로 사용할게! 라고 래핑함 = @
 * 인식할 때 얘를 사용. 랩핑되었기 때문에 url에서 사용하는 주소 패턴을 넣어줌: ip, port, 주소
 * 내부는 클래스이름(인스턴스화 된 상태에서 접근해야 함)으로 접근하지만, 
 * 외부는 클래스로 인식불가능하므로 url방식으로 접근해서 인식함
*/