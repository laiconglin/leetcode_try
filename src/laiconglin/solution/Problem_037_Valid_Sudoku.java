package laiconglin.solution;

public class Problem_037_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean isValid = true;
		int[] nineNum = new int[10];
		// check row
		char[] tmpRow;
		if(board.length != 9) {
			isValid = false;
			return isValid;
		}
		for (int i = 0; i < board.length; i++) {
			this.resetNineNum(nineNum);
			tmpRow = board[i];
			if(tmpRow.length != 9) {
				break;
			}
			for(int j = 0; j < tmpRow.length; j++) {
				char cur = tmpRow[j];
				if(cur == '.') {
					continue;
				} else if(cur >='1' && cur <= '9') {
					int tmpIndex = cur - '0';
					if(nineNum[tmpIndex] == 1) {
						isValid = false;
						break;
					} else if(nineNum[tmpIndex] == 0){
						nineNum[tmpIndex] = 1;
					}
				}
			}
			if(isValid == false) {
				break;
			}
		}
 		if(isValid == false) {
 			return isValid;
 		}
		// check column
 		for(int i = 0; i < 9; i++) {
			this.resetNineNum(nineNum);
			// check column i
			for(int j = 0; j < 9; j++) {
				char cur = board[j][i];
				if(cur == '.') {
					continue;
				} else if(cur >='1' && cur <= '9') {
					int tmpIndex = cur - '0';
					if(nineNum[tmpIndex] == 1) {
						isValid = false;
						break;
					} else if(nineNum[tmpIndex] == 0){
						nineNum[tmpIndex] = 1;
					}
				}
			}
			if(isValid == false) {
				break;
			}
		}
 		if(isValid == false) {
 			return isValid;
 		}
 		//check nine block box
 		for(int i = 0; i < 9; i++) {
 			this.resetNineNum(nineNum);
 			int row = i / 3;
 			int col = i % 3;
 			for(int j = row * 3; j < row * 3 + 3; j++) {
 				for(int k = 3 * col; k < 3 * col + 3; k++) {
 					char cur = board[j][k];
 					if(cur == '.') {
 						continue;
 					} else if(cur >='1' && cur <= '9') {
 						int tmpIndex = cur - '0';
 						if(nineNum[tmpIndex] == 1) {
 							isValid = false;
 							break;
 						} else if(nineNum[tmpIndex] == 0){
 							nineNum[tmpIndex] = 1;
 						}
 					}
 				}
 				if(isValid == false) {
 					break;
 				}
 			}
			if(isValid == false) {
				break;
			}
 		}
		return isValid;
	}

	private void resetNineNum(int[] nineNum) {
		for(int i = 0; i < nineNum.length; i++) {
			nineNum[i] = 0;
		}
	}
	public static void main(String[] args) {

	}

}
