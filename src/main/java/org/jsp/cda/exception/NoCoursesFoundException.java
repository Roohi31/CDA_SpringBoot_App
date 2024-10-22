package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoCoursesFoundException extends RuntimeException{
	
	private String message;
	
	public NoCoursesFoundException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
