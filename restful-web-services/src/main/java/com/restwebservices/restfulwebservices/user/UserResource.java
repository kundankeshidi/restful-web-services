package com.restwebservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	// retrieve all users
	
	@GetMapping(path = "/users")
	public List<User> retrieveAll(){
		return service.findAll();
	}
	
	// retrieveUser(int id)
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	// create a user
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = service.save(user);
	}
	
}
