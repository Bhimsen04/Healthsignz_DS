package readInput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Codechef {
	public static void main(String[] args) {
		try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    int t = Integer.parseInt(br.readLine());
    	    while(t-- > 0 ){
    	        int number = Integer.parseInt(br.readLine());
    	        int result = 1;
    	        while(number > 1)
    	            result *= number--;
    	        System.out.println(result);
    	    }
	    } catch (Exception e) {
			return;
		}
	}
}
