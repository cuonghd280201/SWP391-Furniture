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
public class VerifyCodeErr implements Serializable{
    private String codeIncorrect;

    public VerifyCodeErr() {
    }

    public String getCodeIncorrect() {
        return codeIncorrect;
    }

    public void setCodeIncorrect(String codeIncorrect) {
        this.codeIncorrect = codeIncorrect;
    }
    
}
