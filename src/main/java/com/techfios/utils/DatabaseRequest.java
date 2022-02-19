package com.techfios.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.RowResult;

public class DatabaseRequest {
    
    private static final String databaseName = "september2021";

    private String requestUrl = "jdbc:mysql://localhost:3306/" + databaseName;
    private String query = "select * from customerInformation";
    private String username = "root";
    private String password = "root";
    private ResultSet resultSet = null;


    public ResultSet getData(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(requestUrl, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();

            return resultSet;


        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return resultSet;

    }

}
