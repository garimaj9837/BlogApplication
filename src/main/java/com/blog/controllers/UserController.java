package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	//PUT -update user
	@PutMapping("/{Id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("Id") Integer userId){
		UserDto updateUserDto=this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
	}
	
	//DELETE -delete user
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> deleteUser(@PathVariable("Id") Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}
	
	//GET -all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> getallUsers = this.userService.getallUsers();
		return ResponseEntity.ok(getallUsers);
	}
	
	//GET -user by id
		@GetMapping("/{Id}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable("Id") Integer userId){
			UserDto userById = this.userService.getUserById(userId);
			return ResponseEntity.ok(userById);
		}
	
	
}
