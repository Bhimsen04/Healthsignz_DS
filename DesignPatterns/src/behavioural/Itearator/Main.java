package behavioural.Itearator;

public class Main {

	public static void main(String[] args) {
		BrowseHistory history = new BrowseHistory();
		history.push("a");
		history.push("b");
		history.push("c");

		Iterator itr = history.createIterator();
		while (itr.hasNext()) {
			String s = itr.current();
			System.out.println(s);
			itr.next();
		}
	}

}
