/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author cdkhu
 */
public class ProjectErrorDTO {
    private String projectNameErr;
    private String scaleErr;
    private String projectNameExisted;
    private String sessionRunOut;

    public ProjectErrorDTO() {
        this.projectNameErr = "";
        this.scaleErr = "";
        this.projectNameExisted = "";
        this.sessionRunOut = "";
    }

    public ProjectErrorDTO(String projectNameErr, String scaleErr, String projectNameExisted, String sessionRunOut) {
        this.projectNameErr = projectNameErr;
        this.scaleErr = scaleErr;
        this.projectNameExisted = projectNameExisted;
        this.sessionRunOut = sessionRunOut;
    }

    public String getProjectNameErr() {
        return projectNameErr;
    }

    public void setProjectNameErr(String projectNameErr) {
        this.projectNameErr = projectNameErr;
    }

    public String getScaleErr() {
        return scaleErr;
    }

    public void setScaleErr(String scaleErr) {
        this.scaleErr = scaleErr;
    }

    public String getProjectNameExisted() {
        return projectNameExisted;
    }

    public void setProjectNameExisted(String projectNameExisted) {
        this.projectNameExisted = projectNameExisted;
    }
    
    public String getSessionRunOut() {
        return sessionRunOut;
    }

    public void setSessionRunOut(String sessionRunOut) {
        this.sessionRunOut = sessionRunOut;
    }
}
