package com.francisco.castanieda.fluxtest.service.impl;

import com.francisco.castanieda.fluxtest.model.User;
import com.francisco.castanieda.fluxtest.repository.UserRepository;
import com.francisco.castanieda.fluxtest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User newUser) {
		return null;
	}
}
