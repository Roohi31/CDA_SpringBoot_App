package org.jsp.cda.ServiceImpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.DepartmentDao;
import org.jsp.cda.Dao.FacultyDao;
import org.jsp.cda.Dao.UserDao;
import org.jsp.cda.Service.FacultyService;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.entity.User;
import org.jsp.cda.exception.InvalidDepartmentIdException;
import org.jsp.cda.exception.InvalidFacultyIdException;
import org.jsp.cda.exception.InvalidUserIdException;
import org.jsp.cda.exception.NoFacultiesFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService
{
	@Autowired
	private FacultyDao facultyDao;

	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<?> saveFaculty(Faculty faculty, int id) {
		Optional<User> optional = userDao.findUserById(id);
		if (optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id...Unable To save faculty").build();
		User user = optional.get();
		faculty.setUser(user);
		faculty = facultyDao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Saved Successfully...").body(faculty).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Faculty> optional = facultyDao.findById(id);
		if (optional.isEmpty())
			throw InvalidDepartmentIdException.builder().message("Invalid Faculty Id...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Faculty Found Successfully...").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Faculty> dl = facultyDao.findAll();
		if(dl.isEmpty())
			throw NoFacultiesFoundException.builder().message("No Faculties Found...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("All Faculties Fetched Successfully...").body(dl).build());
	}

	@Override
	public ResponseEntity<?> setDepartmentToFacutly(int fid, int did) {
		Optional<Faculty> optional1 = facultyDao.findById(fid);

		Optional<Department> optional2 = deptDao.findById(did);

      if(optional1.isEmpty())
    	  throw InvalidFacultyIdException.builder().message("Invalid Faculty Id...Please check").build();
      if(optional1.isEmpty())
    	  throw InvalidDepartmentIdException.builder().message("Invalid Department Id...Please check").build();
      
		Faculty faculty = optional1.get();
		Department dept = optional2.get();
		faculty.setDepartment(dept);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Successfully Set Department To Faculty...").body(faculty).build());
	}

	@Override
	public ResponseEntity<?> updateTimeOfFaculty(int fid, LocalTime officeHours) {
		Optional<Faculty> optional = facultyDao.findById(fid);
		if(optional.isEmpty())
			throw InvalidFacultyIdException.builder().message("Invalid Faculty Id Please Check...").build();
		Faculty faculty = optional.get();
		faculty.setOfficeHours(officeHours);
		faculty=facultyDao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Successfully Updated Faculty OfficeHours...").body(faculty).build());
	}
}
