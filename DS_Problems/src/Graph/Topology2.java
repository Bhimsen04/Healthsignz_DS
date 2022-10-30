package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Topology2 {

	// https://leetcode.com/problems/course-schedule-ii/
	public static void main(String[] args) {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(new Topology2().findOrder(4, prerequisites)));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		boolean[] visitedArr = new boolean[numCourses];
		boolean[] recursiveStk = new boolean[numCourses];
		int[] ansA = new int[numCourses];
		Stack<Integer> ans = new Stack<>();

		HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
		for (int i = 0; i < numCourses; i++)
			adjacencyList.put(i, new ArrayList<>());
		for (int i = 0; i < prerequisites.length; i++)
			adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);

		for (int i = 0; i < numCourses; i++) {
			if (!visitedArr[i])
				if (isCyclic(i, adjacencyList, recursiveStk, visitedArr))
					return new int[0];
		}
		visitedArr = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (!visitedArr[i])
				dfs(i, adjacencyList, visitedArr, ans);
		}

		int j = 0;
		while (!ans.isEmpty())
			ansA[j++] = ans.pop();
		return ansA;
	}

	public boolean isCyclic(int s, HashMap<Integer, ArrayList<Integer>> adjacencyList, boolean[] recursiveStk,
			boolean[] visitedArr) {

		if (recursiveStk[s])
			return true;
		if (visitedArr[s])
			return false;
		visitedArr[s] = true;
		recursiveStk[s] = true;
		for (int v : adjacencyList.get(s))
			if (isCyclic(v, adjacencyList, recursiveStk, visitedArr))
				return true;
		return recursiveStk[s] = false;
	}

	public void dfs(int u, HashMap<Integer, ArrayList<Integer>> adjacencyList, boolean[] visitedArr,
			Stack<Integer> ans) {
		if (visitedArr[u])
			return;
		visitedArr[u] = true;
		for (int v : adjacencyList.get(u))
			dfs(v, adjacencyList, visitedArr, ans);
		ans.push(u);
	}

}
