package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo {
    private Connection connection;
    public void getDatabaseMetadata(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
            DatabaseMetaData databaseMetaData=connection.getMetaData();
            System.out.println(databaseMetaData.getDriverName());
            System.out.println(databaseMetaData.getDriverVersion());
            System.out.println(databaseMetaData.getUserName());
            System.out.println(databaseMetaData.getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
