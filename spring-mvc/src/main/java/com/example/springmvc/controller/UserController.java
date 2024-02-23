package com.example.springmvc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springmvc.model.User;
import com.example.springmvc.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "{userId}")
	public User getUser(@PathVariable Long userId) {
		return userService.loadUserById(userId);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, String> registerUser(@RequestBody @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			Map<String, String> errors = new HashMap<>();

			bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			errors.put("status", "not ok");
			return errors;
		}
		Map<String, String> sucsses = new HashMap<>();
		userService.addNewUser(user);
		sucsses.put("messege", "created sucsses");
		sucsses.put("status", "ok");
		return sucsses;
	}

	@DeleteMapping(path = "{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}

	@PutMapping(path = "{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@PathVariable("userId") Long userId, @RequestParam(required = true) String name,
			@RequestParam(required = true) String email) {
		userService.updateUser(userId, name, email);
	}

}
