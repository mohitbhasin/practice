class RemoveNthNodeFromEnd {
	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		// head.next.next = new Node(3);
		// head.next.next.next = new Node(4);
		// head.next.next.next.next = new Node(5);
		// head.next.next.next.next.next = new Node(6);
		// head.next.next.next.next.next.next = new Node(7);
		// head.next.next.next.next.next.next.next = new Node(8);
		// head.next.next.next.next.next.next.next.next = new Node(9);
		Node result = removeBetterIterative(head, 2);
		while(result!=null) {
			System.out.print(result.val+", ");
			result=result.next;
		}
	}

	 public static Node removeBetterIterative(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node start = dummy;
        Node end = dummy.next;
        
        while(end!=null) {
            end=end.next;
            if(n>0) {
                n--;
            } else if(n==0) {
                start=start.next;
            }
        }
        
        start.next = start.next.next;
        
        return dummy.next;
        
    }

    static int count;
    public static ListNode removeNthFromEndRecursive(ListNode head, int n) {
        count=n;
        helper(head);
        if(count==0) return head.next;
        return head;
    }


    public static void helper(ListNode curr) {
        if(curr == null) return;
        helper(curr.next);
        count--;
        if(count==-1) {
            curr.next = curr.next.next;
        }
    }



	public static Node remove(Node head, int n) {
		int size=0;
		Node dummy=new Node(0);
		dummy.next=head;
		Node first = head;
		while(first!=null) {
			first=first.next;
			size++;
		}
		size-=n;
		first = dummy;
		while(size>1) {
			first=first.next;
			size--;
		}
		first.next = first.next.next;
		return dummy.next;

	}

	public static Node remove2(Node head, int n) {
		int size=0;
		Node dummy=head;
		while(dummy!=null) {
			dummy=dummy.next;
			size++;
		}
		size-=n;
		dummy = head;
		Node temp = dummy;
		while(size>0) {
			temp=temp.next;
			size--;
		}
		Node temp2 = temp.next;
		temp.next = temp2.next;
		return dummy;

	}
}

class Node {
	int val;
	Node next;
	Node(int val) {
		this.val = val;
		this.next = null;
	}
}