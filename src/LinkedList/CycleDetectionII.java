class CycleDetectionII {
	static ListNode head;
	public static void main(String args[]) {
		head = new ListNode(3);
		add(0);
		add(7);
		add(5);
		add(13);
		add(8);
		add(1);
		// head.next.next.next.next.next.next = head.next.next.next;
		ListNode result = detectCycle(head);
		System.out.println(result!=null ? result.val : -1);
	}

	public static void add(int val) {
		ListNode curr = head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=new ListNode(val);
	}

	public static ListNode detectCycle(ListNode head) {
		ListNode interact = interaction(head);
		ListNode curr = head;
		if(interact==null) {
			return null;
		}
		while(curr!=interact) {
			curr=curr.next;
			interact=interact.next;
		}
		return curr;
	}

	public static ListNode interaction(ListNode head) {
		if(head==null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return fast;
			}
		}

		return null;
	}
}


class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}