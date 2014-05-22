package laiconglin.solution;

public class Problem_061_Rotate_List {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode res = head;
        if(head == null) {
        	return res;
        }
        int len = this.listLen(head);
        if(len == 1) {
        	return res;
        }
        n = n % len;
        if(n == 0) {
        	return res;
        } 
        int skipNum = len - n;
        ListNode cur = head;
        ListNode curPre = head;
        int count = 1;
        while(count <= skipNum) {
        	curPre = cur;
        	cur = cur.next;
        	count++;
        }
        curPre.next = null;
        res = cur;
        while(cur != null) {
        	if(cur.next == null) {
        		cur.next = head;
        		break;
        	} else {
        		cur = cur.next;
        	}
        }
        return res;
    }
    private int listLen(ListNode head) {
    	int len = 0;
    	ListNode cur = head;
    	while(cur != null) {
    		len++;
    		cur = cur.next;
    	}
    	return len;
    }
    
    public void showList(ListNode head) {
    	ListNode cur = head;
    	while(cur != null) {
    		System.out.print(cur.val + "->");
    		cur = cur.next;
    	}
    	System.out.println("NULL");
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur.next = new ListNode(2);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(4);
		cur = cur.next;
		cur.next = new ListNode(5);
		cur = cur.next;
		Problem_061_Rotate_List solution = new Problem_061_Rotate_List();
		ListNode res = solution.rotateRight(head, 5);
		solution.showList(res);
	}

}
