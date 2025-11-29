package com.example.hotel.entitys;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int roomNumber;
    private String roomType;
    private String roomStatus;
    private int roomPricae;
    private int roomNoOfGuest;

    @ManyToOne
    @JoinColumn(name = "hotel")
    private HotelEntity hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<BookingEntity> bookings;
}
