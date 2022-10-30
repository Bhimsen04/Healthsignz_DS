package java_practice;

import java.util.ArrayList;

public class System_arraycopy {

	public static void main(String[] args) {
				
		// System.arraycopy(a, 0, temp, 0, a.length);
		int[] a = new int[5];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		System.out.println("A length :- " + a.length);

		int[] temp = new int[a.length * 2];
		System.arraycopy(a, 1, temp, 0, a.length - 1);

		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		System.out.println(temp[3]);

		a = temp;
		System.out.println("A length :- " + a.length);
	}

}
