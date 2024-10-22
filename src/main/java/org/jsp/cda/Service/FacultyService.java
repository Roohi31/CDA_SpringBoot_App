package org.jsp.cda.Service;

import java.time.LocalTime;

import org.jsp.cda.entity.Faculty;
import org.springframework.http.ResponseEntity;

public interface FacultyService 
{
	ResponseEntity<?> findAll();

	ResponseEntity<?> saveFaculty(Faculty faculty, int id);


	ResponseEntity<?> findById(int id);

	ResponseEntity<?> setDepartmentToFacutly(int fid, int did);

	ResponseEntity<?> updateTimeOfFaculty(int fid, LocalTime officeHours);

}
