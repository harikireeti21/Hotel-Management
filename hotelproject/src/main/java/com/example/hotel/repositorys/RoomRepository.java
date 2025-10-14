package com.example.hotel.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.entitys.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

}
