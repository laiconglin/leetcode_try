package pat.laiconlgin;

import java.util.Scanner;

public class Main_1006 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1006
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int N = scan.nextInt();
			if (N >= 100) {
				int hundredNumber = N / 100;
				for (int i = 0; i < hundredNumber; i++) {
					System.out.print("B");
				}
				N = N % 100;
			}
			if (N >= 10) {
				int tenNumber = N / 10;
				for (int i = 0; i < tenNumber; i++) {
					System.out.print("S");
				}
				N = N % 10;
			}
			for (int i = 1; i <= N; i++) {
				System.out.print(i);
			}
			System.out.println("");
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
