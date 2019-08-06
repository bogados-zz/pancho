package com.francisco.castanieda.fluxtest.service;

import com.francisco.castanieda.fluxtest.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	Optional<User> findUserById(Long id);
	List<User> findAllUsers();

	User createUser(User newUser);
}
