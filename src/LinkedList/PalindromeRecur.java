class PalindromeRecur {
	public static void main(String[] args) {
		PalindromeRecur obj = new PalindromeRecur();

		ListNode head = new ListNode(1);
		head.add(2);
		head.add(2);
		head.add(1);
		// head.add(1);

		System.out.println(obj.isPalindrome(head));
		System.out.println(obj.isPalindromeIterative(head));
	}

	public boolean isPalindromeIterative(ListNode head) {
		ListNode first = head, second = head;

        while(second!=null && second.next!=null) {
            first = first.next;
            second = second.next.next;
        }

        //reverse second half

        ListNode prev = null;
        ListNode curr = first;

        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        second = prevpancake@26121985
        ;
        first = head;
        while(second!=null) {
            if(first.val!=second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
	}

	ListNode left;
    
    public boolean isPalindrome(ListNode head) {
        left=head;
        ListNode right = head;
        return helper(right);
    }

    public boolean helper(ListNode right) {
        if(right==null) return true;
        if(!helper(right.next)) {
        	return false;
        }
        if(left.val!=right.val) {
            return false;
        } else {
        	left=left.next;
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

	public void print() {
		ListNode curr = this;
		while(curr!=null) {
			System.out.print(curr.val+" -> ");
			curr=curr.next;
		}
		System.out.println();
	}
}