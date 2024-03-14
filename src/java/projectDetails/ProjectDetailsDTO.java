/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectDetails;

import java.sql.Timestamp;

/**
 *
 * @author cdkhu
 */
public class ProjectDetailsDTO {
    private int projectID;
    private String projectName;
    private String scale;
    private String description;
    private Timestamp createAt;
    private Timestamp updateAt;
    private double price;
    private int userID;
    private String firstName;
    private String lastName;
    private int projectTypeID;
    private String projectTypeName;
    private int status;

    public ProjectDetailsDTO() {
    }

    public ProjectDetailsDTO(int projectID, String projectName, String scale, String description,  Timestamp createAt, Timestamp updateAt, double price, int userID, String firstName, String lastName, int projectTypeID, String projectTypeName, int status) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.scale = scale;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.price = price;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectTypeID = projectTypeID;
        this.projectTypeName = projectTypeName;
        this.status = status;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(int projectTypeID) {
        this.projectTypeID = projectTypeID;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
