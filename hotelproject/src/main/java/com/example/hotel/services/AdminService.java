package com.example.hotel.services;

import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.entitys.HotelEntity;

import java.util.List;

import com.example.hotel.dtos.AdminLoginDto;
import com.example.hotel.dtos.AdminRegDto;

import jakarta.servlet.http.HttpSession;

public interface AdminService {

	long Create(AdminRegDto reg);
	String Login(AdminLoginDto login,HttpSession session);
	String CreateHotel(HotelDto hotel);
	String UpdateHotel(HotelDto uphotel,Long id);
	String UpdateRoom(RoomDto upRoom,Long roomId,Long hotelId);
	String delHotel(Long id);
	String delRoom(Long hotelId,Long roomId);
	HotelDto getHotel(Long hotelId);
	List<RoomDto> getAllRoom(Long hotelId);
	List<HotelDto> getAllHotel();
	
	
}
