package com.example.hotel.entitys;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class HotelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hotelName;
	private String hotelNumber;
	private int    hotelRateing;
	private String hotelLocation;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	private List<RoomEntity> rooms;
	
	 
	
	
	public List<RoomEntity> getRooms() {
		return rooms;
	}

	public HotelEntity setRooms(List<RoomEntity> rooms) {
		this.rooms = rooms;
		return this;
	}

	public long getId() {
		return id;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public HotelEntity setHotelName(String hotelName) {
		this.hotelName = hotelName;
		return this;
	}
	public String getHotelNumber() {
		return hotelNumber;
	}
	public HotelEntity setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
		return this;
	}
	public int getHotelRateing() {
		return hotelRateing;
	}
	public HotelEntity setHotelRateing(int hotelRateing) {
		this.hotelRateing = hotelRateing;
		return this;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public HotelEntity setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
		return this;
	}
	 
	
}
