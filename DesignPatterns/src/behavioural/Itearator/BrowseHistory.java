package behavioural.Itearator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {

	private List<String> urls = new ArrayList<String>();
	
	public Iterator createIterator() {
		return new ListIterator(this);
	}

	public void push(String string) {
		urls.add(string);
	}

	public class ListIterator implements Iterator {

		private BrowseHistory history;
		private int index;

		public ListIterator(BrowseHistory history) {
			this.history = history;
		}

		@Override
		public boolean hasNext() {
			return index < history.urls.size();
		}

		@Override
		public String current() {
			return history.urls.get(index);
		}

		@Override
		public void next() {
			index++;

		}
	}
}
