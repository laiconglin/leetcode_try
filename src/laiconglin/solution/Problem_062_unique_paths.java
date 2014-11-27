package laiconglin.solution;

public class Problem_062_unique_paths {

	/****
	 * M x N (3 X 7) <-------------------------
	 * __________________________________________________
	 * |map[3]|map[3]|map[3]|map[3]|map[3]|map[3]|map[3]| ^
	 * |______|______|______|______|______|______|______| |
	 * |map[2]|map[2]|map[2]|map[2]|map[2]|map[2]|map[2]| |
	 * |______|______|______|______|______|______|______| |
	 * |map[1]|map[1]|map[1]|map[1]|map[1]|map[1]|map[1]| |
	 * |______|______|______|______|______|______|__(1)_|
	 * 
	 */
	public int uniquePaths(int m, int n) {
		int[] map = new int[m + 1];
		if (m <= 0 || n <= 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		map[1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[j] = map[j - 1] + map[j];
			}
		}
		return map[m];

	}

	public int uniquePathsRecuisive(int m, int n) {
		if (m <= 0 || n <= 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		// move right
		int right = this.uniquePathsRecuisive(m - 1, n);
		// move down
		int down = this.uniquePathsRecuisive(m, n - 1);
		return (right + down);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_062_unique_paths solution = new Problem_062_unique_paths();
		long start = System.currentTimeMillis();
		System.out.println(solution.uniquePaths(23, 12));
		long end = System.currentTimeMillis();
		System.out.println("" + (end - start) + "ms");

		start = System.currentTimeMillis();
		System.out.println(solution.uniquePathsRecuisive(23, 12));
		end = System.currentTimeMillis();
		System.out.println("" + (end - start) + "ms");
	}

}
