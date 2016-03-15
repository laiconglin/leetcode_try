package laiconglin.solution;

public class Problem_006_longest_palindromic_substring {
	public String longestPalindrome(String s) {
		/**
		 * 
		 * Manacher算法
		 * 首先进行定义，假设。
		 * 为了将问题进行简化，我们将类似
		 * a b c b a ->  $ # a # b # c # b # a #
		 * a b b a   ->  $ # a # b # b # a #
		 * $符号是起始符号，为了使边界处理更加简单
		 * str   : $ a # b # c # b # a
		 * index : 0 1 2 3 ..i ..j....
		 * 对于p[i]表示以str[i]为中心的字符串的向右延伸的最大距离。
		 * 
		 */
		String palin = null;
		String str = s;
		int len = str.length();
		if (len <= 1) {
			return str;
		}
		/**
		 * 字符串转换
		 */
		char[] str1 = new char[len * 2 + 4];
		str1[0] = '$';
		str1[1] = '#';
		int tmpIndex = 2;
		for (int i = 0; i < len; i++) {
			str1[tmpIndex] = s.charAt(i);
			tmpIndex++;
			str1[tmpIndex] = '#';
			tmpIndex++;
		}
		len = tmpIndex;
		int maxRightPos = 0;
		int maxRightCenter = -1;
		int maxPalinLen = -1;
		int maxPalinCenter = -1;
		int[] p = new int[len + 4];
		for (int i = 1; i < len; i++) {
			/**
			 * 遍历字符串，以这个str[i]为中心，尝试计算出它能够到达的最远的边界
			 */
			 if (maxRightPos > i) {
				 p[i] = p[2*maxRightCenter - i];
				 if (maxRightPos - i < p[i]) {
					 p[i] = maxRightPos - i;
				 }
			 } else {
				 p[i] = 0;
			 }
			 for(;i + p[i] < len && i - p[i] >= 0 && str1[i-p[i]] == str1[i + p[i]];p[i]++) {
				 
			 }
			 p[i]--;
			 if (p[i] + i > maxRightPos) {
				 maxRightCenter = i;
				 maxRightPos = p[i] + i;
			 }
			 if (p[i] > maxPalinLen) {
				 maxPalinLen = p[i];
				 maxPalinCenter = i;
			 }
		}
		int start = maxPalinCenter - maxPalinLen;
		int end = maxPalinCenter + maxPalinLen;
		char[] result = new char[maxPalinLen + 1];
		int j = 0;
		for (int i = start; i < end; i++) {
			if (str1[i] != '#') {
				result[j] = str1[i];
				j++;
			}
		}
		return new String(result, 0, j);
	}
	
	public String longestPalindrome_with_string_op(String s) {
		/**
		 * 35ms估计是使用了很多字符串的操作，很耗时
		 * 
		 * Manacher算法
		 * 首先进行定义，假设。
		 * 为了将问题进行简化，我们将类似
		 * a b c b a ->  $ # a # b # c # b # a #
		 * a b b a   ->  $ # a # b # b # a #
		 * $符号是起始符号，为了使边界处理更加简单
		 * str   : $ a # b # c # b # a
		 * index : 0 1 2 3 ..i ..j....
		 * 对于p[i]表示以str[i]为中心的字符串的向右延伸的最大距离。
		 * 
		 */
		String palin = null;
		String str = s;
		int len = str.length();
		if (len <= 1) {
			return str;
		}
		/**
		 * 字符串转换
		 */
		StringBuilder sb = new StringBuilder(len * 2 + 2);
		sb.append("$#");
		for (int i = 0; i < len; i++) {
			sb.append(str.charAt(i));
			sb.append("#");
		}
		str = sb.toString();
		len = str.length();
		int maxRightPos = 0;
		int maxRightCenter = -1;
		int maxPalinLen = -1;
		int maxPalinCenter = -1;
		int[] p = new int[len + 4];
		for (int i = 1; i < len; i++) {
			/**
			 * 遍历字符串，以这个str[i]为中心，尝试计算出它能够到达的最远的边界
			 */
			 if (maxRightPos > i) {
				 p[i] = p[2*maxRightCenter - i];
				 if (maxRightPos - i < p[i]) {
					 p[i] = maxRightPos - i;
				 }
			 } else {
				 p[i] = 0;
			 }
			 for(;i + p[i] < len && i - p[i] >= 0 && str.charAt(i-p[i]) == str.charAt(i + p[i]);p[i]++) {
				 
			 }
			 p[i]--;
			 if (p[i] + i > maxRightPos) {
				 maxRightCenter = i;
				 maxRightPos = p[i] + i;
			 }
			 if (p[i] > maxPalinLen) {
				 maxPalinLen = p[i];
				 maxPalinCenter = i;
			 }
		}
		return str.substring(maxPalinCenter - maxPalinLen, maxPalinCenter + maxPalinLen).replace("#", "");
	}
	/**
	 * 15ms 
	 * 
	 * 递归的方法来实现,
	 * i从0到len-1进行遍历, 找出以i为中心的字符串为回文字符串的最大的回文字符串
	 */
	int palinStartIndex = 0;
	int palinEndIndex = 0;
	int maxLen = 0;
	public String longestPalindrome_recursive(String s) {
		String palin = null;
		String str = s;
		int len = str.length();
		boolean[][] match = new boolean[len][len];
		if (len == 1) {
			return str;
		}
		for (int i = 0; i < len; i++) {
			checkMaxPalin(str, i, i);
			checkMaxPalin(str, i, i + 1);
		}
		return str.substring(this.palinStartIndex, this.palinEndIndex + 1);
	}
	private void checkMaxPalin(String str, int left, int right) {
		if (right >= str.length()) {
			return;
		}
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		int tmpLen = right - left + 1 - 1 - 1;
		if (tmpLen > this.maxLen) {
			this.palinStartIndex = left + 1;
			this.palinEndIndex = right - 1;
			this.maxLen = tmpLen;
		}
	}
	
