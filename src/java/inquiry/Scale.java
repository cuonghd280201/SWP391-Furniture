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
public class Scale {
    public int scaleID;
    public String scaleName;
    public String scaleDescription;

    public Scale() {
    }
    
    

    public Scale(int scaleID, String scaleName, String scaleDescription) {
        this.scaleID = scaleID;
        this.scaleName = scaleName;
        this.scaleDescription = scaleDescription;
    }

    public int getScaleID() {
        return scaleID;
    }

    public void setScaleID(int scaleID) {
        this.scaleID = scaleID;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    public String getScaleDescription() {
        return scaleDescription;
    }

    public void setScaleDescription(String scaleDescription) {
        this.scaleDescription = scaleDescription;
    }
    
    
}
