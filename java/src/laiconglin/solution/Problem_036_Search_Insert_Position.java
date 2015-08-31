package laiconglin.solution;

import java.util.Arrays;

public class Problem_036_Search_Insert_Position {
    public int searchInsert(int[] A, int target) {
        int index = -1;
        index = Arrays.binarySearch(A, target);
        if(index >= 0) {
        	return index;
        }
        int startIndex = 0;
        int endIndex = A.length - 1;
        if(target < A[startIndex]) {
        	return 0;
        } else if(target > A[endIndex]) {
        	return A.length;
        }
        int mid = 0;
        int midIndex = 0;
        while(startIndex < endIndex) {
        	midIndex = startIndex + (endIndex - startIndex + 1) / 2;
        	mid = A[midIndex];
        	if(mid > target) {
        		endIndex = midIndex;
        	} else if(mid < target) {
        		startIndex = midIndex;
        	}
        	
        	if(endIndex - startIndex == 1) {
        		if(target > A[startIndex] && target < A[endIndex]) {
        			midIndex = endIndex;
        		}
        		break;
        	}
        }
        return midIndex;      
    }
	public static void main(String[] args) {

	}

}
