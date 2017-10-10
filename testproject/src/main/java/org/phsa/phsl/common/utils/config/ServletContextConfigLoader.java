/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.phsl.common.utils.config;

/**
 *
 * @author kai.du
 */
/*
*
In the web.xml deployment descriptor,  register the ServletContextListener and set the folder it searches for config files.

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0" metadata-complete="true">
  <display-name>Load Config Files</display-name>

    <context-param>
        <param-name>config</param-name>
        <param-value>/conf</param-value>
    </context-param>

    <listener>
        <listener-class>com.stackhunter.blog.config.ServletContextConfigLoader</listener-class>        
    </listener>

</web-app>
	
*/
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextConfigLoader extends FileConfigLoader implements ServletContextListener{
     private ServletContext servletContext;
    @Override
    public Properties getConfig(String file) {
        //
        ServletContext localServletContext = servletContext;
        
        if (localServletContext == null) {
            return null;
        }
        
        return getConfigImpl(localServletContext.getInitParameter("config"), file);
    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        servletContext = event.getServletContext();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        servletContext = null;
    }
    
}
