package com.stackroute.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcBatchDemo {
    public void batchProcessDemo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            stmt.addBatch("insert into employee values(12,'nani',27,'M')");
            stmt.addBatch("insert into employee values(13,'dinesh',25,'M')");
            stmt.executeBatch();//executing the batch
            System.out.println("executed successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}