
package event_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.util.Properties;

public class conn {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/event";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    // init connection object
    Connection connection;

     Statement s;
     
     
     public conn(){
         try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                s = connection.createStatement();

          } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
     }
     public static void main(String args[]){
         conn c = new conn();
     }
}