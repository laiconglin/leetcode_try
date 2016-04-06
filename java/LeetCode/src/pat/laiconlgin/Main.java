package pat.laiconlgin;

import java.util.Scanner;

public class Main {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1013 time limit out again
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int first = scan.nextInt();
			int second = scan.nextInt();
			int[] nums = new int[105773];
			int count = nums.length;
			for (int i = 0; i < count; i++) {
				nums[i] = i;
			}
			int sqrtResult = (int) Math.sqrt(count) + 1;
			for (int i = 2; i <= sqrtResult; i++) {
				for (int j = i; j < count; j++) {
					int tmpIndex = i * j;
					if (tmpIndex >= count) {
						break;
					}
					nums[tmpIndex] = 0;
				}
			}
			int primeCount = 0;
			int printCount = 0;
			for (int i = 2; i < count; i++) {
				if (nums[i] > 0) {
					primeCount++;
					if (primeCount < first) {
						continue;
					} else if (primeCount > second) {
						break;
					}
					System.out.print(nums[i]);
					printCount++;
					if (primeCount == second) {
						System.out.println("");
						break;
					} else if (printCount % 10 == 0) {
						System.out.println("");
					} else {
						System.out.print(" ");
					}
				}
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
