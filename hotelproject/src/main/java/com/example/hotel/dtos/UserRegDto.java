package com.example.hotel.dtos;

import com.example.hotel.entitys.AdminEntity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRegDto {

    private String name;
    private String username;
    private String password;
    private String number;
    private String email;
    // private String role;

}
