package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidEnrollmentIdException extends RuntimeException{
	
	private String message;
	
	public InvalidEnrollmentIdException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
