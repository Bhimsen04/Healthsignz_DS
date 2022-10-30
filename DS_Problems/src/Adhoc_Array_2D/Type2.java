package Adhoc_Array_2D;

public class Type2 {

	public static void main(String[] args) {
		int[][] arr = { 
				{ -70 , -35, -11, -9, -8, -4 }, 
				{ 0, 1, 3, 4, 6, 10 }, 
				{ 12, 14, 18, 19, 21, 22 }, 
				{ 30, 33, 38, 39, 40, 45 },
				{ 48, 50, 56, 61, 63, 71 } };
		System.out.println(searchKey(arr , 19));
		
	}

	private static boolean searchKey(int[][] arr,int key) {
		int ROWS = arr.length;
		int COLUMNS = arr[0].length;
		int low = 0 , high = ROWS - 1 , mid = 0 , m = -1;
		if(key < arr[0][0] || key > arr[ROWS-1][COLUMNS-1])
			return false;
		while(low <= high) {
			mid = (low + high) /2;
			if(key <= arr[mid][0]) {
				if(key == arr[mid][0]) 
					return true;
				else if(key < arr[mid][0])
					m = mid - 1;
				high = mid - 1;	
			}else {
				low = mid + 1;
				if(low > high && m == -1 )
					m = ROWS-1;
			}
			
		}
		low = 0 ; 
		high = COLUMNS - 1;
		while(low <= high) {
			mid = (low + high) /2;
			if(key == arr[m][mid])
				return true;
			else if(key < arr[m][mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

}
