package com.example.study_servlets.controlls;


import com.example.study_servlets.commons.Common;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
    public Common common;

     @Override
    public void init() throws ServletException {
        common = new Common();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // MySQL workbench 실행 : JDBC
            // User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.41:3306/db_cars"; // local 호스트가 내커퓨터 자체를 말함
            String user = "yojulab";
            String password = "!yojulab*";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // Query Edit
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR")
                        + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
            }
            
            String carName = "VW_sciroccoR";
            int year = 2023;
            String carInforID = common.generateUUID();
            String companyID = "C001";
            
            query = "INSERT INTO car_infors (CAR_NAME,YEAR,CAR_INFOR_ID,COMPANY_ID)\n" + //
                    "value ('"+carName+"', '"+year+"', '"+carInforID+"', '"+companyID+"')";
            int count = statement.executeUpdate(query);
            
            System.out.println(count);
            System.out.println();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }

    }
}
