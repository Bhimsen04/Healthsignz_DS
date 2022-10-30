package creational.FactoryDesign;

import creational.AbstractFactoryDesign.Profession;
import creational.AbstractFactoryDesign.Teacher;

public class ProfessionFactory {

	public Profession getProfession(String typeOfProfession) {
		if (typeOfProfession == null)
			return null;
		if (typeOfProfession.equalsIgnoreCase("doctor"))
			return new Doctor();
		else if (typeOfProfession.equalsIgnoreCase("teacher"))
			return new Teacher();
		else if (typeOfProfession.equalsIgnoreCase("enginner"))
			return new Engineer();

		return null;

	}
}
