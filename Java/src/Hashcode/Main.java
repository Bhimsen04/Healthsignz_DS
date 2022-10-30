package Hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Map<Employee, Integer> map = new HashMap<>();

		Employee e1 = new Employee();
		e1.empId = 1;
		e1.empName = "A";
		e1.salary = 10000;

		Employee e2 = new Employee();
		e2.empId = 2;
		e2.empName = "B";
		e2.salary = 15000;

		Employee e3 = new Employee();
		e3.empId = 1;
		e3.empName = "A";
		e3.salary = 12000;

		map.put(e1, 1);
		map.put(e2, 1);
		map.put(e3, 1);

		System.out.println("Map size :- " + map.size());

		Set<Employee> s = new HashSet<>();
		s.add(e1);
		s.add(e2);
		s.add(e3);

		System.out.println("Set size :- " + s.size());

		
		// Hashcode and equals is not applicable for list
		List<Employee> l = new ArrayList<>();
		l.add(e1);
		l.add(e2);
		l.add(e3);
		
		//Collections.sort(l);
		System.out.println("List size :- " + l.size());
	}
}
