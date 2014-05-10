package laiconglin.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_040_Combination_Sum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		if (candidates.length == 0) {
			return res;
		}
		int maxNum = target / candidates[0];
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		for (int i = 1; i <= maxNum; i++) {
			res.addAll(this.combinationSumByNum(candidates, target, 0, i,
					prefix));
		}
		return res;
	}

	private ArrayList<ArrayList<Integer>> combinationSumByNum(int[] candidates,
			int target, int minPos, int num, ArrayList<Integer> prefix) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == 1) {
			for (int i = minPos; i < candidates.length; i++) {
				if (target == candidates[i]) {
					ArrayList<Integer> tmpAns = new ArrayList<Integer>(prefix);
					tmpAns.add(candidates[i]);
					res.add(tmpAns);
				}
			}
		} else {
			for (int i = minPos; i < candidates.length; i++) {
				// remain
				int remain = target - candidates[i];
				if (remain < 0) {
					break;
				}
				ArrayList<Integer> subPrefix = new ArrayList<Integer>(prefix);
				subPrefix.add(candidates[i]);
				ArrayList<ArrayList<Integer>> subRes = this
						.combinationSumByNum(candidates, remain, i, num - 1,
								subPrefix);
				res.addAll(subRes);
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
