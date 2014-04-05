package laiconglin.solution;

public class Problem_030_Divide_Two_Integers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0 && dividend > 0) {
			return Integer.MAX_VALUE;
		} else if (divisor == 0 && dividend < 0) {
			return Integer.MIN_VALUE;
		} else if (divisor == 0 && dividend == 0) {
			return 0;
		}
		if (dividend == divisor) {
			return 1;
		}
		if (divisor == Integer.MIN_VALUE) {
			return 0;
		}
		if (dividend == 0) {
			return 0;
		}
		int flag = 1;
		int special_add_one = 0;
		if (dividend == Integer.MIN_VALUE) {
			dividend = Integer.MAX_VALUE;
			special_add_one = 1;
			flag = -flag;
		}
		if (dividend < 0 && divisor > 0) {
			dividend = -dividend;
			flag = -flag;
		} else if (dividend > 0 && divisor < 0) {
			divisor = -divisor;
			flag = -flag;
		} else if (dividend < 0 && divisor < 0) {
			dividend = -dividend;
			divisor = -divisor;
		}

		if (dividend < divisor) {
			return 0;
		} else if (dividend == divisor) {
			return flag;
		}

		if (divisor == 1) {
			return dividend * flag + special_add_one * flag;
		}
		/**
		 * simulate the human-being calculate divide processing
		 */
		String dividendStr = Integer.toString(dividend);
		String divisorStr = Integer.toString(divisor);
		int divisorLen = divisorStr.length();
		String resStr = "";
		int curIndex = 0;
		int nextStartIndex = curIndex + divisorLen;
		String curDiv = dividendStr.substring(curIndex, nextStartIndex);
		if (curDiv.compareTo(divisorStr) < 0) {
			nextStartIndex++;
			curDiv = dividendStr.substring(curIndex, nextStartIndex);
		}
		String carryStr = "";
		while (Integer.parseInt(curDiv) >= divisor) {
			int tmpDivResult = 0;
			int tmpDivNum = Integer.parseInt(curDiv);
			int remainder = tmpDivNum - divisor;
			while (remainder >= 0) {
				tmpDivResult++;
				tmpDivNum = remainder;
				if ((tmpDivNum - divisor) >= 0) {
					remainder = tmpDivNum - divisor;
				} else {
					break;
				}
			}
			resStr += Integer.toString(tmpDivResult);
			carryStr = "";
			if (remainder > 0) {
				carryStr += Integer.toString(remainder);
			}
			curIndex = nextStartIndex;
			if (nextStartIndex >= dividendStr.length()) {
				break;
			}
			curDiv = carryStr + dividendStr.charAt(nextStartIndex);
			nextStartIndex++;
			while (Integer.parseInt(curDiv) < divisor) {
				resStr += "0";
				if (nextStartIndex >= dividendStr.length()) {
					break;
				}
				curDiv += dividendStr.charAt(nextStartIndex);
				nextStartIndex++;
			}
		}
		int result = Integer.parseInt(resStr);
		if ((Integer.parseInt(carryStr) + special_add_one) == divisor) {
			result++;
		}
		return result * flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
