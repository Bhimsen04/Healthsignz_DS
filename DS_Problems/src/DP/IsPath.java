package DP;

public class IsPath {
	static boolean isPath(int arr[][]) {
		arr[0][0] = 1;
		for (int i = 1; i < 5; i++)
			if (arr[0][i] != -1)
				arr[0][i] = arr[0][i - 1];
		for (int j = 1; j < 5; j++)
			if (arr[j][0] != -1)
				arr[j][0] = arr[j - 1][0];
		for (int i = 1; i < 5; i++)
			for (int j = 1; j < 5; j++)
				if (arr[i][j] != -1)
					arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
		return (arr[5 - 1][5 - 1] == 1);
	}

	// Driver code
	public static void main(String[] args) {
		int arr[][] = { 
				{ 0, 0, 0, -1, 0 }, 
				{ -1, 0, 0, -1, -1 }, 
				{ 0, 0, 0, -1, 0 }, 
				{ -1, 0, -1, 0, -1 },
				{ 0, 0, -1, 0, 0 } };
		if (isPath(arr))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
