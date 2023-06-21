package com.example.study_servlets.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connectDBServlet" )
public class ConnectDBServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.41:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");
            // - query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); // 하면 결과값이 return됨. ..??
            while (resultSet.next()) {
                // query의 table을 가져올건데, 나올 값이 끝날때까지 돌기. next는 자체내에서 뭉치를 던지는 동작을함. 레코드가 다음레코드로
                // 넘어감.
                System.out.println(
                        resultSet.getString("COMPANY_ID") + " " + // getStting은 DB의 type을 따라가기때문에 getString
                                resultSet.getString("COMPANY"));
            }

            // SELECT count(*) AS CNT FROM factorys;
            query = "SELECT count(*) AS CNT FROM factorys";
            resultSet = statement.executeQuery(query);
            int totalcount = 0;
              while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalcount = resultSet.getInt("CNT");
            }
            // INSERT INTO factorys
            // (COMPANY_ID,COMPANY)
            // value
            // ('CAR-01', 'AUDI');

            String COMPANY_ID = "CAR-01";
            String COMPANY = "AUDI";
            // query ="INSERT INTO factorys " + "(COMPANY_ID,COMPANY) " + "value " + "('"+COMPANY_ID+"', '"+COMPANY+"') ";
            // // 변수를 넣어줄때 싱글 쿼테이션 '' 안에 더블 쿼테이션 ""을 넣고 ++사이에 변수를 넣어줘야한다.
            // int count = statement.executeUpdate(query);

// UPDATE factorys
// SET COMPANY = '패러리'
// WHERE COMPANY_ID = 'CAR-01'
            COMPANY_ID = "CAR-01";
            COMPANY = "페라리";
            query ="UPDATE factorys " + "SET COMPANY ='"+COMPANY+"' " + "WHERE COMPANY_ID ='"+COMPANY_ID+"' ";  // CAR-01 AUDI를 페라리로 업데이트

// DELETE FROM factorys
// WHERE COMPANY_ID = 'CAR-01';
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
