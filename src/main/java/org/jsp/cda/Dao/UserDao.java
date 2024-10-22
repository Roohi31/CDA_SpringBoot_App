package org.jsp.cda.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.User;

public interface UserDao
{
	User save(User user);
	
	Optional<User> findUserById(int id);
	
	List<User> findAllUsers();

	Optional<User> findByUserAndPassword(String username, String password);

}
