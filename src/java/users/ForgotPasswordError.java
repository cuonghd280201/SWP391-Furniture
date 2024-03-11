/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Admin
 */
public class ForgotPasswordError {
    
    private String emailAndPhonenumberNotMathErr;
    private String phonenumberExisted;
    private String emailExisted;
    private String newPasswordFormatErr;
    private String newPasswordSameAsErr;
    private String confirmNotMathched;

    public ForgotPasswordError() {
    }

    public String getEmailAndPhonenumberNotMathErr() {
        return emailAndPhonenumberNotMathErr;
    }

    public void setEmailAndPhonenumberNotMathErr(String emailAndPhonenumberNotMathErr) {
        this.emailAndPhonenumberNotMathErr = emailAndPhonenumberNotMathErr;
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

    public String getNewPasswordFormatErr() {
        return newPasswordFormatErr;
    }

    public void setNewPasswordFormatErr(String newPasswordFormatErr) {
        this.newPasswordFormatErr = newPasswordFormatErr;
    }

    public String getNewPasswordSameAsErr() {
        return newPasswordSameAsErr;
    }

    public void setNewPasswordSameAsErr(String newPasswordSameAsErr) {
        this.newPasswordSameAsErr = newPasswordSameAsErr;
    }

    public String getConfirmNotMathched() {
        return confirmNotMathched;
    }

    public void setConfirmNotMathched(String confirmNotMathched) {
        this.confirmNotMathched = confirmNotMathched;
    }
    
}
