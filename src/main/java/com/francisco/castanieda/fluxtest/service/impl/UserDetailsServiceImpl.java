package com.francisco.castanieda.fluxtest.service.impl;

import com.francisco.castanieda.fluxtest.model.User;
import com.francisco.castanieda.fluxtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getIsAdmin() ?
				Collections.singletonList(new GrantedAuthority() {
					@Override
					public String getAuthority() {
						return "ADMIN";
					}
				}) : emptyList());
	}

}
