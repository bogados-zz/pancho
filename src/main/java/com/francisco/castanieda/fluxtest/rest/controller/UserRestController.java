package com.francisco.castanieda.fluxtest.rest.controller;

import com.francisco.castanieda.fluxtest.exceptions.CustomException;
import com.francisco.castanieda.fluxtest.exceptions.UserNotFoundException;
import com.francisco.castanieda.fluxtest.model.User;
import com.francisco.castanieda.fluxtest.rest.dto.UserDTO;
import com.francisco.castanieda.fluxtest.security.JWTRepository;
import com.francisco.castanieda.fluxtest.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.francisco.castanieda.fluxtest.security.SecurityConstants.HEADER_STRING;
import static com.francisco.castanieda.fluxtest.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserRestController {
	@Autowired
	private MapperFacade orikaMapper;

	@Autowired
	private UserService userService;


	@PostMapping
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO user) throws CustomException {
		User newUser = orikaMapper.map(user, User.class);
		userService.createUser(newUser);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) throws CustomException {
		User user = userService.findUserById(id).orElseThrow(() -> new UserNotFoundException());
		return new ResponseEntity<>(orikaMapper.map(user, UserDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/logout")
	public ResponseEntity<Object> logout(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING).replace(TOKEN_PREFIX, "");
		JWTRepository.getInstance().removeToken(token);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
