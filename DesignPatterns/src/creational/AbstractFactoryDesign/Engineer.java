package creational.AbstractFactoryDesign;

import creational.AbstractFactoryDesign.Profession;

public class Engineer implements Profession {

	@Override
	public void print() {
		System.out.println("In print of Engineer class");
	}

}
