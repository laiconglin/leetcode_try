package laiconglin.solution;

public class Problem_025_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
		ListNode preHead = new ListNode(0);
		ListNode preNode = preHead;
		preNode.next = head;
		ListNode cur = head;
		ListNode curNext = null;
		ListNode curNextNext = null;
		while (cur != null) {
			curNext = cur.next;
			if (curNext != null) {
				curNextNext = curNext.next;
				preNode.next = curNext;
				curNext.next = cur;
				cur.next = curNextNext;
				preNode = cur;
			} else {
				break;
			}
			cur = cur.next;
		}

		return preHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
