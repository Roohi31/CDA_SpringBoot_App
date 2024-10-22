package org.jsp.cda.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.CourseDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository 
public class CourseDaoImpl implements CourseDao{

	@Autowired
	private CourseRepository repository;
	
	@Override
	public Course save(Course course) {
		return repository.save(course);
	}

	@Override
	public Optional<Course> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return repository.findAll();
	}


}
