package Interviews.Porter;

public class FindLastIndex {
//	Find the last index of given element in sortedArray

//	int findLastIndex(int arr[], int k )

//	 1 2 2 3 3 3 4 5 

	public int findLastIndex(int arr[], int k) {
		if (arr == null)
			return -1;
		int startingIndex = 0, endingIndex = arr.length - 1;
		int lastIndex = -1;
		while (startingIndex <= endingIndex) {
			int middleIndex = (startingIndex + endingIndex) / 2;
			if (arr[middleIndex] <= k) {
				if (arr[middleIndex] == k)
					lastIndex = middleIndex;
				startingIndex = middleIndex + 1;
			} else
				endingIndex = middleIndex - 1;
		}
		return lastIndex;
	}

}
