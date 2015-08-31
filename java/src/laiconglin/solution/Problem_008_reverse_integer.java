package laiconglin.solution;

public class Problem_008_reverse_integer {
	
    public int reverse(int x) {
        int isNeg = 1;
        if(x < 0) {
        		isNeg = -1;
        		x = - x;
        }
        Integer tmp = x;
        String tmpStr = new StringBuilder(tmp.toString()).reverse().toString();
        
        return Integer.parseInt(tmpStr) * isNeg;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_008_reverse_integer solution = new Problem_008_reverse_integer();
		int test = -123000;
		System.out.println(solution.reverse(test));
	}

}
