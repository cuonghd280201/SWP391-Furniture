/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBUtils {
    
      public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Furniture";
        Connection con = DriverManager.getConnection(url,"sa","12345");
//            Connection con = DriverManager.getConnection(url,"sa","1234567890");
            return con;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
      
       public static Connection makeConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Furniture";
            Connection con = DriverManager.getConnection(url,"sa","12345");
            return con;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    

}
