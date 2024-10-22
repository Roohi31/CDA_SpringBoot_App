package org.jsp.cda.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Faculty;

public interface FacultyDao
{
	Faculty saveFaculty(Faculty faculty);

	Optional<Faculty> findById(int id);

	List<Faculty> findAll();
}
