package laiconglin.solution;

public class Problem_021_Remove_Nth_Node_From_End_of_List {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
        		cur = cur.next;
        		len++;
        }
        if(len == 1 && n == 1) {
        		return null;
        }
        
        int indexFromHead = len - n;
        cur = head;
        while(indexFromHead > 1) {
        		cur = cur.next;
        		indexFromHead--;
        }
        if(indexFromHead == 0) {
        		head = cur.next;
        }
        
        ListNode curNext = cur.next;
        cur.next = curNext.next;
    		return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Problem_021_Remove_Nth_Node_From_End_of_List solution = new Problem_021_Remove_Nth_Node_From_End_of_List();
	}

}
