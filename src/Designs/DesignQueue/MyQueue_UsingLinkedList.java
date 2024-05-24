class MyQueue_UsingLinkedList {
	int count;
	int capacity;
	Node head;
	Node tail;

	public MyQueue_UsingLinkedList(int k) {
		capacity = k;
		count = 0;
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return count==0;
	}

	public boolean isFull() {
		return count==capacity;
	}

	public int Front() {
		if(!isEmpty()) return head.val;
		return -1;
	}

	public int Rear() {
		if(!isEmpty()) return tail.val;
		return -1;
	}

	public boolean enQueue(int value) {
		if(isFull()) return false;
		Node curr = new Node(value);
		if(isEmpty()) {
			head = curr;
			tail = curr;
		} else {
			tail.next = curr;
			tail=tail.next;
		}
		count++;
		return true;
	}

	public boolean deQueue() {
		if(isEmpty()) return false;
		head=head.next;
		count--;
		return true;
	}
}

class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
		this.next  = null;
	}
}