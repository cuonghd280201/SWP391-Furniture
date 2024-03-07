/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Email_DTO implements Serializable {
    
    private String email;
    private String code;

    public Email_DTO() {
    }

    public Email_DTO( String email, String code) {
        
        this.email = email;
        this.code = code;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}

