class RotateList {
	public static void main(String args[]) {
		ListNode list = new ListNode(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list = rotateRight(list, 2);

		while(list!=null) {
			System.out.print(list.val+", ");
			list=list.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null || k==0) return head;

        int length=0;

        ListNode curr = head;

        while(curr!=null) {
        	length++;
        	curr=curr.next;
        }

        k = k%length;

        if(k==0) return head;
        index=k;

        helper(head);
        ListNode tail = posNode;
        ListNode prev = tail.next;
        tail.next = null;
        tail = prev;
        while(tail.next!=null) {
            tail=tail.next;
        }
        tail.next = head;
        return prev;
    }
    
    static int index;
    static ListNode posNode;
    
    public static void helper(ListNode head) {
        if(head==null) {
            return;
        }
        helper(head.next);
        index--;   
        if(index==-1) {
            posNode = head;
            return;
        }
    }
}