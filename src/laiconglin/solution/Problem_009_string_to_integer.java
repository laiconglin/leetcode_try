package laiconglin.solution;

public class Problem_009_string_to_integer {

    public int atoi(String str) {
		str = str.trim();
		if(str.length() == 0)
			return 0;
			
		char firchar = str.charAt(0);	
		if(firchar != '-' && firchar != '+' && (firchar < '0' || firchar >'9')) {
			return 0;
		} else {
			int isPositive = 1;
			int curIndex = 0;
			if(firchar == '-') {
				isPositive = -1;
				curIndex = 1;
			} else if(firchar == '+') {
				curIndex = 1;
			}
			int res = 0;
			boolean isOver = false;
			for(int i = curIndex;i < str.length();i++) {
				if(str.charAt(i) >= '0' && str.charAt(i) <='9') {
					int tmp = (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10;
					if(tmp < res || (tmp == res && (str.charAt(i) - '0') >= 8)){
						isOver = true;
						break;
					} else {
						res = 10 * res + str.charAt(i) - '0';
					}
				} else {
					break;
				}
			}
			if(isOver) {
				if(isPositive == 1)
					return Integer.MAX_VALUE;
				else {
					return Integer.MIN_VALUE;
				}
			}
			return res * isPositive;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_009_string_to_integer solution = new Problem_009_string_to_integer();
		
		String str = "-10aa";
		System.out.println(solution.atoi(str));
	}

}
