class LinkedListCycle {
	public static void main(String args[]) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		System.out.println(isCyclic(head));
	}

	public static boolean isCyclic(ListNode head) {
		ListNode curr = head.next;
		ListNode follow = head;
		int temp=1;
		while(curr.next!=null) {
			if(curr==follow) {
				return true;
			}
			curr=curr.next;
			if(++temp%2==0) {
				follow=follow.next;
			}
		}
		return false;
	}

	public static boolean isCyclicOnlineSol(ListNode head) {
		ListNode curr = head;
		ListNode follow = head;
		int temp=1;
		while(curr!=null && curr.next!=null) {			
			curr=curr.next.next;
			follow=follow.next;
			if(curr==follow) {
				return true;
			}
		}
		return false;
	}
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
 }