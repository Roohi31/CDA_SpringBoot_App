package org.jsp.cda.Controller;

import org.jsp.cda.Service.DepartmentService;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/departments")
public class DepartmentController
{
	@Autowired
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department dept)
	{
		return service.saveDepartment(dept);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllDepartments()
	{
		return service.findAll();
	}
}
