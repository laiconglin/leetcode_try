package pat.laiconlgin;

import java.util.Scanner;

public class Main_1008 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1008
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = scan.nextInt();
			}
			for (int i = 0; i < M; i++) {
				int last = num[N - 1];
				for (int j = N - 2; j >= 0; j--) {
					num[j+1] = num[j];
				}
				num[0] = last;
			}
			for (int i = 0; i < N; i++) {
				System.out.print(num[i]);
				if (i == N - 1) {
					System.out.println("");
				} else {
					System.out.print(" ");
				}
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
