package hashcode_equals;

class Employee {

	int id;
	String name;

	Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Employee emp = (Employee) obj;
		return (emp.name.equals(this.name) && emp.id == this.id);
	}

	@Override
	public int hashCode() {

		// We are returning the Geek_id
		// as a hashcode value.
		// we can also return some
		// other calculated value or may
		// be memory address of the
		// Object on which it is invoked.
		// it depends on how you implement
		// hashCode() method.
		return this.id + this.name.hashCode();
	}

}