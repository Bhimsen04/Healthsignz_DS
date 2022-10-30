package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Topology {

	// https://leetcode.com/problems/course-schedule-ii/
	public static void main(String[] args) {
		
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] ans = new int[numCourses];

		int t = 0;
		int[] inDegree = new int[numCourses];

		HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
		for (int i = 0; i < numCourses; i++)
			adjacencyList.put(i, new ArrayList<>());

		for (int i = 0; i < prerequisites.length; i++) {
			adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
			inDegree[prerequisites[i][0]]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < numCourses; i++)
			if (inDegree[i] == 0)
				q.add(i);

		while (!q.isEmpty()) {
			int ele = q.poll();
			ans[t++] = ele;
			for (int connected : adjacencyList.get(ele)) {
				inDegree[connected]--;
				if (inDegree[connected] == 0)
					q.offer(connected);
			}
		}

		if (t != numCourses)
			return new int[0];

		return ans;
	}
}
