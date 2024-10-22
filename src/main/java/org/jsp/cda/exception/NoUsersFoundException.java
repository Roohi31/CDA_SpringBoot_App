package org.jsp.cda.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoUsersFoundException  extends RuntimeException
{
	private String message;

	public NoUsersFoundException(String message) {
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}
	
}
