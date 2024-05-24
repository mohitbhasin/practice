class JosephusCircle {
	public static void main(String args[]) {
		int n=12;
		int k=7;
		System.out.println(search(n,k));

		Node node = new Node(1);
		for(int i=2; i<=n; i++) {
			node.add(i);
		}
		node.makeCircular();
		System.out.println(seek(node,k));
	}

	public static int search(int n, int k) {
		if(n==1) {
			return 1;
		}
		return (search(n - 1, k) + k - 1) % n + 1;
	}

	public static int seek(Node node, int k) {
		Node prev = null;
		Node curr = node;

		while(prev!=curr) {
			for(int i=0; i<k-1; i++) {
				prev=curr;
				curr=curr.next;
			System.out.println("-->"+curr);
			}
			System.out.println("----->"+curr);
			prev.next=curr.next;
			curr=curr.next;
		}
		return curr.val;
	}

	// public static int seek(Node node, int k) {
	// 	Node curr = node;
	// 	Node prev = null;

	// 	while(curr!=prev) {
	// 		for(int i=0; i<k; i++) {
	// 			prev=curr;
	// 			curr=curr.next;
	// 		}
	// 		prev.next=curr.next;

	// 	}

	// 	return curr.val;

	// }


	static class Node {
		int val;
		Node next;
		Node(int val) {
			this.val=val;
			this.next=null;
		}

		public void add(int val) {
			Node curr=this.next;
			Node prev=this;
			while(curr!=null) {
				curr=curr.next;
				prev=prev.next;
			}
			curr=new Node(val);
			prev.next=curr;
			// System.out.println(curr.val);
		}

		public void makeCircular() {
			Node curr=this;
			Node head=this;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=head;
		}

		@Override
		public String toString() {
			return this.val + "";
		}
	}
}


