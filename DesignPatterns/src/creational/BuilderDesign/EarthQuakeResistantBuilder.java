package creational.BuilderDesign;

public class EarthQuakeResistantBuilder implements Builder {

	private Home earthQuakeResistantHome = new Home();

	@Override
	public void buildFloor() {
		this.earthQuakeResistantHome.floor = "Wooden floor";
	}

	@Override
	public void buildWalls() {
		this.earthQuakeResistantHome.floor = "Wooden walls";
	}

	@Override
	public void buildTerrace() {
		this.earthQuakeResistantHome.floor = "Wooden terrace";
	}

	@Override
	public Home getComplexHomeObject() {
		return this.earthQuakeResistantHome;
	}

}
