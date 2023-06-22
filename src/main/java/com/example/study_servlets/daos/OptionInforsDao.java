package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Common;
import com.example.study_servlets.commons.Commons;

public class OptionInforsDao {
    public int UpdateWithUniqueID(String name) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in MySQL workbench 띄움
            String unique_id = commons.generateUUID();

            String query = "UPDATE option_infors\n" + //
                    "SET OPTION_NAME = '" + name + "'\n" + //
                    "where OPTION_INFOR_ID = '" + unique_id + "'";

            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;

    }

    public int InserWithUniqueID(String name) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String uniqiue_id = commons.generateUUID();
            String query = "INSERT INTO option_infors\n" + //
                    "(OPTION_INFOR_ID, OPTION_NAME)\n" + //
                    "values\n" + //
                    "('" + uniqiue_id + "', '" + name + "')";

            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int DeleteWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in MySQL workbench 띄움
            String query = "DELETE FROM option_infors\n" + //
                    "WHERE OPTION_INFOR_ID = '" + unique_id + "';";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList optionInfoList = new ArrayList<>();
        try { // OptionsInforsServlet.java 와 연계
            if (search == null) {
                search = "";
            }
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in MySQL workbench
            String query = "SELECT *\n" + //
                    "FROM option_infors\n" + //
                    "WHERE OPTION_NAME LIKE '" + search + "%';";

            ResultSet resultSet = statement.executeQuery(query);

            HashMap optionInfoRecord = new HashMap<>();

            while (resultSet.next()) {
                optionInfoRecord = new HashMap<>();
                optionInfoRecord.put("OPTION_INFOR_ID", resultSet.getString("OPTION_INFOR_ID"));
                optionInfoRecord.put("OPTION_NAME", resultSet.getString("OPTION_NAME"));

                optionInfoList.add(optionInfoRecord);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInfoList;
    }
}
