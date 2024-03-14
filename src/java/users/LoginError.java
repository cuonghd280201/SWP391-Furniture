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
public class LoginError implements Serializable {
    private String emailEmptyErr;
    private String passwordEmptyErr;
    private String accountNotFound;
    private String emailFormatErr;
    private String passwordFormatErr;
    private String accIsactive;
    public LoginError() {
    }

    public LoginError(String emailEmptyErr, String passwordEmptyErr, String accountNotFound) {
        this.emailEmptyErr = emailEmptyErr;
        this.passwordEmptyErr = passwordEmptyErr;
        this.accountNotFound = accountNotFound;
    }

    public LoginError(String emailEmptyErr, String passwordEmptyErr, String accountNotFound, String emailFormatErr, String passwordFormatErr, String accIsactive) {
        this.emailEmptyErr = emailEmptyErr;
        this.passwordEmptyErr = passwordEmptyErr;
        this.accountNotFound = accountNotFound;
        this.emailFormatErr = emailFormatErr;
        this.passwordFormatErr = passwordFormatErr;
        this.accIsactive = accIsactive;
    }

    public String getEmailEmptyErr() {
        return emailEmptyErr;
    }

    public void setEmailEmptyErr(String emailEmptyErr) {
        this.emailEmptyErr = emailEmptyErr;
    }

    public String getPasswordEmptyErr() {
        return passwordEmptyErr;
    }

    public void setPasswordEmptyErr(String passwordEmptyErr) {
        this.passwordEmptyErr = passwordEmptyErr;
    }

    public String getAccountNotFound() {
        return accountNotFound;
    }

    public void setAccountNotFound(String accountNotFound) {
        this.accountNotFound = accountNotFound;
    }

    public String getEmailFormatErr() {
        return emailFormatErr;
    }

    public void setEmailFormatErr(String emailFormatErr) {
        this.emailFormatErr = emailFormatErr;
    }

    public String getPasswordFormatErr() {
        return passwordFormatErr;
    }

    public void setPasswordFormatErr(String passwordFormatErr) {
        this.passwordFormatErr = passwordFormatErr;
    }

    public String getAccIsactive() {
        return accIsactive;
    }

    public void setAccIsactive(String accIsactive) {
        this.accIsactive = accIsactive;
    }
    
    
    
    
}
