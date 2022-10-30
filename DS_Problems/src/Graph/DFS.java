package Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class DFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the noOfVertexes !!!!!!!");
		int noOfVertexes = sc.nextInt();
		System.out.println("Enter the noOfEdges !!!!!!!");
		int noOfEdges = sc.nextInt();
		boolean[] visitedArr = new boolean[noOfVertexes + 1];
		DFS dfs = new DFS();
		Map<Integer, HashSet<Integer>> adjList = AdjacencyList.createAdjList(noOfEdges);
		for (int u = 1; u <= noOfVertexes; u++)
			if (!visitedArr[u])
				dfs.dfsTraverse(u, visitedArr, adjList);

		sc.close();
	}

	private void dfsTraverse(int u, boolean[] visitedArr, Map<Integer, HashSet<Integer>> adjList) {
		if (!visitedArr[u]) {
			visitedArr[u] = true;
			System.out.print(u + "->");
			HashSet<Integer> set = adjList.get(u);
			for (int v : set)
				if (!visitedArr[v])
					dfsTraverse(v, visitedArr, adjList);
		}
	}
}
