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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
public class ClasspathConfigLoader implements ConfigLoader {

    @Override
    public Properties getConfig(String file) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        
        if (inputStream == null) {
            return null;
        }
    
        try {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                Properties properties = new Properties();
                properties.load(reader);
                return properties;
            } finally {
                reader.close();
            }
        } catch (Throwable e) {
            throw new RuntimeException("Unable to read property file: " + file, e);
        }
    }

    
    
}
