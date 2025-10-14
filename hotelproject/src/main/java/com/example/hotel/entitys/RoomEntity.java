package com.example.hotel.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int roomNumber;
	private String roomType;
	private String roomStatus;
	private int roomPricae;
	private int roomNoOfGuest;
	
	@ManyToOne()
	@JoinColumn(name = "hotel")
	private HotelEntity hotel;

	
	public HotelEntity getHotel() {
		return hotel;
	}

	public RoomEntity setHotel(HotelEntity hotel) {
		this.hotel = hotel;
		return this;
	}

	public long getId() {
		return id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public RoomEntity setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
		return this;
	}

	public String getRoomType() {
		return roomType;
	}

	public RoomEntity setRoomType(String roomType) {
		this.roomType = roomType;
		return this;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public RoomEntity setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
		return this;
	}

	public int getRoomPricae() {
		return roomPricae;
	}

	public RoomEntity setRoomPricae(int roomPricae) {
		this.roomPricae = roomPricae;
		return this;
	}

	public int getRoomNoOfGuest() {
		return roomNoOfGuest;
	}

	public RoomEntity setRoomNoOfGuest(int roomNoOfGuest) {
		this.roomNoOfGuest = roomNoOfGuest;
		return this;
	}

	
	
	
}
