package com.example.study_servlets.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.mysql.cj.xdevapi.Statement;

public class Commons {
    public java.sql.Statement getStatement(){
            String url = "jdbc:mysql://192.168.0.25:3306/db_cars"; 
            String user = "yojulab";
            String password = "!yojulab*";

        java.sql.Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (java.sql.Statement) statement;
    }

    public String getGeneratorID(){
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");  
        String strDate = formatter.format(date);
        return strDate;
    }
}