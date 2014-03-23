package laiconglin.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Problem_017_3Sum {

	class Triplets {
		private int a;
		private int b;
		private int c;

		public Triplets(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triplets other = (Triplets) obj;

			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashSet<Triplets> resSet = new HashSet<Triplets>();
		HashMap<Integer, ArrayList<Integer>> num2IndexMap = new HashMap<Integer, ArrayList<Integer>>();
		int len = num.length;
		for (int i = 0; i < len; i++) {
			if (num2IndexMap.containsKey(num[i])) {
				ArrayList<Integer> indexArr = num2IndexMap.get(num[i]);
				indexArr.add(i);
				num2IndexMap.put(num[i], indexArr);
			} else {
				ArrayList<Integer> indexArr = new ArrayList<Integer>();
				indexArr.add(i);
				num2IndexMap.put(num[i], indexArr);
			}
		}

		HashSet<Integer> checkedNum = new HashSet<Integer>();
		for (int i = 0; i < len - 2; i++) {
			checkedNum.clear();
			for (int j = i + 1; j < len - 1; j++) {
				int remainder = 0 - num[i] - num[j];
				if (num2IndexMap.containsKey(remainder)
						&& checkedNum.contains(num[j]) == false) {
					checkedNum.add(num[j]);
					ArrayList<Integer> indexs = num2IndexMap.get(remainder);
					boolean isExists = false;
					for (Integer index : indexs) {
						if (index > j) {
							isExists = true;
							break;
						}
					}
					
					if (isExists) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(remainder);
						Collections.sort(tmp);
						Triplets tmpTriplets = new Triplets(tmp.get(0),
								tmp.get(1), tmp.get(2));
						if (resSet.contains(tmpTriplets) == false) {
							resSet.add(tmpTriplets);
							res.add(tmp);
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
		// TODO Auto-generated method stub
		Problem_017_3Sum solution = new Problem_017_3Sum();
		int[] nums = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7,
				9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2,
				-5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5,
				-15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1,
				0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10,
				0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7,
				-12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
		//int [] nums = {-1, 0, 1, 2, -1, -4};
		//int [] nums = {-1, 0, 1};
		System.out.println("array size:" + nums.length);
		long start = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> res = solution.threeSum(nums);
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");
		for (int i = 0; i < res.size(); i++) {
			System.out.print("(");
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
				if (j != 2)
					System.out.print(",");
			}
			System.out.println(")");
		}
	}

}
