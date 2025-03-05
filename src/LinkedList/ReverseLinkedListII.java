class ReverseLinkedListII {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);;
		ListNode curr = head;
		for(int i=2; i<=5; i++) curr.add(i);

		ListNode result = reverseBetween(head, 2, 4);

		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
	}

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = dummy.next;
        // set curr to left position. Keep leftPrev aside for connecting reversed tail and head.
        int pos = 1;
        while(pos<left) {
            curr=curr.next;
            leftPrev=leftPrev.next;
            pos++;
        }
        // reverse left to right
        ListNode prev = null;
        while(left<=right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            left++;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }

	public static ListNode reverseBetween_old(ListNode head, int left, int right) {
        int count = right - left + 1;
        if(count==1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        
        while(left--!=1) {
            prev=prev.next;
            curr=curr.next;
        }
        ListNode newHead = prev;
        ListNode newTail = curr;
        while(count-->0) {
            ListNode  temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        newHead.next = prev;
        newTail.next = curr;
        return dummy.next;
    }
}