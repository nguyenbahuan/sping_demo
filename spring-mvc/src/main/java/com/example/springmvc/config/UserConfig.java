package com.example.springmvc.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.springmvc.model.Phones;
import com.example.springmvc.model.User;
import com.example.springmvc.repository.PhonesRepository;
import com.example.springmvc.repository.UserRepository;

@Configuration
public class UserConfig {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository, PhonesRepository phonesRepository) {
		return arg -> {
			repository.saveAll(List.of(new User(1,"Huan","123@gmail.com",passwordEncoder.encode("123456"),LocalDate.of(2002, Month.JANUARY, 20)), new User(2,"Huan","12@gmail.com",passwordEncoder.encode("123456"),LocalDate.of(2006, Month.JANUARY, 20))));
			phonesRepository.saveAll(List.of(new Phones(1L, "IP15", 100000), new Phones(2L, "IP16", 100000)));
		};
	}
}
