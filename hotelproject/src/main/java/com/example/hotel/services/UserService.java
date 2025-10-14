package com.example.hotel.services;

import java.util.List;

import com.example.hotel.dtos.BookingDto;
import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.dtos.UserLoginDto;
import com.example.hotel.dtos.UserRegDto;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	long Create(UserRegDto reg);
	String Login(UserLoginDto login,HttpSession session);

	HotelDto getHotel(Long hotelId);
	List<RoomDto> getAllRoom(Long hotelId);
	List<HotelDto> getAllHotel();
	String Booking(BookingDto booking,Long roomId,Long userId);
}
