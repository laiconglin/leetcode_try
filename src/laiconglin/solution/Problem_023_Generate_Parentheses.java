package laiconglin.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem_023_Generate_Parentheses {

	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if(n == 0) {
			res.add("");
			return res;
		} else if(n == 1) {
			res.add("()");
			return res;
		} else if(n == 2) {
			res.add("(())");
			res.add("()()");
			Collections.sort(res);
			return res;
		} 
		/*
		 else if(n == 3) {
			res.add("((()))");
			res.add("(()())");
			res.add("(())()");
			res.add("()(())");
			res.add("()()()");
			return res;
		} 
		*/
		else {
			ArrayList<String> tmpChild = generateParenthesis(n - 1);
			HashSet<String> childSet = new HashSet<String>();
			for (String child : tmpChild) {
				int pos = 0;

				while(pos < child.length()) {
					String tmpStrLeft = child.substring(0, pos);
					String tmpStrRight = child.substring(pos);
					String tmp4 = tmpStrLeft + "()" + tmpStrRight;
					if(childSet.contains(tmp4) == false) {
						res.add(tmp4);
						childSet.add(tmp4);
					}
					pos++;
				}
				
			}
			Collections.sort(res);
			return res;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
