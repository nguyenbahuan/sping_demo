package com.example.springmvc.dto;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Transient;

public class UserDTO {
	private long id;

	private String name;

	private String email;

	private String password;

	private LocalDate dob;

	@Transient
	private int age;

	public UserDTO() {

	}

	public UserDTO(long id, String name,String email,String password, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
