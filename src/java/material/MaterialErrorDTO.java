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
public class MaterialErrorDTO {
    private String materialNameErr;
    private String valueLevelErr;
    private String materialNameExisted;

    public MaterialErrorDTO() {
        this.materialNameErr = "";
        this.valueLevelErr = "";
        this.materialNameExisted = "";
    }
    
    public MaterialErrorDTO(String materialNameErr, String valueLevelErr, String materialNameExisted) {
        this.materialNameErr = materialNameErr;
        this.valueLevelErr = valueLevelErr;
        this.materialNameExisted = materialNameExisted;
    }

    public String getMaterialNameErr() {
        return materialNameErr;
    }

    public void setMaterialNameErr(String materialNameErr) {
        this.materialNameErr = materialNameErr;
    }

    public String getValueLevelErr() {
        return valueLevelErr;
    }

    public void setValueLevelErr(String valueLevelErr) {
        this.valueLevelErr = valueLevelErr;
    }

    public String getMaterialNameExisted() {
        return materialNameExisted;
    }

    public void setMaterialNameExisted(String materialNameExisted) {
        this.materialNameExisted = materialNameExisted;
    }
    
    
}
