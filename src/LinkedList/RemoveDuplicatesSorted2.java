class RemoveDuplicatesSorted2 {
		public static void main(String args[]) {
		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(5);
		head.add(5);
		head = deleteDuplicates(head);

		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}

	 public static Node deleteDuplicates(Node head) {
        Node dummy=new Node(0);
	 	Node prev = dummy;
        dummy.next = head;
        while(head!=null) {
        	if(head.next != null && head.val == head.next.val) {
        		while(head.next!=null && head.val==head.next.val) {
        			head=head.next;
        		}
        		prev.next=head.next;
        	} else {
        		prev=prev.next;
        	}
        	head=head.next;
        }
        return dummy.next;
    }
}

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
		this.next = null;
	}

	public void add(int val) {
		Node head = this;
		while(head.next!=null) {
			head=head.next;
		}
		head.next = new Node(val);
	}
}