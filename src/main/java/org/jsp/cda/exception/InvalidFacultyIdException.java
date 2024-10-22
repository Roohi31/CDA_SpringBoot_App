package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidFacultyIdException extends RuntimeException{

	private String message;
	
    public InvalidFacultyIdException(String message)
    {
    	this.message=message;
    }
    
    @Override
    public String getMessage() {
    	return this.message;
    }
}
