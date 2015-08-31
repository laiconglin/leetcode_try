package laiconglin.solution;

public class Problem_052_N_Queens_II {
    public int totalNQueens(int n) {
    	int[][] board= new int[n][n];
    	this.resetBoard(board);
    	//first row index
    	int res = this.solve(board,  n);

    	return res;
    }
    private int solve(int[][] board, int n) {
    	int len = board.length;
    	int row = len - n;
    	int count = 0;
    	if(n == 1) {
    		for(int col = 0; col < len; col++) {
    			if(this.isAvailable(board, row, col)) {
    				//find the solution
    				count++;
    			} else {
    				continue;
    			}
    		}
    	} else {
    		for(int col = 0; col < len; col++) {
    			if(this.isAvailable(board, row, col)) {
    				board[row][col] = 1;
    				count = count + this.solve(board, n - 1);
    				board[row][col] = 0;
    			} else {
    				continue;
    			}
    		}
    	}
    	return count;
    }
    
    private boolean isAvailable(int[][] board, int row, int col) {
    	boolean isOK = true;
    	int len = board.length;
    	//check row
    	for(int j = 0; j < len; j++) {
    		if(board[row][j] == 1) {
    			isOK = false;
    			break;
    		}
    	}
    	if(isOK == false) {
    		return isOK;
    	}
    	
    	//check column
    	for(int i = 0; i < len; i++) {
    		if(board[i][col] == 1) {
    			isOK = false;
    			break;
    		}
    	}
    	if(isOK == false) {
    		return isOK;
    	}
    	
    	//check the right diagonal
    	for(int i = 1; i < len - col; i++) {
    		int rightDiagUp = row - i;
    		int rightDiagDown = row + i;
    		if(rightDiagUp >= 0 && board[rightDiagUp][col + i] == 1) {
    			isOK = false;
    			break;
    		}
    		
    		if(rightDiagDown < len && board[rightDiagDown][col + i] == 1) {
    			isOK = false;
    			break;
    		}
    	}
    	if(isOK == false) {
    		return isOK;
    	}
    	
    	//check the left diagonal
    	for(int i = col - 1; i >= 0; i--) {
    		int leftDiagUp = row - (col - i);
    		int leftDiagDown = row + (col - i);
    		
    		if(leftDiagUp >= 0 && board[leftDiagUp][i] == 1) {
    			isOK = false;
    			break;
    		}
    		
    		if(leftDiagDown < len && board[leftDiagDown][i] == 1) {
    			isOK = false;
    			break;
    		}
    	}
    	
    	return isOK;
    }
    private void resetBoard(int[][] board) {
    	for(int i = 0; i < board.length; i++) {
    		int[] row = board[i];
    		for(int j = 0; j < row.length; j++) {
    			board[i][j] = 0;
    		}
    	}
    }
	public static void main(String[] args) {
		Problem_052_N_Queens_II solution = new Problem_052_N_Queens_II();
		System.out.println(solution.totalNQueens(4));
	}


}
