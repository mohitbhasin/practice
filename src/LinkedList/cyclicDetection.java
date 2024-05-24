class cyclicDetection {
	public static void main(String args[]) {
		Node head = new Node(3);
		head.add(0);
		head.add(7);
		head.add(5);
		head.add(13);
		head.add(8);
		head.add(1);
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println(checkCyclic(head));

	}

	public static boolean checkCyclic(Node head) {
		if(head==null) return false;
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null) {
            if(slow == fast) {
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return false;
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