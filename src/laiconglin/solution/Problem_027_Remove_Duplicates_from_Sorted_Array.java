package laiconglin.solution;

public class Problem_027_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] A) {
		int count = 0;
		int len = A.length;
		if (len <= 1) {
			return len;
		}
		int curNum = A[0];
		count = 1;
		for (int i = 1; i < len; i++) {
			if (curNum == A[i]) {
				continue;
			} else {
				curNum = A[i];
				A[count] = curNum;
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {

	}

}
