package Comparable;

public class Employee implements Comparable<Employee> {
	int empId;
	String empName;
	double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {

		
		// Ist way
		// return new Integer(o.empId).compareTo(new Integer(this.empId));
		
		// IInd way
		return o.empId - this.empId;
		
		// IIIrd way
		// if (this.empId == o.empId)
		// return 0;
		// else if (this.empId < o.empId)
		// return 1;
		// else
		// return -1;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

}
