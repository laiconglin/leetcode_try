package laiconglin.solution;

public class Problem_042_Trapping_Rain_Water {
	public int trap(int[] A) {
		int res = 0;
		int left = -1;
		int right = -1;
		for (int i = 0; i < A.length; i++) {
			if (left == -1 && A[i] == 0) {
				continue;
			}
			if (i != A.length - 1) {
				if (A[i] > A[i + 1]) {
					left = i;
					right = this.findBiggerIndex(A, i);
					//System.out.println(left + ":" + right);
					if (right != -1) {
						res += this.countSmallGap(A, left, right);
						i = right - 1;
					}
				}
			}
		}
		return res;
	}

	private int findBiggerIndex(int[] A, int curPos) {
		int index = -1;
		int tmpMaxNum = -1;
		for (int i = curPos + 1; i < A.length; i++) {
			if (A[i] > A[i - 1] && A[i] > tmpMaxNum) {
				index = i;
				tmpMaxNum = A[i];
			}
			if (A[i] >= A[curPos]) {
				break;
			}
		}
		return index;
	}

	private int countSmallGap(int[] A, int startIndex, int endIndex) {
		int res = 0;
		int height = Math.min(A[startIndex], A[endIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			if (A[i] < height) {
				res += height - A[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {

	}

}
