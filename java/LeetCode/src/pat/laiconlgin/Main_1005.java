package pat.laiconlgin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_1005 {
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1005
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int N = scan.nextInt();
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			Set<Integer> numbersSet = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				int tmp = scan.nextInt();
				numbers.add(tmp);
				numbersSet.add(tmp);
			}
			for (int i = 0; i < numbers.size(); i++) {
				int curNumber = numbers.get(i);
				if (numbersSet.contains(curNumber)) {
					while (curNumber != 1) {
						if ((curNumber & 1) == 0) {
							curNumber = curNumber / 2;
						} else {
							curNumber = (3 * curNumber + 1) / 2;
						}
						if (numbersSet.contains(curNumber)) {
							numbersSet.remove(curNumber);
						}
					}
				}
			}
			ArrayList<Integer> keyNumbers = new ArrayList<Integer>();
			for (Integer num : numbersSet) {
				keyNumbers.add(num);
			}
			Collections.sort(keyNumbers);
			for(int i = keyNumbers.size() - 1; i >= 0 ; i--) {
				System.out.print(keyNumbers.get(i));
				if (i != 0) {
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
