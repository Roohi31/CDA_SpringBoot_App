package org.jsp.cda.exceptionHandler;

import org.jsp.cda.exception.InvalidFacultyIdException;
import org.jsp.cda.exception.NoFacultiesFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FacultyExceptionHandler {

	@ExceptionHandler(InvalidFacultyIdException.class)
	public ResponseEntity invalidFacultyIdException(InvalidFacultyIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Invalid Faculty Id ...").body(e.getMessage()).build());
	}

	@ExceptionHandler(NoFacultiesFoundException.class) // this annotation maps the exception
	public ResponseEntity noFacultiesFoundException(NoFacultiesFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Faculties Found In The Database ...").body(e.getMessage()).build());
	}
}
