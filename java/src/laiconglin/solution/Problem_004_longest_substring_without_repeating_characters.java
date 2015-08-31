package laiconglin.solution;

import java.util.HashMap;

public class Problem_004_longest_substring_without_repeating_characters {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int startNoRep = 0;
		int endNoRep = -1;
		HashMap<String, Integer> charMap = new HashMap<String, Integer>();
		int maxLen = 0;
		boolean isTailNoRep = true;
		for (int i = 0; i < len; i++) {
			String curCh = String.valueOf(s.charAt(i));
			if (!charMap.containsKey(curCh)) {
				charMap.put(curCh, i);
				endNoRep = i;
			} else {
				endNoRep = i;
				if(endNoRep == (len - 1))
					isTailNoRep = false;
				if((endNoRep - startNoRep) > maxLen) {
					maxLen = endNoRep - startNoRep;
				}
				int repCharIndex = charMap.get(curCh);
				startNoRep = repCharIndex + 1;
				charMap.clear();
				for(int j = startNoRep; j <= endNoRep; j++) {
					String tmpCurCh = String.valueOf(s.charAt(j));
					charMap.put(tmpCurCh, j);
				}
			}
		}
		
		if(isTailNoRep && (endNoRep - startNoRep + 1) > maxLen) {
			maxLen = endNoRep - startNoRep + 1;
		}
		return maxLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_004_longest_substring_without_repeating_characters solution = new Problem_004_longest_substring_without_repeating_characters();
		String t = "laiconglin";
		t = "bbbbbb";
		//t = "qopubjguxhxdipfzwswybgfylqvjzhar";
		System.out.println(solution.lengthOfLongestSubstring(t));
	}

}
