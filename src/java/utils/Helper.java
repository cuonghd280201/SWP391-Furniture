/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import javax.servlet.ServletContext;

/**
 *
 * @author Admin
 */
public class Helper implements Serializable {

    public static Properties getProperties (ServletContext context, String fileRelativePath) throws IOException{
        InputStream input=context.getResourceAsStream(fileRelativePath);
        Properties prop=null;
        try{
            prop=new Properties();
            prop.load(input);
        }finally {
            if (input!=null) {
                input.close();
            }
        }
        return prop;
    }
}

