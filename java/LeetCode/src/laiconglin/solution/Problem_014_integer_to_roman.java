package laiconglin.solution;

/**
 * 参考：http://www.onlineconversion.com/roman_numerals_advanced.htm
 * 
 * @author lai-c
 * 
 */
public class Problem_014_integer_to_roman {

	public String intToRoman(int num) {
		StringBuilder resSb = new StringBuilder();
		if (num >= 1000) {
			resSb.append("M");
			resSb.append(this.intToRoman(num - 1000));
		} else if (num >= 900) {
			resSb.append("CM");
			resSb.append(this.intToRoman(num - 900));
		} else if (num >= 500) {
			resSb.append("D");
			resSb.append(this.intToRoman(num - 500));
		} else if (num >= 400) {
			resSb.append("CD");
			resSb.append(this.intToRoman(num - 400));
		} else if (num >= 100) {
			resSb.append("C");
			resSb.append(this.intToRoman(num - 100));
		} else if (num >= 90) {
			resSb.append("XC");
			resSb.append(this.intToRoman(num - 90));
		} else if (num >= 50) {
			resSb.append("L");
			resSb.append(this.intToRoman(num - 50));
		} else if (num >= 40) {
			resSb.append("XL");
			resSb.append(this.intToRoman(num - 40));
		} else if (num >= 10) {
			resSb.append("X");
			resSb.append(this.intToRoman(num - 10));
		} else if (num >= 9) {
			resSb.append("IX");
			resSb.append(this.intToRoman(num - 9));
		} else if (num >= 5) {
			resSb.append("V");
			resSb.append(this.intToRoman(num - 5));
		} else if (num == 4) {
			resSb.append("IV");
		} else if (num == 3) {
			resSb.append("III");
		} else if (num == 2) {
			resSb.append("II");
		} else if (num == 1) {
			resSb.append("I");
		}
		return resSb.toString();
	}
	public void testCase(int num, String expected) {
		System.out.println("Solution: " + num + "->" + this.intToRoman(num));
		System.out.println("Expected: " + num + "->" + this.intToRoman(num));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_014_integer_to_roman solution = new Problem_014_integer_to_roman();
		solution.testCase(3999, "MMMCMXCIX");
		solution.testCase(1001, "MI");
		solution.testCase(1999, "MCMXCIX");
		solution.testCase(999, "CMXCIX");
		solution.testCase(899, "DCCCXCIX");
		solution.testCase(499, "CDXCIX");
		solution.testCase(399, "CCCXCIX");
	}

}
