package laiconglin.solution;
/**
 * 需要不断的去减少需要搜索的范围，
 * 左端边界i从0,1,...n-2,
 * 右端边界j则从n-1,n-2,...minStart
 * 每一次获得当前最大面积的时候，记录左端边界的index为lastMaxIndexStart
 * 
 * 为了缩小范围，有三个点。
 * 1. minStart = 当前得到的最大的面积 / height[j]，这样可以缩小很多范围。
 * 2. 右端边界开始搜索的时候，当出现了某个元素，height[j] >= height[i]的时候，
 *    就可以跳出循环了，因为接下来的继续向左的话，不可能获得更大的面积了。
 * 3. 然后左端边界递增的时候，如果height[i] <= height[lastMaxIndexStart],跳过该元素，
 *    因为该元素作为左端边界的最大值肯定比之前的那个小，没有必要去检查。
 * @author lai-c
 *
 */
public class Problem_013_container_with_most_water {
	public int maxArea(int[] height) {
		int maxRes = 0;
		int i, j;
		int lastMaxIndexStart = -1;
		for (i = 0; i < height.length - 1; i++) {
			int minStart = i + 1;
			if(height[i] == 0) {
				continue;
			}
			if(lastMaxIndexStart != -1 && height[i] <= height[lastMaxIndexStart]) {
				continue;
			}
			if(maxRes != -1) {
				minStart = maxRes / height[i];
			}
			for (j = height.length - 1; j >= minStart; j--) {
				int tmpRes = (j - i) * Math.min(height[i], height[j]);
				if(tmpRes > maxRes) {
					maxRes = tmpRes;
					lastMaxIndexStart = i;
				}
				if(height[j] >= height[i]) {
					break;
				}
			}
		}
		return maxRes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_013_container_with_most_water solution = new Problem_013_container_with_most_water();
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(solution.maxArea(arr));
	}

}
