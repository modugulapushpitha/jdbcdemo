package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void getMetaData(){
          try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("Select * from employee");
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
              System.out.println(resultSetMetaData.getColumnCount());
              System.out.println(resultSetMetaData.getColumnName(1));
              System.out.println(resultSetMetaData.getColumnType(1));
              System.out.println(resultSetMetaData.getColumnTypeName(1));
    } catch (
    SQLException e) {
        e.printStackTrace();
    }
}
}
