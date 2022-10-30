package Hashing;

import java.util.Arrays;

class MyHashMap {

	public static void main(String[] args) {
		MyHashMap m = new MyHashMap();
		m.put(0, 50);
		m.put(1, 51);
		m.put(2, 55);
		m.remove(2);
		m.put(3, 53);

		System.out.println(m.get(2));
	}

	// https://leetcode.com/problems/design-hashmap/
	int[] keys, values;
	int N;

	public MyHashMap() {
		N = 100000;
		keys = new int[N];
		values = new int[N];
		Arrays.fill(keys, -1);
		Arrays.fill(values, -1);
	}

	public int hash(int key) {
		int i = 0;
		while (keys[(i * i) % N] != -1 && keys[(i * i) % N] != key)
			i++;
		return (i * i) % N;
	}

	public void put(int key, int value) {
		int index = hash(key);
		keys[index] = key;
		values[index] = value;
	}

	public int get(int key) {
		int index = hash(key);
		return values[index];
	}

	public void remove(int key) {
		int index = hash(key);
		values[index] = -1;
	}
}
