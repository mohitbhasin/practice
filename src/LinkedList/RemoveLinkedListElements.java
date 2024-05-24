class RemoveLinkedListElements {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(6);
		head.add(3);
		head.add(6);
		head.add(7);
		// removeElements(head, 6).printList();
		removeElements_recursion(head, 6).printList();
	}

	public static ListNode removeElements(ListNode head, int val) {
		if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next!=null) {
            if(prev.next.val == val) prev.next=prev.next.next;
            else prev=prev.next;
        }
        return dummy.next;
    }

    public static ListNode removeElements_recursion(ListNode head, int val) {
    	if(head==null) return null;
    	head.next = removeElements_recursion(head.next, val);
    	return head.val==val ? head.next : head;
    }
}