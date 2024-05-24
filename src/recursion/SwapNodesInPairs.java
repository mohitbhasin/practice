class SwapNodesInPairs {
	public static void main(String args[]) {
		ListNode list = new ListNode(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		ListNode result = swapPairs(list);

		result.printList();

	}


	public static ListNode swapPairs(ListNode head) {
        return helper(head);
    }
    
    public static ListNode helper(ListNode curr) {
        if(curr==null || curr.next==null) return curr;
        
        // storing next is unnecessary;
        ListNode next = curr.next.next;
        ListNode temp = curr.next;
        temp.next = curr;
        curr.next = helper(next);

        // the above can be refactored to
        // ListNode a = curr;
        // ListNode b = curr.next;
        // a.next = helper(b.next);
        // b.next = a;
        // return b;
        return temp;
    }

}