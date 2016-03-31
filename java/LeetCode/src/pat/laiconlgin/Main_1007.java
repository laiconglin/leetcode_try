package pat.laiconlgin;

import java.util.Scanner;

public class Main_1007 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1007
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int N = scan.nextInt();
			int[] rawNumbers = new int[N + 1];
			for (int i = 2; i * i <= N; i++) {
				for(int j = 2; j * i <= N; j++) {
					rawNumbers[i * j] = 1;
				}
			}
			int tmpLeft = 2;
			int count = 0;
			for (int i = 3; i <= N; i++) {
				if (rawNumbers[i] == 0) {
//					System.out.print(i + " ");
					int tmpRight = i;
					if (tmpRight - tmpLeft == 2) {
						count++;
					}
					tmpLeft = tmpRight;
				}
			}
			System.out.println(count);
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
