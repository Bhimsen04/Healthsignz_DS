package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the noOfVertexes !!!!!!!");
		int noOfVertexes = sc.nextInt();
		System.out.println("Enter the noOfEdges !!!!!!!");
		int noOfEdges = sc.nextInt();
		bfsTraverse(noOfVertexes, AdjacencyList.createAdjList(noOfEdges));
		sc.close();

		// 5 4
		// 6 1
		// 1 11
		// 8 12
		// 9 3
		// 7 4
		// 5 10
		// 3 8
		// 1 4
		// 2 5
	}

	public static void bfsTraverse(int noOfVertexes, Map<Integer, HashSet<Integer>> adjList) {
		boolean[] visitedArr = new boolean[noOfVertexes + 1];
		for (int i = 1; i <= noOfVertexes; i++) {
			if (!visitedArr[i]) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.offer(i);
				queue.offer(-1);
				while (!queue.isEmpty()) {
					int u = queue.poll();
					if (queue.isEmpty()) {
						System.out.println();
						break;
					} else if (u == -1) {
						System.out.println();
						queue.offer(-1);
						continue;
					}
					visitedArr[u] = true;
					System.out.print(u + " ");
					HashSet<Integer> set = adjList.get(u);
					if (set != null)
						for (int v : set) {
							if (!visitedArr[v])
								queue.offer(v);
						}
				}
			}
		}
	}
}
