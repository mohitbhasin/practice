class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}
	
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public void add(int val) {
		ListNode head = this;
		while(head.next!=null) {
			head=head.next;
		}
		head.next = new ListNode(val);
	}

	public void printList() {
		ListNode head = this;
		while(head!=null) {
			System.out.print(head.val + "-->");
			head=head.next;
		}
		System.out.println();
	}
}