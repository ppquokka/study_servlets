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

import com.example.study_servlets.commons.Common;

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet{
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
            // - query Edit
            Statement statement = connection.createStatement();

            

            Common common = new Common();
            String CARINFORID = common.generateUUID();
            String query= "INSERT INTO car_infors\n" + //
                    "( CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID )\n" + //
                    "value\n" + //
                    "('SKY', '1994', '"+CARINFORID+"', 'C005')";
            int count = statement.executeUpdate(query);

            query = "SELECT * FROM db_cars.car_infors";
            ResultSet resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("CAR_NAME") + "," + resultSet.getString("YEAR") + "," + resultSet.getString("CAR_INFOR_ID") + "," +resultSet.getString("COMPANY_ID")); 

            System.out.println();

        } 
        }catch (Exception e) {
            System.out.println(e.getMessage());   // 에러 내용을 볼수 있는 명령문
            // TODO: handle exception
        }
                    System.out.println();
    }
    
}
