class SwapNodesInPairs {
	public static void main(String args[]) {
		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);

		Node result = swapPairs(head);

		while(result!=null) {
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

	public static Node swapPairs(Node head) {
        if(head==null || head.next==null) {
            return head;
        }
        Node firstNode = head;
        Node secondNode = head.next;
        
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;        
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