package com.example.hotel.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hotel.dtos.*;
import com.example.hotel.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/userServer")
public class UserController {

    @Autowired
    private UserService userServicesImp;

    @PostMapping("/create")
    public long Create(@RequestBody UserDtos reg) {
        return userServicesImp.Create(reg);
    }

    @PostMapping("/login")
    public String Login(@RequestBody UserDtos login, HttpSession session) {
        return userServicesImp.Login(login, session);
    }

    @GetMapping("/getHotel/{hotelid}")
    public HotelDto getHotel(@PathVariable Long hotelid) {
        return userServicesImp.getHotel(hotelid);
    }

    @GetMapping("/getAllRoom/{hotelid}")
    public List<RoomDto> getAllRoom(@PathVariable Long hotelid) {
        return userServicesImp.getAllRoom(hotelid);
    }

    @GetMapping("/getAllHotel")
    public List<HotelDto> getAllHotel() {
        return userServicesImp.getAllHotel();
    }

    @PostMapping("/Booking")
    public String Booking(@RequestBody BookingDto booking, HttpSession session) {
        return userServicesImp.Booking(
                booking.getHotel_id(),
                booking.getRoomType(),
                booking.getFdate(),
                booking.getEdate(),
                session
        );
    }
    @GetMapping("/getbookings")
    public List<BookingDto> getBookings(HttpSession session) {
        return userServicesImp.getUserBookings(session);
    }
    @GetMapping("/delbooking/{Booking_id}")
    public String delBooking(@PathVariable Long Booking_id) {
        return userServicesImp.delBooking(Booking_id);
    }

}
