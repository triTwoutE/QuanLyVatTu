/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author colan
 */

public class JDBCConnection {  
//    public static void main(String[] args) {
//        try {
//            Connection conn = getConnection(DB_URL,USER_NAME,PASSWORD);
//        } catch (SQLException ex) {
//            System.getLogger(JDBCtoMySQL.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
//    }

    //Conect to mySQL
    public static Connection getConnection() throws SQLException{
        final String DB_URL = "jdbc:mysql://localhost:3306/project_java";
        final String USER_NAME = "root";
        final String PASSWORD = "0312";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            //System.out.println("Connect successfully!");
        } catch (ClassNotFoundException ex) {
            //System.out.println("Connect failed!");
            ex.printStackTrace();
        }
        return connection;
    }
    

}
