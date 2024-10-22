package org.jsp.cda.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Enrollment;

public interface EnrollementDao {

	Enrollment saveenrollment(Enrollment enrollment);

	Optional<Enrollment> findById(int eid);

	List<Enrollment> findAllEnrollments();



}