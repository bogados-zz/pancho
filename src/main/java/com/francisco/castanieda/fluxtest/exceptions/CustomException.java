package com.francisco.castanieda.fluxtest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends Exception{
	private String message;
	private String description;
	private HttpStatus status;
}
