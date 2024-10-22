package org.jsp.cda.Service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {


	ResponseEntity<?> saveEnrollment(int cid, int sid);

	ResponseEntity<?> findEnrollmentById(int eid);

	ResponseEntity<?> findAllEnrollments();

}
