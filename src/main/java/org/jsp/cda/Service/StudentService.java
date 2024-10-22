package org.jsp.cda.Service;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
	
	ResponseEntity<?> saveStudent(Student student, int uid);
	
	ResponseEntity<?> findById(int uid);
	
	ResponseEntity<?> findAll();

	ResponseEntity<?> setDepartmentToStudent(int sid, int did);
	
}
