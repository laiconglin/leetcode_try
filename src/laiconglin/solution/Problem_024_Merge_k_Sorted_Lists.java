package laiconglin.solution;

import java.util.ArrayList;

public class Problem_024_Merge_k_Sorted_Lists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode res = null;
		ListNode cur = null;
		// may be I need to know if it is ascending or descending
		// here first I assume that it is ascending
		int len = lists.size();
		while (true) {
			boolean isOver = true;
			int tmpMinNum = Integer.MAX_VALUE;
			int tmpMinIndex = -1;
			// find the smallest element
			for (int i = 0; i < len; i++) {
				ListNode tmpNode = lists.get(i);
				if (tmpNode != null) {
					isOver = false;
					if (tmpNode.val < tmpMinNum) {
						tmpMinNum = tmpNode.val;
						tmpMinIndex = i;
					}
				}
			}

			if (tmpMinIndex != -1) {
				if (res == null) {
					res = new ListNode(tmpMinNum);
					cur = res;
				} else {
					ListNode tmpMin = new ListNode(tmpMinNum);
					cur.next = tmpMin;
					cur = cur.next;
				}

				// pop the min element
				ListNode tmpNode = lists.get(tmpMinIndex);
				tmpNode = tmpNode.next;
				lists.set(tmpMinIndex, tmpNode);
			}
			if (isOver) {
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
