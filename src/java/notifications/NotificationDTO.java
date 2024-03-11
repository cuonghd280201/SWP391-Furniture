/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifications;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class NotificationDTO implements Serializable{
    
    private int notificationID;
    private int userID;
    private String notificationContent;
    private Date createAt;
    private int status;

    public NotificationDTO() {
    }

    public NotificationDTO(int notificationID, int userID, String notificationContent, Date createAt, int status) {
        this.notificationID = notificationID;
        this.userID = userID;
        this.notificationContent = notificationContent;
        this.createAt = createAt;
        this.status = status;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
    
}
