package com.example.hotel.services;

import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.LoginDtos;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.dtos.UserDtos;
import java.util.List;
import jakarta.servlet.http.HttpSession;

public interface AdminService {

	long Create(UserDtos reg);
	String Login(UserDtos login,HttpSession session);
	String CreateHotel(HotelDto hotel);
	String AddRoom(RoomDto room ,Long hotelId);
	String UpdateHotel(HotelDto uphotel,Long id);
	String UpdateRoom(RoomDto upRoom,Long roomId,Long hotelId);
	String delHotel(Long id);
	String delRoom(Long hotelId,Long roomId);
	HotelDto getHotel(Long hotelId);
	List<RoomDto> getAllRoom(Long hotelId);
	List<HotelDto> getAllHotel();
}
