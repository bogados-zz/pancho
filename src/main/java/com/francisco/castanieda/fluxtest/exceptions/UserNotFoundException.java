package com.francisco.castanieda.fluxtest.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {
	public UserNotFoundException() {
		super("USER_NOT_FOUND", "User not found", HttpStatus.NOT_FOUND);
	}
}
