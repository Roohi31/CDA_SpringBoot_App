package org.jsp.cda.Controller;

import org.jsp.cda.Service.UserService;
import org.jsp.cda.ServiceImpl.UserServiceImpl;
import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController // combination of rest and controller and controller indicate as bean class...
@RequestMapping(value = "/users")
public class UserController
{
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthUser authUser)
	{
		return userService.login(authUser);
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<?> findUserById(@PathVariable int uid)
	{
		return userService.findUserById(uid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers()
	{
		return userService.findAllUsers();
	}
	
	@PatchMapping(value = "/{uid}")
	public ResponseEntity<?> setUserStatusToActive(@PathVariable int uid)
	{
		return userService.setUserStatusToActive(uid);
	}
	
}
