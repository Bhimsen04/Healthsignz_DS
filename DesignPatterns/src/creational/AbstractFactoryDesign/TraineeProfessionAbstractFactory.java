package creational.AbstractFactoryDesign;

public class TraineeProfessionAbstractFactory extends AbstractFactory {

	public Profession getProfession(String typeOfProfession) {

		if (typeOfProfession == null)
			return null;
		else if (typeOfProfession.equalsIgnoreCase("teacher"))
			return new TraineeTeacher();
		else if (typeOfProfession.equalsIgnoreCase("engineer"))
			return new TraineeEngineer();

		return null;

	}
}
