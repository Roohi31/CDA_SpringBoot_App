package org.jsp.cda.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.FacultyDao;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FacultyDaoImpl implements FacultyDao
{
	@Autowired
	private FacultyRepository repository;

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return repository.save(faculty);
	}

	@Override
	public Optional<Faculty> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Faculty> findAll() {
		return repository.findAll();
	}

}
