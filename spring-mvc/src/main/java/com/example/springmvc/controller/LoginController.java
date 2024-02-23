package com.example.springmvc.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmvc.config.CustomUserDetails;
import com.example.springmvc.jwt.JwtTokenProvider;
import com.example.springmvc.model.User;
import com.example.springmvc.payload.LoginRequest;
import com.example.springmvc.payload.LoginResponse;
import com.example.springmvc.payload.RandomStuff;
import com.example.springmvc.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class LoginController {
	private final UserService service;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	public LoginController(UserService service) {
		this.service = service;
	}

	@PostMapping(path = "/login")
	public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		// Nếu không xảy ra exception tức là thông tin hợp lệ
		// Set thông tin authentication vào Security Context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Trả về jwt cho người dùng.
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		return new LoginResponse(jwt);
	}
	 @GetMapping("/random")
	    public RandomStuff randomStuff(){
	        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
	    }
//	@PostMapping()
//	public void handleLogin(@RequestBody String email, String password) {
////		Optional<User> user = service.n
//	}
}
