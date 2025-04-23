package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService as;
	
    //get all users
	@GetMapping("/all")
	public List<User> getAllUser() {

		return as.getUser();
	}

	//add user by id
	@PostMapping("/add")
	public User addUser(@RequestBody @Valid User a) {
		return as.addUser(a);
	}

	//update user by id
	@PutMapping("/update/{id}")
	public User updateUSer(@RequestBody @Valid User u, @PathVariable int id) {
		return as.updateUSer(u, id);
	}

	//delete user by id
	@DeleteMapping("/del/{id}")
	public String deleteUser(@PathVariable int id) {
		return as.deleteUser(id);

	}
	
	//find user by id
	@GetMapping("/find/{id}")
	public Optional<User> findUserById(@PathVariable int id) {
	    return as.getUserByID(id); // Call the service to find the user
	}
	
	//counts total number of users
	@GetMapping("countuser")
	public long countUsers() {
	return as.countUsers();

	}
	//find full name in ascending order
	@GetMapping("orderbyusername")
	public List<User> findByOrderByFullNameAsc(){
	return as.findByOrderByFullNameAsc();
	}
	
	//find users whose names are starting with a
	@GetMapping("startwith/{a}")
	List<User> findByFullNameStartingWith(@PathVariable String a){
	return as.findByFullNameStartingWith(a);
	}
	
	

}
