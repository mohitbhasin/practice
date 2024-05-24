class LinkedListCycleII {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.next.next.next.next.next.next = l1.next.next;
		System.out.println(detectCycle(l1).val);
	}

	public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        
        if(fast==null || fast.next==null) return null;
        
        fast = head;
        
        while(fast!=slow) {
            if(fast==slow) break;
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}