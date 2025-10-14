package com.example.hotel.dtos;

import java.util.List;

public class HotelDto {

	private String hotelName;
	private String hotelNumber;
	private int    hotelRateing;
	private String hotelLocation;
	private List<RoomDto> rooms;
	
	public String getHotelName() {
		return hotelName;
	}
	public HotelDto setHotelName(String hotelName) {
		this.hotelName = hotelName;
		return this;
	}
	public String getHotelNumber() {
		return hotelNumber;
	}
	public HotelDto setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
		return this;
	}
	public int getHotelRateing() {
		return hotelRateing;
	}
	public HotelDto setHotelRateing(int hotelRateing) {
		this.hotelRateing = hotelRateing;
		return this;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public HotelDto setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
		return this;
	}
	public List<RoomDto> getRooms() {
		return rooms;
	}
	public HotelDto setRooms(List<RoomDto> rooms) {
		this.rooms = rooms;
		return this;
	}
	
	
	
	
	
}
