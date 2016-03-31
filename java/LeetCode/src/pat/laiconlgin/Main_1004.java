package pat.laiconlgin;

import java.util.Scanner;

public class Main_1004 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1004
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int N = scan.nextInt();
			String highestName = "";
			String highestNumber = "";
			int highestScore = Integer.MIN_VALUE;
			String lowestName = "";
			String lowestNumber = "";
			int lowestScore = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String curName = scan.next();
				String curNumber = scan.next();
				int curScore = scan.nextInt();
				if (curScore > highestScore) {
					highestName = curName;
					highestNumber = curNumber;
					highestScore = curScore;
				}
				if (curScore < lowestScore) {
					lowestName = curName;
					lowestNumber = curNumber;
					lowestScore = curScore;
				}
			}
			System.out.println(highestName + " " + highestNumber);
			System.out.println(lowestName + " " + lowestNumber);
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
