package creational.BuilderDesign;

public class Main_Client {

	public static void main(String[] args) {

		// Create Object of required homebuilder
		EarthQuakeResistantBuilder earthQuakeResistantBuilder = new EarthQuakeResistantBuilder();

		// Create Object of director that will keep an eye on your builder
		Director director = new Director(earthQuakeResistantBuilder);

		director.manageRequiredHomeConstruction();
		Home homeConstructedAtTheEnd = director.getComplexObjectOfHome();

		System.out.println(homeConstructedAtTheEnd);
		System.out.println(homeConstructedAtTheEnd.floor);
	}
}
