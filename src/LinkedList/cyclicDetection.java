class cyclicDetection {
	public static void main(String args[]) {
		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(6);
		head.add(7);
		head.add(8);
		head.add(9);
		head.add(10);
		head.add(11);
		head.add(12);
		head.add(13);
		head.add(14);
		head.add(15);
		head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = head.next.next.next;
		System.out.println(checkCyclic(head));

	}

	public static boolean checkCyclic(Node head) {
		if(head==null) return false;
        Node slow = head;
        Node fast = head;
        int slowCount = 1;
        int fastCount = 1;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast) {
            	System.out.println("slow: "+slow.val+ " fast: "+fast.val);
                return true;
            }
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