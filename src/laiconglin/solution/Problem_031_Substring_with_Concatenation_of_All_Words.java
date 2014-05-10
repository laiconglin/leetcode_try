package laiconglin.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Problem_031_Substring_with_Concatenation_of_All_Words {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> oriMap = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (oriMap.containsKey(L[i]) == false) {
				oriMap.put(L[i], 1);
			} else {
				int tmpCount = oriMap.get(L[i]);
				oriMap.put(L[i], tmpCount + 1);
			}
		}

		int strLen = S.length();
		int wordsLen = L[0].length();
		int wordsNum = L.length;
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();

		for (int i = 0; i <= strLen - wordsNum * wordsLen; i++) {
			countMap.clear();
			boolean exists = true;
			for (int j = 0; j < wordsNum; j++) {
				String tmp = S.substring(i + j * wordsLen, i + (j + 1)
						* wordsLen);
				if (oriMap.containsKey(tmp) == false) {
					exists = false;
					break;
				} else {
					if (countMap.containsKey(tmp) == false) {
						countMap.put(tmp, 1);
					} else {
						int tmpCount = countMap.get(tmp);
						countMap.put(tmp, tmpCount + 1);
					}
				}
			}
			if (exists == true && this.isTwoMapEquals(oriMap, countMap)) {
				res.add(i);
			}
		}
		return res;
	}

	private boolean isTwoMapEquals(HashMap<String, Integer> a,
			HashMap<String, Integer> b) {
		boolean isEqual = true;
		Set<Entry<String, Integer>> aEntrySet = a.entrySet();
		Iterator<Entry<String, Integer>> aIt = aEntrySet.iterator();
		Entry<String, Integer> next;
		while (aIt.hasNext()) {
			next = aIt.next();
			if (b.containsKey(next.getKey()) == false) {
				isEqual = false;
				break;
			} else if (next.getValue() != b.get(next.getKey())) {
				isEqual = false;
				break;
			}
		}
		return isEqual;
	}

	public static void main(String[] args) {

	}

}
