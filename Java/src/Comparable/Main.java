package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Map<Employee, Integer> map = new HashMap<>();

		Employee e1 = new Employee();
		e1.setEmpId(0);
		e1.setEmpName("A");
		e1.setSalary(10000);

		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setEmpName("B");
		e2.setSalary(20000);

		Employee e3 = new Employee();
		e3.setEmpId(1);
		e3.setEmpName("A");
		e3.setSalary(10000);

		map.put(e1, 1);
		map.put(e2, 1);
		map.put(e3, 1);
		
		TreeMap<Employee, Integer> sortedMap = new TreeMap<>();
		sortedMap.putAll(map);

		Set<Employee> s = sortedMap.keySet();

		Iterator<Employee> itr = s.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getEmpId());
		}
		System.out.println("///////////////////////////////////////////");

		List<Employee> l = new ArrayList<>();
		l.add(e1);
		l.add(e2);
		l.add(e3);
		Collections.sort(l);

		Iterator<Employee> itr1 = l.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next().getEmpId());
		}
	}
}
