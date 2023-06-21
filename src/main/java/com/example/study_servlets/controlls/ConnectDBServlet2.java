package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ConnectDBServlet2")
public class ConnectDBServlet2 extends HttpServlet {
    @Override//상속이 된 걸 확장하는구나!! 알 수 있음
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.41:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");
            Statement statement = connection.createStatement();

            // 클라이언트에 html 화면 제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n" + //
                    "    <!-- <link rel=\"stylesheet\" href=\"../CSS/commons.css\"> -->\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "   <div class = \"container\">\r\n" + //
                    "    <table class=\"table table-bordered table-hover\">\r\n" + //
                    "        <thead>\r\n" + //
                    "            <tr>\r\n" + //
                    "                <th>COMPANY_ID</th>\r\n" + //
                    "                <th>COMPANY</th>\r\n" + //
                    "            </tr>\r\n" + //
                    "        </thead>\r\n" + //
                    "        <tbody>\r\n" ;


            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); 
            while (resultSet.next()) {
                    contents = contents + "<tr>\r\n" + //
                                          "<td>"+ resultSet.getString("COMPANY_ID")+"</td>\r\n" + //
                                          "<td>"+ resultSet.getString("COMPANY") +"</td>\r\n" + //
                                          "</tr>\r\n" ;
            }
                    contents = contents + "</tbody>\r\n" + //
                                          "</table>\r\n" + //
                                          "</div> \r\n" + //
                                          "</body>\r\n" + //
                                          "</html>";

            // 클라이언트에 html 화면 제공
            PrintWriter printWriter = response.getWriter(); 
            printWriter.println(contents); 
            printWriter.close();

            query = "SELECT count(*) AS CNT FROM factorys";
            resultSet = statement.executeQuery(query);
            int totalcount = 0;
              while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalcount = resultSet.getInt("CNT");
            }

            String COMPANY_ID = "CAR-01";
            String COMPANY = "AUDI";

            COMPANY_ID = "CAR-01";
            COMPANY = "페라리";
            query ="UPDATE factorys " + "SET COMPANY ='"+COMPANY+"' " + "WHERE COMPANY_ID ='"+COMPANY_ID+"' ";  // CAR-01 AUDI를 페라리로 업데이트


            query = "DELETE FROM factorys " + "WHERE COMPANY_ID = '"+COMPANY_ID+"'";  // CAR-01 페라리 삭제
            
            int count = statement.executeUpdate(query);

            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());   // 에러 내용을 볼수 있는 명령문
            // TODO: handle exception
        }
                    System.out.println();
    }
    
}
