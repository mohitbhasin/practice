class ReverseLinkedList {
	public static void main(String args[]) {
		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);

		Node result = reverse(head);
		while(result!=null) {
			System.out.print(result.val+" --> ");
			result=result.next;
		}

	}

	public static Node reverse(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node prev = null;
		Node curr = head;
		Node next = head.next;
		while(next!=null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next=prev;
		return curr;
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