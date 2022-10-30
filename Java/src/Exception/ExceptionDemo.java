package Exception;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExceptionDemo {

	public static void show() {
		try (FileReader file = new FileReader("file.txt"); InputStream input = new FileInputStream("abc.txt")) {
			new SimpleDateFormat().parse("");
			System.out.println("Hello");
		} catch (IOException | ParseException e) {
			System.out.println("Hi");
		}
		System.out.println("India");
	}

	public static void main(String args[]) {
		// Instantiating an ArrayList object
		ArrayList<String> list = new ArrayList<String>();
		// populating the ArrayList
		list.add("apples");
		list.add("mangoes");
		list.add("banana");

		Map<Integer,Integer> map = new HashMap<>();
		
		// Getting the Iterator object of the ArrayList
		Iterator<String> it = list.iterator();
		System.out.println(list);
		// Removing the element without moving to first position
		if (it.hasNext()) {
			String m = it.next();
			System.out.println(m);
			it.remove();
		}
		System.out.println(list);
		// show();
	}

}
