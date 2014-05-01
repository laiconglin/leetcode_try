package laiconglin.solution;

public class Problem_048_Rotate_Image {
	public void rotate(int[][] matrix) {
		int [] tmpRow;
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
	}

	public void showMatrix(int[][] matrix) {
		int [] tmpRow;
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
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { 
				{ 1, 2, 3 }, 
				{ 2, 0, 0 }, 
				{ 3, 4, 5 } };
		
		
		Problem_048_Rotate_Image solution = new Problem_048_Rotate_Image();
		solution.showMatrix(matrix);
	}

}
