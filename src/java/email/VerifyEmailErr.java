/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

/**
 *
 * @author Admin
 */
public class VerifyEmailErr {
    private String cannotSend;
    private String emailNotExisted;
    private String emailIsActive;

    public VerifyEmailErr() {
    }

    public VerifyEmailErr(String cannotSend, String emailNotExisted, String emailIsActive) {
        this.cannotSend = cannotSend;
        this.emailNotExisted = emailNotExisted;
        this.emailIsActive = emailIsActive;
    }

    public String getCannotSend() {
        return cannotSend;
    }

    public void setCannotSend(String cannotSend) {
        this.cannotSend = cannotSend;
    }

    public String getEmailNotExisted() {
        return emailNotExisted;
    }

    public void setEmailNotExisted(String emailNotExisted) {
        this.emailNotExisted = emailNotExisted;
    }

    public String getEmailIsActive() {
        return emailIsActive;
    }

    public void setEmailIsActive(String emailIsActive) {
        this.emailIsActive = emailIsActive;
    }
    
    
    
}
