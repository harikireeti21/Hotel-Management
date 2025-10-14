package com.example.hotel.dtos;

public class RoomDto {

	private int roomNumber;
	private String roomType;
	private String roomStatus;
	private int roomPricae;
	private int roomNoOfGuest;
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public RoomDto setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
		return this;
	}
	public String getRoomType() {
		return roomType;
	}
	public RoomDto setRoomType(String roomType) {
		this.roomType = roomType;
		return this;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public RoomDto setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
		return this;
	}
	public int getRoomPricae() {
		return roomPricae;
	}
	public RoomDto setRoomPricae(int roomPricae) {
		this.roomPricae = roomPricae;
		return this;
	}
	public int getRoomNoOfGuest() {
		return roomNoOfGuest;
	}
	public RoomDto setRoomNoOfGuest(int roomNoOfGuest) {
		this.roomNoOfGuest = roomNoOfGuest;
		return this;
	}
	
	
}
