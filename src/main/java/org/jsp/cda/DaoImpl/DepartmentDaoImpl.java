package org.jsp.cda.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao
{

	@Autowired
	private DepartmentRepository repository;

	@Override
	public Department saveDepartment(Department dept) {
		return repository.save(dept);
	}

	@Override
	public Optional<Department> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Department> findAll() {
		return repository.findAll();
	}


}
