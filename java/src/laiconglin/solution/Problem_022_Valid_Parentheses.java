package laiconglin.solution;

import java.util.Stack;

public class Problem_022_Valid_Parentheses {

	public boolean isValid(String s) {
		if ((s.length() % 2) == 1)
			return false;

		Stack<String> signStack = new Stack<String>();
		for (char ch : s.toCharArray()) {
			if (signStack.size() == 0) {
				signStack.add(String.valueOf(ch));
			} else {
				char topCh = signStack.peek().charAt(0);
				switch (ch) {
				case ')':
					if (topCh == '(') {
						signStack.pop();
					} else {
						return false;
					}

					break;
				case '}':
					if (topCh == '{') {
						signStack.pop();
					} else {
						return false;
					}

					break;
				case ']':
					if (topCh == '[') {
						signStack.pop();
					} else {
						return false;
					}
					break;
				default:
					signStack.add(String.valueOf(ch));
					break;
				}
			}
		}
		return signStack.size() == 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
