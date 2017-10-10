/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.phsl.common.utils.config;

import java.util.Properties;

/**
 *
 * @author kai.du
 */
import java.io.File;
import java.util.Properties;

public class TomcatConfigLoader extends FileConfigLoader  {

    @Override
    public Properties getConfig(String file) {
        String tomcatRoot = System.getProperty("catalina.base");
        if (tomcatRoot == null || tomcatRoot.length() == 0) {
            return null;
        }
        File folder = new File(tomcatRoot, "conf");
        return getConfigImpl(folder.getAbsolutePath(), file);
        
    }
    
}
