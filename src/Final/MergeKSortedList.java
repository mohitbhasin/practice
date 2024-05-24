class MergeKSortedList {
	public static void main(String args[]) {
		Node l1 = new Node(1);
		l1.add(4);
		l1.add(5);
		Node l2 = new Node(1);
		l2.add(3);
		l2.add(4);
		Node l3 = new Node(2);
		l3.add(6);
		Node[] lists = new Node[3];
		lists[0]=l1;
		lists[1]=l2;
		lists[2]=l3;

		Node result = mergerK(lists);
		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}

	}

	public static Node mergerK(Node[] lists) {
		Node head = null;
		for(int i=0; i<lists.length; i++) {
			head = merge(lists[i], head);
		}
		return head;
	}

	public static Node merge(Node l1, Node l2) {
		Node head = new Node(0);
		Node dummy = head;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				dummy.next = l1;
				l1=l1.next;
			} else {
				dummy.next = l2;
				l2=l2.next;
			}
			dummy=dummy.next;
		}
		if(l1!=null) {
			dummy.next = l1;
		}
		if(l2!=null) {
			dummy.next = l2;
		}
		return head.next;
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