	public String longestPalindrome_dynamic(String str) {
		String palin = null;
		/**
		 * 
		 * 65ms
		 * 
		 * 采用动态规划来实现进行遍历搜索，尽管时间复杂度和空间复杂度都是N^2，
		 * 但是因为会记录之前的搜索的结果，所以会减少很多的重复搜索，相对于
		 * 直接使用暴力搜索会快很多。
		 * 介绍算法。
		 * len表示字符串str的长度
		 * 1. 初始化一个match[len][len], 其中我们假设 i <= j, 
		 *    那么match[i][j] 表示index从i开始到j结束的子字符串是否为回文字符串
		 * 2. 当我们需要进行判定的时候，外层循环，我们将i从 len -1 到 0 进行遍历，内层循环
		 *    我们将 j 从 i 到 len - 1进行遍历。
		 * 3. 当str[i] == str[j] 并且 match[i+1][j-1]也为真的话, 也就是说如果内层也为真的话，
		 *    那么就不用再往里面进行遍历了。这样就节省了需要循环的次数，进行了剪枝。
		 */
		int len = str.length();
		boolean[][] match = new boolean[len][len];
		if (len == 1) {
			return str;
		}
		int palinStartIndex = 0;
		int palinEndIndex = 0;
		int maxLen = 0;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				boolean tmpFind = false;
				if (str.charAt(i) == str.charAt(j)) {
					if (j - i <= 2) {
						match[i][j] = true;
						tmpFind = true;
					} else {
						//当j - i > 2的时候
						if (match[i+1][j-1] == true) {
							match[i][j] = true;
							tmpFind = true;
						}
					}
				}
				
				if (tmpFind == true) {
					int tmpLen = j - i + 1;
					if (tmpLen > maxLen) {
						palinStartIndex = i;
						palinEndIndex = j;
						maxLen = tmpLen;
					}
				}
			}
		}
		
		return str.substring(palinStartIndex, palinEndIndex + 1);
	}
	
	
	public String longestPalindrome_old_unreadable(String s) {
		String palin = null;
		int len = s.length();
		if(len == 1)
			return s;
		boolean[][] matchMatrix = new boolean[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				// initial all the matrix's diagonal be 1 and the neighborhood characters be 1
				// two cases
				// 		case 1: input is like "abcba" 
				//		case 2: input is like "bb"
				if(i == j || i ==(j + 1)) {
					matchMatrix[i][j] = true;
				} else {
					matchMatrix[i][j] = false;
				}
			}
		}
		int palinStartIndex = 0;
		int palinEndIndex = 0;
		int i = 0;
		int j = 1;
		int maxLen = 0;
		while(j < len) {
			i = j - 1;
			while(i >= 0) {
				if(s.charAt(i) != s.charAt(j)) {
					matchMatrix[i][j] = false;
				} else {
					matchMatrix[i][j] = matchMatrix[i + 1][j - 1];
					if(matchMatrix[i][j] && (j - i + 1) > maxLen) {
						palinStartIndex = i;
						palinEndIndex = j;
						maxLen = j - i + 1;
					}
				}
				i--;
			}
			j++;
		}
		palin = s.substring(palinStartIndex, palinEndIndex + 1);
		return palin;
	}
	
    public String longestPalindromeVersion1_0(String s) {
    		//Time Limit Exceeded
    		String palin = null;
        int palinLen = 1;
        String reverseStr = new StringBuilder(s).reverse().toString();
        if(s.equals(reverseStr)) {
        		return s;
        }
        int len = s.length();
        for(int i = 0; i < len; i++) {
        		char leftCh = s.charAt(i);
        		int next = i;
        		int startOriIndex = i;
        		int endOriIndex = -1;
        		int startRevStrIndex = -1;
        		int endRevStrIndex = len - i;
        		
        		next = s.lastIndexOf(leftCh, len);
        		while(next != -1) {
        			endOriIndex = next + 1;
        			startRevStrIndex = len - endOriIndex;
        			String tmpPalinCheck = s.substring(startOriIndex, endOriIndex);
        			String tmpCompStr = reverseStr.substring(startRevStrIndex, endRevStrIndex);
        			//System.out.println(tmpPalinCheck + "<->" + tmpCompStr);
        			if(tmpPalinCheck.equals(tmpCompStr)){
        				if(tmpPalinCheck.length() > palinLen) {
        					palin = tmpPalinCheck;
        					palinLen = palin.length();
        					// skip to check the substring of the palindromic string
        					i = next;
        					//System.out.println("i : " + i);
        					break;
        				}
        			}
        			next = s.lastIndexOf(leftCh, next - 1);
        			if(next <= i)
        				break;
        		}
        }
        return palin;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_006_longest_palindromic_substring solution = new Problem_006_longest_palindromic_substring();
		String test = "abcdefgfedab";
		test = "bbbbbb";
		//System.out.println(test.substring(2, test.length()));
		System.out.println(solution.longestPalindrome(test));
		//System.out.println(test.lastIndexOf('a', test.length()));
	}
}
