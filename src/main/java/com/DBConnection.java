package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/online_shoping";
  //  private static final String JDBC_USER = "root";
   // private static final String JDBC_PASSWORD = "eyob";

    public static Connection getConnection() throws SQLException {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
    		
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shoping","root","eyob");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }
}
