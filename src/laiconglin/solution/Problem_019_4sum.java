package laiconglin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
/**
 * 这道题的目标大概就是不断的去优化，通过剪枝，来缩小需要搜索的范围。
 * 
 * @author lai-c
 *
 */


public class Problem_019_4sum {
	class Quadruplet {
		private int a;
		private int b;
		private int c;
		private int d;

		public Quadruplet(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			result = prime * result + d;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Quadruplet other = (Quadruplet) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			if (d != other.d)
				return false;
			return true;
		}
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> num2IndexArr = new HashMap<Integer, ArrayList<Integer>>();
		HashSet<Quadruplet> resSet = new HashSet<Quadruplet>();

		int len = num.length;
		// init the num to num's index hashmap
		Arrays.sort(num);
		for (int i = 0; i < len; i++) {
			if (num2IndexArr.containsKey(num[i])) {
				ArrayList<Integer> indexArr = num2IndexArr.get(num[i]);
				indexArr.add(i);
				num2IndexArr.put(num[i], indexArr);
			} else {
				ArrayList<Integer> indexArr = new ArrayList<Integer>();
				indexArr.add(i);
				num2IndexArr.put(num[i], indexArr);
			}
		}
		HashSet<Integer> checkedNum = new HashSet<Integer>();
		boolean needBreak = false;
		for (int i = 0; i < len - 3; i++) {
			if(num[i] > 0 && num[i] > target) {
				//System.out.println("break i:" + i);
				break;
			}
			if(needBreak) {
				break;
			}
			for (int j = i + 1; j < len - 2; j++) {
				if(num[j] > 0 && (num[i] + num[j]) > target) {
					//System.out.println("break j:" + j);
					if(num[i] > 0) {
						needBreak = true;
					}
					break;
				}
				checkedNum.clear();
				for (int k = j + 1; k < len - 1; k++) {
					int remainder = target - (num[i] + num[j] + num[k]);
					if(num[k] > 0 && remainder < num[k]) {
						//System.out.println("break k:" + j);
						break;
					}
					
					
					if (num2IndexArr.containsKey(remainder)
							&& checkedNum.contains(num[k]) == false) {
						checkedNum.add(num[k]);
						boolean isExists = false;
						ArrayList<Integer> indexs = num2IndexArr.get(remainder);
						for (Integer index : indexs) {
							if (index > k) {
								isExists = true;
								break;
							}
						}
						if (isExists) {
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							tmp.add(num[i]);
							tmp.add(num[j]);
							tmp.add(num[k]);
							tmp.add(remainder);
							Collections.sort(tmp);
							Quadruplet quadrup = new Quadruplet(tmp.get(0),
									tmp.get(1), tmp.get(2), tmp.get(3));
							if (resSet.contains(quadrup) == false) {
								resSet.add(quadrup);
								res.add(tmp);
							}
						}
					}
				}
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_019_4sum solution = new Problem_019_4sum();
		int[] nums = { -5,-4,-3,-2,-1,0,0,1,2,3,4,5 };
		int target = 0;
		//int[] nums = {91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245};
		//int target = -236727523;
		
		System.out.println("array size:" + nums.length);
		long start = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> res = solution.fourSum(nums, target);
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");
		for (int i = 0; i < res.size(); i++) {
			System.out.print("(");
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
				if (j != (res.get(i).size() - 1))
					System.out.print(",");
			}
			System.out.println(")");
		}
	}

}
