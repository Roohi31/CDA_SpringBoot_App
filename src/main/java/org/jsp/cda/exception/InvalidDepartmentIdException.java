package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidDepartmentIdException extends RuntimeException{
    private String message;
    
    public InvalidDepartmentIdException(String message)
    {
    	this.message=message;
    }
    
    @Override
    public String getMessage() {
		return this.message;
	}
    
}

