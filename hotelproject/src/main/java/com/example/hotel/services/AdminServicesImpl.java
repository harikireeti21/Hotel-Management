package com.example.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dtos.AdminLoginDto;
import com.example.hotel.dtos.AdminRegDto;
import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.entitys.AdminEntity;
import com.example.hotel.entitys.HotelEntity;
import com.example.hotel.entitys.RoomEntity;
import com.example.hotel.entitys.RoomEntity;
import com.example.hotel.repositorys.AdminRepository;
import com.example.hotel.repositorys.HotelRepository;
import com.example.hotel.repositorys.RoomRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServicesImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Override
	public long Create(AdminRegDto reg) {
		// TODO Auto-generated method stub
		
		AdminEntity admin =new AdminEntity();
		
		admin
		.setName(reg.getName())
		.setEmail(reg.getEmail())
		.setNumber(reg.getNumber())
		.setPassword(reg.getPassword())
		.setUserName(reg.getUsername());
		
		adminRepository.save(admin);
		return admin.getId();
	}

	@Override
	public String Login(AdminLoginDto login,HttpSession session) {
		// TODO Auto-generated method stub
		AdminEntity admin=adminRepository.findByUserName(login.getUsername());
		
		if(admin==null) {
			throw new Error("Admin not founded!");
		}
		if(!admin.getPassword().equals(login.getPassword())) {
			throw new Error("Wrong Password!");
		}
		session.setAttribute("logedinAdmin", admin);
		return "Login Successfull";
	}

	@Override
	public String CreateHotel(HotelDto hotel) {
		// TODO Auto-generated method stub
		
		HotelEntity hotelcreate=new HotelEntity();
		
		hotelcreate
		.setHotelName(hotel.getHotelName())
		.setHotelNumber(hotel.getHotelNumber())
		.setHotelLocation(hotel.getHotelLocation())
		.setHotelRateing(hotel.getHotelRateing());
		
		List<RoomDto> roomsdto = hotel.getRooms();
		List<RoomEntity> rooms=new ArrayList<RoomEntity>();
		for(RoomDto r:roomsdto) {
			RoomEntity room = new RoomEntity();
			room.setRoomNoOfGuest(r.getRoomNoOfGuest())
			    .setRoomNumber(r.getRoomNumber())
			    .setRoomPricae(r.getRoomPricae())
			    .setRoomStatus(r.getRoomStatus())
			    .setRoomType(r.getRoomType())
			    .setHotel(hotelcreate);
			
			rooms.add(room);
		}
		hotelcreate.setRooms(rooms);
		
		hotelRepository.save(hotelcreate);
		return "Hotel Data is Incersted Successfull!";
	}

	@Override
	public String UpdateHotel(HotelDto upHotel,Long id) {
		// TODO Auto-generated method stub
		Optional<HotelEntity> opHotel = hotelRepository.findById(id);
		if(opHotel.isEmpty()) {
		throw new Error("Hotel not Founded!");
		}
		HotelEntity hotel = opHotel.get();
		hotel
		.setHotelName(upHotel.getHotelName())
		.setHotelLocation(upHotel.getHotelLocation())
		.setHotelNumber(upHotel.getHotelNumber())
		.setHotelRateing(upHotel.getHotelRateing());
		
		hotelRepository.save(hotel);
		return "Hotel data is Updated Successfull";
	}

	@Override
	public String UpdateRoom(RoomDto upRoom, Long roomId, Long hotelId) {
		// TODO Auto-generated method stub
		Optional<HotelEntity> opHotel = hotelRepository.findById(hotelId);
		Optional<RoomEntity> opRoom=roomRepository.findById(roomId);
		if(opHotel.isEmpty()) {
		throw new Error("Hotel not Founded!");
		}
		if(opRoom.isEmpty()) {
			throw new Error("Room not Founded!");
			}
		RoomEntity room=opRoom.get();
		room
		.setRoomNoOfGuest(upRoom.getRoomNoOfGuest())
		.setRoomNumber(upRoom.getRoomNumber())
		.setRoomPricae(upRoom.getRoomPricae())
		.setRoomStatus(upRoom.getRoomStatus())
		.setRoomType(upRoom.getRoomType());
		
		roomRepository.save(room);
			return "The room was Updated";
	}
	
	

	@Override
	public String delHotel(Long id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
 
		return "Hotel is Removed!";
	}

	@Override
	public String delRoom(Long hotelId, Long roomId) {
		// TODO Auto-generated method stub
		Optional<HotelEntity> opHotel = hotelRepository.findById(hotelId);
		Optional<RoomEntity> opRoom=roomRepository.findById(roomId);
		if(opHotel.isEmpty()) {
		throw new Error("Hotel not Founded!");
		}
		if(opRoom.isEmpty()) {
			throw new Error("Room not Founded!");
			}
		roomRepository.deleteById(roomId);
		return null;
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
			.setId(e.getId())
			.setHotelName(e.getHotelName())
		    .setHotelLocation(e.getHotelLocation())
		    .setHotelNumber(e.getHotelNumber())
		    .setHotelRateing(e.getHotelRateing())
		    .setRooms(e.getRooms().stream().map(  r -> new RoomDto()
		    								   .setRoomNoOfGuest(r.getRoomNoOfGuest())
		    								   .setRoomNumber(r.getRoomNumber())
		    								   .setRoomPricae(r.getRoomPricae())
		    								   .setRoomStatus(r.getRoomStatus())
		    								   .setRoomType(r.getRoomType())).toList());
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
			if(r.getHotel().getId()==hotelId) {
			RoomDto roomdto=new RoomDto();
			roomdto
			
			.setRoomNoOfGuest(r.getRoomNoOfGuest())
			   .setRoomNumber(r.getRoomNumber())
			   .setRoomPricae(r.getRoomPricae())
			   .setRoomStatus(r.getRoomStatus())
			   .setRoomType(r.getRoomType());
			Roomdet.add(roomdto);
		}}

		return Roomdet;
	}

	


}
