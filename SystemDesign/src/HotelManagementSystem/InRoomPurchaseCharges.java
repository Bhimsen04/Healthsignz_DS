package HotelManagementSystem;

public class InRoomPurchaseCharges implements BaseRoomCharge {

	Double cost;
	BaseRoomCharge baseRoomCharge;

	@Override
	public Double getCost() {
		baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
		return baseRoomCharge.getCost();
	}

	@Override
	public void setCost(Double cost) {
		
	}

}
