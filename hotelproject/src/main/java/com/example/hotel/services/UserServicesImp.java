package com.example.hotel.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dtos.*;
import com.example.hotel.entitys.*;
import com.example.hotel.repositorys.*;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServicesImp implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private HotelRepository hotelRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private BookingRepository bookingRepository;

    @Override
    public long Create(UserRegDto reg) {
        UserEntity user = new UserEntity()
                .setName(reg.getName())
                .setEmail(reg.getEmail())
                .setUsername(reg.getUsername())
                .setPassword(reg.getPassword())
                .setNumber(reg.getNumber());

        userRepository.save(user);
        return user.getId();
    }

    @Override
    public String Login(UserLoginDto login, HttpSession session) {
        UserEntity user = userRepository.findByUsername(login.getUsername());
        
        if (user == null) throw new RuntimeException("User not found!");
        if (!user.getPassword().equals(login.getPassword()))
            throw new RuntimeException("Wrong password!");

        session.setAttribute("logedinUser", user);
        return "Login Successful";
    }

    @Override
    public HotelDto getHotel(Long hotelId) {
        HotelEntity hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        HotelDto dto = new HotelDto()
                .setHotelName(hotel.getHotelName())
                .setHotelLocation(hotel.getHotelLocation())
                .setHotelNumber(hotel.getHotelNumber())
                .setHotelRateing(hotel.getHotelRateing())
                .setRooms(
                        hotel.getRooms().stream().map(
                                r -> new RoomDto()
                                        .setRoomNoOfGuest(r.getRoomNoOfGuest())
                                        .setRoomNumber(r.getRoomNumber())
                                        .setRoomPricae(r.getRoomPricae())
                                        .setRoomStatus(r.getRoomStatus())
                                        .setRoomType(r.getRoomType())
                        ).toList()
                );

        return dto;
    }

    @Override
    public List<HotelDto> getAllHotel() {
        List<HotelDto> list = new ArrayList<>();

        for (HotelEntity e : hotelRepository.findAll()) {
            list.add(new HotelDto()
                    .setId(e.getId())
                    .setHotelName(e.getHotelName())
                    .setHotelLocation(e.getHotelLocation())
                    .setHotelNumber(e.getHotelNumber())
                    .setHotelRateing(e.getHotelRateing()));
        }

        return list;
    }

    @Override
    public List<RoomDto> getAllRoom(Long hotelId) {
        HotelEntity hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        List<RoomDto> list = new ArrayList<>();

        for (RoomEntity r : roomRepository.findByHotel(hotel)) {
            list.add(new RoomDto()
                    .setRoomNoOfGuest(r.getRoomNoOfGuest())
                    .setRoomNumber(r.getRoomNumber())
                    .setRoomPricae(r.getRoomPricae())
                    .setRoomStatus(r.getRoomStatus())
                    .setRoomType(r.getRoomType()));
        }

        return list;
    }

    @Override
    public String Booking(Long hotelId, String roomType, LocalDate fdate, LocalDate edate, HttpSession session) {

       
        UserEntity user = (UserEntity) session.getAttribute("logedinUser");
                    if (user == null) throw new RuntimeException("Please login first");
        HotelEntity hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        List<RoomEntity> rooms = roomRepository.findByHotelAndRoomTypeIgnoreCaseAndRoomStatusIgnoreCase(
                hotel, roomType, "UnBooked"
        );

        if (rooms.isEmpty()) throw new RuntimeException("No rooms available");

        RoomEntity room = rooms.get(0); 

    
        BookingEntity bookingEntity = new BookingEntity()
                .setHotel(hotel)
                .setRoom(room)
                .setUser(user)
                .setStartDate(fdate)
                .setEndDate(edate)
                .setPrice(room.getRoomPricae())
                .setBookingStatus("Active");

        
        room.setRoomStatus("Booked");

      
        bookingRepository.save(bookingEntity);
        roomRepository.save(room);

        return "Booking successful. Room no: " + room.getRoomNumber() + " in hotel: " + hotel.getHotelName();
    }
    
    @Override
    public List<BookingDto> getUserBookings(HttpSession session) {

        UserEntity user = (UserEntity) session.getAttribute("logedinUser");
        if (user == null) {
            throw new RuntimeException("Please login first");
        }

        // Fetch all bookings of this user
        List<BookingEntity> bookings = bookingRepository.findByUser(user);

        List<BookingDto> list = new ArrayList<>();

        for (BookingEntity b : bookings) {
        	if(b.getUser().getId()==user.getId()) {
            list.add(new BookingDto()
            		.setBooking_id(b.getId())
                    .setHotel_id(b.getHotel().getId())
                    .setRoomType(b.getRoom().getRoomType())
                    .setFdate(b.getStartDate())
                    .setEdate(b.getEndDate())
            );}
        }

        return list;
    }

	
	@Override
	public String delBooking(Long Booking_id) {

	    BookingEntity booking = bookingRepository.findById(Booking_id)
	            .orElseThrow(() -> new RuntimeException("Booking not found"));

	    RoomEntity room = booking.getRoom();
	    room.setRoomStatus("UnBooked");
	    roomRepository.save(room);  

	    bookingRepository.deleteById(Booking_id);

	    return "Booking is canceled";
	}

    

}
