/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.validation;

/**
 *
 * @author kai.du
 */
public class ValidationError {
    String pointer;
    String missing;
    ValidationErrorType type;

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public ValidationErrorType getType() {
        return type;
    }

    public void setType(ValidationErrorType type) {
        this.type = type;
    }

    public String getMissing() {
        return missing;
    }

    public void setMissing(String missing) {
        this.missing = missing;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pointer != null ? pointer.hashCode() : 0);
        hash += (missing != null ? missing.hashCode() : 0);
         hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidationError)) {
            return false;
        }
        ValidationError other = (ValidationError) object;
        if (this.pointer != null) 
            if(!this.pointer.equals(other.pointer)) 
                return false;
         if (this.missing != null) 
            if(!this.missing.equals(other.missing)) 
                return false;
          if (this.type != null) 
            if(!this.type.equals(other.type)) 
                return false;
        return true;
    }
}
