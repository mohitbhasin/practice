class ReverseLinkedList {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		ListNode result = reverseListIterative(head);

		while(result!=null) {
			System.out.print(result.val+" --> ");
			result=result.next;
		}
	}

	public static ListNode reverseListIterative(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}

		ListNode prev=null;
		while(head!=null) {
			ListNode temp = head.next;
			head.next = prev;
			prev=head;
			head=temp;
		}
		return prev;
	}

	public static ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) {
            return head;
        }

        
        ListNode prev = reverseList(head.next);
        ListNode temp = head.next;
        head.next = head.next;
        head.next=temp;
        return reverseList(head.next);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
		this.next=null;
	}
}