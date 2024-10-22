package org.jsp.cda.Service;

import org.jsp.cda.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {
	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> findAllCourses();

	ResponseEntity<?> setFacultyToCourse(int cid, int fid);

	ResponseEntity<?> setDepartmentToCourse(int cid, int did);

}
