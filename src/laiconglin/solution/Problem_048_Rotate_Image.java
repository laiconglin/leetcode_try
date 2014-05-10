package laiconglin.solution;

public class Problem_048_Rotate_Image {
    public void rotate(int[][] matrix) {
		/**
		 * 1 2 3 4 
		 * 1 0 0 0
		 * 1 0 0 0 
		 * 1 0 0 0
		 */
		int row = matrix.length;
		int col = row;
		/**
		 * replace method
		 * link:
		 * http://k2code.blogspot.in/2014/03/rotate-n-n-matrix-by-90-degrees.html
		 * 
		 */
		for(int i = 0; i < row / 2; i++) {
			for(int j = 0; j < (col + 1) / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[row - 1 - j][i];
				matrix[row - 1 - j][i] = matrix[row - 1 - i][row - 1 - j];
				matrix[row - 1 - i][row - 1 - j] = matrix[j][row - 1 - i];
				matrix[j][row - 1 - i] = tmp;
			}
		}
    }
    
    public void showMatrix(int[][] matrix) {
		int[] tmpRow;
		for(int i = 0; i < matrix.length; i++) {
			tmpRow = matrix[i];
			for(int j = 0; j < tmpRow.length; j++) {
				System.out.print(tmpRow[j]);
				if(j != tmpRow.length - 1) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, 2, 3, 4 }, 
				{ 2, 0, 0, 5 }, 
				{ 3, 0, 0, 6 },
				{ 4, 5, 6, 7 }, 
		};
		Problem_048_Rotate_Image solution = new Problem_048_Rotate_Image();
		solution.showMatrix(matrix);
		solution.rotate(matrix);
		solution.showMatrix(matrix);
		solution.rotate(matrix);
		solution.showMatrix(matrix);
		solution.rotate(matrix);
		solution.showMatrix(matrix);
		solution.rotate(matrix);
		solution.showMatrix(matrix);

	}

}
