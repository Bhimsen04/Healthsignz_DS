package Interview;

public class Main {

	public static void main(String[] args) {
		EngineerFirm eng = new EngineerFirm(5);
//		int[] sal = new int[5];
//		sal[0] = 6848;
//		sal[1] = 9329;
//		sal[2] = 9984;
//		sal[3] = 5543;
//		sal[4] = 7986;
//		eng.assignSalaries(sal);
//		eng.averageSalary();

		String s = "Java@Program";
		System.out.println(s.matches(".@."));
		System.out.println(eng.result());
		for (Languages a : Languages.values()) {
			System.out.println(a + " " + a.getCoders() + " coders.");
		}
	}

}
