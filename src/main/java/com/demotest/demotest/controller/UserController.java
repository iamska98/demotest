package com.demotest.demotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demotest.demotest.modal.Users;
import com.demotest.demotest.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userrepository;
	
	@GetMapping("/{username}")
	public List<Users> getUser(@PathVariable("username") final String username){
		
	return	userrepository.
		findByName(username);
	}

	@PostMapping("/add")
	public List<Users> addUser(@RequestBody final Users users){
		
		userrepository.save(users);
		return userrepository.findByName(users.getName());
		
	}
	
	@GetMapping("/youngest")
	public List<Users> getYoungestUser(){
		
		return userrepository.findByAge();
	}
}
