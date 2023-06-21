package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Common;

public class FactorysDao {
    public ArrayList selectAll() {
        ArrayList arrayList = new ArrayList<>();
        try {
            Common commons = new Common();
            Statement statement = commons.getStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); // 하면 결과값이 return됨. ..??
             arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            while (resultSet.next()) {
                // query의 table을 가져올건데, 나올 값이 끝날때까지 돌기. next는 자체내에서 뭉치를 던지는 동작을함. 레코드가 다음레코드로
                // 넘어감.
                hashMap = new HashMap();
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID")); // 값, 키
                hashMap.put("COMPANY", resultSet.getString("COMPANY"));
                arrayList.add(hashMap);
            }
           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return arrayList;
    } // 퍼블릭 다음에 리턴값

}
