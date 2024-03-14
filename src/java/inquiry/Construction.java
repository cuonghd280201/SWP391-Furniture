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
public class Construction {
        public int constructionID;
        public String constructionName;
        public String constructionDescription;
        public boolean constructionStatus;

    public Construction() {
    }

    public Construction(int constructionID, String constructionName) {
        this.constructionID = constructionID;
        this.constructionName = constructionName;
    }

    public Construction(String constructionName, String constructionDescription) {
        this.constructionName = constructionName;
        this.constructionDescription = constructionDescription;
    }

    public Construction(int constructionID, String constructionName, String constructionDescription, boolean constructionStatus) {
        this.constructionID = constructionID;
        this.constructionName = constructionName;
        this.constructionDescription = constructionDescription;
        this.constructionStatus = constructionStatus;
    }

  



    public int getConstructionID() {
        return constructionID;
    }

    public void setConstructionID(int constructionID) {
        this.constructionID = constructionID;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getConstructionDescription() {
        return constructionDescription;
    }

    public void setConstructionDescription(String constructionDescription) {
        this.constructionDescription = constructionDescription;
    }

    public boolean getConstructionStatus() {
        return constructionStatus;
    }

    public void setConstructionStatus(boolean constructionStatus) {
        this.constructionStatus = constructionStatus;
    }
    
        
    
}
