package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidCourseIdException extends RuntimeException{

	private String message;
	
	public InvalidCourseIdException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
