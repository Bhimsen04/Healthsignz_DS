package creational.FactoryDesign;

import creational.AbstractFactoryDesign.Profession;

public class Main_Client_Class {
	public static void main(String[] args) {
		ProfessionFactory factory = new ProfessionFactory();
		Profession doc = factory.getProfession("Doctor");
		doc.print();
	}
}
