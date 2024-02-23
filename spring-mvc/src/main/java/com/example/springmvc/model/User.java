package com.example.springmvc.model;

import java.time.LocalDate;
import java.time.Period;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import com.example.springmvc.validate.CapitalizedConstraint;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@NotBlank(message = "required name")
	@CapitalizedConstraint
	@Length(min = 2, message = "name is so short")
	@Length(max = 50, message = "name is so long")
	@Column
	private String name;
	
	@Email(message = "Invalid email")
	@NotBlank(message = "required email")
//	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$" , message = "Invalid email")
	@Column
	private String email;
	
	@NotBlank(message = "required password")
	@Column
	private String password;
	
	@NotNull(message = "required date")
	@Column
	private LocalDate dob;

	@Transient
	private int age;

	public User() {

	}

	public User(long id, String name,String email,String password, LocalDate dob) {
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
