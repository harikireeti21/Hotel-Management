package com.example.hotel.entitys;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String userName;
	private String email;
	private String number;
	private String password;
	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public AdminEntity setName(String name) {
		this.name = name;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public AdminEntity setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public AdminEntity setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getNumber() {
		return number;
	}
	public AdminEntity setNumber(String number) {
		this.number = number;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public AdminEntity setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	
	

}
