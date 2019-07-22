package com.stackroute.jdbc;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class SimpleJdbcDemo {
    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//        resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

        }


    /*Print ResultSet in reverse order*/

    public void getEmployeeDetailsInReverse() {

        /*Load driver and register with DriverManager*/

        /*Use DriverManager to get Connection*/
      try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
          statement = connection.createStatement();
          resultSet = statement.executeQuery("Select * from employee");
          System.out.println("Print ResultSet in reverse order");
          resultSet.afterLast(); //Moves the cursor to the end of the ResultSet object
          while(resultSet.previous())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
           } catch (SQLException e) {
            e.printStackTrace();
            }
         }

    /*Move ResultSet to second row and print in reverse order*/

    public void getEmployeeDetailsFromSecondRowInReverse() {
        /*Load driver and register with DriverManager*/

        /*Use DriverManager to get Connection*/
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from employee");
            resultSet.absolute(3); //Moves the curser to the end of the ResultSet object
            System.out.println("Move ResultSet to second row and print in reverse order");
            while(resultSet.previous())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,Character gender) {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "Root@123");
            PreparedStatement statement=connection.prepareStatement("select * from employee where name=? and gender=?");
            statement.setString(1,name);
            statement.setString(2,String.valueOf(gender));
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+" "+"Age:"+resultSet.getString(3)+" "+"Gender:"+resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}