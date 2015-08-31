package laiconglin.solution;

public class Problem_043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        String res = "";
        if(num1.equals("0")) {
        	return "0";
        }
        if(num2.equals("0")) {
        	return "0";
        }
        num1 = this.trimLeadingZero(num1);
        num2 = this.trimLeadingZero(num2);
        int len2 = num2.length();
        String tmpMulti;
        char [] num2Zero = new char[len2];
        for(int i = 0; i < len2; i++ ) {
        	num2Zero[i] = '0';
        }
        String strZero = String.valueOf(num2Zero);
        for(int i = len2 - 1; i >= 0; i--) {
        	int tmp = num2.charAt(i) - '0';
        	if(tmp == 0) {
        		continue;
        	}
        	tmpMulti = this.multiStringByDigit(num1, tmp);
        	tmpMulti = tmpMulti + strZero.substring(0, len2 - 1 - i);
        	res = this.add(res, tmpMulti);
        }
        return res;
    }
    
    private String trimLeadingZero(String num) {
    	int len = num.length();
    	int beginIndex  = 0;
    	for(int i = 0; i < len; i++) {
    		if(num.charAt(i) == '0') {
    			continue;
    		} else {
    			beginIndex = i;
    			break;
    		}
    	}
    	return num.substring(beginIndex);
    }
    
    private String multiStringByDigit(String num, int a) {
    	StringBuilder sb = new StringBuilder();
    	int len = num.length();
    	int carry = 0;
    	for(int i = len - 1; i >= 0; i--) {
    		int tmpDigit = num.charAt(i) - '0';
    		int sum = tmpDigit * a + carry;
    		carry = sum / 10;
    		sb.append(String.valueOf(sum % 10));
    	}
    	if(carry > 0) {
    		sb.append(String.valueOf(carry));
    	}
    	return sb.reverse().toString();
    }
    private String add(String num1, String num2) {
    	StringBuilder sb = new StringBuilder();
    	int num1Pos = num1.length() - 1;
    	int num2Pos = num2.length() - 1;
    	int carry = 0;
    	while(num1Pos >= 0 && num2Pos >= 0) {
    		int tmpNum1 = num1.charAt(num1Pos) - '0';
    		int tmpNum2 = num2.charAt(num2Pos) - '0';
    		int sum = tmpNum1 + tmpNum2 + carry;
    		carry = sum / 10;
    		sb.append(String.valueOf(sum % 10));
    		num1Pos--;
    		num2Pos--;
    	}
    	while(num1Pos >= 0) {
    		int tmpNum1 = num1.charAt(num1Pos) - '0';
    		int sum = tmpNum1 + carry;
    		carry = sum / 10;
    		sb.append(String.valueOf(sum % 10));
    		num1Pos--;
    	}
    	while(num2Pos >= 0) {
    		int tmpNum2 = num2.charAt(num2Pos) - '0';
    		int sum = tmpNum2 + carry;
    		carry = sum / 10;
    		sb.append(String.valueOf(sum % 10));
    		num2Pos--;
    	}
    	if(carry > 0) {
    		sb.append(String.valueOf(carry));
    	}
    	return sb.reverse().toString();
    }
	public static void main(String[] args) {

	}
}
