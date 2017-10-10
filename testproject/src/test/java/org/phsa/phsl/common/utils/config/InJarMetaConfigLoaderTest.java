/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.phsl.common.utils.config;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author kai.du
 */
public class InJarMetaConfigLoaderTest {
    private static final Logger logger = LoggerFactory.getLogger(InJarMetaConfigLoaderTest.class);
    public InJarMetaConfigLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConfig method, of class InJarMetaConfigLoader.
     */
    @Test
    public void testGetConfig() {
        //String file = "";
        InJarMetaConfigLoader instance = new InJarMetaConfigLoader();
        //Properties expResult = null;
        Properties prop = instance.getConfig("test.properties");
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (prop!=null){
            logger.info(prop.getProperty("javax.persistence.jdbc.driver"));
            logger.info(prop.getProperty("javax.persistence.jdbc.password"));
            logger.info(prop.getProperty("javax.persistence.jdbc.url"));
            logger.info(prop.getProperty("javax.persistence.jdbc.user"));
        }
        
    }
    
}
