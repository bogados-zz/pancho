package com.francisco.castanieda.fluxtest.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@RunWith(value = MockitoJUnitRunner.class)
public class TestBCrypt {
	@Test
	public void testBCrypt() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("pancho");
		System.out.println(encodedPassword);
	}

	@Test
	public void testBCryptMatch() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Assert.assertTrue(passwordEncoder.matches("pancho","$2a$10$tM9NHWq83f9bQWrlK6M0/uqxqIITmvBVWSOYg2lUBQ7inVboNWFFO"));
	}
}
