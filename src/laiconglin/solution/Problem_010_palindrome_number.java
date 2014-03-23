package laiconglin.solution;

public class Problem_010_palindrome_number {
    public boolean isPalindrome(int x) {
    		boolean isPalindrome = true;
    		Integer tmp = x;
    		if(x < 0) {
    			tmp = -x;
    			return false;
    		}
    		isPalindrome = tmp.toString().equals(new StringBuilder(tmp.toString()).reverse().toString());
    		return isPalindrome;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_010_palindrome_number solution = new Problem_010_palindrome_number();
		int x = -2147447412;
		System.out.println(x);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(solution.isPalindrome(x));
	}

}
