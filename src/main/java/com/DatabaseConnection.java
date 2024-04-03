package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

   
    public static Connection getConnection() {
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Shoping", "root", "eyob");
            System.out.println("Connection established successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

     public static ResultSet getResultFromSqlQuery(String sqlQueryString) {
        ResultSet rs = null;
        try {
            if (connection == null) {
                getConnection();
            }
            rs = connection.createStatement().executeQuery(sqlQueryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int insertUpdateFromSqlQuery(String sqlQueryString) {
        int i = 2;
        try {
            if (connection == null) {
                getConnection();
            }
            i = connection.createStatement().executeUpdate(sqlQueryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
