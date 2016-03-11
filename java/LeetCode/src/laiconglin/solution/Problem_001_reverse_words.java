package laiconglin.solution;

public class Problem_001_reverse_words {

	public String reverseWords(String s) {
		s = s.trim();
		String [] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		int len = words.length;
		for(int i = len -1; i >= 0; i--){
			if(!words[i].equals("")){
				sb.append(words[i]);
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "  the sky is   blue";
		Problem_001_reverse_words solution = new Problem_001_reverse_words();
		System.out.println(solution.reverseWords(test));
	}

}
