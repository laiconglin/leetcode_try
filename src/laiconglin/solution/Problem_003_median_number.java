package laiconglin.solution;

public class Problem_003_median_number {

	public double findMedianSortedArrays(int A[], int B[]) {
		double median = 0.0;
		int aLen = A.length;
		int bLen = B.length;
		if (aLen > bLen) {
			median = this.findMedian(B, A);
			//median = this.findMedianSimple(B, A);
		} else {
			median = this.findMedian(A, B);
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
	private double findMedian(int A[], int B[]) {
		double median = 0.0;
		int aLen = A.length;
		int bLen = B.length;

		if (aLen == 0) {
			if ((bLen % 2) == 1) {
				return B[bLen / 2];
			} else {
				return (B[bLen / 2] + B[bLen / 2 - 1]) / 2.0;
			}
		}

		int aMid = A[aLen / 2];
		int bMid = B[bLen / 2];
		int cutSize = (aLen / 2);
		if(aLen % 2 == 0) {
			cutSize = cutSize - 1;
		}
		int[] nextA = new int[aLen - cutSize];
		int[] nextB = new int[bLen - cutSize];
		if (aLen == 1) {
			if (bLen == 1) {
				median = (A[0] + B[0]) / 2.0;
			} else if (bLen > 1) {
				if (bLen % 2 == 1)
					median = this.findMedian1AndOddArrar(A[0], B);
				else
					median = this.findMedian1AndEvenArrar(A[0], B);
			}
		} else if (aLen == 2) {
			if (bLen == 2)
				median = this.MO4(A[0], A[1], B[0], B[1]);
			else if (bLen > 2) {
				if ((bLen % 2) == 1) {
					median = this.MO3(B[bLen / 2],
							Math.max(A[0], B[bLen / 2 - 1]),
							Math.min(A[1], B[bLen / 2 + 1]));
				} else if ((bLen % 2) == 0) {
					median = this.MO4(B[bLen / 2], B[bLen / 2 - 1],
							Math.max(A[0], B[bLen / 2 - 2]),
							Math.min(A[1], B[bLen / 2 + 1]));
				}
			}
		} else {

			
			if (aMid > bMid) {
				System.arraycopy(A, 0, nextA, 0, aLen - cutSize );
				System.arraycopy(B, cutSize, nextB, 0, bLen - cutSize);
			} else {
				System.arraycopy(A, cutSize, nextA, 0, aLen - cutSize);
				System.arraycopy(B, 0, nextB, 0, bLen - cutSize);
			}
			median = this.findMedian(nextA, nextB);
		}
		return median;
	}

	private double findMedian1AndOddArrar(int num, int B[]) {
		double bMid = B[B.length / 2];
		double another = this
				.MO3(num, B[B.length / 2 - 1], B[B.length / 2 + 1]);
		return (bMid + another) / 2;
	}

	private double findMedian1AndEvenArrar(int num, int B[]) {
		return this.MO3(num, B[B.length / 2 - 1], B[B.length / 2]);
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
		int[] A = new int [30000000];
		int[] B = new int [30000000];
		long start = System.currentTimeMillis();
		for(int i = 0; i < 30000000; i++) {
			A[i] = 2 * i;
			B[i] = 2 * i + 1;
		}
		long end = System.currentTimeMillis();
		System.out.println("init time: " + (end - start)  + "ms");
		start = System.currentTimeMillis();
		System.out.println(solution.findMedianSortedArrays(A, B));
		end = System.currentTimeMillis();
		System.out.println("get median time: " + (end - start)  + "ms");
	}
}
