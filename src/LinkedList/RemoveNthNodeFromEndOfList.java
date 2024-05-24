class RemoveNthNodeFromEndOfList {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);

		ListNode result = removeNthFromEnd(l1, 2);
		while(result!=null) {
			System.out.print(result.val + " --> ");
			result=result.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode curr = head;
        
        while(curr!=null) {
            curr=curr.next;
            if(n<0) {
                prev=prev.next;
            }
            n--;
        }
        if(n<0) {
            prev.next=prev.next.next;
            return head;
        }
        return head.next;
    }
}

class ListNode {
	int val;
	ListNode next;

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
}