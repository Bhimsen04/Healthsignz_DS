package HotelManagementSystem;

public class RoomCharge implements BaseRoomCharge {

	Double cost;

	@Override
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		// TODO Auto-generated method stub
		this.cost = cost;
	}

}
