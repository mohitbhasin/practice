class Recur3 {
	public static void main(String args[]) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);

		ListNode temp = swapPairs(node);
		System.out.println();
		while(temp!=null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode curr = head;
       	ListNode nextNode = head.next;
       	
       	curr.next = swapPairs(nextNode.next);
       	nextNode.next = head;
        return nextNode;
    }


}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }