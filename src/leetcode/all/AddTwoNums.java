package leetcode.all;


//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807

public class AddTwoNums {
	
	public static void main(String args[]) {
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1,l2);
		
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
			
		}
	}
	
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp; 
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
        	int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
        	ListNode curr = new ListNode(sum%10);
        	temp.next = curr;
        	carry=sum/10;
        	temp=curr;
        	l1= l1 == null ? null : l1.next;
        	l2= l2 == null ? null : l2.next;
        }
        return head.next;
    }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
