package com.example.hotel.dtos;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HotelDto {
    private Long id;
    private String hotelName;
    private String hotelNumber;
    private int hotelRateing;
    private String hotelLocation;
    private List<RoomDto> rooms;
}
