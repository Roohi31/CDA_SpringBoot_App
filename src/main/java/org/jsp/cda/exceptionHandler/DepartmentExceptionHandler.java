package org.jsp.cda.exceptionHandler;

import org.jsp.cda.exception.InvalidDepartmentIdException;
import org.jsp.cda.exception.NoDepartmentsFoundexception;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DepartmentExceptionHandler {

	@ExceptionHandler(InvalidDepartmentIdException.class) // this annotation maps the exception
	public ResponseEntity invalidDepartmentIdException(InvalidDepartmentIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("Invalid Department Id ...").body(e.getMessage()).build());
	}

	@ExceptionHandler(NoDepartmentsFoundexception.class) // this annotation maps the exception
	public ResponseEntity noDepartmentsFoundexception(NoDepartmentsFoundexception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Departments Found In The Database ...").body(e.getMessage()).build());
	}
}
