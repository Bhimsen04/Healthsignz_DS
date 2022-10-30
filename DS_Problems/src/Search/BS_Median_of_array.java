package Search;

import java.util.Arrays;
import java.util.List;

public class BS_Median_of_array {

	// https://www.interviewbit.com/problems/median-of-array/
	public static void main(String[] args) {
		double d = findMedianSortedArrays(Arrays.asList(1, 14, 15), Arrays.asList(2, 3));
		System.out.println(d);
	}

	private static double findMedianSortedArrays(List<Integer> l1, List<Integer> l2) {
		// we need l1 as a smaller and l2 as a bigger
		if (l2.size() < l1.size())
			return findMedianSortedArrays(l2, l1);
		int l1Size = l1.size(), l2Size = l2.size();
		int l = 0, h = l1Size;
		while (l <= h) {
			int partitionX = (l + h) / 2;
			int partitionY = (l1Size + l2Size + 1) / 2 - partitionX;

			int leftMaxX = partitionX == 0 ? Integer.MIN_VALUE : l1.get(partitionX - 1);
			int leftMaxY = partitionY == 0 ? Integer.MIN_VALUE : l2.get(partitionY - 1);

			int rightMinX = partitionX == l1Size ? Integer.MAX_VALUE : l1.get(partitionX);
			int rightMinY = partitionY == l2Size ? Integer.MAX_VALUE : l2.get(partitionY);

			if (leftMaxX <= rightMinY && leftMaxY <= rightMinX) {
				if ((l1Size + l2Size & 1) == 0)  // for even no. of elements
					return (Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY)) / 2.0;
				else
					return Math.max(leftMaxX, leftMaxY);
			} else if (leftMaxX > rightMinY)
				h = partitionX - 1;
			else
				l = partitionX + 1;
		}
		return -1;
	}
}
