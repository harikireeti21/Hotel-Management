package com.example.hotel.dtos;

//import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoomDto {
	private long roomid;
	private int roomNumber;
	private String roomType;
	private String roomStatus;
	private int roomPricae;
	private int roomNoOfGuest;

	
	
	
}
