class AddTwoNumbers {
	public static void main(String args[]) {
		Node l1 = new Node(9);
		l1.add(2);
		l1.add(6);
		l1.add(3);
		Node l2 = new Node(7);
		l2.add(1);
		l2.add(5);
		l2.add(5);
		l2.add(5);
		// Node result = addNums(l1, l2);
		// while(result!=null) {
		// 	System.out.println(result.val);
		// 	result=result.next;
		// }
		Node result2 = addNums2(l1, l2);
		while(result2!=null) {
			System.out.print(result2.val);
			result2=result2.next;
		}
	}

	public static Node addNums2(Node l1, Node l2) {
		int carry=0;
		Node dummyHead = new Node(0);
		Node curr = dummyHead;
		while(l1!=null || l2!=null) {
			int x = l1!=null ? l1.val : 0;
			int y = l2!=null ? l2.val : 0;
			int sum = x + y + carry;
			carry=sum/10;
			curr.next = new Node(sum%10);
			curr=curr.next;
			if(l1!=null) l1=l1.next;
			if(l2!=null) l2=l2.next;
		}
		if(carry>0) {
			curr.next = new Node(carry);
		}
		return dummyHead.next;

	}

	public static Node addNums(Node l1, Node l2) {
		int carry=0;
		Node a1 = l1;
		Node a2 = l2;
		Node dummyHead = new Node(0);
		Node curr = dummyHead;
		while(a1!=null || a2!=null) {
			int temp=0;
			if(a1!=null && a2!=null) {
				temp = a1.val + a2.val + carry;
				a1=a1.next;
				a2=a2.next;
			} else if(a1==null && a2!=null) {
				temp = a2.val + carry;
				a2=a2.next;
			} else if(a1!=null && a2==null) {
				temp = a1.val + carry;
				a1=a1.next;
			}
			curr=new Node(temp%10);
			curr=curr.next;
			carry=temp/10;
		}
		return dummyHead.next;
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