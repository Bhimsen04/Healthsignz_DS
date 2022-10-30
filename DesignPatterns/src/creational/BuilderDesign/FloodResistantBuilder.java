package creational.BuilderDesign;

public class FloodResistantBuilder implements Builder {

	private Home floodResistantHome = new Home();

	@Override
	public void buildFloor() {
		this.floodResistantHome.floor = "10 feet Above ground level floor";
	}

	@Override
	public void buildWalls() {
		this.floodResistantHome.floor = "water resistant walls";
	}

	@Override
	public void buildTerrace() {
		this.floodResistantHome.floor = "Wooden leakage resistant terrace";
	}

	@Override
	public Home getComplexHomeObject() {
		return this.floodResistantHome;
	}

}
