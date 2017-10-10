/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.validation;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author kai.du
 */
public class ValidationResult {
    ValidationStatus status;
    ValidationError error;
    
    public ValidationResult(){
       
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public ValidationError getError() {
        return error;
    }

    public void setError(ValidationError error) {
        this.error = error;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (status != null ? status.hashCode() : 0);
        hash += (error != null ? error.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidationResult)) {
            return false;
        }
        ValidationResult other = (ValidationResult) object;
        
         if (this.status != null) 
            if(!this.status.equals(other.status)) 
                return false;
          if (this.error != null) 
            if(!this.error.equals(other.error)) 
                return false;
        return true;
    }
       
}
