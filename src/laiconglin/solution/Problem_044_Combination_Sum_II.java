package laiconglin.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_044_Combination_Sum_II {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		int len = num.length;
		int pos = 0;
		for(int i = 0; i < len; i++) {
			if(num[i] > target) {
				pos = i;
				break;
			} else {
				pos = i + 1;
			}
		}
		
		int countSum = 0;
		int maxNum = 0;
		for(int i = 0; i < len; i++) {
			countSum += num[i];
			if(countSum >= target) {
				maxNum = i + 1;
				break;
			}
		}
		int[] subNum = new int[pos];
		System.arraycopy(num, 0, subNum, 0, pos);
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		int lowestPos = 0;
		for (int i = 1; i <= maxNum; i++) {
			res.addAll(this.combinationSum2Sub(subNum, lowestPos, target, i,
					prefix));
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> combinationSum2Sub(int[] num,
			int lowestPos, int target, int remainedNum,
			ArrayList<Integer> prefix) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (remainedNum == 1) {
			for (int i = lowestPos; i < len; i++) {
				if((i + 1) < len && num[i] == num[i + 1]) {
					continue;
				}
				
				if (num[i] == target) {
					ArrayList<Integer> tmpAns = new ArrayList<Integer>(prefix);
					tmpAns.add(num[i]);
					res.add(tmpAns);
				}
				
				if (num[i] > target) {
					break;
				}
			}
		} else {
			for (int i = lowestPos; i < len; i++) {
				if (num[i] > target) {
					break;
				}
				if ((i - 1) >= 0 && num[i] == num[i - 1] && i > lowestPos) {
					continue;
				}
				int remainTarget = target - num[i];
				ArrayList<Integer> subPrefix = new ArrayList<Integer>(prefix);
				subPrefix.add(num[i]);
				res.addAll(this.combinationSum2Sub(num, i + 1, remainTarget, remainedNum - 1, subPrefix));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
