package com.example.springmvc.hello;

import java.time.LocalDate;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmvc.model.User;
import com.example.springmvc.service.UserService;

import org.springframework.ui.Model;

@Controller
public class Hello {
	private final UserService userService;

	@Autowired
	public Hello(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String helloWorld(Model model) {
//		List<User> users = userService.getUsers();
//		model.addAttribute("ok", "ok");
		return "index";
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		// Gắn vào model giá trị name nhận được
		
		model.addAttribute("users", userService.getUsers());

		return "hello"; // trả về file hello.html cùng với thông tin trong object Model
	}
}
