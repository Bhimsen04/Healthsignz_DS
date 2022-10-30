package creational.AbstractFactoryDesign;

public class Main_Client {

	public static void main(String[] args) {
		AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession(true);

		Profession engg = abstractFactory.getProfession("engineer");
		engg.print();

	}

}
