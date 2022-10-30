package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Y extends X {

	int y = 100;

	public static void main(String[] args) {

		TreeSet t5 = new TreeSet();
		t5.add(null);
		System.out.println(t5);

		String a = "10";
		String b = a;
		a = "30";
		System.out.println(a + " , " + b);

		// try {
		// Calendar.getInstance();
		// X x1 = new Y();
		// Y y = (Y) x1;
		// X x = new Y();
		// System.out.println(y.x + " , " + y.y);
		// System.out.println(x.x);
		// } finally {
		//
		// }

		String st = "java";
		int i = st.codePointAt(1);
		System.out.println(i);

		HashMap<Integer, Integer> t = new HashMap<>();
		t.put(5, 2);
		t.put(2, 53);
		t.put(15, 33);
		System.out.println(t);

		Set s = new HashSet<>();
		s.add(1);
		s.add(2);
		Iterator<Set> s1 = s.iterator();
		System.out.println(s);
		while (s1.hasNext()) {
			s1.next();
		}
		System.out.println(s);

		Queue<X> q = new LinkedList<X>();
		q.add(null);
		q.add(null);
		q.add(new X());
		System.out.println(q);

		Queue<X> q1 = new PriorityQueue<X>();
		// q1.add(null);
		// q1.add(null);
		q1.add(new X());
		q1.add(new X());
		System.out.println(q1.peek());
		// while (!q1.isEmpty()) {
		// System.out.println(q1.poll());
		// }

		ArrayList list = new ArrayList<>();
		System.out.println(list.size());
		list.add(true);
		list.add(1);
		list.add("BHimsen");
		list.add(3, 2);
		System.out.println(list);
		ArrayList list2 = new ArrayList<>(list);
		System.out.println(list.size());

	}
}
