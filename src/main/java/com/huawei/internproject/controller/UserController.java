package com.huawei.internproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.internproject.model.User;
import com.huawei.internproject.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value= "/users")
	public List<User> getUsers() {
		List<User> users= userService.findAll();
		return users;
		
	}
	
	@GetMapping(value="/user/{user_id}")
	public User findOne(@PathVariable Long user_id) {
		
		return userService.findOne(user_id);
	}

	@PostMapping(value= "/users")
	public User addUser(@RequestBody User user) {
		User users = userService.addUser(user);
		return users;
	}
	
	@DeleteMapping(value="/user/{user_id}")
	public User deleteUser(@PathVariable Long user_id)
	{
		return userService.deleteUser(user_id);
	}
	
	@PutMapping(value="/user/{user_id}")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
		
	}


	


}
