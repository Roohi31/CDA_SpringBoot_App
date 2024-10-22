package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoEnrollmentsFoundException extends RuntimeException{
	private String message;
	
	public NoEnrollmentsFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
