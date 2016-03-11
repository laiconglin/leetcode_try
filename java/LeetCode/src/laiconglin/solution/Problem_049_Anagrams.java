package laiconglin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_049_Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> res = new ArrayList<String>();
    	int len = strs.length;

    	int[] addNum = new int[len];
    	Set<String> strSet = new HashSet<String>();
    	Map<String, Integer> strMap = new HashMap<String, Integer>();
    	for(int i = 0; i < len; i++) {
    		char[] curArr = strs[i].toCharArray();
    		Arrays.sort(curArr);
    		String curSortedStr = String.valueOf(curArr);
    		if(strSet.contains(curSortedStr)) {
    			if(addNum[i] == 0) {
    				res.add(strs[i]);
    				addNum[i] = 1;
    			}
    			int ori = strMap.get(curSortedStr);
    			if(addNum[ori] == 0) {
    				res.add(strs[ori]);
    				addNum[ori] = 1;
    			}
    		} else {
    			strSet.add(curSortedStr);
    			strMap.put(curSortedStr, i);
    		}
    	}
    	
    	return res;
    }
	public static void main(String[] args) {

	}
}
