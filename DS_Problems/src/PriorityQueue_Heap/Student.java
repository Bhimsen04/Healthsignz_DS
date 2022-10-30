package PriorityQueue_Heap;

public class Student {
	private int priority;
	private String name;
	private double cgpa;

	public Student(String name, double cgpa, int priority) {
		this.priority = priority;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getPriority() {
		return priority;
	}

	public String getName() {
		return name;
	}

	public double getCGPA() {
		return cgpa;
	}
	
}
