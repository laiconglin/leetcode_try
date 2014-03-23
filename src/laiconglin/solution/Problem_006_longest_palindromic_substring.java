package laiconglin.solution;

public class Problem_006_longest_palindromic_substring {
	public String longestPalindrome(String s) {
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
		//System.out.println(test.substring(2, test.length()));
		System.out.println(solution.longestPalindrome(test));
		//System.out.println(test.lastIndexOf('a', test.length()));
	}
}
