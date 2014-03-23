package laiconglin.solution;

import java.util.HashMap;

public class Problem_002_two_sum {
	public int[] twoSum(int[] numbers, int target) {
		int[] index = new int[2];
		int len = numbers.length;
		int i = 0;
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (i = 0; i < len; i++) {
			if (!hashmap.containsKey(numbers[i])) {
				hashmap.put(numbers[i], i + 1);
			}
			
			if ((numbers[i] * 2) == target) {
				index[0] = hashmap.get(numbers[i]);
				index[1] = i + 1;
			} else {
				if (hashmap.containsKey(target - numbers[i])) {
					index[0] = hashmap.get(target - numbers[i]);
					index[1] = i + 1;
					break;
				}
			}
		}
		return index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 3, 2, 4 };
		int target = 6;
		Problem_002_two_sum solution = new Problem_002_two_sum();
		int[] index = solution.twoSum(numbers, target);
		System.out.printf("index1:%d, index2:%d", index[0], index[1]);
	}
}
