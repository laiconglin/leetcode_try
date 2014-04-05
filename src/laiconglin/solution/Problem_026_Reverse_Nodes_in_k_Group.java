package laiconglin.solution;

public class Problem_026_Reverse_Nodes_in_k_Group {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode preHead = new ListNode(0);
		ListNode preNode = preHead;
		preNode.next = head;
		while (true) {
			boolean isExistK = false;
			ListNode curHead = preNode.next;
			ListNode cur = curHead;
			int count = 0;
			while (cur != null) {
				count++;
				cur = cur.next;
				if (count == k) {
					isExistK = true;
					break;
				}
			}
			if (isExistK == false) {
				break;
			}
			ListNode nextLoopPreNode = curHead;
			ListNode tailNode = cur;
			cur = curHead;
			ListNode nextCur = cur.next;
			while (count > 0) {
				cur.next = tailNode;
				tailNode = cur;
				cur = nextCur;
				if (cur != null) {
					nextCur = cur.next;
				} else {
					break;
				}
				count--;
			}
			preNode.next = tailNode;
			preNode = nextLoopPreNode;
			if (preNode == null) {
				break;
			}
		}
		return preHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
