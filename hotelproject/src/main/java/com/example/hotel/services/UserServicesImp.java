package com.example.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dtos.BookingDto;
import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.dtos.UserLoginDto;
import com.example.hotel.dtos.UserRegDto;
import com.example.hotel.entitys.AdminEntity;
import com.example.hotel.entitys.BookingEntity;
import com.example.hotel.entitys.HotelEntity;
import com.example.hotel.entitys.RoomEntity;
import com.example.hotel.entitys.UserEntity;
import com.example.hotel.repositorys.BookingRepository;
import com.example.hotel.repositorys.HotelRepository;
import com.example.hotel.repositorys.RoomRepository;
import com.example.hotel.repositorys.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServicesImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Override
	public long Create(UserRegDto reg) {
		// TODO Auto-generated method stub
		UserEntity user=new UserEntity();
		
		user
		.setName(reg.getName())
		.setEmaile(reg.getEmaile())
		.setUsername(reg.getUsername())
		.setPassword(reg.getPassword())
		.setNumber(reg.getNumber())
		.setRole(reg.getRole());
		
		userRepository.save(user);
		return user.getId();
	}

	@Override
	public String Login(UserLoginDto login, HttpSession session) {
		// TODO Auto-generated method stub
UserEntity user=userRepository.findByUsername(login.getUsername());
		
		if(user==null) {
			throw new Error("User not founded!");
		}
		if(!user.getPassword().equals(login.getPassword())) {
			throw new Error("Wrong Password!");
		}
		session.setAttribute("logedinAdmin", user);
		return "Login Successfull";
	}
	@Override
	public HotelDto getHotel(Long hotelId) {
		// TODO Auto-generated method stub
		 HotelEntity hotel = hotelRepository.findById(hotelId).get();
		    HotelDto hotelDto = new HotelDto();
		    hotelDto
		    .setHotelName(hotel.getHotelName())
		    .setHotelLocation(hotel.getHotelLocation())
		    .setHotelNumber(hotel.getHotelNumber())
		    .setHotelRateing(hotel.getHotelRateing())
		    .setRooms( hotel.getRooms()
		    						  .stream()
		    						   .map( r -> new RoomDto()
		    								   .setRoomNoOfGuest(r.getRoomNoOfGuest())
		    								   .setRoomNumber(r.getRoomNumber())
		    								   .setRoomPricae(r.getRoomPricae())
		    								   .setRoomStatus(r.getRoomStatus())
		    								   .setRoomType(r.getRoomType())).toList());
		return hotelDto;
	}

	
	
	@Override
	public List<HotelDto> getAllHotel() {
		// TODO Auto-generated method stub
		List<HotelDto> Hoteldet=new ArrayList<>();
		List<HotelEntity>hotel=hotelRepository.findAll();
		
		for(HotelEntity e:hotel) {
			HotelDto hotelDto=new HotelDto();
			hotelDto
		    .setHotelName(e.getHotelName())
		    .setHotelLocation(e.getHotelLocation())
		    .setHotelNumber(e.getHotelNumber())
		    .setHotelRateing(e.getHotelRateing());
		Hoteldet.add(hotelDto);
		}
		return Hoteldet;
	}

	@Override
	public List<RoomDto> getAllRoom(Long hotelId) {
		Optional<HotelEntity> opHotel = hotelRepository.findById(hotelId);
		if(opHotel.isEmpty()) {
		throw new Error("There is no room for this Hotel!");
		}
		List<RoomDto> Roomdet=new ArrayList<>();
		List<RoomEntity>room=roomRepository.findAll();
		
		for(RoomEntity r:room) {
			RoomDto roomdto=new RoomDto();
			roomdto
			.setRoomNoOfGuest(r.getRoomNoOfGuest())
			   .setRoomNumber(r.getRoomNumber())
			   .setRoomPricae(r.getRoomPricae())
			   .setRoomStatus(r.getRoomStatus())
			   .setRoomType(r.getRoomType());
			Roomdet.add(roomdto);
		}

		return Roomdet;
	}

	@Override
	public String Booking(BookingDto booking,Long roomId,Long userId) {
		// TODO Auto-generated method stub
		BookingEntity book=new BookingEntity();
		Optional<UserEntity>opuser=userRepository.findById(userId);
		Optional<RoomEntity>opRoom=roomRepository.findById(roomId);
		if(opRoom.isEmpty() || opuser.isEmpty()) {
			throw new Error("The (Room or user) data is Miss Match!");
		}
		RoomEntity room=new RoomEntity();
		room.setRoomStatus("Booked");
		roomRepository.save(room);
		
		book
		.setDate(booking.getDate())
		.setHotelId(booking.getHotelId())
		.setRoomId(booking.getRoomId())
		.setUserId(booking.getUserId());
		
		
		bookingRepository.save(book);
		
		
		return "Hotel is Booked Successfuly!";
	}


}
