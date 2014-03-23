package laiconglin.solution;

public class Problem_016_longest_common_prefix {

	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		if(strs.length == 0)
			return "";
		while (true) {
			boolean isSame = true;
			boolean isEnd = false;
			char tmp = '\0';
			for (int i = 0; i < strs.length; i++) {
				if(index < strs[i].length()) {
					char curCh = strs[i].charAt(index);
					if(tmp == '\0') {
						tmp = curCh;
					}
					
					if(tmp != curCh) {
						isSame = false;
						break;
					}
				} else {
					isEnd = true;
					break;
				}
			}
			if(isEnd || isSame == false)
				break;
			
			if(isSame) {
				sb.append(tmp);
			}
			index++;
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] strs = {"hi123", "hihi", "himyworld", "hihello"};
		Problem_016_longest_common_prefix solution = new Problem_016_longest_common_prefix();
		System.out.println(solution.longestCommonPrefix(strs));
	}

}
