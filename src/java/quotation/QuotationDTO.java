/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quotation;

import java.sql.Timestamp;

/**
 *
 * @author cdkhu
 */
public class QuotationDTO {
    private int quotationID;
    private int projectID;
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp createAt;
    private int status;
    private int userID;

    public QuotationDTO() {
    }

    public QuotationDTO(int quotationID, int projectID, Timestamp startDate, Timestamp endDate, Timestamp createAt, int status, int userID) {
        this.quotationID = quotationID;
        this.projectID = projectID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createAt = createAt;
        this.status = status;
        this.userID = userID;
    }

    public int getQuotationID() {
        return quotationID;
    }

    public void setQuotationID(int quotationID) {
        this.quotationID = quotationID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
}
