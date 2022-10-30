package ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<>();
		al.add("a");
		al.add("b");
		al.add("c");

		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		System.out.println(al);

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		map.put(1, 1);
		map.put(2, 4);
		map.put(3, 8);

		Set<Integer> s = map.keySet();
		Iterator<Integer> itr = s.iterator();
		System.out.println(map);

		while (itr.hasNext()) {
			itr.next();
			map.putIfAbsent(21, 8);
		}
		System.out.println(map);

	}
}
