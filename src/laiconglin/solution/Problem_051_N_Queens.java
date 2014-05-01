package laiconglin.solution;

import java.util.ArrayList;

public class Problem_051_N_Queens {
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	int[][] board= new int[n][n];
    	this.resetBoard(board);
    	//first row index
    	this.solve(board, res, n);

    	return res;
    }
    private void solve(int[][] board, ArrayList<String[]> res, int n) {
    	int len = board.length;
    	int row = len - n;
    	if(n == 1) {
    		for(int col = 0; col < len; col++) {
    			if(this.isAvailable(board, row, col)) {
    				board[row][col] = 1;
    				//find the solution
    				res.add(this.convertAns(board));
    				
    				board[row][col] = 0;
    			} else {
    				continue;
    			}
    		}
    	} else {
    		for(int col = 0; col < len; col++) {
    			if(this.isAvailable(board, row, col)) {
    				board[row][col] = 1;
    				this.solve(board, res, n - 1);
    				board[row][col] = 0;
    			} else {
    				continue;
    			}
    		}
    	}
    }
    private String[] convertAns(int[][] board) {
    	int len = board.length;
    	String[] res = new String[len];
    	for (int i = 0; i < len; i++) {
    		int[] row = board[i];
			char[] rowChars = new char[len];
			for(int j = 0; j < len; j++) {
				if(row[j] == 0) {
					rowChars[j] = '.';
				} else if(row[j] == 1) {
					rowChars[j] = 'Q';
				}
			}
			res[i] = String.valueOf(rowChars);
		}
    	return res;
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
    
    public void showResult(ArrayList<String[]> res) {
    	for(int i = 0; i < res.size(); i++) {
    		String[] tmpAns = res.get(i);
    		System.out.println("Ans : " + (i + 1));
    		for (String str : tmpAns) {
				System.out.print("\t");
				System.out.println(str);
			}
    		System.out.println();
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_051_N_Queens solution = new Problem_051_N_Queens();
		ArrayList<String[]> res = solution.solveNQueens(4);
		solution.showResult(res);
	}

}
