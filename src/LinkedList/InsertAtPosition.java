class InsertAtPosition {
	public static void main(String args[]) {
		Node head = new Node(5);
		head.add(3);
		head.add(8);
		head.add(1);
		head.add(9);
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val+" ");
			curr=curr.next;
		}
		System.out.println("---------");
		insert(head, 0, 14);
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	//if position is neyond the size of list, then add at the end
	public static void insert(Node head, int val, int pos) {
		Node a = new Node(val);
		Node curr = head;
		int i=1;
		while(i++<pos-1 && curr.next!=null) {
			curr=curr.next;
		}
		a.next=curr.next;
		curr.next=a;
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