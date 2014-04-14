package laiconglin.solution;

import java.util.Arrays;

public class Problem_034_Search_in_Rotated_Sorted_Array {
    public int search(int[] A, int target) {
        int index = -1;
        if(A.length == 1) {
        	return A[0] == target ? 0 : -1;
        } else {
        	int len = A.length;
        	int startIndex = 0;
        	int endIndex = len - 1;
        	int midIndex = 0;
        	
        	int front = A[startIndex];
        	int mid;
        	boolean isFound = false;
        	while(startIndex < endIndex) {
        		midIndex = startIndex + (endIndex - startIndex + 1) / 2;
        		mid = A[midIndex];
        		if(mid > front) {
        			startIndex = midIndex;
        		} else {
        			if(midIndex == endIndex) {
        				if(A[startIndex] > A[midIndex]) {
        					isFound = true;
        				}
        				break;
        			}
        			endIndex = midIndex;
        		}
        	}
        	if(isFound == false) {
        		index = Arrays.binarySearch(A, target);
        		return index < 0 ? -1 : index;
        	}
        	
        	mid = A[midIndex];
        	if(target < mid) {
        		return -1;
        	} else if(target >= A[0]) {
        		index = Arrays.binarySearch(A, 0, midIndex, target);
        		return index < 0 ? -1 : index;
        	} else{
        		index = Arrays.binarySearch(A, midIndex, len, target);
        		return index < 0 ? -1 : index;
        	}
        }     
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
