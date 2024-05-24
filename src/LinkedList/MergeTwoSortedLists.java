class MergeTwoSortedLists {
	public static void main(String args[]) {
		ListNode h1 = new ListNode(1);
		h1.add(3);
		h1.add(5);
		h1.add(6);

		ListNode h2 = new ListNode(1);
		h2.add(2);
		h2.add(4);

		ListNode result = mergeTwoLists(h1, h2);
		result.printList();
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                curr.next=l1;
                l1=l1.next;
            } else {
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }

        if(l1!=null) curr.next = l1;
        else if(l2!=null) curr.next = l2;

        return dummy.next;
    }
}