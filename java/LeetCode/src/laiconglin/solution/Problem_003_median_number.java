package laiconglin.solution;

public class Problem_003_median_number {

	public double findMedianSortedArrays(int A[], int B[]) {
		double median = 0.0;
		int aLen = A.length;
		int bLen = B.length;
		if (aLen > bLen) {
			median = this.findMedian(B, 0, bLen - 1, A, 0, aLen - 1);
			//median = this.findMedianSimple(B, A);
		} else {
			median = this.findMedian(A, 0, aLen - 1, B, 0, bLen -1);
			//median = this.findMedianSimple(A, B);
		}
		return median;
	}
	/*
	private double findMedianSimple(int A[], int B[]) {
		double median = 0.0;
		int aLen = A.length;
		int bLen = B.length;
		int[] merged = new int[aLen + bLen];
		int aIndex = 0;
		int bIndex = 0;
		int mergedIndex = 0;
		while(aIndex <=(aLen - 1) && bIndex <= (bLen - 1)) {
			if(A[aIndex] < B[bIndex]) {
				merged[mergedIndex] = A[aIndex];
				aIndex++;
			} else {
				merged[mergedIndex] = B[bIndex];
				bIndex++;
			}
			mergedIndex++;
		}
		
		while(aIndex <= (aLen - 1)) {
			merged[mergedIndex] = A[aIndex];
			aIndex++;
			mergedIndex++;
		}
		
		while(bIndex <= (bLen - 1)) {
			merged[mergedIndex] = B[bIndex];
			bIndex++;
			mergedIndex++;
		}
		int mid = (aLen + bLen) / 2;
		if((aLen + bLen) % 2 == 0) {
			median = (merged[mid] + merged[mid - 1]) / 2.0;
		} else {
			median = merged[mid];
		}
		return median;
	}
	*/
	private double findMedian(int A[], int aStartPos, int aEndPos, int B[], int bStartPos, int bEndPos) {
		double median = 0.0;
		int aLen = aEndPos - aStartPos + 1;
		int bLen = bEndPos - bStartPos + 1;
		System.out.println("INFO:");
		System.out.print("[");
		for(int i = aStartPos; i <= aEndPos; i++) {
			System.out.print(A[i]);
			if(i != aEndPos) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.print("[");
		for(int i = bStartPos; i <= bEndPos; i++) {
			System.out.print(B[i]);
			if(i != bEndPos) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		if (aLen == 0) {
			if ((bLen % 2) == 1) {
				return B[bLen / 2 + bStartPos];
			} else {
				return (B[bLen / 2 + bStartPos] + B[bLen / 2 - 1 + bStartPos]) / 2.0;
			}
		}

		int aMid = A[aLen / 2 + aStartPos];
		int bMid = B[bLen / 2 + bStartPos];
		int cutSize = (aLen / 2);
		if(aLen % 2 == 0) {
			cutSize = cutSize - 1;
		}
		if (aLen == 1) {
			if (bLen == 1) {
				median = (A[0 + aStartPos] + B[0 + bStartPos]) / 2.0;
			} else if (bLen > 1) {
				if (bLen % 2 == 1)
					median = this.findMedian1AndOddArrar(A[0 + aStartPos], B, bStartPos, bEndPos);
				else
					median = this.findMedian1AndEvenArrar(A[0 + aStartPos], B, bStartPos, bEndPos);
			}
		} else if (aLen == 2) {
			if (bLen == 2)
				median = this.MO4(A[0 + aStartPos], A[1 + aStartPos], B[0 + bStartPos], B[1 + bStartPos]);
			else if (bLen > 2) {
				if ((bLen % 2) == 1) {
					median = this.MO3(B[bLen / 2 + bStartPos],
							Math.max(A[0 + aStartPos], B[bLen / 2 - 1 + bStartPos]),
							Math.min(A[1 + aStartPos], B[bLen / 2 + 1 + bStartPos]));
				} else if ((bLen % 2) == 0) {
					median = this.MO4(B[bLen / 2 + bStartPos], B[bLen / 2 - 1 + bStartPos],
							Math.max(A[0 + aStartPos], B[bLen / 2 - 2 + bStartPos]),
							Math.min(A[1 + aStartPos], B[bLen / 2 + 1 + bStartPos]));
				}
			}
		} else {
			if (aMid > bMid) {
				median = this.findMedian(A, 0 + aStartPos, aStartPos + aLen - cutSize - 1, B, bStartPos + cutSize, bEndPos);
			} else {
				median = this.findMedian(A, cutSize + aStartPos, aEndPos, B, bStartPos, bStartPos + bLen - cutSize - 1);
			}
		}
		return median;
	}

	private double findMedian1AndOddArrar(int num, int B[], int bStartPos, int bEndPos) {
		int bLen = bEndPos - bStartPos + 1;
		double bMid = B[bLen / 2 + bStartPos];
		double another = this
				.MO3(num, B[bLen / 2 - 1], B[bLen / 2 + 1]);
		return (bMid + another) / 2;
	}

	private double findMedian1AndEvenArrar(int num, int B[], int bStartPos, int bEndPos) {
		int bLen = bEndPos - bStartPos + 1;
		return this.MO3(num, B[bLen / 2 - 1 + bStartPos], B[bLen / 2 + bStartPos]);
	}

	private double MO3(int a, int b, int c) {
		return a + b + c - Math.max(a, Math.max(b, c))
				- Math.min(a, Math.min(b, c));
	}

	private double MO4(int a, int b, int c, int d) {
		int Max = Math.max(a, Math.max(b, Math.max(c, d)));
		int Min = Math.min(a, Math.min(b, Math.min(c, d)));
		return (a + b + c + d - Max - Min) / 2.0;
	}

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		Problem_003_median_number solution = new Problem_003_median_number();
		int[] A = { 3,5,6,7,8 };
		int[] B = { 1,2,4,9,10};
		long start = System.currentTimeMillis();

		long end = System.currentTimeMillis();
		System.out.println("init time: " + (end - start)  + "ms");
		start = System.currentTimeMillis();
		System.out.println(solution.findMedianSortedArrays(A, B));
		end = System.currentTimeMillis();
		System.out.println("get median time: " + (end - start)  + "ms");
	}
}
