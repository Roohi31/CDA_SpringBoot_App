package org.jsp.cda.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.CourseDao;
import org.jsp.cda.Dao.DepartmentDao;
import org.jsp.cda.Service.CourseService;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exception.InvalidCourseIdException;
import org.jsp.cda.exception.InvalidDepartmentIdException;
import org.jsp.cda.exception.InvalidFacultyIdException;
import org.jsp.cda.exception.NoCoursesFoundException;
import org.jsp.cda.repository.FacultyRepository;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private DepartmentDao deptDao;

	@Autowired
	private FacultyRepository frepo;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		course = courseDao.save(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Course Saved Successufully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Course> optional = courseDao.findById(id);
		if (optional.isEmpty())
			throw InvalidCourseIdException.builder().message("Invalid Course Id...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Course Found Successfully...").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> cl = courseDao.findAllCourses();
		if (cl.isEmpty())
			throw NoCoursesFoundException.builder().message("No Courses Found...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("All the Courses Fetched Successfully...").body(cl).build());
	}

	@Override
	public ResponseEntity<?> setFacultyToCourse(int cid, int fid) {

		Optional<Faculty> optional1 = frepo.findById(fid);

		Optional<Course> optional2 = courseDao.findById(cid);
//			
//			
//			validation
		if (optional2.isEmpty())
			throw InvalidFacultyIdException.builder().message("Invalid Faculty Id...").build();
		if (optional2.isEmpty())
			throw InvalidCourseIdException.builder().message("Invalid Course Id...").build();

//			
		Faculty faculty = optional1.get();
		Course course = optional2.get();
		course.setFaculty(faculty);
		courseDao.save(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Successfully set faculty to course...").body(course).build());
	}

	@Override
	public ResponseEntity<?> setDepartmentToCourse(int cid, int did) {

		Optional<Department> optional1 = deptDao.findById(did);

		Optional<Course> optional2 = courseDao.findById(cid);

		if (optional1.isEmpty())
			throw InvalidDepartmentIdException.builder().message("Invalid Department Id...")
					.build();
       if(optional2.isEmpty())
    	   throw InvalidCourseIdException.builder().message("Invalid Course Id ...").build();

		Department dept = optional1.get();
		Course course = optional2.get();
		course.setDepartment(dept);
		courseDao.save(course);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Successfully set department to course...").body(course).build());
	}
}

