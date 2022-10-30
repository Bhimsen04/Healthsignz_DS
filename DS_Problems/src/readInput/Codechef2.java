package readInput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Codechef2 {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0 ){
		    String s = br.readLine();
		    System.out.println((s.charAt(0)-48) + (s.charAt(s.length()-1)-48));
		}
	}

}
