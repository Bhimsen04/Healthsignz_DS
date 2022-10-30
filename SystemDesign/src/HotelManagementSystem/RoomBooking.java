package HotelManagementSystem;

import java.util.Date;
import java.util.List;

public class RoomBooking {
	String bookingId;
	Date startDate;
	Integer durationInDays;
	BookingStatus bookingStatus;
	List<Guest>  guestList;
	List<Room> roomInfo;
	BaseRoomCharge totalRoomCharges;
}
