package laiconglin.solution;

import java.util.Stack;

public class Problem_033_Longest_Valid_Parentheses {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		char cur = '\0';
		int[] parenthesis = new int[len];
		for (int i = 0; i < len; i++) {
			cur = s.charAt(i);
			switch (cur) {
			case '(':
				stack.add(i);
				break;
			case ')':
				if (!stack.isEmpty()) {
					if (s.charAt(stack.peek()) == '(') {
						parenthesis[stack.peek()] = 1;
						parenthesis[i] = 1;
						stack.pop();
					}
				} else {
					stack.add(i);
				}
			default:
				break;
			}
		}
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < len; i++) {
			if (parenthesis[i] == 1) {
				count++;
				if (count > maxCount) {
					maxCount = count;
				}
			} else {
				count = 0;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "()";
		Problem_033_Longest_Valid_Parentheses solution = new Problem_033_Longest_Valid_Parentheses();
		System.out.println(solution.longestValidParentheses(test));
	}

}
