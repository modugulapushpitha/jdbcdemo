package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public void rowsetDemo()

    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/Demo");
        rowSet.setUsername("root@localhost");
        rowSet.setPassword("Root@123");

        rowSet.setCommand("select * from employee");
        rowSet.execute();
        while (rowSet.next()){
            System.out.println("Id: " + rowSet.getString(1));
            System.out.println("Name: " + rowSet.getString(2));
            System.out.println("age: " + rowSet.getString(3));
        }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
