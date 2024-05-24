class SinglyLinkedList {
	Node head;
	Node tail;

	public SinglyLinkedList(int val) {
		this.head = new Node(val);
		this.tail = head;
	}

	public void addTail(int val) {
		Node curr = new Node(curr);
		tail.next = curr;
		tail=curr;
	}

	public int removeHead() {
		
		Node curr = head;
		head = head.next;
		return head.val;
	}

	public int removeTail() {
		Node curr = head;
		while(curr.next.next!=null) {
			curr=curr.next;
		}

	}


	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
}