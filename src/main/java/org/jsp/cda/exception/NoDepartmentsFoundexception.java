package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoDepartmentsFoundexception extends RuntimeException{

	private String message;
	
	public NoDepartmentsFoundexception(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
