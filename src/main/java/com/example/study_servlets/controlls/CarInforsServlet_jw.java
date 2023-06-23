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

import com.example.study_servlets.commons.Common_jw;

@WebServlet(urlPatterns = "/carInforsServlet")
public class CarInforsServlet_jw extends HttpServlet {
    private static final String UUID = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url = "jdbc:mysql://192.168.0.41:8080/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            Commons_s commoms = new Commons_s();

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM db_cars.car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("CAR_NAME") + " " 
                        + resultSet.getString("YEAR") + " "
                        + resultSet.getString("CAR_INFOR_ID") + " "
                        + resultSet.getString("COMPANY_ID"));
            }

            // SELECT COUNT(*) AS CNT FROM FACTORYS;
            query = "SELECT * FROM db_cars.car_infors\n" + //
                    "insert into car_infors\n" + //
                    "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
                    "values\n" + //
                    "('speed', '1892', '" + Common_jw.CAR_INFOR_IDUUID() + "', 'CAR-01');";
            System.out.println(query);
            int totalcount = 0;

            /* String query2 = "SELECT COUNT(*) AS CNT FROM car_infors";
            resultSet = statement.executeQuery(query2);
            int totalCount = 0;
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }
            // int count = statement.executeUpdate(query);
            String CAR_NAME = "speed";
            String YEAR = "1892";
            String 
            System.out.println(query2); */

            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        super.doGet(request, response);
    }
}
