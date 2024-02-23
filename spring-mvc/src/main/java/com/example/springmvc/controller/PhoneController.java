package com.example.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmvc.model.Phones;
import com.example.springmvc.service.PhoneService;

@RestController
@RequestMapping(path = "api/v1/phones")
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping
	public List<Phones> getPhones(){
		return phoneService.getAllPhone();
	}
}
