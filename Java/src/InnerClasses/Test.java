package InnerClasses;

public class Test {

	public static void main(String[] args) {

		// Anonymus inner class
		PopCorn p = new PopCorn() {
			public void taste() {
				System.out.println("Spicy");
			}
		};

		p.taste();

		PopCorn p2 = new PopCorn();
		p2.taste();
		PopCorn p3 = new SubPopcorn();
		p3.taste();

		PopCorn p4 = new PopCorn() {
			public void taste() {
				System.out.println("Sweety");
			}
		};
		p4.taste();

	}
}
