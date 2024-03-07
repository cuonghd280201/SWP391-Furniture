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
public class PriceRange {
    public int priceRangeID;
    public String priceRangeName;
    public String priceDescription;

    public PriceRange(int priceRangeID, String priceRangeName) {
        this.priceRangeID = priceRangeID;
        this.priceRangeName = priceRangeName;
    }
    
    

    public PriceRange() {
    }

    public PriceRange(int priceRangeID, String priceRangeName, String priceDescription) {
        this.priceRangeID = priceRangeID;
        this.priceRangeName = priceRangeName;
        this.priceDescription = priceDescription;
    }

    public int getPriceRangeID() {
        return priceRangeID;
    }

    public void setPriceRangeID(int priceRangeID) {
        this.priceRangeID = priceRangeID;
    }

    public String getPriceRangeName() {
        return priceRangeName;
    }

    public void setPriceRangeName(String priceRangeName) {
        this.priceRangeName = priceRangeName;
    }

    public String getPriceDescription() {
        return priceDescription;
    }

    public void setPriceDescription(String priceDescription) {
        this.priceDescription = priceDescription;
    }
    
    
}
