package laiconglin.solution;

public class Problem_063_unique_paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row <= 0) {
        	return 0;
        }

        int col = obstacleGrid[0].length;
        if(col <= 0) {
        	return 0;
        }
        if(obstacleGrid[0][0] == 1) {
        	return 0;
        }
        
		int[] map = new int[row + 1];
		map[1] = 1;
		for (int i = 1; i <= col; i++) {
			for (int j = 1; j <= row; j++) {
				if(obstacleGrid[j - 1][i - 1] == 1) {
					map[j] = 0;
				} else {
					map[j] = map[j - 1] + map[j];
				}
				
			}
		}
		return map[row];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {
				{0, 1, 0},
				{1, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
		};
		Problem_063_unique_paths_II solution = new Problem_063_unique_paths_II();
		System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
	}

}
