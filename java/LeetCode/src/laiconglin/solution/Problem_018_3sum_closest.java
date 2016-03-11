package laiconglin.solution;

import java.util.Arrays;

public class Problem_018_3sum_closest {
    public int threeSumClosest(int[] num, int target) {
        int res = 0;
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE;
        int len = num.length;
        for(int i = 0; i < len - 2; i++) {
        		for(int j = i + 1; j < len - 1; j++) {
        			for(int k = j + 1; k < len; k++) {
        				int tmpDiff = (num[i] + num[j] + num[k]) - target;
        				if(tmpDiff >= 0) {
        					if(tmpDiff < diff) {
        						res = target + tmpDiff;
        						diff = tmpDiff;
        					}
        					break;
        				} else {
        					tmpDiff = -tmpDiff;
        					if(tmpDiff < diff) {
        						res = target - tmpDiff;
        						diff = tmpDiff;
        					}
        				}
        			}
        		}
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_018_3sum_closest solution = new Problem_018_3sum_closest();
		int [] num = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(solution.threeSumClosest(num, target));
	}

}
