package Interviews.Porter;

import java.util.HashMap;

public class ParkingALot {

	// Design a single level parking lot with entrance and exit with a feature of
	// hourly parking fee.
	HashMap<Long, VehicleDetails> vehicleDetailsList = new HashMap<Long, VehicleDetails>();

	public void addVehicle(long vehicleId, VehicleType vehicleType) {
		VehicleDetails details = new VehicleDetails();
		details.entryTime = System.currentTimeMillis();
		details.vehicleId = vehicleId;
		details.vehicleType = vehicleType;
		vehicleDetailsList.put(vehicleId, details);
	}

	public VehicleDetails exitVehicle(long vehicleId) {
		VehicleDetails details = null;
		if (vehicleDetailsList.containsKey(vehicleId)) {
			details = vehicleDetailsList.get(vehicleId);
			details.exitTime = System.currentTimeMillis();
			long currentMile = (details.exitTime - details.entryTime) / 3600000;
			double finalPrice = currentMile * details.vehicleType.vehiclePrice;
			details.finalPrice = finalPrice;
			vehicleDetailsList.remove(vehicleId);
		}
		return details;
	}
}
