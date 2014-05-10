package laiconglin.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_046_Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		
		ArrayList<Integer> nextPer = this.convertArray2List(num);
		res.add(nextPer);
		int[] next = this.nextPermutation(num);
		while(this.isTwoArraySame(num, next) == false) {
			nextPer = this.convertArray2List(next);
			res.add(nextPer);
			next = this.nextPermutation(next);
		}
		
		return res;
	}
	private int[] nextPermutation(int[] num) {
		int len = num.length;
		int[] next = new int[len];
		System.arraycopy(num, 0, next, 0, len);
		if(len <= 1) {
			return next;
		}
		int first = len - 2;
		int second = len - 1;
		while(next[first] >= next[second]) {
			first--;
			second--;
			if(first == -1) {
				break;
			}
		}
		if(first != -1) {
			for(int i = len - 1; i >= first; i--) {
				if(next[i] > next[first]) {
					this.swap(next, i, first);
					break;
				}
			}
		}
		this.reverseArray(next, first + 1, len - 1);
		return next;
	}
	private void swap(int[] num, int first, int second) {
		num[first] = num[first] ^ num[second];
		num[second] = num[first] ^ num[second];
		num[first] = num[second] ^ num[first];
	}
	private ArrayList<Integer> convertArray2List(int[] num) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (Integer i : num) {
			res.add(i);
		}
		return res;
	}
	
	private boolean isTwoArraySame(int[] a, int[] b) {
		boolean isSame = true;
		int len = a.length;
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (a[i] != b[i]) {
				isSame = false;
				break;
			}
		}
		return isSame;
	}

	public void reverseArray(int[] num, int start, int end) {
		for (int i = start; i < end; i++) {
			this.swap(num, i, end);
			end--;
		}
	}

	public void showNum(int[] num) {
		System.out.print("[");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
			if (i != num.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public void showList(ArrayList<Integer> list) {
		System.out.print("[");
		for (Integer i : list) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		int[] num = {1, 2, 3};
		Problem_046_Permutations solution = new Problem_046_Permutations();
		//solution.reverseArray(num, 0, num.length - 1);
		//solution.showNum(num);
		ArrayList<ArrayList<Integer>> per = solution.permute(num);
		for (ArrayList<Integer> arrayList : per) {
			solution.showList(arrayList);
		}
	}

}
