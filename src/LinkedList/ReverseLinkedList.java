class ReverseLinkedList {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);

		// System.out.println(isPalindrome(head));

		ListNode result = reverseList2(head);

		while(result!=null) {
			System.out.print(result.val+" --> ");
			result=result.next;
		}

	}

	public static ListNode reverseList2(ListNode head) {
		ListNode curr = head;
		ListNode prev=null;
		while(curr!=null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

	public static ListNode reverseList(ListNode head) {
    	if (head == null) {
            return head;
        }
        ListNode currentHead = head;
        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }
        return currentHead;
    }

	static ListNode frontNode;
    
    public static boolean isPalindrome(ListNode head) {
        frontNode = head;
        return helper(head);
    }
    
    public static boolean helper(ListNode curr) {
        if(curr!=null) {
            if(!helper(curr.next)) return false;
            if(curr.val != frontNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
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