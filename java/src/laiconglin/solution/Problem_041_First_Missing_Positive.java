package laiconglin.solution;

public class Problem_041_First_Missing_Positive {
    public int firstMissingPositive(int[] A) {
        int res = 1;
        int len = A.length;
        for(int i = 0; i < len; i++) {
        	if(A[i] <= 0 || A[i] > len) {
        		A[i] = -1;
        	}
        }
        int tmpIndex = -1;
        int tmpNextNum = -1;
        for(int i = 0; i < len; i++) {
        	if(A[i] == -1 || A[i] == (i + 1)) {
        		continue;
        	} else {
        		tmpIndex = A[i] - 1;
        		A[i] = -1;
        		while(true) {
        			tmpNextNum = A[tmpIndex];
        			A[tmpIndex] = tmpIndex + 1;
        			tmpIndex = tmpNextNum - 1;
        			if(tmpNextNum == -1) {
        				break;
        			} else if(A[tmpIndex] == tmpIndex + 1) {
        				break;
        			}
        		}
        	}
        }
        int i;
        for(i = 0; i < len; i++) {
        	if(A[i] == -1) {
        		break;
        	}
        }
        res = i + 1;
        return res;
    }
    public static void main(String[] args) {
		
	}
}
