package creational.AbstractFactoryDesign;

public class ProfessionAbstractFactory extends AbstractFactory {
	
	public Profession getProfession(String typeOfProfession) {
		if (typeOfProfession == null)
			return null;
		else if (typeOfProfession.equalsIgnoreCase("teacher"))
			return new Teacher();
		else if (typeOfProfession.equalsIgnoreCase("engineer"))
			return new Engineer();

		return null;

	}
}
