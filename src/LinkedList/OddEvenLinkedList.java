class OddEvenLinkedList {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.printList();
		oddEven(head);
		head.printList();
	}

	public static ListNode oddEven(ListNode head) {
		if(head==null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while(odd.next!=null && even.next!=null) {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;

        return head;
	}
}