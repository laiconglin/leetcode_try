package laiconglin.solution;

public class Problem_007_Zigzag_conversion {
    public String convert(String s, int nRows) {
    		//special case
    		if(s.length() == 1 || nRows == 1)
    			return s;
        StringBuilder[] sbRows = new StringBuilder[nRows];
        for(int i = 0; i < nRows; i++) {
        		sbRows[i] = new StringBuilder();
        }
        int len = s.length();
        int cycle = 2 * nRows - 2;
        int remainder = -1;
        for(int i = 0; i < len; i++) {
        		remainder = i % cycle;
        		if(remainder == 0) {
        			sbRows[0].append(s.charAt(i));
        		} else if(remainder == (nRows - 1)) {
        			sbRows[nRows - 1].append(s.charAt(i));
        		} else if(remainder < (nRows - 1)) {
        			sbRows[remainder].append(s.charAt(i));
        		} else if(remainder > (nRows - 1)) {
        			sbRows[cycle - remainder].append(s.charAt(i));
        		}
        }
        StringBuilder resSb = new StringBuilder();
        for(int i = 0; i < nRows; i++) {
    			resSb.append(sbRows[i].toString());
        }
        return resSb.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_007_Zigzag_conversion solution = new Problem_007_Zigzag_conversion();
		String test = "A";
		System.out.println(solution.convert(test, 1));
	}

}
