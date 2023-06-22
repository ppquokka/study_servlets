package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Common;

public class CarInforsDao {
    public ArrayList selectAll() {

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
        return arrayList;

    }
}
