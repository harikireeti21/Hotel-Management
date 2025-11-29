package com.example.hotel.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.entitys.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
}
