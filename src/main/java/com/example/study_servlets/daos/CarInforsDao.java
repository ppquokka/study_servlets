package com.example.study_servlets.daos;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Common;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/carInforsDao")
public class CarInforsDao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("carInforsDao - doGet()");
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        try {
            Common commons = new Common();
            Statement statement = commons.getStatement();

            String query = "SELECT * FROM car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            HashMap<String, String> hashMap;

            while (resultSet.next()) {
                hashMap = new HashMap<>();
                hashMap.put("CAR_NAME", resultSet.getString("CAR_NAME"));
                hashMap.put("YEAR", resultSet.getString("YEAR"));
                hashMap.put("CAR_INFOR_ID", resultSet.getString("CAR_INFOR_ID"));
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                arrayList.add(hashMap);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
