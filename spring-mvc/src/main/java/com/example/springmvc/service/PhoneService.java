package com.example.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springmvc.model.Phones;
import com.example.springmvc.repository.PhonesRepository;

@Service
public class PhoneService {
	@Autowired
	private PhonesRepository phonesRepository;

	@GetMapping
	public List<Phones> getAllPhone() {
		return phonesRepository.findAll();
	}
}
