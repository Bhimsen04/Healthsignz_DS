package MutableToImmutable;

public class MainClass {
	public static void main(String[] args) throws Exception {
		Employee emp = new Employee("Adithya", 34, new Address("Home", "Madhapur", "Hyderabad"));
		Address address = emp.getAddress();
		System.out.println(address);
		address.setAddress("Hi-tech City");
		address.setAddressType("Office");
		address.setCity("Hyderabad");
		System.out.println(emp.getAddress());

		Address address2 = new Address("Home", "Madhapur", "Hyderabad");
		Address address3 = (Address) address2.clone();
		address3.setAddress("Hi-tech City");
		address3.setAddressType("Office");
		address3.setCity("Hyderabad");
		System.out.println(address2);
		System.out.println(address3);

	}
}
