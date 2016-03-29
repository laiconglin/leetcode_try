package pat.laiconlgin;

import java.util.Scanner;

public class Main_1002 {

	/**
	 * https://www.patest.cn/contests/pat-b-practise/1002
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			String number = scan.next();
			int sum = 0;
			for (int i = 0; i < number.length(); i++) {
				sum += number.charAt(i) - '0';
			}
			String tmpSum = Integer.toString(sum);
			for (int i = 0; i < tmpSum.length(); i++) {
				switch(tmpSum.charAt(i)) {
				case '0':
					System.out.print("ling");
					break;
				case '1':
					System.out.print("yi");
					break;
				case '2':
					System.out.print("er");
					break;
				case '3':
					System.out.print("san");
					break;
				case '4':
					System.out.print("si");
					break;
				case '5':
					System.out.print("wu");
					break;
				case '6':
					System.out.print("liu");
					break;
				case '7':
					System.out.print("qi");
					break;
				case '8':
					System.out.print("ba");
					break;
				case '9':
					System.out.print("jiu");
					break;
				}
				if (i != tmpSum.length() - 1) {
					System.out.print(" ");
				} else {
					System.out.println("");
				}
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
