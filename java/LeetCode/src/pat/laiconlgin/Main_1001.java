package pat.laiconlgin;

import java.util.Scanner;

public class Main_1001 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1001
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int n = scan.nextInt();
			int count = 0;
			while(n != 1) {
				if ((n & 1) == 0) {
					n = n / 2;
				} else {
					n = (3 * n + 1) / 2;
				}
				count++;
			}
			System.out.println(count);
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
