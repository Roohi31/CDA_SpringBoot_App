package org.jsp.cda.exceptionHandler;

import org.jsp.cda.exception.InvalidCourseIdException;
import org.jsp.cda.exception.NoCoursesFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandler {

	@ExceptionHandler(InvalidCourseIdException.class)
	public ResponseEntity invalidCourseIdException(InvalidCourseIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("Invalid Course Id Please Check...").body(e.getMessage()).build());
	}

	@ExceptionHandler(NoCoursesFoundException.class) // this annotation maps the exception
	public ResponseEntity noCoursesFoundException(NoCoursesFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Courses Found In The DataBase ...").body(e.getMessage()).build());
	}
}
