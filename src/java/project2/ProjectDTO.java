/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author cdkhu
 */
public class ProjectDTO {
    private int projectID;
    private String projectName;
    private String scale;
    private String description;
    private String image;
    private Timestamp createAt;
    private Timestamp updateAt;
    private int status;
    private double price;
    private int userID;
    private int projectTypeID;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectID, String projectName, String scale, String description, String image, Timestamp createAt, Timestamp updateAt, int status, double price, int userID, int projectTypeID) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.scale = scale;
        this.description = description;
        this.image = image;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.price = price;
        this.userID = userID;
        this.projectTypeID = projectTypeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(int projectTypeID) {
        this.projectTypeID = projectTypeID;
    }
    
    
}
