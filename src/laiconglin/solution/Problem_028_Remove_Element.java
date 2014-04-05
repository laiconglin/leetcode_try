package laiconglin.solution;

public class Problem_028_Remove_Element {
	public int removeElement(int[] A, int elem) {
		int len = A.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1 && A[0] == elem) {
			return 0;
		}
		int countRemove = 0;
		int resultLen = len;
		for (int i = 0; i < len; i++) {
			if (A[i] == elem) {
				resultLen--;
				countRemove++;
			} else {
				A[i - countRemove] = A[i];
			}
		}
		return resultLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
