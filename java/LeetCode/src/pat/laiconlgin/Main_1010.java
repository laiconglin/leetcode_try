package pat.laiconlgin;

import java.util.Scanner;

public class Main_1010 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1010 
	 * really a bad problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			boolean isFirst = true;
			while (scan.hasNext()) {
				int i = scan.nextInt();
				int j = scan.nextInt();
				if (i * j != 0) {
					if (isFirst) {
						isFirst = false;
					} else {
						System.out.print(" ");
					}
					System.out.print(i * j);
					System.out.print(" ");
					System.out.print(j - 1);
				}
				if (isFirst) {
					System.out.println("0 0");
				}
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
