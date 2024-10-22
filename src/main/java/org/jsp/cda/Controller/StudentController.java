package org.jsp.cda.Controller;

import org.jsp.cda.Service.StudentService;
import org.jsp.cda.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/{uid}")
	public ResponseEntity<?> saveStudent(@RequestBody Student student ,@PathVariable int uid)
	{
		return studentService.saveStudent(student, uid);
	}
	
	@GetMapping(value = "/{uid}")
	public ResponseEntity<?> findStudentById(@PathVariable int uid)
	{
		return  studentService.findById(uid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllStudents()
	{
		return studentService.findAll();
	}
	
	@PatchMapping(value = "/department/{sid}/{did}")
	public ResponseEntity<?> setDepartmentToStudent(@PathVariable int sid, @PathVariable int did){	
		return studentService.setDepartmentToStudent(sid, did);
	}
	
}
