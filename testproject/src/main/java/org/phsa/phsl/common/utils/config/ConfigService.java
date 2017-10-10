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
Loading Strategy:

(1)The servlet context (web.xml)
(2)The container’s config folder (Tomcat’s conf folder)
(3)The classpath
(4)The in-Jar path
*/
import java.util.Properties;
public class ConfigService {
     private static ConfigLoader[] LOADERS = new ConfigLoader[]{
        //new SystemPropertyConfigLoader(),
        //new EnvironmentVariableConfigLoader(),
        new ServletContextConfigLoader(),
        new TomcatConfigLoader(),
        new ClasspathConfigLoader(),
        new InJarMetaConfigLoader()
    };
    
    public static Properties getConfig(String file) {
        for (ConfigLoader loader : LOADERS) {
            Properties config = loader.getConfig(file);
            if (config != null) {
                return config;
            }
        }
        return null;
        //throw new RuntimeException("config file not found: " + file);
    }
}
