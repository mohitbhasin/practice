// Wrong
class AddNodeInSortedList {
	public static void main(String args[]) {
		Node head = new Node(4);
		head.add(6);
		head.add(8);
		head.add(12);
		head.add(15);
		addToList(head, 3);

		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}

	public static void addToList(Node node, int val) {
		while(node.next!=null && node.val<val) {
			node=node.next;
		}
		Node n = new Node(val);
		n.next = node.next;
		node.next = n;
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