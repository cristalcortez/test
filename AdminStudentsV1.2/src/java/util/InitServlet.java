/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import service.NamingService;

/**
 *
 * @author user
 */
public class InitServlet implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent event){
        
        ServletContext sc = event.getServletContext();
        NamingService ns = NamingService.getInstance();
        
        String path = sc.getInitParameter("configFile");

        Properties initProperties = new Properties();
        try {
            initProperties.load(new FileInputStream(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url = initProperties.getProperty("url");
        ns.setAttribute("url", url);

        String user = initProperties.getProperty("user");
        ns.setAttribute("user", user);

        String password = initProperties.getProperty("password");
        ns.setAttribute("password", password);

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event){
    
    }
}
