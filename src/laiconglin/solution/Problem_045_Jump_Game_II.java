package laiconglin.solution;

public class Problem_045_Jump_Game_II {
	public int jump(int[] A) {
		int res = 0;
		int[] minJumpInit = new int[A.length];

		res = this.jumpFromPos(A, 0, minJumpInit);
		return res;
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
	
	public static void main(String[] args) {
		Problem_045_Jump_Game_II solution = new Problem_045_Jump_Game_II();
		int[] A = {2,3,1,1,4};
		System.out.println(solution.jump(A));
	}

}
