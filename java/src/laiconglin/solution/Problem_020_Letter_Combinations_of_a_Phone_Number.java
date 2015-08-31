package laiconglin.solution;

import java.util.ArrayList;

/**
 * 递归解决
 * @author lai-c
 *
 */
public class Problem_020_Letter_Combinations_of_a_Phone_Number {

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		int len = digits.length();
		if (len == 0) {
			res.add("");
			return res;
		} else {
			ArrayList<String> childRes = this.letterCombinations(digits.substring(1));
			switch (digits.charAt(0)) {
			case '0':
				this.combine2string(res, childRes, " ");
				break;
			case '1':
				break;
			case '2':
				this.combine2string(res, childRes, "a");
				this.combine2string(res, childRes, "b");
				this.combine2string(res, childRes, "c");
				break;
			case '3':
				this.combine2string(res, childRes, "d");
				this.combine2string(res, childRes, "e");
				this.combine2string(res, childRes, "f");
				break;
			case '4':
				this.combine2string(res, childRes, "g");
				this.combine2string(res, childRes, "h");
				this.combine2string(res, childRes, "i");
				break;
			case '5':
				this.combine2string(res, childRes, "j");
				this.combine2string(res, childRes, "k");
				this.combine2string(res, childRes, "l");
				break;
			case '6':
				this.combine2string(res, childRes, "m");
				this.combine2string(res, childRes, "n");
				this.combine2string(res, childRes, "o");
				break;
			case '7':
				this.combine2string(res, childRes, "p");
				this.combine2string(res, childRes, "q");
				this.combine2string(res, childRes, "r");
				this.combine2string(res, childRes, "s");
				break;
			case '8':
				this.combine2string(res, childRes, "t");
				this.combine2string(res, childRes, "u");
				this.combine2string(res, childRes, "v");
				break;
			case '9':
				this.combine2string(res, childRes, "w");
				this.combine2string(res, childRes, "x");
				this.combine2string(res, childRes, "y");
				this.combine2string(res, childRes, "z");
				break;
			default:
				break;
			}
			return res;
		}
	}
	private void combine2string(ArrayList<String> dist, ArrayList<String> src, String ch) {
		for (String s : src) {
			dist.add(ch + s);
		}
		if(src.size() == 0) {
			dist.add(ch);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "23";
		Problem_020_Letter_Combinations_of_a_Phone_Number solution = new Problem_020_Letter_Combinations_of_a_Phone_Number();
		ArrayList<String> res = solution.letterCombinations(test);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
