package Interview;

import java.util.Stack;

public class Xmlvalidator {

	public static void main(String[] args) {
		System.out.println(validate_xml("text</a>"));
	}

	public static String validate_xml(String xml) {
		Stack<String> stk = new Stack<>();
		char[] ch = xml.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '<' && i + 1 < ch.length && ch[i + 1] == '/') {
				i = i + 2;
				String abc = "";
				while (i < ch.length && ch[i] != '>') {
					if (ch[i] == '<')
						break;
					abc += ch[i];
					i++;
				}
				if (ch[i] == '>' && abc.length() > 0) {
					if (stk.isEmpty() || !stk.peek().equals(abc))
						return "encountered closing tag without matching open tag for " + abc + " tag";
					else
						stk.pop();
				} else
					return "parse error";

			} else if (ch[i] == '<') {
				i = i + 1;
				String abc = "";
				while (i < ch.length && ch[i] != '>') {
					if (ch[i] == '<')
						break;
					abc += ch[i];
					i++;
				}
				if (ch[i] == '>' && abc.length() > 0)
					stk.push(abc);
				else
					return "parse error";

			}
		}
		if (stk.isEmpty())
			return "valid";
		else
			return "missing closing tag for " + stk.peek() + " tag";
	}

}