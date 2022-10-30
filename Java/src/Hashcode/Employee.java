package Hashcode;

public class Employee {
	int empId;
	String empName;
	double salary;

	@Override
	public int hashCode() {
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		return this.empId == emp.empId;
	}
}
