package com.example.hotel.dtos;

import lombok.Data;

@Data
public class UserDtos implements LoginDtos,UserDetails  {
private String name;
private String userName;
private String password;
private String email;
private String number;



}
