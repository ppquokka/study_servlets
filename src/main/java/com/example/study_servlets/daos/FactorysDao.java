package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Common;

public class FactorysDao {
    public ArrayList selectAll() {
<<<<<<< HEAD
        ArrayList arrayList = new ArrayList();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // 이것만 바꾸면 commons ...
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);
            // ArrayList arrayList = new ArrayList(); // DB묶음... 결과값이 arraylist로 나오므로 retun값 및 기타 설정
            // 그리고 오류를 잡기위해 'try ~ catch'문 밖에서 arraylist 인스턴스시킴
            HashMap hashMap = new HashMap(); // 내부에서 사용할 애. while 문 돌때마다 getString컴퍼니_ID를 넣어준다..?
            while (resultSet.next()) {
                hashMap = new HashMap();
                hashMap.put("Company_ID", resultSet.getString("Company_ID")); // 1 column값
                hashMap.put("Company", resultSet.getString("Company"));
                arrayList.add(hashMap);
                /*
                 * contents = contents + "  <tr>\r\n" + //
                 * "                    <td>" + resultSet.getString("Company_ID") + "</td>\r\n"
                 * + //
                 * "                    <td>" + resultSet.getString("Company") + "</td>\r\n" +
                 * //
                 * "                </tr>\r\n"; //
                 */
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
           ArrayList arrayList = new ArrayList();
=======
        ArrayList arrayList = new ArrayList<>();
>>>>>>> 2387c1a2ebe065b7ac257c2243160db5807462f2
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
