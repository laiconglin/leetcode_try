package laiconglin.solution;

public class Problem_011_regular_expression_matching {

	//边界条件需要很小心，不然就很容易出错
	public boolean isMatch(String s, String p) {
		//System.out.println("middle: " + s + "<->" + p);
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0) {
			return (sLen == 0);
		}
		
		if (pLen == 1) {
			if (sLen == 1) {
				if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
					return true;
				}
			}
			return false;
		}

		int ppos = 0, spos = 0;
		if (p.charAt(ppos + 1) != '*') {
			if (spos < sLen && (p.charAt(ppos) == s.charAt(spos) || p.charAt(ppos) == '.')) {
				boolean tmp = this.isMatch(s.substring(spos + 1),
						p.substring(ppos + 1));
				//System.out.println("match: " + tmp);
				return tmp;
			}
			return false;
		} else {
			while (spos < sLen
					&& (p.charAt(ppos) == s.charAt(spos) || p.charAt(ppos) == '.')) {
				boolean tmp = this.isMatch(s.substring(spos),
						p.substring(ppos + 2));
				// System.out.println("match: " + tmp);
				if (tmp) {
					return true;
				}
				spos++;
			}
			boolean tmp = this
					.isMatch(s.substring(spos), p.substring(ppos + 2));
			// System.out.println("match: " + tmp);
			return tmp;
		}
	}

	public void testCase(String s, String p) {
		System.out.print(s + "<->" + p + ":");
		System.out.println(this.isMatch(s, p));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_011_regular_expression_matching solution = new Problem_011_regular_expression_matching();
		// solution.testCase("aa", "a");
		// solution.testCase("aa", "aa");
		// solution.testCase("aaa", "aa");
		// solution.testCase("aa", "a*");
		// solution.testCase("aa", "a.");
		// solution.testCase("ab", ".*");
		// solution.testCase("aab", "c*a*b*");
		// solution.testCase("cbcbc", ".*b*c");
		solution.testCase("a", "ab*");
		//solution.testCase("ab", ".bab");
	}

}
