package com.example.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.dtos.UserLoginDto;
import com.example.hotel.dtos.UserRegDto;
import com.example.hotel.services.UserServicesImp;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/userServer")
public class UserController {
	 
	@Autowired
	UserServicesImp userServicesImp;
	
	@PostMapping("/create")
	public long Create(@RequestBody UserRegDto reg) {
		return userServicesImp.Create(reg);
	}
	public String Login(@RequestBody UserLoginDto login,HttpSession session) {
		return userServicesImp.Login(login, session);
	}

	@GetMapping("/getHotel/{hotelid}")
	public HotelDto getHotel(@PathVariable("hotelid") Long hotelId) {
		return userServicesImp.getHotel(hotelId);
	} 
	 
	@PostMapping("/getAllRoom/{hotelid}")
	public List<RoomDto> getAllRoom(@PathVariable("hotelid") Long hotelId){
		return userServicesImp.getAllRoom(hotelId);
	}
	@GetMapping("/getAllHotel")
	public List<HotelDto> getAllHotel(){
		return userServicesImp.getAllHotel();
	}

}
