package laiconglin.solution;

import java.util.ArrayList;

public class Problem_054_Spiral_Matrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		final int RIGHT = 1;
		final int DOWN = 2;
		final int LEFT = 3;
		final int UP = 4;
		ArrayList<Integer> res = new ArrayList<Integer>();
		int row = matrix.length;
		if (row == 0) {
			return res;
		} else if (row >= 1) {
			int col = matrix[0].length;
			int[][] markMatrix = new int[row][col];
			int sum = row * col;
			int count = 0;
			int curRow = 0;
			int curCol = 0;
			int direction = RIGHT;
			while (count < sum) {
				res.add(matrix[curRow][curCol]);
				count++;
				// mark
				markMatrix[curRow][curCol] = 1;
				// get next row and col
				int tmpNextRow;
				int tmpNextCol;
				switch (direction) {
				case RIGHT:
					tmpNextRow = curRow + 0;
					tmpNextCol = curCol + 1;
					if (this.isValidNext(markMatrix, tmpNextRow, tmpNextCol)) {
						curRow = tmpNextRow;
						curCol = tmpNextCol;
						break;
					} else {
						direction = DOWN;
					}
				case DOWN:
					tmpNextRow = curRow + 1;
					tmpNextCol = curCol + 0;
					if (this.isValidNext(markMatrix, tmpNextRow, tmpNextCol)) {
						curRow = tmpNextRow;
						curCol = tmpNextCol;
						break;
					} else {
						direction = LEFT;
					}
				case LEFT:
					tmpNextRow = curRow + 0;
					tmpNextCol = curCol - 1;
					if (this.isValidNext(markMatrix, tmpNextRow, tmpNextCol)) {
						curRow = tmpNextRow;
						curCol = tmpNextCol;
						break;
					} else {
						direction = UP;
					}
				case UP:
					tmpNextRow = curRow - 1;
					tmpNextCol = curCol + 0;
					if (this.isValidNext(markMatrix, tmpNextRow, tmpNextCol)) {
						curRow = tmpNextRow;
						curCol = tmpNextCol;
						break;
					} else {
						direction = RIGHT;
					}
				default:
					tmpNextRow = curRow + 0;
					tmpNextCol = curCol + 1;
					if (this.isValidNext(markMatrix, tmpNextRow, tmpNextCol)) {
						curRow = tmpNextRow;
						curCol = tmpNextCol;
						break;
					} else {
						direction = DOWN;
					}
				}
			}
		}
		return res;
	}

	private boolean isValidNext(int[][] markMatrix, int curRow, int curCol) {
		boolean isValid = true;
		int row = markMatrix.length;
		int col = markMatrix[0].length;
		if (curRow < 0 || curRow >= row) {
			isValid = false;
			return isValid;
		}

		if (curCol < 0 || curCol >= col) {
			isValid = false;
			return isValid;
		}

		if (markMatrix[curRow][curCol] == 1) {
			isValid = false;
			return isValid;
		}
		return isValid;
	}

	public static void main(String[] args) {

	}

}
