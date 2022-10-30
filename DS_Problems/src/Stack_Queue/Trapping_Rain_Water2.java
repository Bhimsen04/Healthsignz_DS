package Stack_Queue;

import java.util.HashMap;

public class Trapping_Rain_Water2 {

	// https://leetcode.com/problems/trapping-rain-water/
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(new Trapping_Rain_Water2().trap(height));

	}

	public int trap(int[] height) {
		int sum = 0;
		int[] NRM = FindNearestRightMax.findNearestRightMax(height);
		int[] NLM = FindNearestLeftMax.findNearestLeftMax(height);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i < height.length - 1; i++) {
			int NRM_idx = NRM[i];
			int NLM_idx = NLM[i];
			if (map.containsKey(NLM_idx) && map.get(NLM_idx) == NRM_idx)
				continue;
			int width = NRM_idx - NLM_idx - 1;
			int minimumTower = Math.min(height[NLM_idx], height[NRM_idx]);
			int h = minimumTower - height[i];
			if (width * h > 0)
				map.put(NLM_idx, NRM_idx);
			sum += width * h;
		}
		return sum;

	}
}
