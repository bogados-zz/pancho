package com.francisco.castanieda.fluxtest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private Date lastLogin;
	private Boolean isAdmin = false;

	public User (String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User (String username) {
		this.username = username;
		this.password = null;
		this.isAdmin = null;
	}
}
