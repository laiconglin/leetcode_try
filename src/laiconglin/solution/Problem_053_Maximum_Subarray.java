package laiconglin.solution;

public class Problem_053_Maximum_Subarray {
    
	public int maxSubArray(int[] A) {
        int len = A.length;
        if(A.length == 0) {
        	return 0;
        }
        int tmpRes = A[0];
        int maxRes = tmpRes;
        for(int i = 1; i < len; i++) {
        	if(A[i] <= 0) {
        		if(A[i] + tmpRes > 0) {
        			tmpRes += A[i];
        		} else {
        			tmpRes = A[i];
        		}
        	} else {
        		if(tmpRes <= 0) {
        			tmpRes = A[i];
        		} else {
        			tmpRes += A[i];
        		}
        	}
        	if(tmpRes > maxRes) {
        		maxRes = tmpRes;
        	}
        }
        return maxRes;        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
