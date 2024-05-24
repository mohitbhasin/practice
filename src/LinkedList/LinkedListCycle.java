class LinkedListCycle {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.next.next.next.next.next.next = l1.next.next;
		System.out.println(hasCycle(l1));
	}

	public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) return true;
        }
        
        return false;
    }


}