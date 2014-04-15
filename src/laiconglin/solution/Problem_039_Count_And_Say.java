package laiconglin.solution;

public class Problem_039_Count_And_Say {
    public String countAndSay(int n) {
        if(n < 1) {
    		return "";
    	}
    	String res = "1";
    	int len = 0;
    	StringBuilder sb = new StringBuilder();
    	char cur = '\0';
    	int count = 0;
    	while(n > 1) {
    		len = res.length();
    		sb.delete(0, sb.length());
    		cur = '\0';
    		count = 0;
    		for(int i = 0; i < len; i++) {
    			if(cur == '\0'){
    				count = 1;
    				cur = res.charAt(i);
    			} else {
    				if(cur == res.charAt(i)) {
    					count++;
    				} else {
    					sb.append(String.valueOf(count));
    					sb.append(String.valueOf(cur));
    					count = 1;
    					cur = res.charAt(i);
    				}
    			}
    		}
			sb.append(String.valueOf(count));
			sb.append(String.valueOf(cur));
			res = sb.toString();
    		n--;
    	}
    	return res;
    }
}
