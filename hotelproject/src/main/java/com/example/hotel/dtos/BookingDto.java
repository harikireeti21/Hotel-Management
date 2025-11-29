package com.example.hotel.dtos;

import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookingDto {

	private Long booking_id;
    private Long hotel_id;
    private String roomType;
    private LocalDate fdate;
    private LocalDate edate;
}
