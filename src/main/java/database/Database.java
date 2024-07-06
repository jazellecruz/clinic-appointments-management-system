package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static Connection getDbConnection(){
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void closeConnection(Connection connection) {
       if (connection != null) {
           try {
                connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }
}
