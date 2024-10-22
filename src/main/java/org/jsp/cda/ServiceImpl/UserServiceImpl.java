package org.jsp.cda.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.Dao.UserDao;
import org.jsp.cda.DaoImpl.UserDaoImpl;
import org.jsp.cda.Service.UserService;
import org.jsp.cda.entity.User;
import org.jsp.cda.exception.InvalidCredentialException;
import org.jsp.cda.exception.InvalidUserIdException;
import org.jsp.cda.exception.NoUsersFoundException;
import org.jsp.cda.util.AuthUser;
import org.jsp.cda.util.UserStatus;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserDaoImpl userDao;

	public ResponseEntity<?> saveUser(User user) {
		
		user.setStatus(UserStatus.IN_ACTIVE);
		
		user = userDao.save(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(user).message("User Created Sucessfully").build()) ;
		
	}

	public ResponseEntity<?> login(AuthUser authUser)
	{
		String username = authUser.getUsername();
		String password = authUser.getPassword();
		
		Optional<User> optional = userDao.findByUserAndPassword(authUser.getUsername(), authUser.getPassword());
		
		if(optional.isEmpty())
		{
			throw InvalidCredentialException.builder().message("Invalid Username or passsword...").build();
		}
		User user = optional.get();
		
		
		return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Verifivation Sucessfully").body(optional.get()).build());
	
	}

	@Override
	public ResponseEntity<?> findUserById(int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if(optional.isEmpty())
		{
			throw InvalidUserIdException.builder().message("Invalid User Id...Couldn't Find User").build();
		}
		User user = optional.get();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("User Found Sucessfully.....").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User>  ul = userDao.findAllUsers();
		if(ul.isEmpty())
			throw NoUsersFoundException.builder().message("No User Found..").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Users Found Successfully...").body(ul).build());
	}

	@Override
	public ResponseEntity<?> setUserStatusToActive(int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if(optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id...Couldn't Set User Status...").build();
		User user=optional.get();
		user.setStatus(UserStatus.ACTIVE);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Status Set To ACTIVE Successfully...").body(userDao.save(user)).build());
	
	}

	
}
