/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kai.du
 */
public class StringUtilityTest {
    
    public StringUtilityTest() {
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
     * Test of equalsIgnoreNewlineTwirks method, of class StringUtility.
     */
    @Test
    public void testEqualsIgnoreNewlineTwirks() {
        //System.out.println("equalsIgnoreNewlineTwirks");
        String str = "equalsIgnoreNewlineTwirks";
        String other = "equalsIgnoreNewlineTwirks\r\n";
       // boolean expResult = false;
        boolean result = StringUtility.equalsIgnoreNewlineTwirks(str, other);
        assertEquals(result,true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
