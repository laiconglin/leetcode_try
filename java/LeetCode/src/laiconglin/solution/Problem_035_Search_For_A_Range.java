package laiconglin.solution;

import java.util.Arrays;

public class Problem_035_Search_For_A_Range {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int len = A.length;
        if(len == 0) {
        	return res;
        } else if(len == 1) {
        	if(target == A[0]) {
        		res[0] = 0;
        		res[1] = 0;
        	}
        	return res;
        } else {
        	int index = Arrays.binarySearch(A, target);
        	if(index < 0) {
        		return res;
        	}
        	int newStartIndex = this.findLeftBound(A, 0, index, target);
        	int newEndIndex = this.findRightBound(A, index, len - 1, target);

        	res[0] = newStartIndex;
        	res[1] = newEndIndex;
        	return res;
        }       
    }
    private int findLeftBound(int[] A, int startIndex, int endIndex, int target) {
		int index = endIndex;
		int midIndex = 0;
		while(startIndex <= endIndex) {
			midIndex = startIndex + (endIndex - startIndex + 1) / 2;
			if(A[midIndex] == target) {
				index = midIndex;
				endIndex = midIndex - 1;
			} else {
				startIndex = midIndex + 1;
			}
		}
		return index;
	}
	
	private int findRightBound(int[] A, int startIndex, int endIndex, int target) {
		int index = startIndex;
		int midIndex = 0;
		while(startIndex <= endIndex) {
			midIndex = startIndex + (endIndex - startIndex + 1) / 2;
			if(A[midIndex] == target) {
				index = midIndex;
				startIndex = midIndex + 1;
			} else {
				endIndex = midIndex - 1;
			}
		}
		return index;
	}
	
}
