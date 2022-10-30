package Search;

import java.util.ArrayList;

public class Painters_Partition {

	// https://www.interviewbit.com/problems/painters-partition-problem/
	public static void main(String[] args) {
		int A = 10;
		int B = 1;
		ArrayList<Integer> C = new ArrayList<>();
		C.add(1);
		C.add(8);
		C.add(11);
		C.add(3);

		// C.add(640);
		// C.add(435);
		// C.add(647);
		// C.add(352);
		// C.add(8);
		// C.add(90);
		// C.add(960);
		// C.add(329);
		// C.add(859);
		System.out.println(paint(A, B, C));
	}

	public static int paint(int painters, int unitOfTime, ArrayList<Integer> boards) {
		if (boards.size() == 1)
			return (boards.get(0) * unitOfTime) % 10000003;
		int low = 0, mid = 0, high = 0;
		for (int c : boards)
			high += c;

		while (low <= high) {
			mid = (low + high) / 2;
			if (isValid(painters, mid, boards))
				high = mid - 1;
			else
				low = mid + 1;
		}
		return (int) ((long) low * unitOfTime % 10000003);
	}

	public static boolean isValid(int painters, int sum, ArrayList<Integer> boards) {
		int i = 0, N = boards.size();
		while (i < N && painters > 0) {
			int currentSum = 0;
			while (i < N && currentSum + boards.get(i) <= sum)
				currentSum += boards.get(i++);
			painters--; // means one painter done his job
		}
		return i == N; // whether all the boards are painted or not ...if less than some job is not
						// done
	}
}
