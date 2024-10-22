package org.jsp.cda.repository;

import java.util.Optional;

import org.jsp.cda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>
{

//	@Query(name = "select u from User u where u.username=?1 and u.password=?2")
//	if we follow the name convention it will write query by itself
	Optional<User> findByUsernameAndPassword(String username, String password);
	
	

}
