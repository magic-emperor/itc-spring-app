package com.itc.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.app.Dto.userDto;
import com.itc.app.service.userService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin({"http://localhost:3000", "**"})
public class userController {
	@Autowired
	public userService UserService;
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<?> createNewUser(@RequestBody userDto UserDto){
		userDto saveUsers = UserService.createNewUser(UserDto);
		return new ResponseEntity<>(saveUsers, HttpStatus.CREATED);
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<userDto>> getAllUsers(){
		List<userDto> AllUsers = UserService.getAllUsers();
		return ResponseEntity.ok(AllUsers);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long userId){
		userDto findUserById = UserService.getUserById(userId);
		return ResponseEntity.ok(findUserById);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
		UserService.deleteUserById(userId);
		return ResponseEntity.ok("User Deleted Successfully " + userId); 
		
	}
}