/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.phsl.common.utils.config;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author kai.du
 */
public abstract class FileConfigLoader implements ConfigLoader{

   
    protected Properties getConfigImpl(String folder, String filename) {

        if (folder == null || folder.length() == 0) {
            return null;
        }
    
        File file = new File(folder, filename);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
    
        try {
            Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            try {
                Properties properties = new Properties();
                properties.load(reader);
                return properties;
            } finally {
                reader.close();
            }
        } catch (Throwable e) {
            throw new RuntimeException("Unable to read property file: " + file.getAbsolutePath(), e);
        }
    }
    
}
