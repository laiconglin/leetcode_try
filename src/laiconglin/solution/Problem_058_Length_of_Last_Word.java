package laiconglin.solution;

public class Problem_058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int res = 0;
        s = s.trim();
        int len = s.length();
        if(len == 0) {
        	res = 0;
        } else {
        	int pos = s.lastIndexOf(" ");
        	if(pos == -1) {
        		res = len;
        	} else {
        		res = len - pos - 1;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		String s = "hello world ";
		Problem_058_Length_of_Last_Word solution = new Problem_058_Length_of_Last_Word();
		System.out.println(solution.lengthOfLastWord(s));
	}

}
