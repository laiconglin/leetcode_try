package laiconglin.solution;

public class Problem_005_add_two_num {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode num1 = l1;
		ListNode num2 = l2;
		ListNode res = null;
		ListNode cur = null;
		int carry = 0;
		while (num1 != null && num2 != null) {
			int tmpSum = num1.val + num2.val + carry;
			ListNode tmpSumNode = new ListNode((tmpSum % 10));
			if (res == null) {
				res = tmpSumNode;
				cur = tmpSumNode;
			} else {
				cur.next = tmpSumNode;
				cur = tmpSumNode;
			}
			carry = tmpSum / 10;
			num1 = num1.next;
			num2 = num2.next;
		}
		while (num1 != null) {
			int tmpSum = num1.val + carry;
			ListNode tmpSumNode = new ListNode(tmpSum % 10);
			if (res == null) {
				res = tmpSumNode;
				cur = tmpSumNode;
			} else {
				cur.next = tmpSumNode;
				cur = tmpSumNode;
			}
			carry = tmpSum / 10;
			num1 = num1.next;
		}

		while (num2 != null) {
			int tmpSum = num2.val + carry;
			ListNode tmpSumNode = new ListNode(tmpSum % 10);
			if (res == null) {
				res = tmpSumNode;
				cur = tmpSumNode;
			} else {
				cur.next = tmpSumNode;
				cur = tmpSumNode;
			}
			carry = tmpSum / 10;
			num2 = num2.next;
		}
		if (carry != 0) {
			ListNode tmpSumNode = new ListNode(carry);
			cur.next = tmpSumNode;
			cur = tmpSumNode;
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
