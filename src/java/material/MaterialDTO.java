/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

/**
 *
 * @author cdkhu
 */
public class MaterialDTO {
    private int materialID;
    private String materialName;
    private double valueLevel;
    private String desciprtion;
    private int status;

    public MaterialDTO() {
    }

    public MaterialDTO(int materialID, String materialName, double valueLevel, String desciprtion, int status) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.valueLevel = valueLevel;
        this.desciprtion = desciprtion;
        this.status = status;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public double getValueLevel() {
        return valueLevel;
    }

    public void setValueLevel(double valueLevel) {
        this.valueLevel = valueLevel;
    }

    public String getDesciprtion() {
        return desciprtion;
    }

    public void setDesciprtion(String desciprtion) {
        this.desciprtion = desciprtion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
