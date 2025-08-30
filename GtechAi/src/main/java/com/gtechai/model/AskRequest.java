package com.gtechai.model;





import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class AskRequest {
	@NotBlank
 private String message;

	

	// getter and setter
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
	

	
}

