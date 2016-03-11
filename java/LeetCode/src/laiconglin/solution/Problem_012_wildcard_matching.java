package laiconglin.solution;

public class Problem_012_wildcard_matching {

	/**
	 * 解法三其实是对解法二的改进，即把算法二改为非递归，但是解法二中的递归并不是尾递归，
	 * 如果要改为非递归的话为了回溯就需要自己构造堆栈，幸运的是，在这里我们并不需要构造堆栈，
	 * 而只需要通过两个变量pre_s和pre_p来保存上一次它们开始比较的位置，然后在回溯的时候我们
	 * 从上一次比较的位置的后一个位置开始比较。

		那么这么做的原理何在呢？首先，如果p串中只有一个*号，那么这么做无疑是正确的，
		那么对于有多个*号的情况，我们来看一个例子，s="accbcbccx", p="a*b*d"，按解法二第一个*号其实是
		匹配了cc，即accb和a*b匹配了，剩下的cbccx交给*d去匹配，试想如果cbccx和*d匹配失败了，我们回溯
		到上一个*号去匹配是否能够成功呢？还是不能！因为*是可以匹配任意长度的，就算回到上一次的*号位置，
		让accbcb去和a*b匹配了，剩下的ccx和*d还是不能匹配，因为其实第二个*既可以匹配ccx也可以匹配cbccx，
		即是说后面的*号可以代替前面的*号的作用。总结一下，我们得出结论，在遇到*好不匹配时，
		我们直接回到上一次开始比较的位置的后一个位置开始比较就可以了，如果能匹配必然能找到匹配，
		如果不能匹配，那么再回溯也是没用的。而这也是解法三比解法二除了递归开销以外更节省时间的地方。
		http://blog.csdn.net/lifajun90/article/details/10582733
		
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		int sIndex = 0;
		int pIndex = 0;
		boolean isStar = false;
		int tmpPIndex = 0;
		int tmpSIndex = 0;
		char pCh = '\0';
		while (sIndex < sLen) {
			if (pIndex <= (pLen - 1)) {
				pCh = p.charAt(pIndex);
			} else {
				pCh = '\0';
			}
			switch (pCh) {
			case '?':
				pIndex++;
				break;
			case '*':
				isStar = true;
				tmpPIndex = pIndex;
				tmpSIndex = sIndex;
				while (tmpPIndex <= (pLen - 1) && p.charAt(tmpPIndex) == '*') {
					tmpPIndex++;
				}
				if (tmpPIndex == pLen) {
					return true;
				} else {
					sIndex = tmpSIndex - 1;
					pIndex = tmpPIndex;
				}
				break;
			default:
				if (s.charAt(sIndex) != pCh) {
					if (isStar == false) {
						return false;
					} else {
						tmpSIndex++;
						sIndex = tmpSIndex - 1;
						pIndex = tmpPIndex;
					}
				} else {
					pIndex++;
				}
				break;
			}
			sIndex++;
		}
		while(pIndex < pLen && p.charAt(pIndex) == '*') {
			pIndex++;
		}
		
		return (pIndex == pLen);
	}

	public void testCase(String s, String p) {
		System.out.print("[" + s + "]" + "<->[" + p + "]: ");
		System.out.println(this.isMatch(s, p));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_012_wildcard_matching solution = new Problem_012_wildcard_matching();

		solution.testCase("aa", "a");
		solution.testCase("aa", "aa");
		solution.testCase("aaa", "aa");
		solution.testCase("aa", "*");
		solution.testCase("aa", "a*");
		solution.testCase("ab", "?*");
		solution.testCase("aab", "c*a*b");
		solution.testCase("accbcbxxxxbd", "a*b*bd");
	}

}
