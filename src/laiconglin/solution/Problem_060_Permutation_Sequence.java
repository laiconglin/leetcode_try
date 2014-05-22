package laiconglin.solution;

public class Problem_060_Permutation_Sequence {
    public String getPermutation(int n, int k) {
    	char[] chs = new char[n];
    	for(int i = 1; i <= n; i++) {
    		chs[i - 1] = (char) ('0' + i);
    	}
    	while(k > 1) {
    		this.getNextPermutation(chs);
    		k--;
    	}
    	
        return String.valueOf(chs);
    }
    private void getNextPermutation(char[] chs) {
    	int len = chs.length;
    	if(len > 1) {
    		int lastFirst = len - 1;
    		int lastSecond = len - 2;
    		while(chs[lastSecond] >= chs[lastFirst]) {
    			lastFirst--;
    			lastSecond--;
    			if(lastSecond < 0) {
    				break;
    			}
    		}
    		
    		if(lastSecond != -1) {
    			for(int i = len - 1; i > lastSecond; i--) {
    				if(chs[i] > chs[lastSecond]) {
    					this.swapChar(chs, lastSecond, i);
    					break;
    				}
    			}
    		}
    		int end = len - 1;
    		for(int i = lastSecond + 1; i < end; i++) {
    			this.swapChar(chs, i, end);
    			end--;
    		}
    	}
    }
    
    private void swapChar(char[] chs, int first, int second) {
    	char tmp = chs[first];
    	chs[first] = chs[second];
    	chs[second] = tmp;
    }
    
	public static void main(String[] args) {
		Problem_060_Permutation_Sequence solution = new Problem_060_Permutation_Sequence();
		System.out.println(solution.getPermutation(3, 1));
		System.out.println(solution.getPermutation(3, 2));
		System.out.println(solution.getPermutation(3, 3));
		System.out.println(solution.getPermutation(3, 4));
		System.out.println(solution.getPermutation(3, 5));
		System.out.println(solution.getPermutation(3, 6));
		System.out.println(solution.getPermutation(3, 7));
		System.out.println(solution.getPermutation(3, 8));
		System.out.println(solution.getPermutation(3, 9));
		System.out.println(solution.getPermutation(3, 10));
	}

}
