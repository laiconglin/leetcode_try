package laiconglin.solution;
/**
 * integer to roman 问题的逆问题
 * @author lai-c
 *
 */

public class Problem_015_roman_to_integer {

    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
        		char curCh = s.charAt(i);
        		char nextCh = '\0';
        		if(i < len - 1) {
        			nextCh = s.charAt(i + 1);
        		}
        		if(curCh == 'M') {
        			res += 1000;
        		} else if(curCh == 'C' && nextCh == 'M') {
        			res += 900;
        			i++;
        		} else if(curCh == 'C' && nextCh == 'D') {
        			res += 400;
        			i++;
        		} else if(curCh == 'C') {
        			res += 100;
        		} else if(curCh == 'D') {
        			res += 500;
        		}
        		else if(curCh == 'X' && nextCh == 'C') {
        			res += 90;
        			i++;
        		} else if(curCh == 'X' && nextCh == 'L') {
        			res += 40;
        			i++;
        		} else if(curCh == 'X') {
        			res += 10;
        		} else if(curCh == 'L') {
        			res += 50;
        		} else if(curCh == 'I' && nextCh == 'X') {
        			res += 9;
        			i++;
        		} else if(curCh == 'I' && nextCh == 'V') {
        			res += 4;
        			i++;
        		} else if(curCh == 'I') {
        			res += 1;
        		} else if(curCh == 'V') {
        			res += 5;
        		}
        }
        return res;
    }
    
    public void testCase(String roman, int num) {
    		System.out.println("Solution: " + roman + "->" + this.romanToInt(roman));
    		System.out.println("Expected: " + roman + "->" + num);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_015_roman_to_integer solution = new Problem_015_roman_to_integer();
		solution.testCase("MMMCMXCIX", 3999);
		solution.testCase("MI", 1001);
		solution.testCase("MCMXCIX", 1999);
		solution.testCase("CMXCIX", 999);
		solution.testCase("DCCCXCIX", 899);
		solution.testCase("CDXCIX", 499);
		solution.testCase("CCCXCIX", 399);
	}

}
