package taop.laiconglin.string;

/**
 * 
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，
 * 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *   
 *  利用一个矩阵转置的性质
 *  
 *  AB ->  (A^TB^T)^T  -> BA
 * 
 * @author laiconglin
 *
 */
public class Pro_01_ShiftString {
	public void leftShift(char[] tmpChars, int n) {
		if (tmpChars == null || tmpChars.length == 0) {
			return;
		}
		if (n <= 0 || n >= tmpChars.length) {
			return;
		}
		reverse(tmpChars, 0, n - 1);
		reverse(tmpChars, n, tmpChars.length - 1);
		reverse(tmpChars, 0, tmpChars.length - 1);
	}
	private void reverse(char[] tmpChars, int left, int right) {
		while(left < right) {
			swap(tmpChars, left, right);
			left++;
			right--;
		}
	}
	private void swap(char[] tmpChars, int a, int b) {
		char tmp = tmpChars[a];
		tmpChars[a] = tmpChars[b];
		tmpChars[b] = tmp;
	}
	public static void main(String[] args) {
		String str = "abcdef";
		char[] tmpChars = str.toCharArray();
		Pro_01_ShiftString solution = new Pro_01_ShiftString();
		solution.leftShift(tmpChars, 3);
		System.out.println(tmpChars);
	}
}
