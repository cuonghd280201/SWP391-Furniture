/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inquiry;

/**
 *
 * @author Admin
 */
public class Inquiry {
    public int inquiryID;
    public int projectID;
    public String userID;
    public int status;
    public String createAt;
    public String updateAt;
    public String description;
    public int constructionID;
    public int scaleID;
    public int priceRangeID;
    public int projectTypeID;

    public Inquiry() {
    }

    public Inquiry(int inquiryID, int projectID, String userID, int status, String createAt, String updateAt, String description, int constructionID, int scaleID, int priceRangeID, int projectTypeID) {
        this.inquiryID = inquiryID;
        this.projectID = projectID;
        this.userID = userID;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.description = description;
        this.constructionID = constructionID;
        this.scaleID = scaleID;
        this.priceRangeID = priceRangeID;
        this.projectTypeID = projectTypeID;
    }

    public int getInquiryID() {
        return inquiryID;
    }

    public void setInquiryID(int inquiryID) {
        this.inquiryID = inquiryID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getConstructionID() {
        return constructionID;
    }

    public void setConstructionID(int constructionID) {
        this.constructionID = constructionID;
    }

    public int getScaleID() {
        return scaleID;
    }

    public void setScaleID(int scaleID) {
        this.scaleID = scaleID;
    }

    public int getPriceRangeID() {
        return priceRangeID;
    }

    public void setPriceRangeID(int priceRangeID) {
        this.priceRangeID = priceRangeID;
    }

    public int getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(int projectTypeID) {
        this.projectTypeID = projectTypeID;
    }
    
    
    
}
