package org.jsp.cda.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Student;

public interface StudentDao
{
	Student saveStudent(Student student);

	Optional<Student> findById(int uid);

	List<Student> findAllStudents();
}
