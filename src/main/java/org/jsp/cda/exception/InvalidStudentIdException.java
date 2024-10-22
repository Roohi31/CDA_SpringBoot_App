package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidStudentIdException extends RuntimeException{

	private String message;
	
	public InvalidStudentIdException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
