package pat.laiconlgin;

import java.util.Scanner;

public class Main_1012 {
	/**
	 * 
	 * https://www.patest.cn/contests/pat-b-practise/1012
	 * always time limit out, Orz
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int n = scan.nextInt();
			int A1 = 0;
			int A2 = 0;
			int A3 = 0;
			float A4 = 0;
			int A5 = 0;
			int tmp = 0;
			boolean isA2 = false;
			int isPositive = 1;
			int A4Count = 0;
			int[] num = new int[n + 1];
			for (int i = 0; i < n; i++) {
				num[i] = scan.nextInt();
			}
			for (int i = 0; i < n; i++) {
				tmp = num[i];
				if (tmp % 10 == 0) {
					A1 += tmp;
				} else if (tmp % 5 == 1) {
					A2 += (isPositive * tmp);
					isPositive = -isPositive;
					isA2 = true;
				} else if (tmp % 5 == 2) {
					A3 += 1;
				} else if (tmp % 5 == 3) {
					A4 += tmp;
					A4Count++;
				} else if (tmp % 5 == 4) {
					if (tmp > A5) {
						A5 = tmp;
					}
				}
			}
			if (A1 > 0) {
				System.out.print(A1);
				System.out.print(" ");
			} else {
				System.out.print("N ");
			}
			if (isA2) {
				System.out.print(A2);
				System.out.print(" ");
			} else {
				System.out.print("N ");
			}
			if (A3 > 0) {
				System.out.print(A3);
				System.out.print(" ");
			} else {
				System.out.print("N ");
			}
			if (A4Count > 0) {
				float A4Result = A4 / A4Count;
				System.out.printf("%.1f ", A4Result);
			} else {
				System.out.print("N ");
			}
			if (A5 > 0) {
				System.out.println(A5);
			} else {
				System.out.println("N");
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}

}
