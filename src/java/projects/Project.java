package projects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import images.ImageDTO;

/**
 *
 * @author Admin
 */
public class Project {

    public int projectID;
    public String projectName;
    public String scale;
    public String description;
    public String createAt;
    public String updateAt;
    public String status;
    public float price;
    public String projectTypeID;
    public ImageDTO imageDTO;

    public Project() {
    }

    public Project(int projectID, String projectName, String scale, String description, String createAt, String updateAt, String status, float price, String projectTypeID, ImageDTO imageDTO) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.scale = scale;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.price = price;
        this.projectTypeID = projectTypeID;
        this.imageDTO = imageDTO;
    }

    public Project(String projectName, String scale, String description, String createAt, String updateAt, String status, float price, String projectTypeID, ImageDTO imageDTO) {
        this.projectName = projectName;
        this.scale = scale;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.price = price;
        this.projectTypeID = projectTypeID;
        this.imageDTO = imageDTO;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(String projectTypeID) {
        this.projectTypeID = projectTypeID;
    }

    public ImageDTO getImageDTO() {
        return imageDTO;
    }

    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }

}
