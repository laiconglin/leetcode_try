package laiconglin.solution;

public class Problem_059_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
    	final int RIGHT = 1;
    	final int DOWN = 2;
    	final int LEFT = 3;
    	final int UP = 4;
        int[][] matrix = new int[n][n];
        int direction = RIGHT;
        int count = 1;
        int sum = n * n;
        int curRow = 0;
        int curCol = 0;
        while(count <= sum) {
        	matrix[curRow][curCol] = count++;
        	if(count > sum) {
        		break;
        	}
			// get next row and col
			int tmpNextRow;
			int tmpNextCol;
			switch (direction) {
			case RIGHT:
				tmpNextRow = curRow + 0;
				tmpNextCol = curCol + 1;
				if (this.isValidNext(matrix, tmpNextRow, tmpNextCol)) {
					curRow = tmpNextRow;
					curCol = tmpNextCol;
					break;
				} else {
					direction = DOWN;
				}
			case DOWN:
				tmpNextRow = curRow + 1;
				tmpNextCol = curCol + 0;
				if (this.isValidNext(matrix, tmpNextRow, tmpNextCol)) {
					curRow = tmpNextRow;
					curCol = tmpNextCol;
					break;
				} else {
					direction = LEFT;
				}
			case LEFT:
				tmpNextRow = curRow + 0;
				tmpNextCol = curCol - 1;
				if (this.isValidNext(matrix, tmpNextRow, tmpNextCol)) {
					curRow = tmpNextRow;
					curCol = tmpNextCol;
					break;
				} else {
					direction = UP;
				}
			case UP:
				tmpNextRow = curRow - 1;
				tmpNextCol = curCol + 0;
				if (this.isValidNext(matrix, tmpNextRow, tmpNextCol)) {
					curRow = tmpNextRow;
					curCol = tmpNextCol;
					break;
				} else {
					direction = RIGHT;
				}
			default:
				tmpNextRow = curRow + 0;
				tmpNextCol = curCol + 1;
				if (this.isValidNext(matrix, tmpNextRow, tmpNextCol)) {
					curRow = tmpNextRow;
					curCol = tmpNextCol;
					break;
				} else {
					direction = DOWN;
				}
			}
        }
        return matrix;
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

		if (markMatrix[curRow][curCol] != 0) {
			isValid = false;
			return isValid;
		}
		return isValid;
	}
	public static void main(String[] args) {
		Problem_059_Spiral_Matrix_II solution = new Problem_059_Spiral_Matrix_II();
		int[][] matrix = solution.generateMatrix(4);
		for(int[] row : matrix) {
			for(int col : row) {
				System.out.print(col + ",");
			}
			System.out.println();
		}
	}
}
