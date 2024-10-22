package org.jsp.cda.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.EnrollementDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollementDaoImpl implements EnrollementDao
{
	@Autowired
	private EnrollmentRepository repo;
	
	@Override
	public Enrollment saveenrollment(Enrollment enrollment) {
		return repo.save(enrollment);
	}

	@Override
	public Optional<Enrollment> findById(int eid) {
		return repo.findById(eid);
	}

	@Override
	public List<Enrollment> findAllEnrollments() {
		return repo.findAll();
	}
}
