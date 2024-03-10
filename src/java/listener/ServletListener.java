/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.Helper;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
          try {
            ServletContext context = sce.getServletContext();
            String siteMapLocation = context.getInitParameter("SITEMAPS_FILE_PATH");
            String authenticationLocation = context.getInitParameter("AUTHENTICATION_FILE_PATH");
            Properties siteMapProperty = Helper.getProperties(context, siteMapLocation);
            Properties authProperty = Helper.getProperties(context, authenticationLocation);
            context.setAttribute("SITEMAPS", siteMapProperty);
            context.setAttribute("AUTH_LIST", authProperty);
        } catch (IOException ex) {
            Logger.getLogger(ServletListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
