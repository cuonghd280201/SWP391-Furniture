/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interior;

/**
 *
 * @author cdkhu
 */
public class InteriorErrorDTO {
    private String interiorNameErr;
    private String sizeErr;
    private String massErr;
    private String unitPriceErr;
    private String descriptionErr;
    private String interiorExisted;

    public InteriorErrorDTO() {
        this.interiorNameErr = "";
        this.sizeErr = "";
        this.massErr = "";
        this.unitPriceErr = "";
        this.descriptionErr = "";
        this.interiorExisted = "";
    }

    public InteriorErrorDTO(String interiorNameErr, String sizeErr, String massErr, String unitPriceErr, String descriptionErr, String interiorExisted) {
        this.interiorNameErr = interiorNameErr;
        this.sizeErr = sizeErr;
        this.massErr = massErr;
        this.unitPriceErr = unitPriceErr;
        this.descriptionErr = descriptionErr;
        this.interiorExisted = interiorExisted;
    }

    public String getInteriorNameErr() {
        return interiorNameErr;
    }

    public void setInteriorNameErr(String interiorNameErr) {
        this.interiorNameErr = interiorNameErr;
    }

    public String getSizeErr() {
        return sizeErr;
    }

    public void setSizeErr(String sizeErr) {
        this.sizeErr = sizeErr;
    }

    public String getMassErr() {
        return massErr;
    }

    public void setMassErr(String massErr) {
        this.massErr = massErr;
    }

    public String getUnitPriceErr() {
        return unitPriceErr;
    }

    public void setUnitPriceErr(String unitPriceErr) {
        this.unitPriceErr = unitPriceErr;
    }

    public String getDescriptionErr() {
        return descriptionErr;
    }

    public void setDescriptionErr(String descriptionErr) {
        this.descriptionErr = descriptionErr;
    }

    public String getInteriorExisted() {
        return interiorExisted;
    }

    public void setInteriorExisted(String interiorExisted) {
        this.interiorExisted = interiorExisted;
    }
    
    
}
