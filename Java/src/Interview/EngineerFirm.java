package Interview;

class EngineerFirm implements Company {

	int[] income;

	private int add() {
		return 20;
	}
	
	int result() {
		return new EngineerFirm(20).add();
	}
	public EngineerFirm(int n) {
		income = new int[n];
	}

	public void assignSalaries(int[] salaries) {
		for (int i = 0; i < income.length && i < salaries.length; i++)
			income[i] = salaries[i];
		System.out.println("Income of engineers credited");
	}

	public void averageSalary() {
		double sum = 0;
		for (int i = 0; i < income.length; i++)
			sum += income[i];

		System.out.println("Average salary of engineers is " + String.format("%.2f", sum / income.length));
	}

	public void maxSalary() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < income.length; i++)
			if (income[i] > max)
				max = income[i];
		System.out.println("Maximum salary amongest engineers is " + max);

	}

	public void minSalary() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < income.length; i++)
			if (income[i] < min)
				min = income[i];
		System.out.println("Minimum salary amongest engineers is " + min);

	}
}
