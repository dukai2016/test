/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.validation;

import org.phsa.esti.common.utils.validation.ValidationUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author kai.du
 */
public class ValidationUtilsTest {
    
    public ValidationUtilsTest() {
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
     * Test of validateJson method, of class ValidationUtils.
     */
    @Test
    public void testValidateJson_File_File() throws Exception {
      // File schemaFile = new File("schema.json");
         InputStream schemaFileIs = this.getClass().getClassLoader().getResourceAsStream("treatmentSchema.json");
    //File jsonFile = new File("data.json");
     InputStream jsonFileIs = this.getClass().getClassLoader().getResourceAsStream("treatmentData.json");
    	String schemaStr = IOUtils.toString(schemaFileIs, StandardCharsets.UTF_8);
        String dataStr = IOUtils.toString(jsonFileIs, StandardCharsets.UTF_8);
        ValidationUtils.isJsonValid(schemaStr, dataStr);
        ValidationResult result = ValidationUtils.reportJsonValid(schemaStr, dataStr);
        assertEquals(ValidationStatus.SUCCESS,result.getStatus());
       // System.out.println(ValidationUtils.getErrorsList(report, false));
    	
    }
    
    
     @Test
    public void testValidateJson_bad_File() throws Exception {
      // File schemaFile = new File("schema.json");
         InputStream schemaFileIs = this.getClass().getClassLoader().getResourceAsStream("schema.json");
    //File jsonFile = new File("data.json");
     InputStream jsonFileIs = this.getClass().getClassLoader().getResourceAsStream("baddata.json");
    	String schemaStr = IOUtils.toString(schemaFileIs, StandardCharsets.UTF_8);
        String dataStr = IOUtils.toString(jsonFileIs, StandardCharsets.UTF_8);
       
    ValidationResult result = ValidationUtils.reportJsonValid(schemaStr, dataStr);
    assertEquals(ValidationStatus.ERROR,result.getStatus());
    	System.out.println("Missing:"+result.getError().getMissing()+" or invalid value: "+result.getError().getPointer());
    }

}
