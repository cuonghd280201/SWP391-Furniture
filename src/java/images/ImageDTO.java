/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class ImageDTO implements Serializable {
    private int imageID;
    private String imageURL;
    private int projectID;

    public ImageDTO() {
    }

    public ImageDTO(int imageID, String imageURL, int projectID) {
        this.imageID = imageID;
        this.imageURL = imageURL;
        this.projectID = projectID;
    }

    public ImageDTO(int imageID, String imageURL) {
        this.imageID = imageID;
        this.imageURL = imageURL;
    }

    
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    
}
