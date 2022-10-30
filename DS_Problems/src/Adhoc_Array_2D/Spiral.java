package Adhoc_Array_2D;

import java.util.ArrayList;
import java.util.List;

public class Spiral {

	// https://leetcode.com/problems/spiral-matrix/submissions/
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 7, 9, 12, 15 }, { 4, 5, 9, 10, 14, 25 }, { 9, 14, 18, 31, 34, 38 },
				{ 12, 19, 45, 48, 50, 52 }, { 20, 31, 63, 81, 95, 100 } };
		List<Integer> list = spiralOrder(matrix);
		System.out.println(list);

	}

	static public void gm() {

	}
	
	public static void gm1() {

	}

	private static List<Integer> spiralOrder(int[][] matrix) {
		int temp = 0, count = 0, ROWS = matrix.length, COLUMNS = matrix[0].length;
		int TLI = 0; // topLeftIndex
		int TRI = COLUMNS - 1; // topRightIndex
		int BI = ROWS - 1; // bottomIndex
		List<Integer> list = new ArrayList<Integer>();
		while (TLI <= TRI) {
			temp = TLI;
			while (temp <= TRI && count++ < ROWS * COLUMNS)
				list.add(matrix[TLI][temp++]);
			temp = TLI + 1;

			while (temp <= BI && count++ < ROWS * COLUMNS)
				list.add(matrix[temp++][TRI]);
			temp = TRI - 1;

			while (temp >= TLI && count++ < ROWS * COLUMNS)
				list.add(matrix[BI][temp--]);
			temp = BI - 1;

			while (temp > TLI && count++ < ROWS * COLUMNS)
				list.add(matrix[temp--][TLI]);

			TLI++;
			TRI--;
			BI--;
		}
		return list;
	}
}
