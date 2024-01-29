/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBUtils {
    public static Connection getConnection() {
    Connection con = null;
    String url = "jdbc:sqlserver://localhost;databaseName=Furniture;user=sa;password=12345";

    try {
        // Loading the driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Creating a connection
        con = DriverManager.getConnection(url);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return con;
}

}
