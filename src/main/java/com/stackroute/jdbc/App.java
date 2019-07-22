package com.stackroute.jdbc;

public class App 
{
    public static void main( String[] args )
    {
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("krishna",'M');
        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        resultSetMetadataDemo.getMetaData();
        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        databaseMetadataDemo.getDatabaseMetadata();
        //RowSetDemo rowSetDemo=new RowSetDemo();
        //rowSetDemo.rowsetDemo();
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        jdbcBatchDemo.batchProcessDemo();
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.TransactionProcessDemo();
    }
}
