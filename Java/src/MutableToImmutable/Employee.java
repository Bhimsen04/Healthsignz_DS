package MutableToImmutable;

final class Employee {

	private final String empName;
	private final int age;
	private final Address address;

	public Employee(String empName, int age, Address address) {
		this.empName = empName;
		this.age = age;
		this.address = address;
	}

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	// public Address getAddress() {
	// return address;
	// }

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

}
