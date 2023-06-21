package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import com.example.study_servlets.daos.FactorysDao;

@WebServlet(urlPatterns = "/connectDBServle_A_Client")
public class ConnectDBServlet_A_Client extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // study_javas에서 ConnectDBs_Servlet.java의 try~catch문 복붙함
        try {
            /*
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            // ~~ 3306/데이터베이스 입력 : 데이터베이스가 동일해야 작동함
            String url = "jdbc:mysql://192.168.0.41:3306/db_cars"; // local 호스트가 내커퓨터 자체를 말함
            String user = "yojulab";
            String password = "!yojulab*";
            // input시 java.sql로 해야함
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");
            */

            // 클라이언트에 html 화면 제공
           String contents = "<!DOCTYPE html>\r\n" + //
                   "<html lang=\"en\">\r\n" + //
                   "\r\n" + //
                   "<head>\r\n" + //
                   "    <meta charset=\"UTF-8\">\r\n" + //
                   "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                   "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                   "    <title>connect_DB_servlet_A</title>\r\n" + //
                   "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                   "</head>\r\n" + //
                   "\r\n" + //
                   "<body>\r\n" + //
                   "    <!--table\uC740 tr,td\uAC00 \uAF2D \uC788\uC5B4\uC57C \uD568. table\uC548\uC758 table\uC740 td\uC548\uC5D0 \uB4E4\uC5B4\uAC10-->\r\n" + //
                   "    <div class=\"container\">\r\n" + //
                   "        <table class=\"table table-bordered table-hover\">\r\n" + //
                   "            <thead>\r\n" + //
                   "                <tr>\r\n" + //
                   "                    <th>COMPANY_ID</th>\r\n" + //
                   "                    <th>COMPANY</th>\r\n" + //
                   "                </tr>\r\n" + //
                   "            </thead>\r\n" + //
                   "            <tbody>" ;
           
            // - query Edit
            /*  묶음으로 넘어감
            Commons commons = new Commons();
            Statement statement = commons.getStatement();   // 이것만 바꾸면 commons ...
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); 
            */

            FactorysDao factoryDao = new FactorysDao();
            ArrayList factoryList = new ArrayList();
            factoryList = factoryDao.selectAll();          //select 로 DB에가서...
            for(int i=0; i < factoryList.size(); i=i+1){   // list기 때문에 for문
                HashMap hashMap = new HashMap();           // 첫번째는 해쉬맵이 나올거다. 안에서만 우선 쓴다
                hashMap = (HashMap) factoryList.get(i);
                 contents = contents + "  <tr>\r\n" +               // tbody다음에 tr
                   "                    <td>"+hashMap.get("Company_ID")+"</td>\r\n" + // 변수 넣음
                   "                    <td>"+hashMap.get("Company")+"</td>\r\n" + //
                   "                </tr>\r\n" ;                   // 위의 문장과 붙어서 while문 돌면서 계속 늘어날 예정
            }
            
            // DB와 HTML을 구분하여 작성. 특정 매소드의 어느 라인, 어느 에러가 표시됨. 
            //그럼 그 매소드만 에러 수정 하면 됨. 유지 보수에 편리함

            /*
            while (resultSet.next()) { 
               원래는 여기에 'contents = contents + '가 있었음
            }
            */

            contents = contents + "<tbody>\r\n" + //
                   "            </tbody>\r\n" + //
                   "        </table>\r\n" + //
                   "    </div>\r\n" + //
                   "\r\n" + //
                   "</body>\r\n" + //
                   "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>\r\n" + //
                   "\r\n" + //
                   "</html>";  

            //클라이언트에 html 화면 제공
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter(); 
            printWriter.println(contents); 
            printWriter.close();
           
            // SELECT COUNT(*) AS CNT FROM FACTORYS;
            /*
            query = "SELECT COUNT(*) AS CNT FROM FACTORYS";
            resultSet = statement.executeQuery(query);
            int totalCount = 0;
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }
            */

            /*
             * insert into FACTORYS
             * (COMPANY_ID, COMPANY)
             * value
             * ('car-01', 'AUDI');)
             */

            /*
            String companyId = "car-01 ";
            String company = "AUDI ";
            query = "insert into FACTORYS " +
                    "(COMPANY_ID, COMPANY) " +
                    " value " +
                    "('" + companyId + "', '" + company + "') ";

            int count = statement.executeUpdate(query); // table로 결과값 받을 필요 없으므로 이거 사용

            String Company_ID = "CAR-01 ";
            String Company = "페라리 ";
            query = "UPDATE factorys " +
                    "SET COMPANY = '" + Company + "' " +
                    "WHERE Company_ID = '" + Company_ID + "'";
            count = statement.executeUpdate(query);

            String deleteCompany_ID = "CAR-01 ";
            String deleteCompany = "페라리 ";
            query = "DELETE FROM factorys " +
                    "WHERE " +
                    "Company_ID = 'CAR-01' ";
            count = statement.executeUpdate(query);

            */
            
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        super.doGet(request, response);
    }
}

