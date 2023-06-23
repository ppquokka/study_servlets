package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Common;

public class OptionInforsDao {
    public int DeleteWithUniqueID(String unique_id){
        int count = 0;
        try {
            Common commons = new Common();
            Statement statement = commons.getStatement();
            String query = "delete \n" + //
                    "from option_infors\n" + //
                    "where OPTION_INFOR_ID = '"+unique_id+"";
           count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    public ArrayList SelectWithSearch(String search){
        ArrayList optionInforList = new ArrayList();
        try {
            if(search==null){
                search = "";
            }
            Common commons = new Common();
            Statement statement = commons.getStatement(); // Editor in workbench
            String query = "SELECT *\n" + //
                    "FROM option_infors\n" + //
                    "WHERE OPTION_NAME like '"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap optionInforRecord = new HashMap();
            while (resultSet.next()) {
                optionInforRecord = new HashMap();  //query를 돌려 나온 답을 키,값으로 HashMap에 저장한다.
                optionInforRecord.put("OPTION_INFOR_ID",resultSet.getString("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME",resultSet.getString("OPTION_NAME"));

                optionInforList.add(optionInforRecord);  //HashMap에 담은걸 ArrayList에 담는다.
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
        return optionInforList;
    }
}