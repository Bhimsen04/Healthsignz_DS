package Interview;

class AccoutantFirm implements Company {

	int[] income;

	public AccoutantFirm(int n) {
		income = new int[n];
	}

	public void assignSalaries(int[] salaries) {
		for (int i = 0; i < salaries.length; i++)
			income[i] = salaries[i];
		System.out.println("Income of accoutants credited");
	}

	public void averageSalary() {
		double sum = Double.MAX_VALUE;
		for (int i = 0; i < income.length; i++)
			sum += income[i];

		System.out.println("Average salary of accoutants is " + sum / income.length);
	}

	public void maxSalary() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < income.length; i++)
			if (income[i] > max)
				max = income[i];
		System.out.println("Maximum salary amongest accoutants is " + max);

	}

	public void minSalary() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < income.length; i++)
			if (income[i] < min)
				min = income[i];
		System.out.println("Minimum salary amongest accoutants is " + min);

	}
}
