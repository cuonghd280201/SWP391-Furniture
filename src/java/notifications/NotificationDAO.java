/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifications;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class NotificationDAO {
    
    
     public List<NotificationDTO> getListNotiStaff() throws SQLException {
        List<NotificationDTO> notifiLists = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            connection = DBUtils.makeConnection();
            if (connection != null) {
                String sql = "Select notificationID, userID, notificationContent, createAt, status From Notification where status = 1 ORDER BY createAt DESC";
                stm = connection.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int notificationID = rs.getInt("NotificationID");
                    int userID = rs.getInt("userID");
                    String notificationContent = rs.getString("NotificationContent");
                    Date createAt = rs.getDate("createAt");
                    int status = rs.getInt("Status");
                    NotificationDTO notificationDTO = new NotificationDTO(notificationID, userID, notificationContent, createAt, status);

                    if (notifiLists == null) {
                        notifiLists = new ArrayList<>();
                    }
                    notifiLists.add(notificationDTO);
                }
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return notifiLists;
    }


    public List<NotificationDTO> getListNoti(int userID) throws SQLException {
        List<NotificationDTO> notifiLists = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            connection = DBUtils.makeConnection();
            if (connection != null) {
                String sql = "Select notificationID, userID, notificationContent, createAt, status From Notification where userID=? AND status = 1 ORDER BY createAt DESC";
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int notificationID = rs.getInt("NotificationID");
                    String notificationContent = rs.getString("NotificationContent");
                    Date createAt = rs.getDate("createAt");
                    int status = rs.getInt("Status");
                    NotificationDTO notificationDTO = new NotificationDTO(notificationID, userID, notificationContent, createAt, status);

                    if (notifiLists == null) {
                        notifiLists = new ArrayList<>();
                    }
                    notifiLists.add(notificationDTO);
                }
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return notifiLists;
    }

    public int insertNotification(int userID, String notificationContent) throws SQLException {
        int rslt = 0;
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            Date now = Date.valueOf(LocalDate.now());

            if (connection != null) {
                //2. create sql string
                String sql = "INSERT INTO Notification (userID, notificationContent, createAt, status) VALUES (?, ?, ?, ?)";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, userID);
                stm.setString(2, notificationContent);
                stm.setDate(3, now);
                stm.setInt(4, 1);
                //4. execute query
                rslt = stm.executeUpdate();
                //5 process result

            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return rslt;
    }
    
    
     public int insertNotificationStaff(int userID, String notificationContent) throws SQLException {
        int rslt = 0;
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            //1. make connection
            connection = DBUtils.makeConnection();
            Date now = Date.valueOf(LocalDate.now());

            if (connection != null) {
                //2. create sql string
                String sql = "INSERT INTO Notification (userID, notificationContent, createAt, status) VALUES (?, ?, ?, ?)";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, userID);
                stm.setString(2, notificationContent);
                stm.setDate(3, now);
                stm.setInt(4, 2);
                //4. execute query
                rslt = stm.executeUpdate();
                //5 process result

            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return rslt;
    }

}
