package pat.laiconlgin;

import java.util.Scanner;

public class Main_1011 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1011
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				long A = scan.nextLong();
				long B = scan.nextLong();
				long C = scan.nextLong();
				int count = i + 1;
				if (A + B > C) {
					System.out.println("Case #" + count +": true");
				} else {
					System.out.println("Case #" + count +": false");
				}
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
