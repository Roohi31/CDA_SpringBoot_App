package org.jsp.cda.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.User;

public interface DepartmentDao
{
	Department saveDepartment(Department dept);

	Optional<Department> findById(int id);

	List<Department> findAll();

}
