package PriorityQueue_Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

	public List<Student> getStudents(List<String> events) {
		List<Student> s1 = new ArrayList<Student>();
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudentComparator());
		for (String event : events) {
			String[] arr = event.split(" ");
			if (arr[0].equals("ENTER"))
				pq.add(new Student(arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3])));
			else
				pq.poll();
		}
		while (!pq.isEmpty())
			s1.add(pq.poll());
		return s1;
	}
}
