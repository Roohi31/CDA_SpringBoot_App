package org.jsp.cda.exceptionHandler;

import org.jsp.cda.exception.InvalidStudentIdException;
import org.jsp.cda.exception.NoStudentsFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(NoStudentsFoundException.class) // this annotation maps the exception
	public ResponseEntity noStudentsFoundException(NoStudentsFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Students Found In The Database ...").body(e.getMessage()).build());
	}

	@ExceptionHandler(InvalidStudentIdException.class)
	public ResponseEntity invalidStudentIdException(InvalidStudentIdException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Students Found In The Database ...").body(e.getMessage()).build());
	}
}
