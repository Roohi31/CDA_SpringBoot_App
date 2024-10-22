package org.jsp.cda.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.StudentDao;
import org.jsp.cda.entity.Student;
import org.jsp.cda.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
		
	}

	@Override
	public Optional<Student> findById(int uid) {
		
		return studentRepository.findById(uid);
		
	}

	@Override
	public List<Student> findAllStudents() {
		
		return studentRepository.findAll();
		
	}

}
