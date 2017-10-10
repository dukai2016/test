/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.security;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.phsa.esti.common.utils.StringUtility;

/**
 *
 * @author kai.du
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class EncryptionUtilsTest {
    Logger logger = LoggerFactory.getLogger(EncryptionUtilsTest.class);
    public EncryptionUtilsTest() {
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
     * Test of calculateSignature method, of class JWTUtils.
     */
    @Test
    public void testCalculateSignature() throws Exception {
        logger.info("calculateSignature");
       // calculateSignature("secret")
        String key = "secret";
        String expResult = "25cf3c44c8f39313e8cbf7c23e22fe8b2ee8b288ee5206b0a6397583a1f7f0ef";
        String result = EncryptionUtils.calculateSignature(key,"HmacSHA256","UTF-8");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of encode method, of class JWTUtils.
     */
    @Test
    public void testEncode() throws Exception {
        logger.info("encode");
        String key = "key";
        String data = "secret";
        String expResult = "25cf3c44c8f39313e8cbf7c23e22fe8b2ee8b288ee5206b0a6397583a1f7f0ef";
        
        String result = EncryptionUtils.shaEncode(key, data,"HmacSHA256","UTF-8");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of base64UrlDecode method, of class JWTUtils.
     */
    @Test
    public void testBase64UrlDecode() {
        logger.info("base64UrlDecode");
        String input = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
        String expResult = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String result = EncryptionUtils.base64UrlDecode(input);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of base64UrlEncode method, of class JWTUtils.
     */
    @Test
    public void testBase64UrlEncode() {
        logger.info("base64UrlEncode");
        String input = "{\"iss\":\"phsl-rest-key\",\"sub\":\"phsl-rest-key\",\"exp\":\"123456789\"}";
        String expResult ="eyJpc3MiOiJwaHNsLXJlc3Qta2V5Iiwic3ViIjoicGhzbC1yZXN0LWtleSIsImV4cCI6IjEyMzQ1Njc4OSJ9";
        
        String result = EncryptionUtils.base64UrlEncode(input);
       // boolean x = StringUtility.equalsIgnoreNewlineTwirks(result, expResult);
        assertTrue(StringUtility.equalsIgnoreNewlineTwirks(result, expResult));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
  
}
