package org.jsp.cda.Controller;

import java.time.LocalTime;
import java.util.Optional;

import org.jsp.cda.Dao.UserDao;
import org.jsp.cda.Service.FacultyService;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.entity.User;
import org.jsp.cda.repository.DepartmentRepository;
import org.jsp.cda.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController
{
	@Autowired
	private FacultyService service;
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private FacultyRepository frepository;
	
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty,@PathVariable int id)
	{
	
		return service.saveFaculty(faculty,id);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findFacultyById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllFaculties()
	{
		return service.findAll();
	}
	
	@PatchMapping(value = "/department/{fid}/{did}")
	public ResponseEntity<?> setDepartmentToFacutly(@PathVariable int fid, @PathVariable int did){	
		return service.setDepartmentToFacutly(fid, did);
	}
	
	@PatchMapping(value = "/officeHours/{fid}")
	public ResponseEntity<?> updateTimeOfFaculty(@PathVariable int fid,@RequestParam LocalTime officeHours)
	{
		return service.updateTimeOfFaculty(fid,officeHours);
	}
	
}
