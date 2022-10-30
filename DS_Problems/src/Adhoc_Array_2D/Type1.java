package Adhoc_Array_2D;

public class Type1 {
	public static void main(String[] args) {
		int[][] arr = { 
				{ 1, 3, 7, 9, 12, 15 }, 
				{ 4, 5, 9, 10, 14, 25 }, 
				{ 9, 14, 18, 31, 34, 38 }, 
				{ 12, 19, 45, 48, 50, 52 },
				{ 20, 31, 63, 81, 95, 100 } };
		System.out.println(searchKey(arr , 101));
		
	}

	private static boolean searchKey(int[][] arr,int key) {
		int ROWS = arr.length;
		int COLUMNS = arr[0].length;
		int topRight = arr[0][COLUMNS - 1] ,n = 0 , m = COLUMNS - 1;
		while (true) {
			if(key == topRight)
				return true;
			else if(key > topRight) {
				if(n == ROWS-1) break;
				topRight = arr[++n][m];
			}
			else {
				if(m == 0) break;
				topRight = arr[n][--m];
			}
		}
		return false;
	}
}
