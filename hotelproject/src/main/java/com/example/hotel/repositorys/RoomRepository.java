package com.example.hotel.repositorys;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.entitys.HotelEntity;
import com.example.hotel.entitys.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    // fetch all rooms of a hotel
    List<RoomEntity> findByHotel(HotelEntity hotel);

    // optional: fetch by type and status
    List<RoomEntity> findByHotelAndRoomTypeIgnoreCaseAndRoomStatusIgnoreCase(
            HotelEntity hotel, String roomType, String roomStatus);
}
