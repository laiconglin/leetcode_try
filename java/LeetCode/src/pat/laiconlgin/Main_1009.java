package pat.laiconlgin;

import java.util.Scanner;

public class Main_1009 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1009
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			String line = scan.nextLine();
			String[] words = line.split(" ");
			for (int i = words.length - 1; i >= 0; i--) {
				System.out.print(words[i]);
				if (i == 0) {
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
