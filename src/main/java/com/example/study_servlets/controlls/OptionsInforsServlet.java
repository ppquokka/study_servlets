package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionsInforsServlet") // 동작을 하는 애는 매소드. 얘를 찾아서 싸야함. 얘가 doGet
public class OptionsInforsServlet extends HttpServlet { // 클라이언트 요청 시 화면을 보여줌. http가 들어올 때 url 패턴으로 들어옴
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        try {
             String search = request.getParameter("search");
            /*
            Commons commons = new Commons();
            Statement statement = commons.getStatement();     // Editor in MySQL workbench
            String query = "SELECT *\n" + //
                    "FROM option_infors;";
            ResultSet resultSet = statement.executeQuery(query);       // 쿼리넣기, 쿼리 결과는 리설트셋으로 나옴
                                                                    // while문을 돌려서 프린트했다고 해서 이건 html에 들어가지 않음. 터미널에서만 볼 수 있음
            */

            /*  String temp = " <div class=\"container\">\r\n" + //
                    "        <form action=\"/optionsInforsServlet\">     \r\n" + //
                    "        <lable for=\"\">\uAC80\uC0C9</lable>\r\n" + //
                    "        <input type=\"text\" name =\"search\">\r\n" + //
                    "        <button>\uAC80\uC0C9 \uD558\uAE30</button>\r\n" + //
                    "        </form>\r\n" + //
                    "    </div>";   // 작성 완료된 html에서 뜯어오기  */

            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    " <div class=\"container\">\r\n" + //
                    "        <form action=\"/optionsInforsServlet\">     \r\n" + //
                    "        <lable for=\"\">\uAC80\uC0C9</lable>\r\n" + //
                    "        <input type=\"text\" name =\"search\"value='"+search+"'>\r\n" + //
                    "        <button>\uAC80\uC0C9 \uD558\uAE30</button>\r\n" + //
                    "        </form>\r\n" + //
                    "    </div>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                    "                    <th>OPTION_NAME</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n" ;
                OptionInforsDao optionInforsDao = new OptionInforsDao(); // class로 만들었으니 instance화 시켜야 한다
                ArrayList optionInforList = new ArrayList<>();   // arraylist를 받기 위함. 그 class의 method  콜하기. line by line 으로 값이 들어감
                search = request.getParameter("search");
                optionInforList = optionInforsDao.SelectWithSearch(search);   //결과값이 arraylist. 근데 아직 받아낼 준비가 안되서 위에 작성해줌.
                // optionInforList는 값이 초기화되어있음. 그래서 결과값을 받을 때 초기화 시키고 받는다. 
                // while문을 for문으로 대치하기
                for(int i=0; i < optionInforList.size(); i=i+1){ // while(resultSet.next())  // System.out.println( + ", " + );
                    HashMap optionInforRecord = new HashMap<>();    // 루핑이 돌면서 값을 넣음 
                    optionInforRecord = (HashMap) optionInforList.get(i); 
                    contents = contents + "                <tr>\r\n" + //
                    "                    <td>"+optionInforRecord.get("OPTION_INFOR_ID")+"</td>\r\n" + //
                    "                    <td>"+optionInforRecord.get("OPTION_NAME")+"</td>\r\n" + //
                    "                </tr>\r\n";
                    }
                 
                contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "</html>";          // 이 컨텐츠틑 프린트엘엔에 적어서 보낸다
            // getWriter하기 전에 charset하기. 클라이언트 화면에서 한글은 오류가 나므로, 나가기 전에 이를 수정해줘야 함        
            response.setContentType("text/html;charset=UTF-8");   // UTF-8이 한글 오류 잡아줌 
            PrintWriter printwriter = response.getWriter();   // 프린트라이트는 이 클래스의 특정 변수를 사용함. 그러므로 리스폰스를 타고 날아감
            printwriter.println(contents);   // ★클라이언트 화면에 보여지는 건 여기 println()안에 들어가는 내용. 그렇기에 꼭 작성해줘야 함
                                             // ★화면에 보내져서 보이는 것이므로 breakpoint는 꼭 println다음에 찍어야 한다
            printwriter.close(); // 클라이언트에게 보내는 방식은 html. 그냥 스트링으로 실어서 한번에 보내기 그래서 스트링 사용
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
