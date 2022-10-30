package creational.FactoryDesign;

import creational.AbstractFactoryDesign.Profession;

public class Doctor implements Profession {

	@Override
	public void print() {
		System.out.println("In print of Doctor class");
	}

}