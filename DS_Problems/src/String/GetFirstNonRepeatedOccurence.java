package String;

public class GetFirstNonRepeatedOccurence {

	// https://leetcode.com/problems/first-unique-character-in-a-string/
	
	final int NO_OF_CHARS = 26;
	char count[] = new char[NO_OF_CHARS];

	void getCharCountArray(String str) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i) - 97]++;
	}

	int firstUniqChar(String str) {
		getCharCountArray(str);
		int index = -1, i;
		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i) - 97] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Driver method
	public static void main(String[] args) {
		String str = "loveleetcode";
		GetFirstNonRepeatedOccurence g = new GetFirstNonRepeatedOccurence();
		int index = g.firstUniqChar(str);

		System.out.println(str.charAt(index));
	}
}
