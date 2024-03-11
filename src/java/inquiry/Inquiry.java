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

import java.io.Serializable;
import java.util.Date;
import users.UserDTO;

public class Inquiry implements Serializable{

    public int inquiryID;
    public String inquiryTittle;
    public int projectID;
    public int userID;
    public int statusInquiry;
    public Date createAt; // Thay đổi kiểu dữ liệu của createAt
    public Date updateAt; // Thay đổi kiểu dữ liệu của updateAt
    public String description;
    public int constructionID;
    public int scaleID;
    public int priceRangeID;
    public int projectTypeID;
    public Construction construction;
    public Scale scale;
    public ProjectType projectType;
    public PriceRange priceRange;
    public UserDTO userDTO;

    public Inquiry(int projectID, String inquiryTittle, int userID, int statusInquiry, Date createAt, Date updateAt, String description, int constructionID, int scaleID, int priceRangeID, int projectTypeID, Construction construction, Scale scale, ProjectType projectType, PriceRange priceRange, UserDTO userDTO) {
        this.projectID = projectID;
        this.userID = userID;
        this.statusInquiry = statusInquiry;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.description = description;
        this.constructionID = constructionID;
        this.scaleID = scaleID;
        this.priceRangeID = priceRangeID;
        this.projectTypeID = projectTypeID;
        this.construction = construction;
        this.scale = scale;
        this.projectType = projectType;
        this.priceRange = priceRange;
        this.inquiryTittle = inquiryTittle;
        this.userDTO = userDTO;
    }

    public Inquiry() {
    }

    public Inquiry(int userID, String inquiryTittle, int constructionID, int scaleID, int priceRangeID, int projectTypeID, String description) {
        this.userID = userID;
        this.inquiryTittle = inquiryTittle;
        this.description = description;
        this.constructionID = constructionID;
        this.scaleID = scaleID;
        this.priceRangeID = priceRangeID;
        this.projectTypeID = projectTypeID;
    }

    public Inquiry(int inquiryID, int projectID, String inquiryTittle, int userID, int statusInquiry, Date createAt, Date updateAt, String description, int constructionID, int scaleID, int priceRangeID, int projectTypeID, Construction construction, Scale scale, ProjectType projectType, PriceRange priceRange, UserDTO userDTO) {
        this.inquiryID = inquiryID;
        this.projectID = projectID;
        this.inquiryTittle = inquiryTittle;
        this.userID = userID;
        this.statusInquiry = statusInquiry;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.description = description;
        this.constructionID = constructionID;
        this.scaleID = scaleID;
        this.priceRangeID = priceRangeID;
        this.projectTypeID = projectTypeID;
        this.construction = construction;
        this.scale = scale;
        this.projectType = projectType;
        this.priceRange = priceRange;
        this.userDTO = userDTO;
    }
    
     public Inquiry(int inquiryID, int projectID, String inquiryTittle, int userID, int statusInquiry, Date createAt, Date updateAt, String description, int constructionID, int scaleID, int priceRangeID, int projectTypeID, Construction construction, Scale scale, ProjectType projectType, PriceRange priceRange) {
        this.inquiryID = inquiryID;
        this.projectID = projectID;
        this.inquiryTittle = inquiryTittle;
        this.userID = userID;
        this.statusInquiry = statusInquiry;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.description = description;
        this.constructionID = constructionID;
        this.scaleID = scaleID;
        this.priceRangeID = priceRangeID;
        this.projectTypeID = projectTypeID;
        this.construction = construction;
        this.scale = scale;
        this.projectType = projectType;
        this.priceRange = priceRange;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    
    

    public Construction getConstruction() {
        return construction;
    }

    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public int getStatusInquiry() {
        return statusInquiry;
    }

    public void setStatusInquiry(int statusInquiry) {
        this.statusInquiry = statusInquiry;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
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

    public String getInquiryTittle() {
        return inquiryTittle;
    }

    public void setInquiryTittle(String inquiryTittle) {
        this.inquiryTittle = inquiryTittle;
    }
    
}
