package laiconglin.solution;

public class Problem_038_Sudoku_Solver {
	public void solveSudoku(char[][] board) {
		this.tryToSolve(board);
	}
	
	private boolean tryToSolve(char[][] board) {
		char[] tmpRow;
		for(int i = 0; i < board.length; i++) {
			tmpRow = board[i];
			for(int j = 0; j < tmpRow.length; j++) {
				char cur = board[i][j];
				if(cur == '.') {
					for(int k = 1; k <= 9; k++) {
						board[i][j] = (char) ('0' + k);
						if(this.isValidSudoku(board)) {
							if(tryToSolve(board)) {
								return true;
							}
							board[i][j] = '.';
						} else {
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public void showBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			char[] tmpRow = board[i];
			for (int j = 0; j < tmpRow.length; j++) {
				System.out.print(board[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
	public boolean isValidSudoku(char[][] board) {
		boolean isValid = true;
		int[] nineNum = new int[10];
		// check row
		char[] tmpRow;
		if (board.length != 9) {
			isValid = false;
			return isValid;
		}
		for (int i = 0; i < board.length; i++) {
			this.resetNineNum(nineNum);
			tmpRow = board[i];
			if (tmpRow.length != 9) {
				break;
			}
			for (int j = 0; j < tmpRow.length; j++) {
				char cur = tmpRow[j];
				if (cur == '.') {
					continue;
				} else if (cur >= '1' && cur <= '9') {
					int tmpIndex = cur - '0';
					if (nineNum[tmpIndex] == 1) {
						isValid = false;
						break;
					} else if (nineNum[tmpIndex] == 0) {
						nineNum[tmpIndex] = 1;
					}
				}
			}
			if (isValid == false) {
				break;
			}
		}
		if (isValid == false) {
			return isValid;
		}
		// check column
		for (int i = 0; i < 9; i++) {
			this.resetNineNum(nineNum);
			// check column i
			for (int j = 0; j < 9; j++) {
				char cur = board[j][i];
				if (cur == '.') {
					continue;
				} else if (cur >= '1' && cur <= '9') {
					int tmpIndex = cur - '0';
					if (nineNum[tmpIndex] == 1) {
						isValid = false;
						break;
					} else if (nineNum[tmpIndex] == 0) {
						nineNum[tmpIndex] = 1;
					}
				}
			}
			if (isValid == false) {
				break;
			}
		}
		if (isValid == false) {
			return isValid;
		}
		// check nine block box
		for (int i = 0; i < 9; i++) {
			this.resetNineNum(nineNum);
			int row = i / 3;
			int col = i % 3;
			for (int j = row * 3; j < row * 3 + 3; j++) {
				for (int k = 3 * col; k < 3 * col + 3; k++) {
					char cur = board[j][k];
					if (cur == '.') {
						continue;
					} else if (cur >= '1' && cur <= '9') {
						int tmpIndex = cur - '0';
						if (nineNum[tmpIndex] == 1) {
							isValid = false;
							break;
						} else if (nineNum[tmpIndex] == 0) {
							nineNum[tmpIndex] = 1;
						}
					}
				}
				if (isValid == false) {
					break;
				}
			}
			if (isValid == false) {
				break;
			}
		}
		return isValid;
	}

	private void resetNineNum(int[] nineNum) {
		for (int i = 0; i < nineNum.length; i++) {
			nineNum[i] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		char[][] board = new char[9][9];

		String[] sudoku = {
				"..9748...",
				"7........",
				".2.1.9...",
				"..7...24.",
				".64.1.59.",
				".98...3..",
				"...8.3.2.",
				"........6",
				"...2759.."};
		for (int i = 0; i < sudoku.length; i++) {
			board[i] = sudoku[i].toCharArray();
		}
		Problem_038_Sudoku_Solver solution = new Problem_038_Sudoku_Solver();
		solution.solveSudoku(board);
		solution.showBoard(board);
	}


}
