package org.jsp.cda.exceptionHandler;

import org.jsp.cda.exception.InvalidEnrollmentIdException;
import org.jsp.cda.exception.NoEnrollmentsFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EnrollmentExceptionHandler {

	@ExceptionHandler(InvalidEnrollmentIdException.class)
	public ResponseEntity invalidEnrollmentIdException(InvalidEnrollmentIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("Invalid enrollment Id... Please Check").body(e.getMessage()).build());
	}

	@ExceptionHandler(NoEnrollmentsFoundException.class) // this annotation maps the exception
	public ResponseEntity noEnrollmentsFoundException(NoEnrollmentsFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Enrollments Found In The Database ...").body(e.getMessage()).build());
	}
}
