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
public class ProjectType {
    public int projectTypeID;
    public String projectTypeName;
    public String status;

    public ProjectType(int projectTypeID, String projectTypeName, String status) {
        this.projectTypeID = projectTypeID;
        this.projectTypeName = projectTypeName;
        this.status = status;
    }

    public ProjectType(int projectTypeID, String projectTypeName) {
        this.projectTypeID = projectTypeID;
        this.projectTypeName = projectTypeName;
    }

    public ProjectType() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
