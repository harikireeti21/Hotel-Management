package com.example.hotel.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.entitys.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>  {

}
