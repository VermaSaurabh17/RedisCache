package com.redis.cache.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redis.cache.models.User;
import com.redis.cache.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserController {

	@Autowired
	private UserRepository _userRepository;

	public UserController(UserRepository userRepository) {
		_userRepository = userRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public Map<String, User> GetAll() {
		return _userRepository.findAll();
	}

	@GetMapping("/all/{id}")
	public User GetAll(@PathVariable("id") final String id) {
		return _userRepository.findById(id);
	}

	@PostMapping("/add")
	public User add(@RequestBody User user) {
		_userRepository.save(new User(user.getId(), user.getName(), 80000L));
		return _userRepository.findById(user.getId());
	}

	@PostMapping("/update")
	public User update(@RequestBody User user) {
		_userRepository.update(new User(user.getId(), user.getName(), 1000L));
		return _userRepository.findById(user.getId());
	}
}