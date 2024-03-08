/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectType;

/**
 *
 * @author cdkhu
 */
public class ProjectTypeDTO {
    private int projectTypeID;
    private String projectTypeName;
    private int status;

    public ProjectTypeDTO() {
    }

    public ProjectTypeDTO(int projectTypeID, String projectTypeName, int status) {
        this.projectTypeID = projectTypeID;
        this.projectTypeName = projectTypeName;
        this.status = status;
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
