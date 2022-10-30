import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution2 {

	public static void main(String[] args) {
		int[] arr = { 4, 4, 4, 2, 2, 1, 3, 3, 1, 5 };
		System.out.println(Arrays.toString(group_sol(arr.length, arr)));
	}

	static int[] group_sol(int N, int[] a) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		TreeMap<Integer, TreeSet<Integer>> map2 = new TreeMap<Integer, TreeSet<Integer>>(Collections.reverseOrder());
		for (int ar : a) {
			if (!map.containsKey(ar))
				map.put(ar, 1);
			else
				map.put(ar, map.get(ar) + 1);
		}
		Set<Integer> set = map.keySet();
		for (int key : set) {
			int value = map.get(key);
			if (!map2.containsKey(value))
				map2.put(value, new TreeSet<Integer>(Collections.reverseOrder()));
			map2.get(value).add(key);
		}

		Collection<TreeSet<Integer>> cl = map2.values();
		int[] arr = new int[map.size()];
		int i = 0;
		for (TreeSet<Integer> c : cl)
			for (int k : c)
				arr[i++] = k;
		return arr;
	}
}
