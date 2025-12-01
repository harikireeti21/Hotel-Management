package com.example.hotel.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hotel.dtos.HotelDto;
import com.example.hotel.dtos.LoginDtos;
import com.example.hotel.dtos.RoomDto;
import com.example.hotel.dtos.UserDtos;
import com.example.hotel.services.AdminService;
import com.example.hotel.services.AdminServicesImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/adminserver")
public class AdminController {
	@Autowired
	private AdminService  adminService;
	
	@PostMapping("/create")
	public long Create(@RequestBody UserDtos reg) {
		return adminService.Create(reg);
	}
	
	@PostMapping("/login")
	public String Login(@RequestBody LoginDtos login,HttpSession session) {
		return adminService.Login(login, session);
	}
	 
	@PostMapping("/createHotel")
	public String CreateHotel(@RequestBody HotelDto hotel) {
		return adminService.CreateHotel(hotel);
	}
	
	@PutMapping("/upHotel/{id}")
	public String UpdateHotel(@RequestBody HotelDto uphotel,@PathVariable("id") Long id) {
		return adminService.UpdateHotel(uphotel, id);
	}
	
	@PutMapping("/upRoom/{roomid}/{hotelId}")
	public String UpdateRoom(@RequestBody RoomDto upRoom,@PathVariable("roomid") Long roomId,@PathVariable("hotelId") Long hotelId) {
		return adminService.UpdateRoom(upRoom, roomId, hotelId);
	}

	@DeleteMapping("/delHotel/{id}")
	public String delHotel(@PathVariable("id") Long id) {
		return adminService.delHotel(id);
	}
	@DeleteMapping("/delRoom/{hotelid}/{roomid}")
	public String delRoom(@PathVariable("hotelid") Long hotelId,@PathVariable("roomid") Long roomId) {
		return adminService.delRoom(hotelId, roomId);
	}
	
	@GetMapping("/getHotel/{hotelid}")
	public HotelDto getHotel(@PathVariable("hotelid") Long hotelId) {
		return adminService.getHotel(hotelId);
	} 
	 
	@PostMapping("/getAllRoom/{hotelid}")
	public List<RoomDto> getAllRoom(@PathVariable("hotelid") Long hotelId){
		return adminService.getAllRoom(hotelId);
	}
	@GetMapping("/getAllHotel")
	public List<HotelDto> getAllHotel(){
		return adminService.getAllHotel();
	}
	@PostMapping("/addRoom/{hotelId}")
	public String addRoom(@RequestBody RoomDto roomDto, @PathVariable("hotelId") Long hotelId) {
	    return adminService.AddRoom(roomDto, hotelId);
	}

//	
}
