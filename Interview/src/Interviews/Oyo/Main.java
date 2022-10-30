package Interviews.Oyo;

public class Main {

	public static void main(String[] args) {
		TimeMap m = new TimeMap();
		m.set("foo", "bar", 1);
		System.out.println(m.get("foo", 1));
		System.out.println(m.get("foo", 3));
		m.set("foo", "bar2", 4);
		System.out.println(m.get("foo", 4));
		System.out.println(m.get("foo", 5));

	}

}
