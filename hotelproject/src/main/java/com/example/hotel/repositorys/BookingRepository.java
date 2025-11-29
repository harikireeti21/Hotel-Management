package com.example.hotel.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.entitys.BookingEntity;
import com.example.hotel.entitys.UserEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>  {

	List<BookingEntity> findByUser(UserEntity user);

}
