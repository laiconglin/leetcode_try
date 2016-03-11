package laiconglin.solution;

public class Problem_055_Jump_Game {
    public boolean canJump(int[] A) {
    	if(A.length <= 1) {
    		return true;
    	}
    	int [] canJumpFlag = new int[A.length];
    	
    	int distance = this.jumpFromPos(A, 0, canJumpFlag);
    	return distance != -1;
        //return this.canJumpFrom(A, 0, canJumpFlag);    
    }
    
	public int jumpFromPos(int[] A, int pos, int[] minJumpInit) {
		int res = -1;
		int len = A.length;
		int jumpLen = A[pos];
		if(pos == len - 1) {
			return 0;
		}
		
		if (A[pos] == 0) {
			return -1;
		} else {
			if (pos + jumpLen >= len - 1) {
				return 1;
			} else {
				if (minJumpInit[pos] != 0) {
					return minJumpInit[pos];
				} else {
					for (int i = jumpLen; i > 0; i--) {
						if (i + A[pos + i] <= jumpLen) {
							continue;
						}
						int tmpRes = this.jumpFromPos(A, pos + i, minJumpInit);
						if (tmpRes == -1) {
							res = (res == -1) ? -1 : res ;
						} else {
							if(res == -1 || (tmpRes + 1) < res) {
								res = tmpRes + 1;
							}
						}
					}
					minJumpInit[pos] = res;
					return res;
				}
			}
		}
	}
    
    
    
    public boolean canJumpFrom(int[] A, int pos, int[] canJumpFlag) {
        boolean can = false;
        int len = A.length;
        if(pos >= len - 1) {
        	return true;
        } else {
        	int val = A[pos];
        	if(canJumpFlag[pos] == 1) {
        		can = true;
        	} else if(canJumpFlag[pos] == -1) {
        		can = false;
        	} else if(val > 0) {
        		int minValChecked = val + 1;
        		for(int i = val; i >= 1; i--) {
        			if(pos + i < len) {
        				int nextJump = i + A[pos + i];
        				if(nextJump >= minValChecked && nextJump <= val) {
        					continue;
        				}
        			}
        			boolean isFromNextCanJump = this.canJumpFrom(A, pos + i, canJumpFlag);
        			minValChecked = i;
        			if(isFromNextCanJump) {
        				can = true;
        				canJumpFlag[pos] = 1;
        				break;
        			}
        		}
        	}
        }
        if(can == false) {
        	canJumpFlag[pos] = -1;
        }
        return can;
    }
	public static void main(String[] args) {
		Problem_055_Jump_Game solution = new Problem_055_Jump_Game();
		int[] A = {3,2,1,0,4};
		System.out.println(solution.canJump(A));
	}

}
