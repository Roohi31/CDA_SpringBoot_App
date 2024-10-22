package org.jsp.cda.exceptionHandler;

import org.jsp.cda.exception.InvalidCredentialException;
import org.jsp.cda.exception.InvalidUserIdException;
import org.jsp.cda.exception.NoUsersFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// all the exception will come and look into this class so that the excpetion gets handled with the help of this annotation
public class UserExceptionHandler 
{
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<?> invalidCredentialExceptionHandler(InvalidCredentialException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value())
				.message("Invalid Credentials..Unable to verify..Verification failed...").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoUsersFoundException.class) // this annotation maps the exception
	public ResponseEntity noUsersFoundException(NoUsersFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Users Found In The Database ...").body(e.getMessage()).build());
	}

	@ExceptionHandler(InvalidUserIdException.class) // this annotation maps the exception
	public ResponseEntity invalidUserIdException(InvalidUserIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Invalid User Id ...").body(e.getMessage()).build());
	}
	
}

//All the requests are redirected to RestController
//All the exceptions are redirected to RestControllerAdvice
