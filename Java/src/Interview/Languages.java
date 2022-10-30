package Interview;

enum Languages {
	Python(10 - 10 + 10 * 10), Java(9 + 9 * 9 - 9), Angular(12 * 12 - 12 - 12);
	private int coders;

	Languages(int p) {
		coders = p;
	}

	int getCoders() {
		return coders;
	}
}
