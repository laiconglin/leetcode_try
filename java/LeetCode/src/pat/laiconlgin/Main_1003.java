package pat.laiconlgin;

import java.util.Scanner;

public class Main_1003 {
	
	/**
	 * https://www.patest.cn/contests/pat-b-practise/1003
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPass(String str) {
		boolean isPassCheck = true;
		int posP = str.indexOf("P");
		int posA = str.indexOf("A");
		int posT = str.indexOf("T");
		if (posP == -1 || posA == -1 || posT <= 1 || posP == (posT - 1)) {
			isPassCheck = false;
			return isPassCheck;
		}

		String beforeP = "";
		if (posP > 0) {
			beforeP = str.substring(0, posP);
		}
		String betweenPAndT = str.substring(posP + 1, posT);
		String afterT = "";
		if (posT < str.length() - 1) {
			afterT = str.substring(posT + 1, str.length());
		}

		if (Main_1003.isAllCharA(beforeP) == false
				|| Main_1003.isAllCharA(betweenPAndT) == false
				|| Main_1003.isAllCharA(afterT) == false) {
			isPassCheck = false;
			return isPassCheck;
		}

		int beforePLen = beforeP.length();
		int betweenPAndTLen = betweenPAndT.length();
		int afterTLen = afterT.length();
		
		if (betweenPAndTLen == 1) {
			if (beforePLen != afterTLen) {				
				isPassCheck = false;
				return isPassCheck;
			}
		}
		if (beforePLen * betweenPAndTLen != afterTLen) {
			isPassCheck = false;
			return isPassCheck;
		}
		
		return isPassCheck;
	}

	public static boolean isAllCharA(String str) {
		boolean isAllA = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 'A') {
				isAllA = false;
				break;
			}
		}
		return isAllA;
	}

	public static void main(String[] args) {
//		if (Main.isPass("APAAATAA")) {
//			System.out.println("YES");
//		} else {
//			System.out.println("NO");
//		}
		
		Scanner scan = new Scanner(System.in);
		try {
			int N = scan.nextInt();
			for (int i = 0; i < N; i++) {
				String str = scan.next();
				if (Main_1003.isPass(str)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} catch (Exception io) {
			System.out.println(io.getMessage());
		} finally {
			scan.close();
		}
	}
}
