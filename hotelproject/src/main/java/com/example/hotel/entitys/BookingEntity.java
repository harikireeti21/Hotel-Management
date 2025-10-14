package com.example.hotel.entitys;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long hotelId;
	private Long roomId;
	private Long userId;
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}
	public BookingEntity setDate(LocalDate date) {
		this.date = date;
		return this;
	}
	public Long getId() {
		return id;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public BookingEntity setHotelId(Long hotelId) {
		this.hotelId = hotelId;
		return this;
	}
	public Long getRoomId() {
		return roomId;
	}
	public BookingEntity setRoomId(Long roomId) {
		this.roomId = roomId;
		return this;
	}
	public Long getUserId() {
		return userId;
	}
	public BookingEntity setUserId(Long userId) {
		this.userId = userId;
		return this;
	}
	
}
