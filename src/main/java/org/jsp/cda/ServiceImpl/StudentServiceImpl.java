package org.jsp.cda.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.DepartmentDao;
import org.jsp.cda.Dao.StudentDao;
import org.jsp.cda.Dao.UserDao;
import org.jsp.cda.Service.StudentService;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Student;
import org.jsp.cda.entity.User;
import org.jsp.cda.exception.InvalidDepartmentIdException;
import org.jsp.cda.exception.InvalidStudentIdException;
import org.jsp.cda.exception.InvalidUserIdException;
import org.jsp.cda.exception.NoStudentsFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private DepartmentDao deptDao;

	
	@Override
	public ResponseEntity<?> saveStudent(Student student, int uid) {
		
		Optional<User> optional = userDao.findUserById(uid);
		if (optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id...Unable To save Student ").build();
		User user = optional.get();
		student.setUser(user);
		student = studentDao.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Student Saved Successfully...").body(student).build());
	
	}

	@Override
	public ResponseEntity<?> findById(int uid) {
		Optional<Student> optional = studentDao.findById(uid);
		if (optional.isEmpty())
			throw InvalidStudentIdException.builder().message("Couldn't find student...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Student Found Successfully...").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Student> sl = studentDao.findAllStudents();
		if (sl.isEmpty())
			throw NoStudentsFoundException.builder().message("No Students Found... ").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Students Found Successfully...").body(sl).build());
	}

	@Override
	public ResponseEntity<?> setDepartmentToStudent(int sid, int did) {
		Optional<Student> optional1 = studentDao.findById(sid);
		Optional<Department> optional2 = deptDao.findById(did);

		if (optional1.isEmpty())
			throw InvalidStudentIdException.builder().message("Couldn't find student...").build();
		if (optional2.isEmpty())
			throw InvalidDepartmentIdException.builder().message("Couldn't find the department...").build();

		Student student = optional1.get();
		Department dept = optional2.get();
		student.setDepartment(dept);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Successfully Set Department To Student...").body(student).build());
	}

}
