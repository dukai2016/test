/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kai.du
 */
public class ValidationResultTest {
    
    public ValidationResultTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of equals method, of class ValidationResult.
     */
    @Test
    public void testEquals() {
        ValidationResult result= new ValidationResult();
        ValidationError error= new ValidationError();
        error.setMissing("m");
        error.setType(ValidationErrorType.InvalidValue);
        result.setError(error);
        result.setStatus(ValidationStatus.ERROR);
        
        ValidationResult other= new ValidationResult();
        other.setError(error);
        other.setStatus(ValidationStatus.ERROR);
        
        assertTrue(result.equals(other));
        
         ValidationError othererror= new ValidationError();
        othererror.setMissing("m");
        othererror.setType(ValidationErrorType.MissingRequiredData);
        other.setError(othererror);
        assertFalse(result.equals(other));
        
    }
    
}
