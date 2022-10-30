package Tries;

import java.util.Scanner;

public class Contacts {

	// https://www.hackerrank.com/challenges/ctci-contacts/problem
	Tries root = new Tries(1);

	class Tries {
		int count;
		Tries[] children;

		public Tries(int count) {
			this.count = count;
			children = new Tries[26];
		}
	}

	private void insertContacts(String contact) {
		Tries temp = root;
		char[] ch = contact.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			int index = ch[i] - 'a';
			if (temp.children[index] == null)
				temp.children[index] = new Tries(1);
			else
				temp.children[index].count += 1;
			temp = temp.children[index];
		}
	}

	public int findContacts(String contact) {
		int res = 0;
		Tries temp = root;
		char[] ch = contact.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			int index = ch[i] - 'a';
			if (temp.children[index] == null)
				return 0;
			else
				res = temp.children[index].count;
			temp = temp.children[index];
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		Contacts contacts = new Contacts();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int nItr = 0; nItr < n; nItr++) {
			String[] opContact = scanner.nextLine().split(" ");

			String op = opContact[0];

			String contact = opContact[1];
			if (!op.equals("add"))
				System.out.println(contacts.findContacts(contact));
			else
				contacts.insertContacts(contact);

		}
		scanner.close();
	}
}
