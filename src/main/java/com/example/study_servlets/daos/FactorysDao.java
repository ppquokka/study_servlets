package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class FactorysDao {
    public ArrayList selectAll() {

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
        }
        return arrayList;
    }
}
