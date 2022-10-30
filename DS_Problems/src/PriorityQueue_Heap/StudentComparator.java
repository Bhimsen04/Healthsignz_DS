package PriorityQueue_Heap;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	public int compare(Student s1, Student s2) {
		if (s1.getCGPA() == s2.getCGPA() && s1.getName().equals(s2.getName()))
			return Integer.valueOf(s1.getPriority()).compareTo(Integer.valueOf(s2.getPriority()));
		else if (s1.getCGPA() == s2.getCGPA())
			return s1.getName().compareTo(s2.getName());
		return Double.valueOf(s2.getCGPA()).compareTo(Double.valueOf(s1.getCGPA()));
	}
}