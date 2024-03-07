/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RegisterError implements Serializable {

    private String passwordFormatErr;
    private String firstnameFormatErr;
    private String lastnameFormatErr;
    private String phonenumberFormatErr;
    private String emailFormatErr;
    private String confirmNotMathched;
    private String phonenumberExisted;
    private String emailExisted;

    public RegisterError() {
    }

    public RegisterError(String passwordFormatErr, String firstnameFormatErr, String lastnameFormatErr, String phonenumberFormatErr, String emailFormatErr, String confirmNotMathched, String phonenumberExisted, String emailExisted) {
        this.passwordFormatErr = passwordFormatErr;
        this.firstnameFormatErr = firstnameFormatErr;
        this.lastnameFormatErr = lastnameFormatErr;
        this.phonenumberFormatErr = phonenumberFormatErr;
        this.emailFormatErr = emailFormatErr;
        this.confirmNotMathched = confirmNotMathched;
        this.phonenumberExisted = phonenumberExisted;
        this.emailExisted = emailExisted;
    }

    

    public String getPasswordFormatErr() {
        return passwordFormatErr;
    }

    public void setPasswordFormatErr(String passwordFormatErr) {
        this.passwordFormatErr = passwordFormatErr;
    }

    public String getFirstnameFormatErr() {
        return firstnameFormatErr;
    }

    public void setFirstnameFormatErr(String firstnameFormatErr) {
        this.firstnameFormatErr = firstnameFormatErr;
    }

    public String getLastnameFormatErr() {
        return lastnameFormatErr;
    }

    public void setLastnameFormatErr(String lastnameFormatErr) {
        this.lastnameFormatErr = lastnameFormatErr;
    }

    

    public String getPhonenumberFormatErr() {
        return phonenumberFormatErr;
    }

    public void setPhonenumberFormatErr(String phonenumberFormatErr) {
        this.phonenumberFormatErr = phonenumberFormatErr;
    }

    public String getEmailFormatErr() {
        return emailFormatErr;
    }

    public void setEmailFormatErr(String emailFormatErr) {
        this.emailFormatErr = emailFormatErr;
    }

    public String getConfirmNotMathched() {
        return confirmNotMathched;
    }

    public void setConfirmNotMathched(String confirmNotMathched) {
        this.confirmNotMathched = confirmNotMathched;
    }

    public String getPhonenumberExisted() {
        return phonenumberExisted;
    }

    public void setPhonenumberExisted(String phonenumberExisted) {
        this.phonenumberExisted = phonenumberExisted;
    }

    public String getEmailExisted() {
        return emailExisted;
    }

    public void setEmailExisted(String emailExisted) {
        this.emailExisted = emailExisted;
    }

}
