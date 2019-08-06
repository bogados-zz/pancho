package com.francisco.castanieda.fluxtest.rest.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
	private String message;
	private String description;
	private int status;
}
