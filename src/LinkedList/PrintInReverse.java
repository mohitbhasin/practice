class PrintInReverse {
	public static void main(String args[]) {
		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(12);
		head.add(15);

		reversePrint(head);
	}

	public static void reversePrint(Node node) {
		if(node==null) {
			return;
		}
		reversePrint(node.next);
		System.out.println(node.val);
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