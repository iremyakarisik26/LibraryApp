package com.libraryapp.libraryapp.controllers;

import java.util.List;

import com.libraryapp.libraryapp.dto.UserDto;
import com.libraryapp.libraryapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javassist.NotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public List<UserDto> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public UserDto getOneUser(@PathVariable Long userId) throws NotFoundException {
		return userService.getOneUser(userId);
	}

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDto newUser) {
		 userService.saveOneUser(newUser);
		 return ResponseEntity.ok("Created");
	}
	
	@PutMapping("/{userId}")
	public UserDto updateOneUser(@PathVariable Long userId, @RequestBody UserDto newUser) throws NotFoundException {
		return userService.updateOneUser(userId,newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	
}
	