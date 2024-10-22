package org.jsp.cda.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Course;

public interface CourseDao {

	Course save(Course course);

	Optional<Course> findById(int id);

	List<Course> findAllCourses();


}