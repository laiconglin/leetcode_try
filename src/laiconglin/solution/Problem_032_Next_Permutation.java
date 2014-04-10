package laiconglin.solution;

public class Problem_032_Next_Permutation {
	public void nextPermutation(int[] num) {
		int len = num.length;
		if (len <= 1) {
			return;
		}
		int firstIndex = len - 2;
		int secondIndex = len - 1;
		for (; firstIndex >= 0; firstIndex--) {
			secondIndex = firstIndex + 1;
			if (num[firstIndex] < num[secondIndex]) {
				break;
			}
		}

		int numBiggerThanFirstIndex = len - 1;
		int revStartPos = firstIndex == -1 ? 0 : firstIndex + 1;
		int revEndPos = len - 1;
		if (firstIndex != -1) {
			while (num[numBiggerThanFirstIndex] <= num[firstIndex]) {
				numBiggerThanFirstIndex--;
			}
			this.swap(num, firstIndex, numBiggerThanFirstIndex);
		}
		for(; revStartPos < revEndPos; revStartPos++, revEndPos--) {
			this.swap(num, revStartPos, revEndPos);
		}
	}

	private void swap(int[] num, int aPos, int bPos) {
		num[aPos] = num[aPos] ^ num[bPos];
		num[bPos] = num[aPos] ^ num[bPos];
		num[aPos] = num[bPos] ^ num[aPos];
	}

	public void printArr(int[] num) {
		System.out.print("[");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
			if (i != (num.length - 1)) {
				System.out.print(',');
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 5 ,3 };
		Problem_032_Next_Permutation solution = new Problem_032_Next_Permutation();
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
		solution.nextPermutation(A);
		solution.printArr(A);
	}
}
