package practice;

import java.util.HashSet;
import java.util.Set;

public class HashCodeAndEquals {

	public static void main(String[] args) {

		Pen p1 = new Pen(10, "blue");
		Pen p2 = new Pen(10, "blue");
		Pen p3 = new Pen(10, "elub");

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());

		System.out.println(p1.equals(p2));

		Set<Pen> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);

		System.out.println(set);
	}
}

class Pen {
	int price;
	String color;

	public Pen(int price, String color) {
		super();
		this.price = price;
		this.color = color;
	}

	@Override
	public int hashCode() {
		return this.price + this.color.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Pen pen = (Pen) obj;
		return this.price == pen.price && this.color.equals(pen.color);
	}

}
