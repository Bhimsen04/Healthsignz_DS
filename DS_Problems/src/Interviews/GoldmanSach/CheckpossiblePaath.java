package Interviews.GoldmanSach;

public class CheckpossiblePaath {
	static boolean isPath(int arr[][]) {

		return isPath(arr, 0, 0);
	}

	private static boolean isPath(int[][] arr, int rows, int columns) {
		if (rows == arr.length - 1 && columns == arr[0].length - 1 && arr[arr.length - 1][arr[0].length - 1] == 1)
			return true;
		if ((rows >= arr.length || columns >= arr[0].length - 1 || arr[rows][columns + 1] == 0)
				&& (rows >= arr.length - 1 || columns >= arr[0].length || arr[rows + 1][columns] == 0))
			return false;
		boolean rightFlag = false;
		if (rows >= arr.length || columns >= arr[0].length - 1 || arr[rows][columns + 1] == 1)
			rightFlag = isPath(arr, rows, columns + 1);
		boolean downFlag = false;
		if (rows >= arr.length - 1 || columns >= arr[0].length || arr[rows + 1][columns] == 1)
			downFlag = isPath(arr, rows + 1, columns);
		return rightFlag || downFlag;
	}

	// Driver code
	public static void main(String[] args) {

		// Given array
		int arr[][] = { 
				{ 0, 1, 1, 1, 0 }, 
				{ 1, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 1, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 0, 0, 1, 0, 1 } };
		if (isPath(arr))
			System.out.println("Yes");
		else
			System.out.println("No");
	
	}

}
