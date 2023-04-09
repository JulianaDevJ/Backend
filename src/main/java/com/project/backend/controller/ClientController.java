package com.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.model.User;
import com.project.backend.service.UserService;

@RestController
public class ClientController {

	@Autowired
	private UserService userService;

	// Rest API Crud -Create User - POST
	// Read User - GET
	// DELETE User -DELETE
	// Update User - PUT

	// Get User By Id

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}

	// LER/BUSCAR .... Read Users

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	// Create User

	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		User user1 = userService.createUser(user);
		return user1;
	}

	// Update Users By Id

	@PutMapping("/update/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable("id") long id) {
		return userService.updateUser(user, id);
	}

	// Delete User By Id

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "User Deleted Successfully..";
	}

}
