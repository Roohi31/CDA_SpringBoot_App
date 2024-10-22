package org.jsp.cda.Service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService {
	public ResponseEntity<?> saveUser(User user);
	
	public ResponseEntity<?> login(AuthUser authUser);

	public ResponseEntity<?> findUserById(int uid);

	public ResponseEntity<?> findAllUsers();

	public ResponseEntity<?> setUserStatusToActive(int uid);
}
