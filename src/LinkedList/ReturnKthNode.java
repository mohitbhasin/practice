class ReturnKthNode {
	public static void main(String args[]) {
		Node l1 = new Node(9);
		l1.add(2);
		l1.add(6);
		l1.add(3);
		l1.add(8);
		l1.add(328);

		count=0;

		returnKth(l1, 2);
		System.out.println(result.val);
	}
	static int count;
	static Node result;
	public static void returnKth(Node curr, int k) {
		if(curr==null) {
			return;
		}
		returnKth(curr.next, k);
		count++;
		if(count==k) {
			result=curr;
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