package com.example.hotel.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String username;
	private String password;
	private String number;
	private String email;
	private String role;
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public UserEntity setName(String name) {
		this.name = name;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public UserEntity setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public UserEntity setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getNumber() {
		return number;
	}
	public UserEntity setNumber(String number) {
		this.number = number;
		return this;
	}
	public String getEmail() {
		return email;
		
	}
	public UserEntity setEmaile(String email) {
		this.email = email;
		return this;
	}
	public String getRole() {
		return role;
	}
	public UserEntity setRole(String role) {
		this.role = role;
		return this;
	}
	
}
