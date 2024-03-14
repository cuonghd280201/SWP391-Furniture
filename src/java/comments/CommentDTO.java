/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class CommentDTO implements Serializable{
     private int commentID;
    private int userID;
    private int projectID;
    private String firstName;
    private String image;
    private String commentDetail;
    private Date createAt;
    private Date updateAt;
    private boolean is_actived;

    public CommentDTO() {
    }
    
    

    public CommentDTO(int commentID, int userID, int projectID, String firstName, String image, String commentDetail, Date createAt, Date updateAt, boolean is_actived) {
        this.commentID = commentID;
        this.userID = userID;
        this.projectID = projectID;
        this.firstName = firstName;
        this.image = image;
        this.commentDetail = commentDetail;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.is_actived = is_actived;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createdAt) {
        this.createAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isIs_actived() {
        return is_actived;
    }

    public void setIs_actived(boolean is_actived) {
        this.is_actived = is_actived;
    }
    
    
}
