package hashcode_equals;

import java.util.HashMap;
import java.util.Map;

public class Employee_Main {
	public static void main(String[] args) {

		// creating two Objects with
		// same state
		Employee emp1 = new Employee(1, "aditya");
		Employee emp2 = new Employee(1, "aditya");

		Map<Employee, String> map = new HashMap<Employee, String>();
		map.put(emp1, "CSE");
		map.put(emp2, "IT");

		for (Employee geek : map.keySet()) {
			System.out.println(map.get(geek).toString());
		}

	}
}
