package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidUserIdException extends RuntimeException{
	
	private String message;

	public InvalidUserIdException(String message) {
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}

}
