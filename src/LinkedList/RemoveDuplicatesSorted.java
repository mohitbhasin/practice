class RemoveDuplicatesSorted {
	public static void main(String args[]) {
		Node head = new Node(1);
		head.add(2);
		head.add(2);
		head.add(3);
		head.add(3);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(5);
		head.add(5);
		remove(head);

		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}

	public static void remove(Node n) {
		while(n.next != null) {
			if(n.val == n.next.val) {
				n.next = n.next.next;
			} else {
				n=n.next;
			}
		}
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