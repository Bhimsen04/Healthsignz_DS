package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class AdjacencyList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int noOfVertexes = sc.nextInt(); // we don't need here
		int noOfEdges = sc.nextInt();
		Map<Integer, HashSet<Integer>> map = createAdjList(noOfEdges);
		sc.close();
		System.out.println(map);
	}

	public static Map<Integer, HashSet<Integer>> createAdjList(int noOfEdges) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, HashSet<Integer>> map = new HashMap<>();
		System.out.println("Enter the " + noOfEdges + " Edges!!!!!!");
		System.out.println("Enter the u and v !!!!!!!");
		for (int i = 0; i < noOfEdges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (!map.containsKey(u))
				map.put(u, new HashSet<>());
			if (!map.containsKey(v))
				map.put(v, new HashSet<>());
			map.get(u).add(v);
			map.get(v).add(u);
		}
		sc.close();
		return map;
	}
}
