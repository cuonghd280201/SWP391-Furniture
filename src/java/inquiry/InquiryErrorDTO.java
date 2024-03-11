/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inquiry;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class InquiryErrorDTO implements Serializable{
    private String descriptionExceedCharsCount;
    private String inquiryTitleRequired;

    public InquiryErrorDTO() {
    }

    public InquiryErrorDTO(String descriptionExceedCharsCount, String inquiryTitleRequired) {
        this.descriptionExceedCharsCount = descriptionExceedCharsCount;
        this.inquiryTitleRequired = inquiryTitleRequired;
    }

    public String getInquiryTitleRequired() {
        return inquiryTitleRequired;
    }

    public void setInquiryTitleRequired(String inquiryTitleRequired) {
        this.inquiryTitleRequired = inquiryTitleRequired;
    }

 

    public String getDescriptionExceedCharsCount() {
        return descriptionExceedCharsCount;
    }

    public void setDescriptionExceedCharsCount(String descriptionExceedCharsCount) {
        this.descriptionExceedCharsCount = descriptionExceedCharsCount;
    }
    
    

 
}