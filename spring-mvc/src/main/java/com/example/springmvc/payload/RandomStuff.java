package com.example.springmvc.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RandomStuff {
	private String message;

	public RandomStuff (String message) {
		this.message = message;
	}
	public RandomStuff () {
		
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
