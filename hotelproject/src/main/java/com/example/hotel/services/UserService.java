package com.example.hotel.services;

import java.time.LocalDate;
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
	String Booking( Long hotelId,String roomType,LocalDate fdate,LocalDate edate,HttpSession session);
	List<BookingDto> getUserBookings(HttpSession session);
	String delBooking(Long Booking_id);
}
 