package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Common;

public class PollsDao {
    // 원래대로 돌아왔을 때 삭제??
    public int Insert(HashMap<String, Object> map){
        int count = 0;
        try {
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "insert into statistics\n" + //
                        "(STATISTICS_ID, RESPONDENTS_ID, QUESTIONS_ID, CHOICE_ID)\n" + //
                        "values\n" ;
            // print map
            int loops = 1;
            String userId = "R1";   // from session 그런데 우리는 지금 세션을 할 수 없으니, 유저아이디를 임의로 넣어줌
            for(String key : map.keySet()){   // for each의 구문이다':' | 
                String uuid = common.getGenerateUUID();
                if(loops > 1){
                   query = query + ", ";      
                }
               query = query + "('"+uuid+"', '"+userId+"', '"+key+"', '"+map.get(key)+"')\n";
               // R1은 세션에서 가져와야 하지만, 할 수 없으므로 임의값 줌
               // System.out.println(key+", " + map.get(key));
               loops = loops + 1;
            } 
               query = query + ";";
               count = statement.executeUpdate(query);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList InforList = new ArrayList<>();
        try {
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "SELECT T_QC.QUESTIONS_ID, T_QC.CHOICE_ID, T_Q.QUESTIONS, T_C.CHOICE\n" + //
                    "FROM question_choice as T_QC\n" + //
                    "   inner join questions as T_Q\n" + //
                    "   on T_QC.QUESTIONS_ID = T_Q.QUESTIONS_ID\n" + //
                    "   inner join choice as T_C\n" + //
                    "   on T_QC.CHOICE_ID = T_C.CHOICE_ID\n" + //
                    "order by T_QC.QUESTIONS_ID, T_QC.CHOICE_ID\n" + //
                    ";";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap InforRecord = new HashMap<>();
            while (resultSet.next()) {
                InforRecord = new HashMap<>();
                InforRecord.put("QUESTIONS_ID", resultSet.getString("QUESTIONS_ID"));
                InforRecord.put("CHOICE_ID", resultSet.getString("CHOICE_ID"));
                InforRecord.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                InforRecord.put("CHOICE", resultSet.getString("CHOICE"));

                InforList.add(InforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return InforList;
    }
}
