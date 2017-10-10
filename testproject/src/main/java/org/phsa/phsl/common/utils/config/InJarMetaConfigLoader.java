/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.phsl.common.utils.config;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author kai.du
 */
/*
put the proerty fiel in the META-INF

*/
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
        
public class InJarMetaConfigLoader implements ConfigLoader{
 private static final Logger logger = LoggerFactory.getLogger(InJarMetaConfigLoader.class);
 
    @Override
    public Properties getConfig(String file) {
        // return getConfigImpl("META-INF",file);
        logger.info("Enter InJarMetaConfigLoader ");
        InputStream propertiesIs = this.getClass().getClassLoader().getResourceAsStream(file);
        if (propertiesIs==null)
            propertiesIs = this.getClass().getClassLoader().getResourceAsStream("META-INF/"+file);
         if (propertiesIs==null)    return null;
        Properties prop = new Properties();
        try {
            prop.load(propertiesIs);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        finally{
            if (propertiesIs!=null)
                try {
                    propertiesIs.close();
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }
        // System.out.println(prop.getProperty(YourPropertyHere));
         return prop;
    }
    
}
